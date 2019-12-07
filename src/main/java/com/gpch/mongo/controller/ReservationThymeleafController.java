package com.gpch.mongo.controller;

import com.gpch.mongo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/delete-reservation/{id}")
    public String removeReservation(@PathVariable("id") String id, Model model) {
        reservationService.deleteReservationById(id);
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "reservations";
    }

}
