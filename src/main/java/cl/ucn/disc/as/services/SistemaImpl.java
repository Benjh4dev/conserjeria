package cl.ucn.disc.as.services;
import cl.ucn.disc.as.exceptions.SistemaException;
import cl.ucn.disc.as.model.*;
import org.jetbrains.annotations.NotNull;
import io.ebean.Database;
import lombok.extern.slf4j.Slf4j;


import javax.persistence.PersistenceException;
import java.time.Instant;
import java.util.List;


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
        return null;
    }

    @Override
    public List<Pago> getPagos(String rut) {
        return null;
    }
}