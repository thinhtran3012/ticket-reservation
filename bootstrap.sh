#!/bin/bash
# Copyright (c) 2020 by NamND. All rights reserved

SCRNAME=`basename $0`
CONSUL_IP=''
WORKER_LOG_DIR=/opt/logs
SUPPORTED_OSTYPES_LIST=( CENTOS_6_7 FEDORA RHEL_7 DEBIAN_8_9 UBUNTU_16_18_20 UNSUPPORTED )
RPM_DIST=0
DPKG_DIST=0
MVN_VERSION=3.6.3

temp=${#SUPPORTED_OSTYPES_LIST[@]}
for ((i=0; i < temp; i++)); do
    name=${SUPPORTED_OSTYPES_LIST[i]}
    declare -r ${name}=$i
done

if [ ! -d $WORKER_LOG_DIR ]; then
    sudo -v > /dev/null 2>/dev/null
    if [ $? -eq 0 ]; then
        sudo mkdir $WORKER_LOG_DIR
    fi
fi
sudo chmod 766 $WORKER_LOG_DIR

######################################################################################################
check_os_supported() {
    determine_os_type
    echo "Check OS Supported..." | tee -a ./install.log
    if [ $OS_TYPE = ${SUPPORTED_OSTYPES_LIST[$UNSUPPORTED]} ]; then
    echo "OS Unsupported" | tee -a ./install.log
    exit 1;
    return
    fi
    if [[ ($OS_TYPE = ${SUPPORTED_OSTYPES_LIST[$CENTOS_6_7]}) || \
        ($OS_TYPE = ${SUPPORTED_OSTYPES_LIST[$FEDORA]}) || \
        ($OS_TYPE = ${SUPPORTED_OSTYPES_LIST[$RHEL_7]}) ]]; then
        RPM_DIST=1
    elif [[ ($OS_TYPE = ${SUPPORTED_OSTYPES_LIST[$UBUNTU_16_18_20]}) || \
        ($OS_TYPE = ${SUPPORTED_OSTYPES_LIST[$DEBIAN_8_9]}) ]]; then
        DPKG_DIST=1
    fi
}

# install plugin
install_plugin() {
    check_os_supported
    if [ $RPM_DIST -eq 1 ]; then
        echo "start install plugin"
        sudo -v > /dev/null 2>/dev/null
        sudo -c "yum update" | tee -a ./install.log

        if [ $? -eq 0 ]; then
            sudo yum check-update | tee -a ./install.log
        else
            echo "super user password : "
        fi
    elif [ $DPKG_DIST -eq 1 ]; then
        sudo -v > /dev/null 2>/dev/null
        if [ $? -eq 0 ]; then
            echo "sudo password : "
            sudo apt-get update | tee -a ./install.log
            sudo apt-get install apt-transport-https ca-certificates wget curl gnupg-agent software-properties-common -y | tee -a ./install.log
        else
            echo "super user password : "
        fi
    fi
}

# check and install docker if not exist!
check_install_docker() {
    # Verify that we can at least get version output
    if [ ! -e /usr/bin/docker ]; then
        echo "The docker installing..."
        if [ $RPM_DIST -eq 1 ]; then
            sudo -v > /dev/null 2>/dev/null
            if [ $? -eq 0 ]; then
                # install docker
                curl -fsSL https://get.docker.com/ | sh | tee -a ./install.log
                sudo systemctl start docker | tee -a ./install.log
            else
                echo "super user password : "
            fi
        elif [ $DPKG_DIST -eq 1 ]; then
            local _OS_NAME="$(lsb_release -cs)"
            if [[ ${_OS_NAME} == "focal" ]]; then
                $_OS_NAME = "bionic" # pass in ubuntu 20.04
            fi
            sudo -v > /dev/null 2>/dev/null
            if [ $? -eq 0 ]; then
                echo "sudo password : "
                curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add - | tee -a ./install.log
                sudo apt-key fingerprint 0EBFCD88 | tee -a ./install.log
                sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu ${_OS_NAME} stable" | tee -a ./install.log
                sudo apt-get update | tee -a ./install.log
                sudo apt-get install docker-ce docker-ce-cli containerd.io -y | tee -a ./install.log
            else
                echo "super user password : "
                su -c "apt-get update"
            fi
        fi
        # config
        sudo usermod -aG docker $(whoami) | tee -a ./install.log
        sudo systemctl enable docker | tee -a ./install.log
        sudo service docker start | tee -a ./install.log
        echo "Docker installed!!!" | tee -a ./install.log
    else
        echo "Ignore install docker" | tee -a ./install.log
    fi
}
# check and install docker-compose if not exist!
check_install_docker_compose() {
    # Verify that we can at least get version output
    echo "Check docker-compose..."
    if [ ! -e /usr/bin/docker-compose ] ; then
        echo "Installing it..."
        echo "Please, check latest version: https://github.com/docker/compose/releases"
        sudo curl -L "https://github.com/docker/compose/releases/download/1.25.5/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
        if [ $? -ne 0 ]; then
            echo "Failed to download docker-compose"
        else
            sudo chmod +x /usr/local/bin/docker-compose | tee -a ./install.log
            sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose | tee -a ./install.log
            echo "Please run: docker-compose --version to check"
        fi
    else
        echo "Ignore install docker-compose" | tee -a ./install.log
    fi
}

check_install_maven() {
    if [ ! -e /usr/bin/java ] ; then
        echo "Installing java" | tee -a ./install.log
        if [ $RPM_DIST -eq 1 ]; then
            sudo yum install java-1.8.0-openjdk java-1.8.0-openjdk-devel -y
        elif [ $DPKG_DIST -eq 1 ]; then
            sudo apt-get install openjdk-8-jdk -y
        fi
        echo java -version | tee -a ./install.log
    fi
    if [ ! -e /usr/bin/mvn ] ; then
        echo "Installing maven"
        # todo: add method for checking if latest or automatically grabbing latest
        url="https://mirror.downloadvn.com/apache/maven/maven-3/$MVN_VERSION/binaries/apache-maven-$MVN_VERSION-bin.tar.gz"
        install_dir="/opt/maven"
        if [ -d ${install_dir} ]; then
            rm -rf ${install_dir}
        fi

        if [ ! -e ${install_dir} ]; then
            mkdir ${install_dir}
        fi
        curl -fsSL ${url} | tar zx --strip-components=1 -C ${install_dir} | tee -a ./install.log

        update-alternatives --install "/usr/bin/mvn" "mvn" ${install_dir}/bin/mvn 0 | tee -a ./install.log
        update-alternatives --set mvn ${install_dir}/bin/mvn | tee -a ./install.log

        echo maven installed to ${install_dir} | tee -a ./install.log
        mvn --version
    fi
}

#determine the OS TYPE
determine_os_type() {
    if [ -f /etc/centos-release ]; then
        OS_MAJOR_VERSION=$(cat /etc/centos-release | grep -o '.[0-9]'| head -1|sed -e 's/ //')
           if [ $OS_MAJOR_VERSION = 6 ] || [ $OS_MAJOR_VERSION = 7 ]; then
            OS_TYPE=${SUPPORTED_OSTYPES_LIST[$CENTOS_6_7]}
        else
            OS_TYPE=${SUPPORTED_OSTYPES_LIST[$UNSUPPORTED]}
        fi
    elif [ -f /etc/fedora-release ]; then
        OS_TYPE=${SUPPORTED_OSTYPES_LIST[$FEDORA]}
    elif [ -f /etc/redhat-release ]; then
        OS_MAJOR_VERSION=$(cat /etc/redhat-release | grep -o '.[0-9]'| head -1|sed -e 's/ //')
        if [ $OS_MAJOR_VERSION = 7 ]; then
            OS_TYPE=${SUPPORTED_OSTYPES_LIST[$RHEL_7]}
        else
            OS_TYPE=${SUPPORTED_OSTYPES_LIST[$UNSUPPORTED]}
        fi
    else
        OSNAME=$(lsb_release -d | grep -o "Ubuntu")
        if [ "X$OSNAME" != "X" ]; then
            UBUNTU_VER=$(lsb_release -d | grep -o '.[0-9]*\.'| head -1|sed -e 's/\s*//'|sed -e 's/\.//')
            if [ $UBUNTU_VER = 16 ] || [ $UBUNTU_VER = 18 ] || [ $UBUNTU_VER = 20 ]; then
                OS_TYPE=${SUPPORTED_OSTYPES_LIST[$UBUNTU_16_18_20]}
            else
                OS_TYPE=${SUPPORTED_OSTYPES_LIST[$UNSUPPORTED]}
            fi
        else
            if [ -f /etc/debian_version ]; then
                DEBIAN_MAJOR_VERSION=$(cat /etc/debian_version | grep -o '[0-9]'| head -1|sed -e 's/ //')
                if [ $DEBIAN_MAJOR_VERSION = 8 ] || [ $DEBIAN_MAJOR_VERSION = 9 ]; then
                    OS_TYPE=${SUPPORTED_OSTYPES_LIST[$DEBIAN_8_9]}
                else
                    OS_TYPE=${SUPPORTED_OSTYPES_LIST[$UNSUPPORTED]}
                fi
            else
                OS_TYPE=${SUPPORTED_OSTYPES_LIST[$UNSUPPORTED]}
            fi
        fi
    fi
}

build_maven() {
    check_install_maven
    mvn clean package
}

docker_compose_buid_up() {
    check_install_docker
    check_install_docker_compose
    # root
    sudo -v > /dev/null 2>/dev/null
    sudo docker-compose build | tee -a install.log
    sudo docker-compose up -d | tee -a install.log
}

########################################################################################

install_plugin
build_maven
docker_compose_buid_up
