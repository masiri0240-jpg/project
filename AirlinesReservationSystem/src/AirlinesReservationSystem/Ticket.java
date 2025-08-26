/*Name:Sarah Abdullah Alzahrani
 ID:2312065
 Section:IIS
 */
package IIS2312065P1_EasyRent;

public class Ticket {

    private Flight flight;
    private Passenger passenger;
    private int seatRow;
    private String seatNumber;
    private String classType;
    private int reservationConfirmationNumber;
    private static int reservationNumber = 100;

    //The Constructor 
    public Ticket(Flight flight, Passenger passenger, int row, String seatNumber, String classType) {

        this.flight = flight;
        this.passenger = passenger;
        this.seatNumber = seatNumber;
        this.seatRow = row;
        this.classType = classType;

        reservationConfirmationNumber = reservationNumber++;
    }

    //getter and setter method
    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public String getClassType() {
        return classType;
    }

    public int getReservationConfirmationNumber() {
        return reservationConfirmationNumber;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setSeatRow(int row) {
        this.seatRow = row;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    //Calculte The price of the ticket
    public double ticketPrice() {
        double ticketPrice = 2000;
        switch (classType) {
            case "FirstClass": {
                ticketPrice += ticketPrice * 4;
                break;
            }
            case "BusinessClass": {
                ticketPrice += ticketPrice * 2;
                break;
            }
            case "EconomyClass": {
                ticketPrice = ticketPrice;
                break;
            }
        }
        //If the arrival city is "JED" has a discount 20%
        if (flight.getArrivalCity().equals("JED")) {
            ticketPrice = ticketPrice - (0.20 * ticketPrice);
        }
        //Calculte The total Price ticket
        ticketPrice = ticketPrice * 0.15 + ticketPrice;
        return ticketPrice;
    }

    public String toString() {
        return ("Reservation Confirmation Number=" + reservationConfirmationNumber 
                + ", Flight Number=" + flight.getFlightNumber() 
                + ", Passenger Name=" + passenger.getName() 
                + ", Seat Number=" + seatRow + seatNumber + ", classType=" + classType);

    }

}
