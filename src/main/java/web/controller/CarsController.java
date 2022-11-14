package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/cars")
public class CarsController {

    private final CarServiceImpl carService;

    public CarsController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCarsByCount(@RequestParam(value = "count", required = false) Integer count, Model model) {
        if (count != null) {
            model.addAttribute("cars", carService.getCarsByCount(count));
        } else {
            model.addAttribute("cars", carService.getCars());
        }
        return "cars";
    }
}
