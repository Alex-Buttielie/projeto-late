import br.com.iateclubedebrasilia.api.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuariosController")
public class UsuariosController {

    @Autowired
    UsuariosService usuariosService;
}
