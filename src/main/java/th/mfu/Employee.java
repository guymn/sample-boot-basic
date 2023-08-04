package th.mfu;

import java.util.Date;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private long id;

    @JsonProperty("fistName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("birthDay")
    private Date birthDay;

    @JsonProperty("salary")
    private long salary;

    public Employee(long id, String fistName, String lastName, Date birthDay, long salary) {
        this.id = id;
        this.firstName = fistName;
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
