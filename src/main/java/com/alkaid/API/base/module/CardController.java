package com.alkaid.API.base.module;

import com.alkaid.API.base.module.body.CardBody;
import com.alkaid.API.base.module.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<List<String>> createCard(@RequestBody CardBody card) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(cardService.createCard(card.getTime(), card.getCount(), card.getRank(), card.getPrefix(), card.getIsbeta()), headers, HttpStatus.OK);
    }
}
