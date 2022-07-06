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

    // FIND ALL - Metodo por GET y URL
    @GetMapping("/listaemployee")
    public ResponseEntity<?> getAllEmployee(){
        List<Employee> lista = employeeService.getAllEmployee();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin empleados en la base de datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(employeeService.getAllEmployee());
    }

    // FIND BY ID - Definimos que a nuestro metodo se accede por peticion GET y por URL
    @GetMapping("/detalleemployee/{idEmployee}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long idEmployee) {
        return ResponseEntity.ok().body(this.employeeService.getEmployeeById(idEmployee));
    }

    // CREATE - Definimos que nuestro metodo solo para hacer uso de el, debe ser UNICAMENTE por POST
    @PostMapping("/apiv1/clientes/add")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok().body(this.employeeService.createEmployee(employee));
    }

    // UPDATE - Para actualizar los datos de un empleado es a traves de la peticion PUT, realiza una actualizacion
    @PutMapping("/actualizaemployee/{idEmployee}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long idEmployee, @RequestBody Employee employee){
        employee.setId(idEmployee);
        return ResponseEntity.ok().body(this.employeeService.updateEmployee(employee));
    }

    // DELETE - Para eliminar un employee de DB, se hace por medio de la peticion DELETE, el id del prodcuto a eliminar
    @DeleteMapping("/eliminaemployee/{idEmployee}")
    public HttpStatus deleteEmployee(@PathVariable long idEmployee){
        this.employeeService.deleteEmployee(idEmployee);
        return HttpStatus.OK;
    }
}
