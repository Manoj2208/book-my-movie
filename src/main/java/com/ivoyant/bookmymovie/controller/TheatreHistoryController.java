package com.ivoyant.bookmymovie.controller;

import com.ivoyant.bookmymovie.response.TheatreHistoryResponse;
import com.ivoyant.bookmymovie.service.TheatreHistoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreHistoryController {
    @Autowired
    private TheatreHistoryService theatreHistoryService;

    @GetMapping("/{theatreName}")
    public ResponseEntity<List<TheatreHistoryResponse>> getTheaterHistory(@Valid @PathVariable @NotBlank(message = "required field") String theatreName) {
        return ResponseEntity.ok().body(theatreHistoryService.getTheatreHistory(theatreName));
    }
}
