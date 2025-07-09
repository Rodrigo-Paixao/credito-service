package com.gestionna.credito_service.controller;

import com.gestionna.credito_service.dto.CreditoRequestDto;
import com.gestionna.credito_service.dto.CreditoResponseDto;
import com.gestionna.credito_service.entity.Credito;
import com.gestionna.credito_service.service.CreditoService;
import com.gestionna.credito_service.validation.ParametroValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


    @PostMapping(produces = {"application/json"})
    public ResponseEntity<Object> saveCredito(@RequestBody @Valid CreditoRequestDto creditoRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(creditoService.save(creditoRequestDto));
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<Credito>> getAllCreditos() {
        return ResponseEntity.status(HttpStatus.OK).body(creditoService.getAllCreditos());
    }

    @Operation(summary = "Retorna uma lista de crédito por número de Nota Fiscal.", tags = "Créditos por Nota Fiscal")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Crédito(s) encontrado com sucesso!", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CreditoResponseDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Número de pesquisa inválido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Crédito(s) não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Ocorreu um erro ao buscar pelo dado informado.", content = @Content)})
    @GetMapping("/{numeroNfse}")
    public ResponseEntity<List<CreditoResponseDto>> buscarPorNumeroNfse(@PathVariable String numeroNfse) {
        ParametroValidator.validarNumeroNfse(numeroNfse.trim());
        List<CreditoResponseDto> lista = creditoService.buscarPorNumeroNfse(numeroNfse);
        return ResponseEntity.ok(lista);
    }

    @Operation(summary = "Retorna crédito por número do crédito.", tags = "Crédito por número de crédito")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Crédito encontrado com sucesso!", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CreditoResponseDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Número de pesquisa inválido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Crédito não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Ocorreu um erro ao buscar pelo dado informado.", content = @Content)})
    @GetMapping("/credito/{numeroCredito}")
    public ResponseEntity<CreditoResponseDto> buscarPorNumeroCredito(@PathVariable String numeroCredito) {
        ParametroValidator.validarNumeroCredito(numeroCredito.trim());
        CreditoResponseDto dto = creditoService.buscarPorNumeroCredito(numeroCredito);
        return ResponseEntity.ok(dto);
    }



}
