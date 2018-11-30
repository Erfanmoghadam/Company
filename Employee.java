
public class Employee extends Person {
    private int numberOfRestTime = 0;
    public Employee(String name, String familyName, String userName, String password, int age, int workingRecord, int yearOfEntry, int phoneNumber) {
        super(name, familyName, userName, password, age, workingRecord, yearOfEntry, phoneNumber);
    }

    public boolean restTimeRequest(){
        numberOfRestTime = numberOfRestTime + 1;
        return numberOfRestTime <= 3;
    }
}
