package com.gestionna.credito_service.service;

import com.gestionna.credito_service.dto.CreditoRequestDto;
import com.gestionna.credito_service.dto.CreditoResponseDto;
import com.gestionna.credito_service.entity.Credito;
import com.gestionna.credito_service.repository.CreditoRepository;
import com.gestionna.credito_service.service.exceptions.InvalidParameterException;
import com.gestionna.credito_service.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreditoService {

    private final CreditoRepository creditoRepository;

    public Credito save(CreditoRequestDto creditoRequestDto) {
        Credito credito = new Credito();
        BeanUtils.copyProperties(creditoRequestDto, credito);
        return creditoRepository.save(credito);
    }

    public List<Credito> getAllCreditos() {
        return creditoRepository.findAll();
    }

    public List<CreditoResponseDto> buscarPorNumeroNfse(String numeroNfse) {
        List<Credito> creditos = creditoRepository.findByNumeroNfse(numeroNfse);
        return creditos.stream().map(this::toResponseDto).collect(Collectors.toList());
    }

    public CreditoResponseDto buscarPorNumeroCredito(String numeroCredito) {
        Optional<Credito> credito = creditoRepository.findByNumeroCredito(numeroCredito);
        return credito
                .map(this::toResponseDto)
                .orElseThrow(() ->
                        new InvalidParameterException("Crédito com número '" + numeroCredito + "' não encontrado."));
    }


    private CreditoResponseDto toResponseDto(Credito credito) {
        CreditoResponseDto dto = new CreditoResponseDto();
        dto.setId(credito.getId());
        dto.setNumeroCredito(credito.getNumeroCredito());
        dto.setNumeroNfse(credito.getNumeroNfse());
        dto.setDataConstituicao(credito.getDataConstituicao());
        dto.setValorIssqn(credito.getValorIssqn());
        dto.setTipoCredito(credito.getTipoCredito());
        dto.setSimplesNacional(credito.isSimplesNacional());
        dto.setAliquota(credito.getAliquota());
        dto.setValorFaturado(credito.getValorFaturado());
        dto.setValorDeducao(credito.getValorDeducao());
        dto.setBaseCalculo(credito.getBaseCalculo());
        return dto;
    }

}
