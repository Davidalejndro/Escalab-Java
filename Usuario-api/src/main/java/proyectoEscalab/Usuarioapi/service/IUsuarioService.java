package proyectoEscalab.Usuarioapi.service;

import proyectoEscalab.Usuarioapi.model.dto.UsuarioResponse;
import proyectoEscalab.Usuarioapi.model.dto.UsuarioRequest;
import proyectoEscalab.Usuarioapi.model.entity.Usuario;


import java.util.List;
import java.util.Optional;
public interface IUsuarioService {

        List<UsuarioRequest> getUsuarios();
        UsuarioRequest getUsuario(int id);
        UsuarioResponse insertarUsuario(UsuarioRequest usuario);
        UsuarioRequest eliminarUsuario(int id);
        UsuarioRequest actualizarUsuario(Usuario usuario);
    }

