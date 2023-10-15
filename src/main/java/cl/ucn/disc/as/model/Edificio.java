package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
@Getter
public class Edificio extends BaseModel {

    /**
     * Nombre del edificio.
     */
    @NotNull
    private String nombre;

    /**
     * Dirección del edificio.
     */
    @NotNull
    private String direccion;

    /**
     * Lista de departamentos.
     */
    @OneToMany(mappedBy = "edificio")
    private List<Departamento> departamentos;

    /**
     * Método para añadir un departamento .
     *
     * @param departamento el departamento a añadir.
     */
    public void add(Departamento departamento) {

    }
}