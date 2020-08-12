### How to build

#### Requirement

* Supported OS:

    * Ubuntu 16.04 or latter
    
    * Centos 7
    
* Tool for test call grpc service: download and install [BloomRPC](https://github.com/uw-labs/bloomrpc/releases)

#### Build

1. Set environment in **.env** file for row, column, and min distance

2. run ```./boostrap.sh``` to build and start service

3. using ***BloomRPC*** to test service

#### How to test
1. Using **BloomRPC** load proto file from ***src/main/proto/cinema.proto***

2. Set Ip and Port: ***127.0.0.1:9500*** in Bloom

3. Call ***SubmitGetAvailableSeatsRequest*** to get all available seats

4. Call ***SubmitReserveTicket*** and input list seat need to reserve

#### Structure project

* Technology: Java, Maven, Vertx, Docker, Shellscript

* Proto:

    ```syntax = "proto3";
       option java_multiple_files = true;
       option java_package = "io.cinema.proto";
       
       message Seat {
           int32 row = 1;
           int32 column = 2;
       }
       
       message SubmitReserveTicketRequest {
           repeated Seat seats = 2;
       }
       
       message ReserveTicketResponse {
           bool is_success = 1;
           string message = 2;
       }
       
       message GetAvailableSeatsResponse {
           repeated Seat seats = 1;
       }
       
       service CinemaService {
           rpc SubmitReserveTicket (SubmitReserveTicketRequest) returns (ReserveTicketResponse);
           rpc SubmitGetAvailableSeatsRequest (Empty) returns (GetAvailableSeatsResponse);
       }
       
       message Empty {
       }
    ```

* Detail:
    * CinemaGrpcService: implement grpc service
    * CinemaInfomation: handle storage cinema info, exp: min distance, list seats available, list seats reserved
    * GrpcListenerVerticle: deploy grpc server
    * ReservationExecutor: implement reservation ticket
    
* Algorithm calculate mahatan distance

    ```|x2 - x1| + |y2 - y1| > min_distance```