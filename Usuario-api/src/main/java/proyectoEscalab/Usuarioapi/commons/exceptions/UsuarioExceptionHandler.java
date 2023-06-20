package proyectoEscalab.Usuarioapi.commons.exceptions;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.validation.FieldError;

@ControllerAdvice
public class UsuarioExceptionHandler {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> badRequestHandler(MethodArgumentNotValidException ex, WebRequest request){
        ErrorHttp message = new ErrorHttp(DetalleError.mapearError(HttpStatus.BAD_REQUEST.value(), ex.getFieldErrors()));
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<Object> badSQLHandler(DataIntegrityViolationException ex, WebRequest request){
        ErrorSQL message = new ErrorSQL(HttpStatus.BAD_REQUEST.value()
                ,DetalleError.mapearErrorSQL(ex.getMostSpecificCause().toString()));
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }
}
