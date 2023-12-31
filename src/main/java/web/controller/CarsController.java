package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    private final CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(name = "count", defaultValue = "5") int count, ModelMap model) {
        List<Car> cars = carService.getCars(count);

        List<String> messages = new ArrayList<>();
        for (Car car : cars) {
            messages.add(car.toString());
        }
        model.addAttribute("messages", messages);
        return "cars";
    }
}
