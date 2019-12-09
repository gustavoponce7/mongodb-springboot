package com.gpch.mongo.service;

import com.gpch.mongo.model.Reservation;
import com.gpch.mongo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation saveReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public Iterable<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    public void deleteAllReservations(){
        reservationRepository.deleteAll();
    }

    public void deleteReservationById(String id){
        reservationRepository.deleteById(id);
    }

    public Optional<Reservation> findReservationById(String id){
        return reservationRepository.findById(id);
    }
}
