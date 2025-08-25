/*Name:Sarah Abdullah Alzahrani
 ID:2312065
 Section:IIS
 */
package IIS2312065P1_EasyRent;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class IIS2312065P1_EasyRent {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        final int MAX_Ticket = 100;
        File PF = new File("flight_passenger.txt");
        Scanner in2;
        PrintWriter pw;
        // Check the file if existing or not
        try (Scanner in1 = new Scanner(PF)) {
            // Check the file if existing or not
            File input = new File("input.txt");
            in2 = new Scanner(input);
            File output = new File("output.txt");
            pw = new PrintWriter(output);
            if (!PF.exists()) {
                pw.println("The file" + PF.getName() + "is not found\ncheck in" + PF.getAbsolutePath());
                System.exit(0);
            }
            if (!input.exists()) {
                pw.println("The file" + input.getName() + "is not found\ncheck in" + input.getAbsolutePath());
                System.exit(0);
            }
            int fCounter = in1.nextInt();
            int pCounter = in1.nextInt();
            Flight[] flight = new Flight[fCounter];
            Passenger[] passenger = new Passenger[pCounter];
            Ticket[] ticket = new Ticket[MAX_Ticket];
            int findex = 0;
            int pindex = 0;
            int tindex = 0;
            //read the data from flight Passenger file
            while (in1.hasNextLine()) {
                String AllLine = in1.nextLine();
                String[] split = AllLine.split(" ");
                String command = split[0];
                //check the command
                if (command.equalsIgnoreCase("AddFlight")) {
                    String flightNumber = split[1];
                    String departureCity = split[2];
                    String arrivalCity = split[3];
                    int gateNumber = Integer.parseInt(split[4]);
                    int row = Integer.parseInt(split[5]);
                    int column = Integer.parseInt(split[6]);

                    flight[findex] = new Flight(flightNumber, departureCity, arrivalCity, gateNumber, row, column);

                    pw.println("Flight" + " " + flight[findex].getFlightNumber() + " added successfully");
                    findex++;
                } else if (command.equalsIgnoreCase("AddPassenger")) {
                    String passportNumber = split[1];
                    String name = split[2];
                    Passenger p = new Passenger(passportNumber, name);
                    passenger[pindex] = p;
                    pw.println("Passenger" + " " + p.getName() + " added successfully");
                    pindex++;

                }
            }
            //read the data from input file

            while (in2.hasNext()) {

                String command = in2.next();
                if (command.equalsIgnoreCase("BookTicket")) {
                    pw.println("\n*********************BookTicket************************** \n");
                    // Read the booking information
                    String passportNumber = in2.next();
                    String flightNumber = in2.next();
                    int Row = in2.nextInt();
                    String column = in2.next();
                    String classType = in2.next();

                    boolean bookTicket = bookTicket(ticket, tindex, passenger, passportNumber, flight, flightNumber, Row, column, classType, pw);
                    if (bookTicket) {
                        tindex++;
                    }
                } else if (command.equalsIgnoreCase("GenerateInvoice")) {
                    pw.println("\n*********************Generate Ticket Invoice**************************\n");
                    int reservationNumber = in2.nextInt();
                    GenerateInvoice(ticket, tindex, reservationNumber, pw);
                } else if (command.equalsIgnoreCase("GenerateIFlightnvoice")) {
                    pw.println("\n*********************Generate Flight Invoice**************************\n");
                    String flightNumber = in2.next();
                    GenerateFlightInvoice(ticket, tindex, flight, flightNumber, pw);
                }
            }
        }
        in2.close();
        pw.flush();
        pw.close();
    }
    //This method will search for the flight number"flightNumber" in the array of flights
    //It will return the index of that flight if it exist,otherwise it will return -1

    public static int searchFlight(Flight[] flights, String flightNumber) {
        int findex = -1;
        for (int i = 0; i < flights.length; i++) {
            if (flights[i] != null && flights[i].getFlightNumber().equals(flightNumber)) {
                findex = i;
                return i;
            }
        }
        return findex;
    }
//This method will search for the passport number"passport" in the array of passengers
    //It will return the index of that passenger if it exist,otherwise it will return -1

    public static int searchPassenger(Passenger[] passengers, String passPort) {
        int pindex = -1;
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] != null && passengers[i].getPassportNumber().equals(passPort)) {
                pindex = i;
                return i;
            }
        }
        return pindex;
    }
//This method will search for the reservation number"reservationNumber" in the array of tickets
    //It will return the index of that ticket if it exist,otherwise it will return -1

    public static int searchTicket(Ticket[] tickets, int index, int Res) {

        index = -1;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] != null && tickets[i].getReservationConfirmationNumber() == Res) {
                index = i;
                return i;
            }
        }
        return index;
    }

    public static boolean bookTicket(Ticket[] tickets, int tindex, Passenger[] passenger, String passportNumber, Flight[] flight, String flightNumber, int Row, String column, String classType, PrintWriter pw) {

//Search the PassengerNumber
        int passengerPindex = searchPassenger(passenger, passportNumber);
        if (passengerPindex == -1) {

            pw.println("Passenger with Passport number " + passportNumber + " is not Registered");
            return false;
        }
        //Search the flightNumber
        int flightFindex = searchFlight(flight, flightNumber);
        if (flightFindex == -1) {

            pw.println("flight" + " " + flightNumber + " " + "Not Found");
            return false;
        }
        //Check of the seat availabilty

        boolean seatAvailable = flight[flightFindex].isSeatAvailable(Row, column.charAt(0));
        if (!seatAvailable) {

            pw.println("Seat" + " " + Row + column + " " + "is already Reserved Or Not available. ");
            return false;
        }
        boolean bookSeat = flight[flightFindex].bookSeat(Row, column.charAt(0), passportNumber);
        if (bookSeat) {

            //Create ticket object
            tickets[tindex] = new Ticket(flight[flightFindex], passenger[passengerPindex], Row, column, classType);
            // Print ticket information
            pw.println("Seat booked successfully.");
            pw.println("Ticket Information: ");
            pw.println(tickets[tindex].toString());

        }
        return true;

    }

    public static void GenerateInvoice(Ticket[] tickets, int tindex, int reservationNumber, PrintWriter pw) {
        //Search the ticket
        int searchTicket = searchTicket(tickets, tindex, reservationNumber);
        if (searchTicket == -1) {
            pw.println("Reservation Number is not available");
        } else {
            pw.println("Ticket Information: ");
            pw.println(tickets[searchTicket].toString());
            pw.println("Total ticket price = " + tickets[searchTicket].ticketPrice());
        }
    }

    public static void GenerateFlightInvoice(Ticket[] tickets, int tindex, Flight[] flights, String flightNumber, PrintWriter pw) {
        double total = 0;
        //Check iff the flight exist or not
        int flightFindex = searchFlight(flights, flightNumber);
        if (flightFindex == -1) {
            //If the flight does not exist
            pw.println("Flight Not Found or No Ticket booked for this flight");
        } else {
            pw.println("Seat Plane for flight " + flightNumber + " is:");
            pw.println("************************************");
            pw.println(flights[flightFindex].printSeatPlan());
            for (int i = 0; i < tindex; i++) {
                if (flightNumber.equals(tickets[i].getFlight().getFlightNumber())) {
                    pw.println("Ticket Information: ");
                    pw.println(tickets[i].toString());
                    total += tickets[i].ticketPrice();
                }
            }
            pw.println();
            pw.println("Total Invoice price =" + total);
            pw.println();

        }
    }
}
