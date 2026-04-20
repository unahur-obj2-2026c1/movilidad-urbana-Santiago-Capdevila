package ar.edu.unahur.obj2.uml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.vehiculos.Bicicleta;
import ar.edu.unahur.obj2.vehiculos.Monopatin;

public class VehiculoTest {
    @Test
    void obetenerMarcaDeMonopatin() {
        Monopatin monopatin = new Monopatin("Kawasaki");
        
        assertEquals("Kawasaki", monopatin.getMarca());
    }

    @Test
    void obtenerRodadoDeBicicleta() {
        Bicicleta bicicleta = new Bicicleta(29);
        
        assertEquals(29, bicicleta.getRodado());
    }

    
}