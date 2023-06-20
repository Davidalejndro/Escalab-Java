package proyectoEscalab.Usuarioapi.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
@Table(name = "telefonos")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Telefono {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int telefonoId;
    @Min(value = 1,message = "el numero de telefono es obligatorio")
    @Column(nullable = false)
    private int numero;
    @Column(nullable = false)
    private int codigoCiudad;
    @Column(nullable = false)
    private int codigoPais;

    @Min(value = 1, message = "el numero de telefono es obligatorio")
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    @Min(value = 1, message = "el codigo de Ciudad de telefono es obligatorio")
    public int getCodigoCiudad() {
        return codigoCiudad;
    }
    public void setCodigoCiudad(int codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }
    @Min(value = 1, message = "el codigo de Pais de telefono es obligatorio")
    public int getCodigoPais() {
        return codigoPais;
    }
    public void setCodigoPais(int codigoPais) {
        this.codigoPais = codigoPais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefono telefono = (Telefono) o;
        return numero == telefono.numero && codigoCiudad == telefono.codigoCiudad && codigoPais == telefono.codigoPais;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, codigoCiudad, codigoPais);
    }

    @Override
    public String toString() {
        return null;
    }
}

