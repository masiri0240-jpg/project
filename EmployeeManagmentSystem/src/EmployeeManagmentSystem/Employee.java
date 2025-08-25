/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//mawadah asiri
//2306042
//DIT
package DIT_2306042P2;

import java.util.ArrayList;

public abstract class Employee {

    private String name;
    private int id;
    private double salary;
    private String state = "Working";
    private ArrayList<Leave> leaveRecords = new ArrayList<>();

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract double calculateBonus();

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", id=" + id + ", salary=" + salary + ", state=" + state + ", leaveRecords=" + leaveRecords + '}';
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public String getState() {
        return state;
    }

    public void setStateOnLeave() {

        state = "Leave";

    }

    public void setStateWorking() {

        state = "Working";

    }

    public void addLeaveRecord(Leave leave) {

        leaveRecords.add(leave);

    }

    public ArrayList<Leave> getLeaveRecords() {
        return leaveRecords;
    }

}
