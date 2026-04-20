package ar.edu.unahur.obj2.alquileres;

import java.time.LocalDateTime;

import ar.edu.unahur.obj2.usuarios.Usuario;
import ar.edu.unahur.obj2.vehiculos.Vehiculo;

public class Alquiler {
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Usuario usuario;
    private Vehiculo vehiculo;
    
    public Alquiler(Usuario usuario, Vehiculo vehiculo) {
        this.usuario = usuario;
        this.vehiculo = vehiculo;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void registrarAlquier() {
        if (vehiculo.estaDisponible()) {
            this.fechaInicio = LocalDateTime.now();
            vehiculo.marcarComoAlquilado();
        } else {
            throw new RuntimeException("El vehículo no está disponible para alquilar.");
        }
    }

    public void finalizarAlquier() {
        this.fechaFin = LocalDateTime.now();
        vehiculo.marcarComoDisponible();
    }
}
