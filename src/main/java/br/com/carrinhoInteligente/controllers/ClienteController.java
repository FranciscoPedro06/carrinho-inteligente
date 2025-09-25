import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteFacade facade;

    public ClienteController(ClienteFacade facade) {
        this.facade = facade;
    }

    @PostMapping
    public Cliente criar(@RequestBody Cliente obj) {
        return facade.criarCliente(obj);
    }

    @GetMapping("/{id}")
    public Cliente obter(@PathVariable Long id) {
        return facade.obterCliente(id);
    }

    @PutMapping("/{id}")
    public Cliente editar(@PathVariable Long id, @RequestBody Cliente obj) {
        return facade.editarCliente(id, obj);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        facade.deletarCliente(id);
    }

    @GetMapping
    public List<Cliente> listar() {
        return facade.listarClientes();
    }
}
