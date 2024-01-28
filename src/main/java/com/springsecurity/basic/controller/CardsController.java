package com.springsecurity.basic.controller;

import com.springsecurity.basic.model.Cards;
import com.springsecurity.basic.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CardsRepository cardsRepository;

    @GetMapping("/myCards")
    public List<Cards> getCardsDetails(@RequestParam int id) {
        List<Cards> cards = cardsRepository.findByCustomerId(id);
        if(cards != null) {
            return cards;
        } else {
            return null;
        }
    }
}
