/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//mawadah asiri
//2306042
//DIT
package DIT_2306042P2;
import java.util.Date;

public interface Approver {
    
    public void approveLeave(Employee employee, Date startDate, int daysOfLeave);
    
    public void markEmployeeAsWorking(Employee employee);
    
}
