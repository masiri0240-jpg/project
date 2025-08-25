/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//mawadah asiri
//2306042
//DIT
package DIT_2306042P2;
public class Developer extends Employee {

    public Developer(String name, int id, double salary) {
        super(name, id, salary);
    }
    
    @Override
    public double calculateBonus() {
        
        return getSalary() * 0.12;
        
    }
    
}