package cl.ucn.disc.as.conserjeria.services;

import cl.ucn.disc.as.conserjeria.exceptions.SistemaException;
import cl.ucn.disc.as.conserjeria.model.*;
import java.time.Instant;
import java.util.List;

/**
 * Sistema interface.
 */
public interface Sistema {

    Edificio add(Edificio edificio);

    Persona add(Persona persona);

    Departamento addDepartamento(Departamento departamento, Edificio edificio);

    Departamento addDepartamento(Departamento departamento, Long idEdificio);

    Contrato realizarContrato(Persona duenio, Departamento departamento, Instant fechaPago);

    Contrato realizarContrato(Long idDuenio, Long idDepartamento, Instant fechaPago);

    List<Contrato> getContratos();

    List<Persona> getPersonas() throws SistemaException;

    Persona getPersona(String rut) throws SistemaException;

    List<Pago> getPagos(String rut);

    void populate();
}