package com.example.springboot.app.controller;
import com.example.springboot.app.exception.Mensaje;
import com.example.springboot.app.model.Airport;
import com.example.springboot.app.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {
    @Autowired
    private AirportService airportService;

    // FIND ALL - Metodo por GET y URL
    @GetMapping("/listaairport")
    public ResponseEntity<?> getAllAirport(){
        List<Airport> lista = airportService.getAllAirport();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin empleados en la base de datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(airportService.getAllAirport());
    }

    // FIND BY ID - Definimos que a nuestro metodo se accede por peticion GET y por URL
    @GetMapping("/detalleairport/{idAirport}")
    public ResponseEntity<Airport> getByAirportId(@PathVariable long idAirport) {
        return ResponseEntity.ok().body(this.airportService.getAirportById(idAirport));
    }

    // CREATE - Definimos que nuestro metodo solo para hacer uso de el, debe ser UNICAMENTE por POST
    @PostMapping("/apiv1/clientes/add")
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        return ResponseEntity.ok().body(this.airportService.createAirport(airport));
    }

    // UPDATE - Para actualizar los datos de un empleado es a traves de la peticion PUT, realiza una actualizacion
    @PutMapping("/actualizaairport/{idAirport}")
    public ResponseEntity<Airport> updateAirport(@PathVariable long idAirport, @RequestBody Airport airport){
        airport.setId(idAirport);
        return ResponseEntity.ok().body(this.airportService.updateAirport(airport));
    }

    // DELETE - Para eliminar un airport de DB, se hace por medio de la peticion DELETE, el id del prodcuto a eliminar
    @DeleteMapping("/eliminaairport/{idAirport}")
    public HttpStatus deleteAirport(@PathVariable long idAirport){
        this.airportService.deleteAirport(idAirport);
        return HttpStatus.OK;
    }
}
