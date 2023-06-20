package proyectoEscalab.Usuarioapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyectoEscalab.Usuarioapi.model.entity.Usuario;
import org.springframework.stereotype.Component;
import proyectoEscalab.Usuarioapi.model.entity.Telefono;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario,Integer> {
}
