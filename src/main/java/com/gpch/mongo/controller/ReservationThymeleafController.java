package com.gpch.mongo.controller;

import com.gpch.mongo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationThymeleafController {

    private ReservationService reservationService;

    @Autowired
    public ReservationThymeleafController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations-ui")
    public String reservations(Model model) {
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "reservations";
    }

}
