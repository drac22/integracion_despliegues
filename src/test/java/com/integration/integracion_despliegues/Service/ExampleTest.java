package com.integration.integracion_despliegues.Service;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

public class ExampleTest {
    @Test
    void TestDoblar() {
        Example example = new Example();
        int resultado = example.doblar(10);
        Assertions.assertEquals(20, resultado);
    }
}
