package com.greg.api.service;

import com.greg.api.dto.CreditoDTO;
import com.greg.api.entity.Credito;
import com.greg.api.messaging.KafkaProducerService;
import com.greg.api.repository.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditoService {
    private final CreditoRepository creditoRepository;

    public CreditoService(CreditoRepository creditoRepository) {
        this.creditoRepository = creditoRepository;
    }

    public List<CreditoDTO> getAllCreditos() {
        List<Credito> creditos = creditoRepository.findAll();
        return creditos.stream().map(this::convertToDTO).toList();
    }

    public List<CreditoDTO> findByNumeroNfse(String numeroNfse) {
        List<Credito> creditos = creditoRepository.findByNumeroNfse(numeroNfse);
        return creditos.stream().map(this::convertToDTO).toList();
    }

    public CreditoDTO findByNumeroCredito(String numeroCredito) {
        Credito credito = creditoRepository.findByNumeroCredito(numeroCredito)
                .orElseThrow(() -> new RuntimeException("Não encontrado crédito com este Número de Crédito: " + numeroCredito));
        return convertToDTO(credito);
    }

    private CreditoDTO convertToDTO(Credito credito) {
        CreditoDTO dto = new CreditoDTO();
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
