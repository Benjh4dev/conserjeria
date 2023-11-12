package cl.ucn.disc.as.conserjeria.model;

import io.ebean.annotation.NotNull;
import lombok.*;

import javax.persistence.Entity;

@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
@Getter
public class Departamento extends BaseModel {

    @NotNull
    private Integer numero;

    @NotNull
    private Integer piso;

}