package ar.edu.unahur.obj2.vehiculos;

public class Monopatin extends Vehiculo{
    private String marca;

    public Monopatin(String marca) {
        super(true); // Por defecto, un monopatín está disponible
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

}
