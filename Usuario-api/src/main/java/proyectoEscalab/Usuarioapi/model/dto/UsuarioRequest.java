package proyectoEscalab.Usuarioapi.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import proyectoEscalab.Usuarioapi.model.entity.Telefono;
import proyectoEscalab.Usuarioapi.model.entity.Usuario;
import jakarta.validation.constraints.NotEmpty;


import java.util.Objects;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {
    @NotEmpty(message = "el nombre del usuario es obligatorio")
    private String nombre;
    @NotEmpty(message = "el correo del usuario es obligatorio")
    private String correo;
    @NotEmpty(message = "la clave del usuario es obligatorio")
    private String clave;
    @Valid
    private List<Telefono> telefonos;
    private LocalDateTime creado;
    private LocalDateTime modificado;

    private int isActive;
    private int id;
    public static UsuarioRequest mapToDto(Usuario entity){
        UsuarioRequest dto = new UsuarioRequest();
        dto.setNombre(entity.getNombre());
        dto.setCorreo(entity.getCorreo());
        dto.setClave(entity.getClave());
        dto.setId(entity.getUsuarioId());
        dto.setCreado(entity.getCreado());
        dto.setModificado(entity.getModificado());
        dto.setIsActive(entity.getIsActive());
        List<Telefono> telefonos = new ArrayList<>();
        if(entity.getTelefonos().size()>0){
            for (Telefono telefono: entity.getTelefonos()){
                telefonos.add(telefono);
            }
        }
        dto.setTelefonos(telefonos);

        return dto;
    }

    public static Usuario mapToEntity(UsuarioRequest dto){
        Usuario usuarioEntity = new Usuario();
        usuarioEntity.setNombre(dto.getNombre());
        usuarioEntity.setCorreo(dto.getCorreo());
        usuarioEntity.setClave(dto.getClave());
        usuarioEntity.setUsuarioId(dto.getId());
        usuarioEntity.setIsActive(dto.getIsActive());
        usuarioEntity.setCreado(dto.getCreado());
        usuarioEntity.setModificado(dto.getModificado());

        List<Telefono> telefonos = new ArrayList<>();
        if(dto.getTelefonos().size()>0){
            for (Telefono telefono: dto.getTelefonos()){
                telefonos.add(telefono);
            }
        }
        usuarioEntity.setTelefonos(telefonos);

        return usuarioEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioRequest that = (UsuarioRequest) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(telefonos, that.telefonos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, telefonos);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UsuarioRequest{");
        sb.append("creado=").append(creado);
        sb.append(", modificado=").append(modificado);
        sb.append(", isActive=").append(isActive);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
