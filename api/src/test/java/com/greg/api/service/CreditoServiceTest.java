package com.greg.api.service;

import com.greg.api.dto.CreditoDTO;
import com.greg.api.entity.Credito;
import com.greg.api.repository.CreditoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CreditoServiceTest {
    @Mock
    private CreditoRepository creditoRepository;

    @InjectMocks
    private CreditoService creditoService;

    private Credito mockCredito;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        mockCredito = new Credito();
        mockCredito.setNumeroCredito("12345");
        mockCredito.setNumeroNfse("NFSE-001");
        mockCredito.setDataConstituicao(LocalDate.now());
        mockCredito.setValorIssqn(new BigDecimal("100.00"));
        mockCredito.setTipoCredito("Simples");
        mockCredito.setSimplesNacional(true);
        mockCredito.setAliquota(new BigDecimal("0.05"));
        mockCredito.setValorFaturado(new BigDecimal("2000.00"));
        mockCredito.setValorDeducao(new BigDecimal("100.00"));
        mockCredito.setBaseCalculo(new BigDecimal("1900.00"));
    }

    @Test
    void testGetAllCreditos() {
        when(creditoRepository.findAll()).thenReturn(List.of(mockCredito));

        List<CreditoDTO> result = creditoService.getAllCreditos();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("12345", result.get(0).getNumeroCredito());
    }

    @Test
    void testFindByNumeroNfse() {
        when(creditoRepository.findByNumeroNfse("NFSE-001")).thenReturn(List.of(mockCredito));

        List<CreditoDTO> result = creditoService.findByNumeroNfse("NFSE-001");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("NFSE-001", result.get(0).getNumeroNfse());
    }

    @Test
    void testFindByNumeroCredito() {
        when(creditoRepository.findByNumeroCredito("12345")).thenReturn(Optional.of(mockCredito));

        CreditoDTO result = creditoService.findByNumeroCredito("12345");

        assertNotNull(result);
        assertEquals("12345", result.getNumeroCredito());
    }

    @Test
    void testFindByNumeroCreditoNotFound() {
        when(creditoRepository.findByNumeroCredito("99999")).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            creditoService.findByNumeroCredito("99999");
        });

        assertEquals("Não encontrado crédito com este Número de Crédito: 99999", exception.getMessage());
    }
}
