package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
     @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee){
         employee.setEmployeeCode(UUID.randomUUID().toString());
         return employeeRepo.save(employee);
    // in here the jpa repository which we extended to our EmployeeRepo interface helps us to do basic
        // query without having to do it manually

    }
    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee){
         return employeeRepo.save(employee);
    }

    //    public Employee findEmployeeById(Long Id){
//         return employeeRepo.findEmployeeById(Id).
//                 orElseThrow(()->new UserNotFoundException("User by id"+Id+"was not found"));
//    }
    public Employee findEmployeeById(Long id){
         return employeeRepo.findById(id). orElseThrow(()->new UserNotFoundException("User by id"+id+"was not found"));
    }

    public void deleteEmployee(Long Id){
         employeeRepo.deleteById(Id);
    }
}
