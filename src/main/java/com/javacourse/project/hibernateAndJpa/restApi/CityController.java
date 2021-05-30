package com.javacourse.project.hibernateAndJpa.restApi;

import com.javacourse.project.hibernateAndJpa.Business.ICityService;
import com.javacourse.project.hibernateAndJpa.Entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    private ICityService cityService;

    @Autowired
    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public ResponseEntity<List<City>> getAll(){ return ResponseEntity.ok(this.cityService.getAll()); }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody City city){
        int id = this.cityService.add(city);
        URI location = URI.create(String.format("/api/%d", id));
        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/update")
    public ResponseEntity update(@RequestBody City city){
        this.cityService.update(city);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestBody City city){
        this.cityService.delete(city);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<City> getById(@PathVariable int id){
        return ResponseEntity.ok(this.cityService.getById(id));
    }
}
