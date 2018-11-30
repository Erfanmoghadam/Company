public class Person {
    private String name, familyName, userName,password;
    private int age,workingRecord,yearOfEntry,phoneNumber;

    public Person(String name, String familyName, String userName, String password, int age, int workingRecord, int yearOfEntry, int phoneNumber) {
        this.name = name;
        this.familyName = familyName;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.workingRecord = workingRecord;
        this.yearOfEntry = yearOfEntry;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public int getWorkingRecord() {
        return workingRecord;
    }

    public int getYearOfEntry() {
        return yearOfEntry;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
}
