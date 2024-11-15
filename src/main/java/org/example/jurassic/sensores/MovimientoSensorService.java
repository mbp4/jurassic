package org.example.jurassic.sensores;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class MovimientoSensorService {

    private final ConcurrentHashMap<String, List<MovimientoSensor>> ubicacionesDinosaurios = new ConcurrentHashMap<>();

    public Flux<MovimientoSensor> procesarMovimiento(Flux<MovimientoSensor> movimientoDinosaurios) {
        return movimientoDinosaurios
                .publishOn(Schedulers.parallel())
                .doOnNext(this::verificarUbicacion)
                .onBackpressureBuffer();
    }

    private void verificarUbicacion(MovimientoSensor sensor) {
        ubicacionesDinosaurios.compute(sensor.getUbicacion(), (ubicacion, lista) -> {
            if (lista == null) {
                lista = new CopyOnWriteArrayList<>();
            }
            if (lista.stream().anyMatch(d -> !d.getAlimentacion().equals(sensor.getAlimentacion()))) {
                System.out.println("¡Alerta! Herbívoros y carnívoros en la misma ubicación: " + sensor.getUbicacion());
            } else {
                lista.add(sensor);
            }
            return lista;
        });
    }

    public void eliminarDinosaurio(MovimientoSensor sensor) {
        List<MovimientoSensor> lista = ubicacionesDinosaurios.get(sensor.getUbicacion());
        if (lista != null) {
            lista.remove(sensor);
        }
    }
}
