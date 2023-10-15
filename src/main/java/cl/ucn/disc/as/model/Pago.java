package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import lombok.Getter;
import java.time.Instant;

import javax.persistence.Entity;

@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
@Getter
public class Pago extends BaseModel {


    /**
     * Fecha de pago.
     */
    @NotNull
    private Instant fechaPago;

    /**
     * Monto.
     */
    @NotNull
    private Integer monto;
}