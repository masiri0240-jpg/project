/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//mawadah asiri
//2306042
//DIT
package DIT_2306042P2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeManagementSystem {

    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

        // we create a File object for each of the files
        File inputF = new File("input.txt");
        File outputF = new File("output.txt");

        // we check if the input file exists or not if not then exit
        if (!inputF.exists()) {
            System.out.println("The input files does not exist ");
            System.exit(0);
        }

        //Make the scanner and printWriter
        Scanner input = new Scanner(inputF);
        PrintWriter output = new PrintWriter(outputF);

        //we make a loop that will read the lines from the input file
        while (input.hasNext()) {

            String command_line = input.nextLine();

            // Split the data in the command line
            String[] details = command_line.split(",");
            // then we will check the value of index 0 and do a different process at each situation
            if (details[0].equals("Add_Manager")) {

                String name = details[1].trim();
                int id = Integer.parseInt(details[2].trim());
                double salary = Double.parseDouble(details[3].trim());

                Manager manager = new Manager(name, id, salary);

                String message = addEmployee(manager);

                output.println(message);

            } else if (details[0].equals("Add_Developer")) {

                String name = details[1].trim();
                int id = Integer.parseInt(details[2].trim());
                double salary = Double.parseDouble(details[3].trim());

                Developer developer = new Developer(name, id, salary);

                String message = addEmployee(developer);

                output.println(message);

            } else if (details[0].equals("Add_Designer")) {

                String name = details[1].trim();
                int id = Integer.parseInt(details[2].trim());
                double salary = Double.parseDouble(details[3].trim());

                Designer designer = new Designer(name, id, salary);

                String message = addEmployee(designer);

                output.println(message);

            } else if (details[0].equals("Give_Leave")) {

                int manager_id = Integer.parseInt(details[1].trim());
                int employee_id = Integer.parseInt(details[2].trim());

                String date_as_string = details[3].trim();

                String[] splitter_date = date_as_string.split("-");
                int year = Integer.parseInt(splitter_date[0]);
                int month = Integer.parseInt(splitter_date[1]);
                int day = Integer.parseInt(splitter_date[2]);

                Date date = new Date(year, month, day);

                int duration = Integer.parseInt(details[4].trim());

                String message = approveLeave(manager_id, employee_id, date, duration);

                output.println(message);

            } else if (details[0].equals("Change_State")) {

                int manager_id = Integer.parseInt(details[1].trim());
                int employee_id = Integer.parseInt(details[2].trim());

                String message = markEmployeeAsWorking(manager_id, employee_id);

                output.println(message);

            } else if (details[0].equals("del_Employee")) {

                int id = Integer.parseInt(details[1].trim());

                String message = removeEmployee(id);

                output.println(message);

            } else if (details[0].equals("printAllEmployees")) {

                String message = printAllEmployees();

                output.println(message);

            } else if (details[0].equals("print_Leave_Records")) {

                int id = Integer.parseInt(details[1].trim());

                String message = printEmployeeLeaveRecords(id);

                output.println(message);

            }

        }

        input.close();
        output.close();

    }

    // This method will add the employee to the employees ArrayList
    public static String addEmployee(Employee employee) {

        // Add the employee to the employees arrayList
        employees.add(employee);

        // Return the appropriate message 
        if (employee instanceof Manager) {

            return "Manager " + employee.getName() + " added.";
        } else if (employee instanceof Developer) {

            return "Developer " + employee.getName() + " added.";
        } else {

            return "Designer " + employee.getName() + " added.";
        }

    }

    // This method will remove the employee in the arrayList
    public static String removeEmployee(int id) {

        // Search for the employee object using the method findEmployeeById
        Employee employee = findEmployeeById(id);

        if (employee != null) {
// If employee found

            employees.remove(employee);
// Remove the employee from the ArrayList

            return "Employee removed successfully.";
        } else {
// If employee not found

            return "Employee with ID " + id + " not found.";
        }

    }

    // make a method that stores the data of employees in the ArrayList
    public static String printAllEmployees() {

        String result = "";

        result += "Name            ID    Salary     Bonus";

        for (int i = 0; i < employees.size(); i++) {

            result += String.format("\n%-16s%-6d%-11.2f%11.2f", employees.get(i).getName(), employees.get(i).getId(), employees.get(i).getSalary(), employees.get(i).calculateBonus());
        }

        return result;

    }

    // a method that will approve a leave for an employee
    public static String approveLeave(int managerId, int employeeId, Date startDate, int days) {

        // Search for the manager object using the method "findEmployeeById"
        Employee manager = findEmployeeById(managerId);

        // Check if the manager object is an instanceof Approver or not
        if (manager instanceof Approver) {

            Employee employee = findEmployeeById(employeeId);

            if (employee != null) {
// If the employee is found

                if (employee.getState().equals("Working")) { // If the employee state is "Working" , then it will be able to get leave

                    Leave leave = new Leave(employee, startDate, days); //we create a Leave object

                    employee.addLeaveRecord(leave); // we add the leave object to the employee leave records
                    employee.setStateOnLeave(); // Set employee state to Leave

                    return "Leave approved for " + employee.getName() + ".";
                } else { // If the employee state is set to "Leave" then it will not be able to get leave

                    return "Cannot approve leave for " + employee.getName() + " as they are already on leave.";
                }

            } else {
// If the employee not found

                return "Leave approval failed. Either manager ID is incorrect or employee ID does not exist.";
            }

        } else {

            return "Leave approval failed. Either manager ID is incorrect or employee ID does not exist.";
        }

    }

    // This method will set the state of the employee to Working
    public static String markEmployeeAsWorking(int managerId, int employeeId) {

        // we search for the manager object using the method findEmployeeById
        Employee manager = findEmployeeById(managerId);

        // we check if the manager object is an instanceof or not
        if (manager instanceof Approver) {

            // we search for the employee object using the method findEmployeeById
            Employee employee = findEmployeeById(employeeId);

            if (employee != null) {
// If the employee is found

                employee.setStateWorking();
// Set the employee state to Working

                return "Employee " + employee.getName() + " is now marked as working.";
            } else {
// If the employee is not found

                return "Either manager ID is incorrect or employee ID does not exist.";
            }

        } else {

            return "Either manager ID is incorrect or employee ID does not exist.";
        }

    }

    // This method will search for the id in the employees ArrayList
    private static Employee findEmployeeById(int id) {

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                return employees.get(i);
            }
        }

        return null;

    }

    //method that print the leave records of the employee
    public static String printEmployeeLeaveRecords(int employeeId) {

        //Search  the employee object using the method findEmployeeById
        Employee employee = findEmployeeById(employeeId);

        if (employee != null) {
// If the employee is found

            String result = "";

            //store data of the employee leave records in the string named result
            result += "Leave Records for " + employee.getName() + ":";
            result += "\nStart Date   Days of Leave";

            for (int i = 0; i < employee.getLeaveRecords().size(); i++) {

                result += "\n" + employee.getLeaveRecords().get(i).displayLeaveDetails();
            }

            return result;

        } else { // If the employee is not found

            return "Employee with ID " + employeeId + " not found.";
        }

    }

}
