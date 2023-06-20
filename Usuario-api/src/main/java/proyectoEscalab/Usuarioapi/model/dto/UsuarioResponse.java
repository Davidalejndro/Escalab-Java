package proyectoEscalab.Usuarioapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.sql.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {
    private int id;
    private String nombre;
    private LocalDateTime creado;
    private LocalDateTime modificado;
    private int isActive;
}
