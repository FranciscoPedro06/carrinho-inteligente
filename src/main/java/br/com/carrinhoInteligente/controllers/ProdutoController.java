import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoFacade facade;

    public ProdutoController(ProdutoFacade facade) {
        this.facade = facade;
    }

    @PostMapping
    public Produto criar(@RequestBody Produto obj) {
        return facade.criarProduto(obj);
    }

    @GetMapping("/{id}")
    public Produto obter(@PathVariable Long id) {
        return facade.obterProduto(id);
    }

    @PutMapping("/{id}")
    public Produto editar(@PathVariable Long id, @RequestBody Produto obj) {
        return facade.editarProduto(id, obj);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        facade.deletarProduto(id);
    }

    @GetMapping
    public List<Produto> listar() {
        return facade.listarProdutos();
    }
}
