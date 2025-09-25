import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/carrinho-sessao")
public class CarrinhoSessaoController {

    private final CarrinhoSessaoFacade facade;

    public CarrinhoSessaoController(CarrinhoSessaoFacade facade) {
        this.facade = facade;
    }

    @PostMapping
    public CarrinhoSessao criar(@RequestBody CarrinhoSessao obj) {
        return facade.criarCarrinhoSessao(obj);
    }

    @GetMapping("/{id}")
    public CarrinhoSessao obter(@PathVariable Long id) {
        return facade.obterCarrinhoSessao(id);
    }

    @PutMapping("/{id}")
    public CarrinhoSessao editar(@PathVariable Long id, @RequestBody CarrinhoSessao obj) {
        return facade.editarCarrinhoSessao(id, obj);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        facade.deletarCarrinhoSessao(id);
    }

    @GetMapping
    public List<CarrinhoSessao> listar() {
        return facade.listarCarrinhosSessao();
    }
}
