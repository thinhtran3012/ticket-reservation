package io.cinema;

import io.cinema.proto.Seat;
import io.cinema.proto.SubmitReserveTicketRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ReservationExecutor {
    public final static Logger LOGGER = LoggerFactory.getLogger(ReservationExecutor.class.getCanonicalName());

    public static boolean handleReseverTicket(SubmitReserveTicketRequest request, CinemaInfomation cinemaInfomation) {
        try {
            LOGGER.info("Start handling reverse ticket request");
            List<Seat> reversedSeatRequest = request.getSeatsList();
            if (reversedSeatRequest.isEmpty()) {
                return false;
            }
            return cinemaInfomation.executeReserveSeats(reversedSeatRequest);
        } catch (Exception ex) {
            LOGGER.error("Error when handling reverse ticket request", ex);
            return false;
        }
    }
}
