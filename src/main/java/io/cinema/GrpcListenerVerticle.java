package io.cinema;

import io.vertx.core.Context;
import io.vertx.core.Vertx;
import io.vertx.grpc.VertxServerBuilder;
import io.vertx.reactivex.core.AbstractVerticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrpcListenerVerticle extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(GrpcListenerVerticle.class.getCanonicalName());

    private static final String RPC_PORT_ENV = "GRPC_PORT";
    protected VertxServerBuilder serverBuilder;

    public GrpcListenerVerticle() {
    }

    @Override
    public void init(Vertx vertx, Context context) {
        super.init(vertx, context);
    }

    @Override
    public void start() {
        // Read configuration
        int grpcPort = getGrpcPort();
        // Create and start gRPC server
        serverBuilder = VertxServerBuilder.forPort(vertx.getDelegate(), grpcPort).addService(new CinemaGrpcService(vertx));
        serverBuilder.build().start(ar -> {
            if (ar.succeeded()) {
                LOGGER.info("gRPC server started");
            } else {
                LOGGER.error("Could not start gRPC server " + ar.cause().getMessage());
            }
        });
    }

    protected int getGrpcPort() throws NullPointerException {
        String RPCPort = System.getenv(RPC_PORT_ENV);
        if (RPCPort == null) {
            LOGGER.error(String.format("Environment variable %s is not set.", RPC_PORT_ENV));
            throw new NullPointerException();
        }

        return Integer.parseInt(RPCPort);
    }
}
