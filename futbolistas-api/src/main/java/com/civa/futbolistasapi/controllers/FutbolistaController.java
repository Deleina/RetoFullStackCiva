package com.civa.futbolistasapi.controllers;

import com.civa.futbolistasapi.dto.FutbolistaDTO;
import com.civa.futbolistasapi.entities.Futbolista;
import com.civa.futbolistasapi.services.FutbolistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/futbolista")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*",
        methods = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.OPTIONS
        }
)

public class FutbolistaController {

    @Autowired
    private FutbolistaService futbolistaService;


    @GetMapping
    public ResponseEntity<List<FutbolistaDTO>> getFutbolista(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<FutbolistaDTO> futbolistaPage = futbolistaService.obtenerFutbolistas(pageable);
        List<FutbolistaDTO> futbolistas = futbolistaPage.getContent();
        return ResponseEntity.ok((futbolistas));
    }


    @GetMapping("/{id}")
    public ResponseEntity<FutbolistaDTO> getFutbolistaById(@PathVariable("id") Long id) {
        FutbolistaDTO futbolista = futbolistaService.obtenerFutbolistaPorId(id);
        if (futbolista != null) {
            return ResponseEntity.ok(futbolista);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
