package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WebTableModel {

    private String firstName;
    private String lastName;
    private String userEmail;
    private String age;
    private String salary;
    private String department;
    private String editFirstNameElement;
    private String editLastNameElement;
    private String editEmailElement;
    private String editAgeElement;

    public WebTableModel (String jasonFilePath){
        populateObject(jasonFilePath);
    }

    public void populateObject(String jsonFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.readerForUpdating(/*valueToUpdate*/ this)
                    .readValue(Files.readAllBytes(Paths.get(jsonFilePath)));
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as needed
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEditFirstNameElement() {
        return editFirstNameElement;
    }

    public void setEditFirstNameElement(String editFirstNameElement) {
        this.editFirstNameElement = editFirstNameElement;
    }

    public String getEditLastNameElement() {
        return editLastNameElement;
    }

    public void setEditLastNameElement(String editLastNameElement) {
        this.editLastNameElement = editLastNameElement;
    }

    public String getEditEmailElement() {
        return editEmailElement;
    }

    public void setEditEmailElement(String editEmailElement) {
        this.editEmailElement = editEmailElement;
    }

    public String getEditAgeElement() {
        return editAgeElement;
    }

    public void setEditAgeElement(String editAgeElement) {
        this.editAgeElement = editAgeElement;
    }
}
