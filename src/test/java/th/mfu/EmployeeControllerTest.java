package th.mfu;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class EmployeeControllerTest {

    @Autowired
    EmployeeController controller;

    // test query all
    @Test
    public void testGetAllEmployees() {
        // Act
        Collection<Employee> response = controller.getAllEmployees();
        // Assert
        assertEquals(10, response.size());
    }

    // test create
    @Test
    public void testCreate() {
        Employee newemp = new Employee();
        newemp.setFirstname("David");
        newemp.setLastname("Miller");
        newemp.setBirthday(new Date());
        newemp.setSalary(100000);
        // Act
        ResponseEntity response = controller.createEmployee(newemp);
        // Assert check if response is ok
        assertEquals(200, response.getStatusCodeValue());

        ResponseEntity response2 = controller.getEmployeeByFirstname("David");
        // check if response2 returned with proper status code
        assertEquals(200, response2.getStatusCodeValue());

    }

    // test delete
    @Test
    public void testDelete() {
        ResponseEntity response = controller.deleteEmployee(90);
        assertEquals(200, response.getStatusCodeValue());

        ResponseEntity response2 = controller.deleteEmployee(90);
        assertEquals(404, response2.getStatusCodeValue());
    }

    // test update
    @Test
    public void testUpdate() {
        ResponseEntity res = controller.getEmployeeById(91);
        Employee employee = (Employee) res.getBody();
        employee.setFirstname("guy");
        ResponseEntity response = controller.updateEmployee(employee);
        assertEquals(200, response.getStatusCodeValue());
    }
}
