/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//mawadah asiri
//2306042
//DIT
package DIT_2306042P2;
import java.util.Date;

public class Leave {
    
    private Employee employee;
    private Date startDate;
    private int daysOfLeave;

    public Leave(Employee employee, Date startDate, int daysOfLeave) {
        this.employee = employee;
        this.startDate = startDate;
        this.daysOfLeave = daysOfLeave;
    }
    
    public String displayLeaveDetails() {
        
        String date_as_string = String.format("%4d-%2d-%2d", startDate.getYear(), startDate.getMonth(), startDate.getDate());
        date_as_string = date_as_string.replaceAll(" ", "0");
        
        return date_as_string+ "   " +daysOfLeave;
        
    }
    
}