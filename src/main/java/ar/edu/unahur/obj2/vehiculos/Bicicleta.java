package ar.edu.unahur.obj2.vehiculos;

public class Bicicleta extends Vehiculo{
    private Integer rodado;

    public Bicicleta(Integer rodado) {
        super(true); // Por defecto, una bicicleta está disponible
        this.rodado = rodado;
    }

    public Integer getRodado() {
        return rodado;
    }

}
