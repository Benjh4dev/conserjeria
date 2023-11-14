/*
 * Copyright (c) 2023. Arquitectura de Sistemas, DISC, UCN.
 */

package cl.ucn.disc.as.conserjeria.model;

import cl.ucn.disc.as.conserjeria.exceptions.IllegalDomainException;
import cl.ucn.disc.as.conserjeria.utils.ValidationUtils;
import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import lombok.Getter;
import javax.persistence.Entity;

@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
@Getter
public class Persona extends BaseModel {

    /**
     * The RUT.
     */
    @NotNull
    private String rut;

    /**
     * The Nombre.
     */
    @NotNull
    private String nombre;

    /**
     * The Apellidos.
     */
    @NotNull
    private String apellidos;

    /**
     * The Email.
     */
    @NotNull
    private String email;

    /**
     * The Telefono.
     */
    @NotNull
    private String telefono;

    public Persona(String rut, String nombre, String apellidos, String email, String telefono, String id, String version, String created, String lastModified) {
        super();
    }

    /**
     * The internal builder to validate.
     */
    public static class PersonaBuilder {
        /**
         * @return the Persona.
         */
        public Persona build() {
            // validate rut
            /*
            if (!ValidationUtils.isRutValid(this.rut)) {
                throw new IllegalDomainException("RUT no valido: " + this.rut);
            }

            // validate email
            if (!ValidationUtils.isEmailValid(this.email)) {
                throw new IllegalDomainException("Email not valid: " + this.email);
            }
            */
            // TODO: Add the validations

            return new Persona(this.rut, this.nombre, this.apellidos, this.email, this.telefono);
        }
    }
}