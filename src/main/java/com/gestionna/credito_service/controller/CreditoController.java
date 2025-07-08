package com.gestionna.credito_service.controller;

import com.gestionna.credito_service.dto.CreditoRequestDto;
import com.gestionna.credito_service.dto.CreditoResponseDto;
import com.gestionna.credito_service.entity.Credito;
import com.gestionna.credito_service.service.CreditoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/creditos")
public class CreditoController {

    private final CreditoService creditoService;


    @PostMapping(value = "/", produces = {"application/json"})
    public ResponseEntity<Object> saveCredito(@RequestBody @Valid CreditoRequestDto creditoRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(creditoService.save(creditoRequestDto));
    }

    @GetMapping(value = "/", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<List<Credito>> getAllCreditos() {
        return ResponseEntity.status(HttpStatus.OK).body(creditoService.getAllCreditos());
    }

    @GetMapping("/{numeroNfse}")
    public ResponseEntity<List<CreditoResponseDto>> buscarPorNumeroNfse(@PathVariable String numeroNfse) {
        List<CreditoResponseDto> lista = creditoService.buscarPorNumeroNfse(numeroNfse);
        return ResponseEntity.ok(lista);
    }


}
