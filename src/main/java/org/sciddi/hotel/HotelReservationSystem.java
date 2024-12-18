package org.sciddi.hotel;

import org.sciddi.hotel.model.Room;
import org.sciddi.hotel.model.RoomType;
import org.sciddi.hotel.model.Visitor;
import org.sciddi.hotel.service.RoomService;
import org.sciddi.hotel.service.RoomTypeService;
import org.sciddi.hotel.service.VisitorService;

import java.time.LocalDate;
import java.util.Scanner;

public class HotelReservationSystem {
    protected final static RoomTypeService roomTypeService = new RoomTypeService();
    protected final static RoomService roomService = new RoomService();
    protected final static VisitorService visitorService = new VisitorService();

    public static void main(String[] args) {
        visitorService.setRoomService(roomService);
        prepareSampleMasterData();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Room Type");
            System.out.println("2. Add Room");
            System.out.println("3. Register Visitor");
            System.out.println("4. List Room Types");
            System.out.println("5. List Rooms");
            System.out.println("6. List Visitors");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Room Type ID: ");
                        int roomTypeId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Room Type Name: ");
                        String roomTypeName = scanner.nextLine();
                        roomTypeService.addRoomType(new RoomType(roomTypeId, roomTypeName));
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Enter Room ID: ");
                        int roomId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Room Number: ");
                        String roomNumber = scanner.nextLine();
                        System.out.print("Enter Available Start Date (YYYY-MM-DD): ");
                        LocalDate availableStartDate = LocalDate.parse(scanner.nextLine());
                        System.out.print("Enter Available End Date (YYYY-MM-DD): ");
                        LocalDate availableEndDate = LocalDate.parse(scanner.nextLine());

                        if (availableStartDate.isAfter(availableEndDate)) {
                            System.out.println("Error: Start date cannot be after end date.");
                            break;
                        }

                        System.out.print("Enter Room Type ID: ");
                        int typeId = scanner.nextInt();
                        RoomType roomType = roomTypeService.getRoomType(typeId);
                        if (roomType != null) {
                            roomService.addRoom(new Room(roomId, roomNumber, availableStartDate, availableEndDate, roomType));
                        } else {
                            System.out.println("Room Type not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Enter Visitor ID: ");
                        int visitorId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Full Name: ");
                        String fullname = scanner.nextLine();
                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter Check-In Date (YYYY-MM-DD): ");
                        LocalDate checkInDate = LocalDate.parse(scanner.nextLine());
                        System.out.print("Enter Check-Out Date (YYYY-MM-DD): ");
                        LocalDate checkOutDate = LocalDate.parse(scanner.nextLine());

                        if (checkInDate.isAfter(checkOutDate)) {
                            System.out.println("Error: Check-in date cannot be after check-out date.");
                            break;
                        }

                        System.out.print("Enter Room ID: ");
                        int roomId = scanner.nextInt();
                        visitorService.addVisitor(new Visitor(visitorId, fullname, email, checkInDate, checkOutDate), roomId);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    roomTypeService.getAllRoomTypes().forEach(System.out::println);
                    break;
                case 5:
                    roomService.getAllRooms().forEach(System.out::println);
                    break;
                case 6:
                    visitorService.getAllVisitors().forEach(System.out::println);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void prepareSampleMasterData() {
        roomTypeService.addRoomType(new RoomType(1, "Land View Room"));
        roomTypeService.addRoomType(new RoomType(2, "Sea View Room"));
        roomTypeService.addRoomType(new RoomType(3, "Land View Family Room"));
        roomTypeService.addRoomType(new RoomType(4, "Sea View Family Room"));


        int sampleRoomCount = 4;
        int roomId = 1;

        for (RoomType roomType : roomTypeService.getAllRoomTypes()) {

            for (int j=0; j<sampleRoomCount; j++) {
                LocalDate roomAvailableStartDate = LocalDate.now().minusDays(7);
                LocalDate roomAvailableEndDate = LocalDate.now().plusDays(180);

                Room newRoom = new Room(roomId, "R" + roomId, roomAvailableStartDate, roomAvailableEndDate, roomType);
                roomService.addRoom(newRoom);

                roomId++;
            }
        }

        Visitor visitor1 = new Visitor(1, "Ahmet Mehmet", "ahmetmehmet@gmail.com", LocalDate.now(), LocalDate.now().plusDays(5));
        visitorService.addVisitor(visitor1, 6);
    }
}
