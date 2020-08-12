package io.cinema;

import io.cinema.proto.Seat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CinemaInfomation {
    private final int minDistance;
    private List<Seat> availableSeats;
    private final List<Seat> reservedSeats;
    private final int rows;
    private final int columns;

    public CinemaInfomation() {
        rows = Integer.parseInt(System.getenv("ROW_NUMBER"));
        columns = Integer.parseInt(System.getenv("COLUMN_NUMBER"));
        minDistance = Integer.parseInt(System.getenv("MIN_DISTANCE"));
        availableSeats = new ArrayList<>();
        reservedSeats = new ArrayList<>();
        createCinemaListSeat();
    }

    private void createCinemaListSeat() {
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
                availableSeats.add(Seat.newBuilder().setRow(rowIndex).setColumn(columnIndex).build());
            }
        }
    }

    private boolean isAvailableSeat(Seat remainSeat) {
        return reservedSeats.stream().allMatch(seat -> Math.abs(remainSeat.getRow() - seat.getRow()) +
                Math.abs(remainSeat.getColumn() - seat.getColumn()) > minDistance);
    }

    public boolean executeReserveSeats(List<Seat> reservedSeatsRequest) throws Exception {
        if (isValidSeats(reservedSeatsRequest) && availableSeats.containsAll(reservedSeatsRequest)) {
            reservedSeats.addAll(reservedSeatsRequest);
            List<Seat> remainingSeats = getRemainingSeats(reservedSeatsRequest);
            availableSeats = remainingSeats.stream()
                    .filter(this::isAvailableSeat)
                    .collect(Collectors.toList());
            return true;
        }
        return false;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    private boolean isValidSeat(Seat seat) {
        return seat.getRow() >= 0 ||
                seat.getColumn() >= 0 ||
                seat.getRow() < rows ||
                seat.getColumn() < columns;
    }

    private boolean isValidSeats(List<Seat> seats) {
        return seats.stream().allMatch(this::isValidSeat);
    }

    private List<Seat> getRemainingSeats(List<Seat> reservedSeats) {
        return availableSeats.stream().filter(seat -> !reservedSeats.contains(seat)).collect(Collectors.toList());
    }
}
