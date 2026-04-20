package ar.edu.unahur.obj2.uml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.usuarios.Usuario;
import ar.edu.unahur.obj2.vehiculos.Bicicleta;
import ar.edu.unahur.obj2.vehiculos.Monopatin;
import ar.edu.unahur.obj2.alquileres.Alquiler;

public class AlquilerTest {
    private Usuario usuario;
    private Bicicleta bicicleta;
    private Monopatin monopatin;

    @BeforeEach
    public void setUp() {
        usuario = new Usuario("Juan");
        bicicleta = new Bicicleta(29);
        monopatin = new Monopatin("Kawasaki");
    }

    @Test
    public void alquilarVehiculoDisponibleCambiaSuEstado() {
        Alquiler alquiler = new Alquiler(usuario, bicicleta);

        assertTrue(bicicleta.estaDisponible(), "La bicicleta debería estar disponible inicialmente.");

        alquiler.registrarAlquier();

        assertFalse(bicicleta.estaDisponible(), "La bicicleta debería estar marcada como no disponible tras alquilarse.");
    }

    @Test
    public void finalizarAlquilerLiberaElVehiculo() {
        Alquiler alquiler = new Alquiler(usuario, monopatin);
        alquiler.registrarAlquier();

        assertFalse(monopatin.estaDisponible());

        alquiler.finalizarAlquier();

        assertTrue(monopatin.estaDisponible());
    }

    @Test
    public void noSePuedeAlquilarUnVehiculoNoDisponible() {
        Alquiler primerAlquiler = new Alquiler(usuario, bicicleta);
        primerAlquiler.registrarAlquier();

        Usuario otroUsuario = new Usuario("Carlos");
        Alquiler segundoAlquiler = new Alquiler(otroUsuario, bicicleta);

        RuntimeException excepcion = assertThrows(RuntimeException.class, () -> {
            segundoAlquiler.registrarAlquier();
        });

        assertEquals("El vehículo no está disponible para alquilar.", excepcion.getMessage());
    }

    @Test
    public void obtenerFechasDeAlquiler() {
        Alquiler alquiler = new Alquiler(usuario, monopatin);
        alquiler.registrarAlquier();

        assertTrue(alquiler.getFechaInicio() != null, "La fecha de inicio debería estar registrada.");
        assertTrue(alquiler.getFechaFin() == null, "La fecha de fin no debería estar registrada antes de finalizar el alquiler.");

        alquiler.finalizarAlquier();

        assertTrue(alquiler.getFechaFin() != null, "La fecha de fin debería estar registrada después de finalizar el alquiler.");
    }

    @Test
    public void obtenerUsuarioYVehiculoDelAlquiler() {
        Alquiler alquiler = new Alquiler(usuario, bicicleta);

        assertEquals(usuario, alquiler.getUsuario(), "El usuario del alquiler debería ser el mismo que se proporcionó al crear el alquiler.");
        assertEquals(bicicleta, alquiler.getVehiculo(), "El vehículo del alquiler debería ser el mismo que se proporcionó al crear el alquiler.");
    }
}