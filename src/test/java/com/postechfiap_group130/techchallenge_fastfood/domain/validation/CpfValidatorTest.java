package com.postechfiap_group130.techchallenge_fastfood.domain.validation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CpfValidatorTest {

    @Test
    void whenCpfIsNull_thenReturnFalse() {
        assertFalse(CpfValidator.isValid(null));
    }

    @Test
    void whenCpfIsEmpty_thenReturnFalse() {
        assertFalse(CpfValidator.isValid(""));
    }

    @Test
    void whenCpfHasInvalidLength_thenReturnFalse() {
        assertFalse(CpfValidator.isValid("1234567890")); // 10 dígitos
        assertFalse(CpfValidator.isValid("123456789012")); // 12 dígitos
    }

    @Test
    void whenCpfHasAllSameDigits_thenReturnFalse() {
        assertFalse(CpfValidator.isValid("11111111111"));
        assertFalse(CpfValidator.isValid("22222222222"));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "12345678900", // CPF inválido
        "11111111111", // Todos dígitos iguais
        "123.456.789-00", // CPF inválido com formatação
        "123456789012", // CPF com mais de 11 dígitos
        "1234567890", // CPF com menos de 11 dígitos
        "abc.def.ghi-jk", // CPF com letras
        "123.456.789-0a" // CPF com letra no final
    })
    void whenCpfIsInvalid_thenReturnFalse(String cpf) {
        assertFalse(CpfValidator.isValid(cpf));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "52998224725", // CPF válido sem formatação
        "529.982.247-25", // CPF válido com formatação
        "12345678909", // CPF válido sem formatação
        "123.456.789-09" // CPF válido com formatação
    })
    void whenCpfIsValid_thenReturnTrue(String cpf) {
        assertTrue(CpfValidator.isValid(cpf));
    }
} 