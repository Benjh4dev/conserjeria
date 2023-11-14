package cl.ucn.disc.as.conserjeria.services;
import cl.ucn.disc.as.conserjeria.exceptions.SistemaException;
import cl.ucn.disc.as.conserjeria.model.*;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import io.ebean.Query;
import io.ebean.SqlRow;
import org.jetbrains.annotations.NotNull;
import io.ebean.Database;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.PersistenceException;
import java.time.Instant;
import java.util.List;
import java.util.Locale;
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
    public List<Persona> getPersonas() throws SistemaException {
        try {
            Query<Persona> query = database.find(Persona.class);
            return query.findList();
        } catch (PersistenceException ex) {

            log.error("Error al recuperar personas", ex);
            throw new SistemaException("Error al obtener la lista de personas", ex);
        }
    }
    @Override
    public Persona getPersona(String rut) throws SistemaException {
        try {
            Query<Persona> query = database.find(Persona.class)
                    .where()
                    .eq("rut", rut)
                    .query();

            return query.findOne();
        } catch (PersistenceException ex) {

            log.error("Error al recuperar la persona con rut " + rut, ex);
            throw new SistemaException("Error al obtener la persona con rut " + rut, ex);
        }
    }

    @Override
    public List<Pago> getPagos(String rut) {
        return null;
    }

    @Override
    public void populate() {

        // build the persona
        {
            Persona persona = Persona.builder()
                    .rut("20984692-6")
                    .nombre("Benjamín")
                    .apellidos("Plaza Flores")
                    .email("benjamin.plaza@alumnos.ucn.cl")
                    .telefono("+56912345678")
                    .build();
            this.database.save(persona);
        }


        Locale locale = new Locale("es-CL");
        FakeValuesService fvs = new FakeValuesService(locale, new RandomService());
        Faker faker = new Faker(locale);


        for (int i = 0; i < 100; i++) {
            Persona persona = Persona.builder()
                    .rut(fvs.bothify("########-#"))
                    .nombre(faker.name()
                            .firstName())
                    .apellidos(faker.name()
                            .lastName())
                    .email(fvs.bothify("????##@gmail.com"))
                    .telefono(fvs.bothify("+569########"))
                    .build();
            this.database.save(persona);
        }


    }
}