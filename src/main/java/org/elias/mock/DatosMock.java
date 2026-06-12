package org.elias.mock;

import org.elias.modelo.Equipos;
import org.elias.transferible.TransferibleEquipos;
import org.elias.transferible.TransferiblePilotos;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DatosMock {

    private DatosMock() {}

    public static List<TransferibleEquipos> equipos() {
        return List.of(
            equipo(1, "Red Bull Racing",  "Austria",        "Christian Horner",   "Honda RBPT", "Equipo dominante de la era híbrida reciente, con múltiples campeonatos de constructores."),
            equipo(2, "Ferrari",          "Italia",          "Frédéric Vasseur",   "Ferrari",    "La escudería más histórica de la Fórmula 1, fundada en 1950."),
            equipo(3, "Mercedes",         "Alemania",        "Toto Wolff",         "Mercedes",   "Dominador de la era híbrida 2014-2021, ocho títulos consecutivos de constructores."),
            equipo(4, "McLaren",          "Reino Unido",     "Andrea Stella",      "Mercedes",   "Equipo fundado en 1963, con tres títulos de constructores en su historia."),
            equipo(5, "Aston Martin",     "Reino Unido",     "Mike Krack",         "Mercedes",   "Renombrado equipo con la llegada de Fernando Alonso como piloto estrella.")
        );
    }

    public static List<TransferiblePilotos> pilotos() {
        return List.of(
            piloto(1,  "Max",      "Verstappen",  "Neerlandesa",  fecha(1997, 9, 30),  "Tricampeón del mundo, considerado uno de los mejores de su generación.",  1,  "Red Bull Racing"),
            piloto(2,  "Sergio",   "Pérez",       "Mexicana",     fecha(1990, 1, 26),  "Conocido como 'Checo', especialista en gestión de neumáticos.",           11, "Red Bull Racing"),
            piloto(3,  "Charles",  "Leclerc",     "Monegasca",    fecha(1997, 10, 16), "Piloto referente de Ferrari, con victorias en Mónaco y Monza.",            16, "Ferrari"),
            piloto(4,  "Carlos",   "Sainz",       "Española",     fecha(1994, 9, 1),   "Consistente y rápido, ganador del GP de Australia 2024.",                  55, "Ferrari"),
            piloto(5,  "Lewis",    "Hamilton",    "Británica",    fecha(1985, 1, 7),   "Siete veces campeón del mundo, el piloto más ganador de la historia.",     44, "Mercedes"),
            piloto(6,  "George",   "Russell",     "Británica",    fecha(1998, 2, 15),  "Joven promesa de Mercedes, campeón en Fórmula 2 en 2018.",                 63, "Mercedes"),
            piloto(7,  "Lando",    "Norris",      "Británica",    fecha(1999, 11, 13), "Estrella emergente de McLaren, con grandes actuaciones en 2023-2024.",      4, "McLaren"),
            piloto(8,  "Oscar",    "Piastri",     "Australiana",  fecha(2001, 4, 6),   "Campeón de F2 2021, debutó en F1 con McLaren en 2023.",                    81, "McLaren")
        );
    }

    public static TransferibleEquipos equipoPorId(Integer id) {
        return equipos().stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static TransferiblePilotos pilotoPorId(Integer id) {
        return pilotos().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private static TransferibleEquipos equipo(int id, String nombre, String pais, String jefe, String motor, String descripcion) {
        TransferibleEquipos e = new TransferibleEquipos();
        e.setId(id);
        e.setNombre(nombre);
        e.setPais(pais);
        e.setJefeEquipo(jefe);
        e.setMotor(motor);
        e.setDescripcion(descripcion);
        e.setPilotos(Collections.emptyList());
        return e;
    }

    private static TransferiblePilotos piloto(int id, String nombre, String apellido, String nacionalidad,
                                               Date fechaNacimiento, String descripcion, int numero, String nombreEquipo) {
        Equipos equipo = new Equipos();
        equipo.setNombre(nombreEquipo);

        TransferiblePilotos p = new TransferiblePilotos();
        p.setId(id);
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setNacionalidad(nacionalidad);
        p.setFechaNacimiento(fechaNacimiento);
        p.setDescripcion(descripcion);
        p.setNumero(numero);
        p.setEquipo(equipo);
        return p;
    }

    private static Date fecha(int anio, int mes, int dia) {
        Calendar c = Calendar.getInstance();
        c.set(anio, mes - 1, dia, 0, 0, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
}
