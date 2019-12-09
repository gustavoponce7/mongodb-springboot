package com.gpch.mongo.controller;

import com.gpch.mongo.model.Reservation;
import com.gpch.mongo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

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

    @GetMapping(value = {"/edit-add-reservation/{id}", "/edit-add-reservation"})
    public String editReservation(@PathVariable("id") Optional<String> id, Model model) {
        Reservation reservation = id.isPresent() ?
                reservationService.findReservationById(id.get()).get() : new Reservation();
        model.addAttribute("reservation", reservation);
        return "add-edit";
    }

    @PostMapping("/save-reservation")
    public String editReservation(@ModelAttribute("reservation") @Valid Reservation reservation,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-edit";
        }
        reservationService.saveReservation(reservation);
        return "redirect:reservations-ui";
    }
}
