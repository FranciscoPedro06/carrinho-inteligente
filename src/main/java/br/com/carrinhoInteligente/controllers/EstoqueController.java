import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    private final EstoqueFacade facade;

    public EstoqueController(EstoqueFacade facade) {
        this.facade = facade;
    }

    @PostMapping
    public Estoque criar(@RequestBody Estoque obj) {
        return facade.criarEstoque(obj);
    }

    @GetMapping("/{id}")
    public Estoque obter(@PathVariable Long id) {
        return facade.obterEstoque(id);
    }

    @PutMapping("/{id}")
    public Estoque editar(@PathVariable Long id, @RequestBody Estoque obj) {
        return facade.editarEstoque(id, obj);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        facade.deletarEstoque(id);
    }

    @GetMapping
    public List<Estoque> listar() {
        return facade.listarEstoques();
    }
}
