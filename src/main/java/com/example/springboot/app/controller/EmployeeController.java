package com.example.springboot.app.controller;

import com.example.springboot.app.exception.Mensaje;
import com.example.springboot.app.model.Employee;
import com.example.springboot.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    // Metodo por GET y URL
    @GetMapping("/listaemployee")
    public ResponseEntity<?> getAllEmployee(){
        List<Employee> lista = employeeService.getAllEmployee();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin empleados en la base de datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(employeeService.getAllEmployee());
    }

    // Definimos que a nuestro metodo se accede por peticion GET y por URL
    @GetMapping("/detalleemployee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        return ResponseEntity.ok().body(this.employeeService.getEmployeeById(id));
    }

    // Definimos que nuestro metodo solo para hacer uso de el, debe ser UNICAMENTE por POST
    @PostMapping("/creaemployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok().body(this.employeeService.createEmployee(employee));
    }

    // Para actualizar los datos de un empleado es a traves de la peticion PUT, realiza una actualizacion
    @PutMapping("/actualizaemployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
        employee.setId(id);
        return ResponseEntity.ok().body(this.employeeService.updateEmployee(employee));
    }

    // Para eliminar un employee de DB, se hace por medio de la peticion DELETE, el id del prodcuto a eliminar
    @DeleteMapping("/eliminaemployee/{id}")
    public HttpStatus deleteEmployee(@PathVariable long id){
        this.employeeService.deleteEmployee(id);
        return HttpStatus.OK;
    }
}
