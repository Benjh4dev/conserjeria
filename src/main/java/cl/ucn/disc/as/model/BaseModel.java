/*
 * Copyright (c) 2023. Arquitectura de Sistemas, DISC, UCN.
 */

package cl.ucn.disc.as.model;

import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.Instant;

/**
 * Base Class.
 *
 * @author Diego Urrutia-Astorga.
 */
@ToString
@MappedSuperclass
@Getter
@Setter
public abstract class BaseModel {

    /**
     * The Id.
     */
    @Id
    private Long id;

    /**
     * The Version.
     */
    @Version
    private Long version;

    /**
     * Creation date.
     */
    @WhenCreated
    private Instant created;

    /**
     * Modified date.
     */
    @WhenModified
    private Instant modified;
}