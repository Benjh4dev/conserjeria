package cl.ucn.disc.as.conserjeria.services;
import cl.ucn.disc.as.conserjeria.model.*;
import io.ebean.SqlRow;
import org.jetbrains.annotations.NotNull;
import io.ebean.Database;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.PersistenceException;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Sistema implementation
 */
@Slf4j
public class SistemaImpl implements Sistema {

    private final Database database;

    /**
     * Constructor
     * @param database the database
     */
    public SistemaImpl(@NotNull Database database) {

        this.database = database;
    }


    @Override
    public Edificio add(@NotNull Edificio edificio) {
        try {
            this.database.save(edificio);
        } catch (PersistenceException ex) {
            log.error("Error", ex);

        }
        return edificio;
    }

    @Override
    public Persona add(Persona persona) {
        return null;
    }

    @Override
    public Departamento addDepartamento(Departamento departamento, Edificio edificio) {
        return null;
    }

    @Override
    public Departamento addDepartamento(Departamento departamento, Long idEdificio) {
        return null;
    }

    @Override
    public Contrato realizarContrato(Persona duenio, Departamento departamento, Instant fechaPago) {
        return null;
    }

    @Override
    public Contrato realizarContrato(Long idDuenio, Long idDepartamento, Instant fechaPago) {
        return null;
    }

    @Override
    public List<Contrato> getContratos() {
        return null;
    }

    @Override
    public List<Persona> getPersonas() {
        List<SqlRow> result = this.database.sqlQuery("SELECT * FROM persona;").findList();

        return result.stream()
                .map(sqlRow -> new Persona(
                        sqlRow.getString("rut"),
                        sqlRow.getString("nombre"),
                        sqlRow.getString("apellidos"),
                        sqlRow.getString("email"),
                        sqlRow.getString("telefono"),
                        sqlRow.getString("id"),
                        sqlRow.getString("version"),
                        sqlRow.getString("created"),
                        sqlRow.getString("modified")
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<Pago> getPagos(String rut) {
        return null;
    }
}