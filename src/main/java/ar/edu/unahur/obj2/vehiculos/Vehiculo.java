package ar.edu.unahur.obj2.vehiculos;

public abstract class Vehiculo {
    private Boolean disponible;

    public Vehiculo(Boolean disponible) {
        this.disponible = disponible;
    }

    public void marcarComoAlquilado() {
        this.disponible = false;
    }

    public void marcarComoDisponible() {
        this.disponible = true;
    }

    public Boolean estaDisponible() {
        return this.disponible;
    }
}
