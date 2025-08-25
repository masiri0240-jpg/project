/*Name:Sarah Abdullah Alzahrani
 ID:2312065
 Section:IIS
 */
package IIS2312065P1_EasyRent;

public class Flight {

    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    private int gateNumber;
    private String[][] seatMap;
    private int row;
    private int column;

    //The Constructor
    public Flight(String flightNumber, String departureCity, String arrivalCity, int gateNumber, int r, int c) {

        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.gateNumber = gateNumber;
        this.row = r;
        this.column = c;
        this.seatMap = new String[row][column];
        createMap(seatMap);
    }

    public void createMap(String seatMap[][]) {

        for (int i = 0; i < seatMap.length; i++) {
            for (int j = 0; j < seatMap[i].length; j++) {
                seatMap[i][j] = "o";
            }
        }
    }

    //getter and setter method
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public String[][] getSeatMap() {
        return seatMap;
    }

    public int getRow() {
        return row;
    }

    public int getcolumn() {
        return column;
    }

    public void setRow(int r) {
        this.row = r;
    }

    public void setColumn(int c) {
        this.column = c;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public boolean bookSeat(int row, char columnChar, String passengerID) {
        int column = (int) columnChar - (int) 'A';

        if (isSeatAvailable(row, columnChar)) {
            seatMap[row][column] = passengerID;
            return true;
        } else {
            return false;
        }
    }

    public boolean isSeatAvailable(int row, char columnChar) {
        int column = (int) columnChar - (int) 'A';

        if (((row < 0 || row >= this.row) || (column < 0 || column >= this.column)) || (!seatMap[row][column].equalsIgnoreCase("o"))) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return (" flightNumber=" + flightNumber + " , departureCity=" + departureCity + " , arrivalCity=" + arrivalCity + " , gateNumber=" + gateNumber + " ,seatMap=" + seatMap + ",row=" + row + ",column=" + column);

    }

    public String printSeatPlan() {
        String seatPlan = "";

        for (int i = 0; i <= seatMap[0].length; i++) {
            if (i == 0) {
                seatPlan += "Row\t\t";
            } else {
                seatPlan += ((char) ('a' + i - 1) + "\t\t");
            }
        }
        seatPlan += ("\n");
        for (int i = 0; i < seatMap.length; i++) {
            for (int j = 0; j <= seatMap[0].length; j++) {
                if (j == 0) {
                    seatPlan += (i + "\t\t");
                } else {
                    seatPlan += (seatMap[i][j - 1]) + "\t\t";
                }
            }
            seatPlan += ("\n");
        }
        return seatPlan;
    }
}
