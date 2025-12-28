package aerolinea;

import java.time.Duration;
import java.time.LocalDateTime;

class Vuelo2 {
    private String destino;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;

    public Vuelo2(String destino, LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
        this.destino = destino;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public String getDestino() {
        return destino;
    }

    public long getDuracionEnMinutos() {
        return Duration.between(fechaInicio, fechaFinal).toMinutes();
    }
}

class Piloto2 {
    private String dni;
    private Vuelo2[] vuelos;

    public Piloto2(String dni, Vuelo2[] vuelos) {
        this.dni = dni;
        this.vuelos = vuelos;
    }

    public String getDni() {
        return dni;
    }

    public Vuelo2[] getVuelos() {
        return vuelos;
    }

    public long getDuracionTotal() {
        long total = 0;
        for (Vuelo2 v : vuelos) {
            total += v.getDuracionEnMinutos();
        }
        return total;
    }

    public void mostrarEstadisticas() {
        if (vuelos == null || vuelos.length == 0) {
            System.out.println("El piloto " + dni + " no tiene vuelos registrados.");
            return;
        }

        long duracionTotal = 0;
        Vuelo2 vueloMasCorto = vuelos[0];
        Vuelo2 vueloMasLargo = vuelos[0];

        for (Vuelo2 vuelo : vuelos) {
            long duracion = vuelo.getDuracionEnMinutos();
            duracionTotal += duracion;

            if (duracion < vueloMasCorto.getDuracionEnMinutos()) {
                vueloMasCorto = vuelo;
            }
            if (duracion > vueloMasLargo.getDuracionEnMinutos()) {
                vueloMasLargo = vuelo;
            }
        }

        double duracionMedia = (double) duracionTotal / vuelos.length;

        System.out.println("Piloto DNI: " + dni);
        System.out.println("Duración media de los vuelos (minutos): " + duracionMedia);
        System.out.println("Vuelo más corto: " + vueloMasCorto.getDestino() + ", duración: " + vueloMasCorto.getDuracionEnMinutos() + " minutos");
        System.out.println("Vuelo más largo: " + vueloMasLargo.getDestino() + ", duración: " + vueloMasLargo.getDuracionEnMinutos() + " minutos");
        System.out.println("----------------------------");
    }
}

public class ejemplo {
    public static void main(String[] args) {
        // Crear vuelos de ejemplo
        Vuelo2 v1 = new Vuelo2("Madrid", LocalDateTime.of(2025, 12, 22, 8, 0),
                                    LocalDateTime.of(2025, 12, 22, 10, 0));
        Vuelo2 v2 = new Vuelo2("Barcelona", LocalDateTime.of(2025, 12, 23, 9, 0),
                                        LocalDateTime.of(2025, 12, 23, 12, 30));
        Vuelo2 v3 = new Vuelo2("Lisboa", LocalDateTime.of(2025, 12, 24, 14, 0),
                                     LocalDateTime.of(2025, 12, 24, 15, 15));

        Piloto2 piloto1 = new Piloto2("12345678A", new Vuelo2[]{v1, v2});
        Piloto2 piloto2 = new Piloto2("87654321B", new Vuelo2[]{v3});
        Piloto2[] pilotos = {piloto1, piloto2};

        // Estadísticas globales
        long duracionTotalTodos = 0;
        int totalVuelos = 0;
        Vuelo2 vueloMasCortoGlobal = null;
        Vuelo2 vueloMasLargoGlobal = null;

        for (Piloto2 p : pilotos) {
            for (Vuelo2 v : p.getVuelos()) {
                long duracion = v.getDuracionEnMinutos();
                duracionTotalTodos += duracion;
                totalVuelos++;

                if (vueloMasCortoGlobal == null || duracion < vueloMasCortoGlobal.getDuracionEnMinutos()) {
                    vueloMasCortoGlobal = v;
                }
                if (vueloMasLargoGlobal == null || duracion > vueloMasLargoGlobal.getDuracionEnMinutos()) {
                    vueloMasLargoGlobal = v;
                }
            }
        }

        double duracionMediaGlobal = totalVuelos > 0 ? (double) duracionTotalTodos / totalVuelos : 0;

        System.out.println("===== Estadísticas globales de todos los pilotos =====");
        System.out.println("Duración media de todos los vuelos (minutos): " + duracionMediaGlobal);
        if (vueloMasCortoGlobal != null) {
            System.out.println("Vuelo más corto global: " + vueloMasCortoGlobal.getDestino() + ", duración: " + vueloMasCortoGlobal.getDuracionEnMinutos() + " minutos");
        }
        if (vueloMasLargoGlobal != null) {
            System.out.println("Vuelo más largo global: " + vueloMasLargoGlobal.getDestino() + ", duración: " + vueloMasLargoGlobal.getDuracionEnMinutos() + " minutos");
        }

        System.out.println("\n===== Estadísticas por piloto =====");
        for (Piloto2 p : pilotos) {
            p.mostrarEstadisticas();
        }
    }
}
