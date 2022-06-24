package com.example.restservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class BsvController {
    private BsvService bsvService;

    public BsvController(@Autowired BsvService bsvService) {
        this.bsvService = bsvService;
    }

    @GetMapping("/betriebsstelle/{code}")
    public ResponseEntity<Bsv> getData(@PathVariable String code) {
        Bsv bsv = this.bsvService.getBsvByCode(code);
        if (bsv != null) {
            return ResponseEntity.ok(bsv);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
