package com.greg.api.controller;

import com.greg.api.dto.CreditoDTO;
import com.greg.api.service.CreditoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/creditos")
public class CreditoController {
    private final CreditoService creditoService;

    public CreditoController(CreditoService creditoService) {
        this.creditoService = creditoService;
    }

    @GetMapping
    @Operation(
            summary = "Buscar todos os créditos",
            description = "Busca todos os créditos cadastrados"
    )
    public List<CreditoDTO> getAllCreditos() {
        return creditoService.getAllCreditos();
    }

    @GetMapping("/{numeroNfse}")
    @Operation(
            summary = "Buscar créditos por NFSE",
            description = "Busca todos os créditos que possuem o número de NFSE específico."
    )
    public List<CreditoDTO> getCreditoByNumeroNfse(
            @PathVariable String numeroNfse
    ) {
        return creditoService.findByNumeroNfse(numeroNfse);
    }

    @GetMapping("/credito/{numeroCredito}")
    @Operation(
            summary = "Buscar crédito com base no seu número",
            description = "Busca um crédito específico com base no número do crédito."
    )
    public CreditoDTO getCreditoByNumeroCredito(
            @PathVariable String numeroCredito
    ) {
        return creditoService.findByNumeroCredito(numeroCredito);
    }
}
