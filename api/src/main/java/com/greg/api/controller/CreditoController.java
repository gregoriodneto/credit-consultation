package com.greg.api.controller;

import com.greg.api.dto.CreditoDTO;
import com.greg.api.messaging.KafkaProducerService;
import com.greg.api.service.CreditoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/creditos")
public class CreditoController {
    private final CreditoService creditoService;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    public CreditoController(CreditoService creditoService) {
        this.creditoService = creditoService;
    }

    @GetMapping
    @Operation(
            summary = "Buscar todos os créditos",
            description = "Busca todos os créditos cadastrados"
    )
    public List<CreditoDTO> getAllCreditos() {
        List<CreditoDTO> dtos = creditoService.getAllCreditos();
        kafkaProducerService.sendConsultaNotification(
                "Listagem de todos os créditos realizada."
        );
        return dtos;
    }

    @GetMapping("/{numeroNfse}")
    @Operation(
            summary = "Buscar créditos por NFSE",
            description = "Busca todos os créditos que possuem o número de NFSE específico."
    )
    public List<CreditoDTO> getCreditoByNumeroNfse(
            @PathVariable String numeroNfse
    ) {
        List<CreditoDTO> dtos = creditoService.findByNumeroNfse(numeroNfse);
        kafkaProducerService.sendConsultaNotification(
                "Listagem de todos os créditos realizada com base no número NFSE: " + numeroNfse
        );
        return dtos;
    }

    @GetMapping("/credito/{numeroCredito}")
    @Operation(
            summary = "Buscar crédito com base no seu número",
            description = "Busca um crédito específico com base no número do crédito."
    )
    public CreditoDTO getCreditoByNumeroCredito(
            @PathVariable String numeroCredito
    ) {
        CreditoDTO dto = creditoService.findByNumeroCredito(numeroCredito);
        kafkaProducerService.sendConsultaNotification(
                "Consulta de crédito realizada com base no número do Crédito: " + numeroCredito
        );
        return dto;
    }
}
