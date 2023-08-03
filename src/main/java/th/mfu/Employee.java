package th.mfu;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
    @JsonProperty("id")
    private long id;

    @JsonProperty("fistName")
    private String fistName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("birthDay")
    private Date birthDay;

    @JsonProperty("salary")
    private long salary;

    public Employee(long id, String fistName, String lastName, Date birthDay, long salary) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

}
