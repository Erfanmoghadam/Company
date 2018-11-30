import java.util.ArrayList;

public class Manager extends Person {
    public Manager(String name, String familyName, String userName, String password, int age, int workingRecord, int yearOfEntry, int phoneNumber) {
        super(name, familyName, userName, password, age, workingRecord, yearOfEntry, phoneNumber);
    }
     ArrayList<Employee> removeEmployee(String userName, ArrayList<Employee>Employee){
        int indexOfRemove = -1;
        for (int i=0;i<Employee.size();i++){
            if (Employee.get(i).getUserName().equals(userName)){
                indexOfRemove = i;
            }
        }
        if (indexOfRemove != -1) {
            Employee.remove(indexOfRemove);
        }
        return Employee;
    }

     ArrayList<Employee> giveAccessToTheBlockedEmployee(Employee blockedEmployee, ArrayList<Employee> listOfBlockedEmployees){
        listOfBlockedEmployees.remove(blockedEmployee);
        return listOfBlockedEmployees;
    }

}
