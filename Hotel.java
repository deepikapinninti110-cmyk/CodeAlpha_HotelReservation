import java.util.ArrayList;

public class Hotel {
    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();

        rooms.add(new Room(101, "Standard", 1500));
        rooms.add(new Room(102, "Standard", 1500));
        rooms.add(new Room(201, "Deluxe", 2500));
        rooms.add(new Room(202, "Deluxe", 2500));
        rooms.add(new Room(301, "Suite", 4000));
    }

    public void showAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (!room.isBooked()) {
                System.out.println(
                    "Room " + room.getRoomNumber() +
                    " | Type: " + room.getType() +
                    " | Price: ₹" + room.getPrice()
                );
            }
        }
    }

    public void bookRoom(int roomNumber, String customerName) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && !room.isBooked()) {
                room.bookRoom();
                reservations.add(new Reservation(customerName, room));
                System.out.println("Room booked successfully!");
                return;
            }
        }
        System.out.println("Room not available.");
    }

    public void cancelReservation(int roomNumber) {
        for (Reservation res : reservations) {
            if (res.getRoom().getRoomNumber() == roomNumber) {
                res.getRoom().cancelBooking();
                reservations.remove(res);
                System.out.println("Reservation cancelled successfully!");
                return;
            }
        }
        System.out.println("Reservation not found.");
    }

    public void showReservations() {
        System.out.println("\nCurrent Reservations:");
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        }
        for (Reservation res : reservations) {
            System.out.println(
                "Customer: " + res.getCustomerName() +
                " | Room: " + res.getRoom().getRoomNumber() +
                " | Type: " + res.getRoom().getType()
            );
        }
    }
}