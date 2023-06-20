package proyectoEscalab.Usuarioapi.service.Impl;

import org.springframework.stereotype.Service;
import proyectoEscalab.Usuarioapi.model.dto.UsuarioResponse;
import proyectoEscalab.Usuarioapi.model.dto.UsuarioRequest;
import proyectoEscalab.Usuarioapi.model.entity.Usuario;
import proyectoEscalab.Usuarioapi.model.repository.UsuarioRepository;
import proyectoEscalab.Usuarioapi.service.IUsuarioService;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
    UsuarioRepository usuarioRepository;
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<UsuarioRequest> getUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioRequest> usuariosDto = new ArrayList<>();

        for (Usuario usuario: usuarios) {
            usuariosDto.add(UsuarioRequest.mapToDto(usuario));
        }

        return usuariosDto;
    }

    @Override
    public UsuarioRequest getUsuario(int id) {
        Usuario usuario;
        if (usuarioRepository.existsById(id)){
            usuario =  usuarioRepository.findById(id).get();
            return new UsuarioRequest(usuario.getNombre(),usuario.getCorreo(),usuario.getClave(),usuario.getTelefonos(),usuario.getCreado(), usuario.getModificado(),usuario.getIsActive(),usuario.getUsuarioId());
        }
        return null;
    }

    @Override
    public UsuarioResponse insertarUsuario(UsuarioRequest request) {

        Usuario usuarioEntity = UsuarioRequest.mapToEntity(request);
        //seteamos fechas
        Date date = new Date(new java.util.Date().getTime());
        usuarioEntity.setCreado(LocalDateTime.now());
        usuarioEntity.setModificado(LocalDateTime.now());
        usuarioEntity.setIsActive(1);
        Usuario save = usuarioRepository.save(usuarioEntity);

        UsuarioResponse response = new UsuarioResponse();
        response.setId(save.getUsuarioId());
        response.setIsActive(save.getIsActive());
        response.setCreado(save.getCreado());
        response.setModificado(save.getModificado());
        response.setNombre(save.getNombre());
        return response;
    }

    @Override
    public UsuarioRequest eliminarUsuario(int id) {
        Usuario usuario;
        if (usuarioRepository.existsById(id)){
            usuario = usuarioRepository.findById(id).get();
            usuarioRepository.deleteById(id);
            return new UsuarioRequest(usuario.getNombre(),usuario.getCorreo(),usuario.getClave(),usuario.getTelefonos(),usuario.getCreado(), usuario.getModificado(),usuario.getIsActive(),usuario.getUsuarioId());
        }
        return null;
    }
    @Override
    public UsuarioRequest actualizarUsuario(Usuario usuario) {
        Usuario usuarioAux;
        if (usuarioRepository.existsById(usuario.getUsuarioId())){
            usuarioAux = usuarioRepository.findById(usuario.getUsuarioId()).get();
            usuario.setCreado(usuarioAux.getCreado());
            usuario.setIsActive(usuarioAux.getIsActive());
            usuario.setModificado(LocalDateTime.now());
            usuarioRepository.save(usuario);
            usuario = usuarioRepository.findById(usuario.getUsuarioId()).get();

            return new UsuarioRequest(usuario.getNombre(),usuario.getCorreo(),usuario.getClave(),usuario.getTelefonos(),usuario.getCreado(), usuario.getModificado(),usuario.getIsActive(),usuario.getUsuarioId());
        }
        return null;
    }
}

