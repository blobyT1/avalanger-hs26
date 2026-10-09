package ch.zhaw.avalanger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
//gemeinsamer Teil der URL für alle Methoden in diesem Controller
@RequestMapping("/api/avalange")
public class AvalangeController {
    //ohne oder mit Pathvariable möglich
    @GetMapping({"", "/{country}"})
    public String getAllAvelanges(@PathVariable(required = false) String country,
                                  @RequestParam(required = false) String state) {
        return "No avelanges found for country: " + country + ", state: " + state;
    } 
}
