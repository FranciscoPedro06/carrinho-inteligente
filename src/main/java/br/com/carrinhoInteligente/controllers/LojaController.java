import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/lojas")
public class LojaController {

    private final LojaFacade facade;

    public LojaController(LojaFacade facade) {
        this.facade = facade;
    }

    @PostMapping
    public Loja criar(@RequestBody Loja obj) {
        return facade.criarLoja(obj);
    }

    @GetMapping("/{id}")
    public Loja obter(@PathVariable Long id) {
        return facade.obterLoja(id);
    }

    @PutMapping("/{id}")
    public Loja editar(@PathVariable Long id, @RequestBody Loja obj) {
        return facade.editarLoja(id, obj);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        facade.deletarLoja(id);
    }

    @GetMapping
    public List<Loja> listar() {
        return facade.listarLojas();
    }
}
