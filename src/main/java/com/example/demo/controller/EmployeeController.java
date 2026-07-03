package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("employee", new Employee());

        model.addAttribute("employees",
                service.getAllEmployees());

        return "index";
    }

    @PostMapping("/save")
    public String saveEmployee(Employee employee) {

        service.saveEmployee(employee);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable int id,
                               Model model) {

        model.addAttribute("employee",
                service.getEmployeeById(id));

        model.addAttribute("employees",
                service.getAllEmployees());

        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {

        service.deleteEmployee(id);

        return "redirect:/";
    }

}