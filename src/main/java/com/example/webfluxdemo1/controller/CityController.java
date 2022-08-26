package com.example.webfluxdemo1.controller;

import com.example.webfluxdemo1.model.City;
import com.example.webfluxdemo1.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RestController
@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("city/{id}")
    public ResponseEntity<Mono<City>> findCityById(@PathVariable("id") Long id) {
        //return cityService.findCityById(id);
        return ResponseEntity.ok(cityService.findCityById(id));
    }

    @GetMapping("/city")
    public ResponseEntity<Flux<City>> findAllCity() {
        //return cityService.findAllCity();
        return ResponseEntity.ok(cityService.findAllCity());
    }

    @PostMapping("/city")
    public ResponseEntity<Mono<Long>> saveCity(@RequestBody City city) {
        return ResponseEntity.ok(cityService.save(city));
    }

    @PutMapping("/city")
    public ResponseEntity<Mono<Long>> modifyCity(@RequestBody City city) {
        //return cityService.modifyCity(city);
        return ResponseEntity.ok(cityService.modifyCity(city));
    }

    @DeleteMapping("city/{id}")
    public ResponseEntity<Mono<Long>> deleteCity(@PathVariable("id") Long id) {
        //return cityService.deleteCity(id);
        return ResponseEntity.ok(cityService.deleteCity(id));
    }

    @GetMapping("/page/list")
    public String listPage(final Model model) {
        final Flux<City> cityFluxList = cityService.findAllCity();
        model.addAttribute("cityList", cityFluxList);

        /*Context context = new Context();

        model.asMap().forEach(context::setVariable);

        return tempTemplateEngine.process("cityList", context);*/

        return "cityList";
    }
}
