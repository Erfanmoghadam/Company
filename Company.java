import java.util.ArrayList;
import java.util.Scanner;

public class Company {
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Employee> BlockedEmployees = new ArrayList<>();
    private ArrayList<Person> personWhoReserveLunch = new ArrayList<>();
    private ArrayList<Person> PersonWhoReserveDinner = new ArrayList<>();
    private Manager manager1 = new Manager("manager1","","manager1","123",1,2,1,1);
    private Manager manager2 = new Manager("manager2","","manager2","123",1,2,1,1);
    private ArrayList<Manager> allManagers = new ArrayList<>();

    private String loggedInUserName = "";

    private void signUpEmployee(){
         String name, familyName, userName = "",password;
         int age,workingRecord,yearOfEntry,phoneNumber;
         Employee employee;
        System.out.println("Please Write The Following Stuffs...");
        Scanner input = new Scanner(System.in);
        System.out.println("Name : ");
        name = input.nextLine();
        System.out.println("Family Name : ");
        familyName = input.nextLine();
        System.out.println("User Name : ");
        userName = input.nextLine();
        while (findEmployee(userName) != -1) {
            System.out.println("User Name : ");
            userName = input.nextLine().toLowerCase();
            if (findEmployee(userName) != -1){
                System.out.println("Sorry Some Body Choose This UserName Choose Another One...");
            }
        }
        System.out.println("Password : ");
        password = input.nextLine().toLowerCase();
        System.out.println("Age : ");
        age = input.nextInt();
        System.out.println("Working Record : ");
        workingRecord = input.nextInt();
        System.out.println("Year Of Entry : ");
        yearOfEntry = input.nextInt();
        System.out.println("Phone Number : ");
        phoneNumber = input.nextInt();
        employee = new Employee(name,familyName,userName,password,age,workingRecord,yearOfEntry,phoneNumber);
        employees.add(employee);
        System.out.println("You Signed Up SuccessFully;)");
    }
    private int findEmployee(String userName){
        for (int i=0;i<employees.size();i++){
            if (employees.get(i).getUserName().equals(userName)){
                return i;
            }
        }
        return -1;
    }
    private int findBlockedEmployee(String userName){
        for (int i=0;i<BlockedEmployees.size();i++){
            if (BlockedEmployees.get(i).getUserName().equals(userName)){
                return i;
            }
        }
        return -1;
    }
    private int findManager(String userName){
        for (int i=0;i<allManagers.size();i++){
            if (allManagers.get(i).getUserName().equals(userName)){
                return i;
            }
        }
        return -1;
    }
    private boolean SignInEmployee(){
        Scanner input = new Scanner(System.in);
        String userName, password = "";
        System.out.println("Please Write The Following Stuffs ...");
        System.out.println("User Name : ");
        userName = input.nextLine().toLowerCase();
        if (findEmployee(userName) != -1&&!BlockedEmployees.contains(employees.get(findEmployee(userName)))) {
            if (findEmployee(userName) != -1) {
                password = employees.get(findEmployee(userName)).getPassword();
            }
            for (int i = 0; i < 3; i++) {
                String writtenPassword;
                if (i == 0) {
                    System.out.println("Password : ");
                    writtenPassword = input.nextLine();
                    if (writtenPassword.toLowerCase().equals(password)) {
                        System.out.println("You Are LoggedIn.");
                        loggedInUserName = userName;
                        return true;
                    }
                } else {
                    System.out.println("Your Password Is Wrong Try Again For " + (3 - i) + "Times");
                    writtenPassword = input.nextLine();
                    if (writtenPassword.toLowerCase().equals(password)) {
                        System.out.println("You Are LoggedIn.");
                        loggedInUserName = userName;
                        return true;
                    }
                }

            }
            System.out.println("Your Account Blocked :( Called Your Manager...");
            BlockedEmployees.add(employees.get(findEmployee(userName)));
            return false;
        }
        System.out.println("Your Account Is Blocked:( Called Your Manager...");
        return false;
    }
    private boolean signInManager(){
        Scanner input = new Scanner(System.in);
        String userName, password = "";
        System.out.println("Please Write The Following Stuffs ...");
        System.out.println("User Name : ");
        userName = input.nextLine().toLowerCase();
        if (findManager(userName) != -1) {
                password = allManagers.get(findManager(userName)).getPassword();
            }
            for (int i = 0; i < 3; i++) {
                String writtenPassword;
                if (i==0){
                    System.out.println("Password : ");
                    writtenPassword = input.nextLine().toLowerCase();
                    if (password.equals(writtenPassword)){
                        System.out.println("You Are LoggedIn.");
                        return true;
                    }
                    else {
                        System.out.println("Your Password Is Wrong Try Again For " + (3-i) + " Times.");
                        writtenPassword = input.nextLine().toLowerCase();
                        if (password.equals(writtenPassword)){
                            System.out.println("You Are LoggedIn.");
                            return true;
                        }
                    }
                }
            }
        return false;
    }


