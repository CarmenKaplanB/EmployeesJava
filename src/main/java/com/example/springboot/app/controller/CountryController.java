package com.example.springboot.app.controller;
import com.example.springboot.app.exception.Mensaje;
import com.example.springboot.app.model.Country;
import com.example.springboot.app.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    // FIND ALL - Metodo por GET y URL
    @GetMapping("/listacountry")
    public ResponseEntity<?> getAllCountry(){
        List<Country> lista = CountryService.getAllCountry();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin empleados en la base de datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(CountryService.getAllCountry());
    }

    // FIND BY ID - Definimos que a nuestro metodo se accede por peticion GET y por URL
    @GetMapping("/detallecountry/{id}")
    public ResponseEntity<Country> getByCountryId(@PathVariable long id) {
        return ResponseEntity.ok().body(this.countryService.getCountryById(id));
    }

    // CREATE - Definimos que nuestro metodo solo para hacer uso de el, debe ser UNICAMENTE por POST
    @PostMapping("/creacountry")
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        return ResponseEntity.ok().body(this.countryService.createCountry(country));
    }

    // UPDATE - Para actualizar los datos de un empleado es a traves de la peticion PUT, realiza una actualizacion
    @PutMapping("/actualizacountry/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable long id, @RequestBody Country country){
        country.setId(id);
        return ResponseEntity.ok().body(this.countryService.updateCountry(country));
    }

    // DELETE - Para eliminar un country de DB, se hace por medio de la peticion DELETE, el id del prodcuto a eliminar
    @DeleteMapping("/eliminacountry/{id}")
    public HttpStatus deleteCountry(@PathVariable long id){
        this.countryService.deleteCountry(id);
        return HttpStatus.OK;
    }
}
