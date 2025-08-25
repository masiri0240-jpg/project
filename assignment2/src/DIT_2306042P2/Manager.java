/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//mawadah asiri
//2306042
//DIT
package DIT_2306042P2;
  import java.util.Date;
public class Manager extends Employee implements Approver {

    public Manager(String name, int id, double salary) {
        super(name, id, salary);
    }
    
    @Override
    public double calculateBonus() {
        
        return getSalary() * 0.15;
        
    }
    
    @Override
    public void approveLeave(Employee employee, Date startDate, int daysOfLeave) {
        
        Leave leave = new Leave(employee, startDate, daysOfLeave); // Create a Leave object
                
        employee.addLeaveRecord(leave); 
        employee.setStateOnLeave(); 

        
    }
    
    @Override
    public void markEmployeeAsWorking(Employee employee) {
        
        employee.setStateWorking();
    
        
    }
    
}

