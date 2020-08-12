package io.cinema;

import io.cinema.proto.*;
import io.vertx.core.Promise;
import io.vertx.reactivex.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CinemaGrpcService extends CinemaServiceGrpc.CinemaServiceVertxImplBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(CinemaGrpcService.class.getCanonicalName());
    private final Vertx vertx;
    private final CinemaInfomation cinemaInfo;

    public CinemaGrpcService(Vertx vertx) {
        this.vertx = vertx;
        this.cinemaInfo = new CinemaInfomation();
    }

    @Override
    public void submitGetAvailableSeatsRequest(io.cinema.proto.Empty request, Promise<GetAvailableSeatsResponse> response) {
        LOGGER.info("Receive request to get available seat");
        List<Seat> availableSeats = cinemaInfo.getAvailableSeats();
        LOGGER.info("Size: " + availableSeats.size());
        response.complete(GetAvailableSeatsResponse.newBuilder().addAllSeats(availableSeats).build());
    }

    @Override
    public void submitReserveTicket(SubmitReserveTicketRequest request, Promise<ReserveTicketResponse> response) {
        LOGGER.info("Receive request to reserve ticket");
        boolean result = ReservationExecutor.handleReseverTicket(request, cinemaInfo);
        if (result) {
            response.complete(ReserveTicketResponse.newBuilder()
                    .setIsSuccess(true)
                    .setMessage("Reverse ticket success")
                    .build());
        } else {
            response.complete(ReserveTicketResponse.newBuilder()
                    .setIsSuccess(false)
                    .setMessage("Reverse ticket failed")
                    .build());
        }
    }
}
