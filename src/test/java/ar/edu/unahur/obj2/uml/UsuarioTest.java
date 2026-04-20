package ar.edu.unahur.obj2.uml;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.usuarios.Usuario;

public class UsuarioTest {
    @Test
    void obtenerNombreDeUsuario() {
        Usuario usuario = new Usuario("Juan");
        assert usuario.getNombre().equals("Juan");
    }
}
