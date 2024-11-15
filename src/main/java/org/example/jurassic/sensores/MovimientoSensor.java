package org.example.jurassic.sensores;

public class MovimientoSensor {

    private String idDinosaurio;
    private String alimentacion;
    private String ubicacion;

    public MovimientoSensor(String idDinosaurio, String alimentacion, String ubicacion) {
        this.idDinosaurio = idDinosaurio;
        this.alimentacion = alimentacion;
        this.ubicacion = ubicacion;
    }

    public String getIdDinosaurio() {
        return idDinosaurio;
    }

    public void setIdDinosaurio(String idDinosaurio) {
        this.idDinosaurio = idDinosaurio;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "MovimientoSensor{" +
                "idDinosaurio='" + idDinosaurio + '\'' +
                ", alimentacion='" + alimentacion + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