    public static void main(String[] args) {
        Company company = new Company();
        Scanner input = new Scanner(System.in);
        String degreeOfPerson = "";
        company.allManagers.add(company.manager1);
        company.allManagers.add(company.manager2);
        while (!degreeOfPerson.toLowerCase().equals("exit")) {
            System.out.println("Please Write You Are Employee Or Manager.");
            degreeOfPerson = input.nextLine();
            switch (degreeOfPerson.toLowerCase()) {
                case "manager":
                    Manager manager = new Manager("manager","manager","manager","",0,0,1,2);
                    boolean managerFlag = company.signInManager();
                    while (managerFlag){
                        System.out.println("What Do You Want TO DO ? ");
                        String kindOfOperation = input.nextLine().toLowerCase();
                        if (kindOfOperation.toLowerCase().equals("logout")){
                            System.out.println("Bye");
                            break;
                        }
                        switch (kindOfOperation.toLowerCase()){
                            case "reserve dinner":
                                company.PersonWhoReserveDinner.add(manager);
                                System.out.println("Your Dinner SuccessFully Reserved:)");
                                break;
                            case "reserve lunch":
                                company.personWhoReserveLunch.add(manager);
                                System.out.println("Your Lunch SuccessFully Reserved:)");

                                break;
                            case "remove employee":
                                System.out.println("Please Write The userName Of The  Employee That You Want To Remove.");
                                company.employees = manager.removeEmployee(input.nextLine(),company.employees);
                                System.out.println("The Employee Removed:(");
                                break;
                            case "unblocking employee":
                                System.out.println("Please Write The UserName Of The Employee...");
                                company.BlockedEmployees = manager.giveAccessToTheBlockedEmployee(company.BlockedEmployees.get(company.findBlockedEmployee(input.nextLine())), company.BlockedEmployees);
                                System.out.println("The Employee Unblocked:)");
                                break;
                        }

                    }
                    break;
                case "employee":
                    System.out.println("You Should SignUp First.");
                    System.out.println("Do You SignUp ? ");
                    if (!input.nextLine().toLowerCase().equals("yes")) {
                        company.signUpEmployee();
                    }
                    boolean flag = company.SignInEmployee();
                    while (flag){
                        System.out.println("What Do You Want TO DO ? ");
                        String kindOfOperation = input.nextLine().toLowerCase();
                        if (kindOfOperation.toLowerCase().equals("logout")){
                            System.out.println("Bye");
                            break;
                        }
                        switch (kindOfOperation.toLowerCase()){
                            case "reserve dinner":
                                company.PersonWhoReserveDinner.add(company.employees.get(company.findEmployee(company.loggedInUserName)));
                                System.out.println("Your Dinner SuccessFully Reserved:)");
                                break;
                            case "reserve lunch":
                                company.personWhoReserveLunch.add(company.employees.get(company.findEmployee(company.loggedInUserName)));
                                System.out.println("Your Lunch SuccessFully Reserved:)");

                                break;
                            case "morakhasi":
                                if(company.employees.get(company.findEmployee(company.loggedInUserName)).restTimeRequest()){
                                    System.out.println("Enjoy It...");
                                }
                                else {
                                    System.out.println("you cannot use this any more:(");
                                }
                                break;
                                        }

                    }
                    break;
            }
        }
    }
}
