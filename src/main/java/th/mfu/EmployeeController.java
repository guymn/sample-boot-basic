package th.mfu;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private HashMap<Long, Employee> employeeDB = new HashMap<Long, Employee>();

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployee() {
        return employeeDB.values();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
        if (!employeeDB.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(employeeDB.get(id));
    }

    @PostMapping("/employees")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        if (employeeDB.containsKey(employee.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Employee id already exists");
        }
        employeeDB.put(employee.getId(), employee);
        return ResponseEntity.ok("Employee created");
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable long id, @PathVariable Employee employee) {
        employeeDB.put(id, employee);
        return ResponseEntity.ok("Employee updated");

    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
        employeeDB.remove(id);
        return ResponseEntity.ok("Employee is deleted");
    }

    @PatchMapping("/employees/{id}")
    public ResponseEntity<String> patchEmployee(@PathVariable long id,
            @RequestBody HashMap<String, Object> fieldstoupdate) {
        // check if id not exists
        if (!employeeDB.containsKey(id)) {
            // return error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }

        // get employee from db
        Employee emp = employeeDB.get(id);
        // loop throught fields to update
        fieldstoupdate.forEach((key, value) -> {
            // check if field is firstname
            if (key.equals("first_name")) {
                // update firstname
                emp.setFirstName((String) value);
            }
            // check if field is lastname
            if (key.equals("last_name")) {
                // update lastname
                emp.setLastName((String) value);
            }

            // check if field is salary
            if (key.equals("salary")) {
                // update salary
                emp.setSalary(Long.valueOf("" + value));
            }

        });

        // update employee
        employeeDB.put(id, emp);

        // return success message
        return ResponseEntity.ok("Employee updated");
    }
}