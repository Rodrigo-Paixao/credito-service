package com.gestionna.credito_service.service;

import com.gestionna.credito_service.dto.CreditoRequestDto;
import com.gestionna.credito_service.dto.CreditoResponseDto;
import com.gestionna.credito_service.entity.Credito;
import com.gestionna.credito_service.repository.CreditoRepository;
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

    private CreditoResponseDto toResponseDto(Credito c) {
        CreditoResponseDto dto = new CreditoResponseDto();
        dto.setId(c.getId());
        dto.setNumeroCredito(c.getNumeroCredito());
        dto.setNumeroNfse(c.getNumeroNfse());
        dto.setDataConstituicao(c.getDataConstituicao());
        dto.setValorIssqn(c.getValorIssqn());
        dto.setTipoCredito(c.getTipoCredito());
        dto.setSimplesNacional(Boolean.parseBoolean(c.isSimplesNacional() ? "Sim" : "Não"));
        dto.setAliquota(c.getAliquota());
        dto.setValorFaturado(c.getValorFaturado());
        dto.setValorDeducao(c.getValorDeducao());
        dto.setBaseCalculo(c.getBaseCalculo());
        return dto;
    }

}
