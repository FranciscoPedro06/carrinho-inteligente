import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/carrinho-fisico")
public class CarrinhoFisicoController {

    private final CarrinhoFisicoFacade facade;

    public CarrinhoFisicoController(CarrinhoFisicoFacade facade) {
        this.facade = facade;
    }

    @PostMapping
    public CarrinhoFisico criar(@RequestBody CarrinhoFisico obj) {
        return facade.criarCarrinhoFisico(obj);
    }

    @GetMapping("/{id}")
    public CarrinhoFisico obter(@PathVariable Long id) {
        return facade.obterCarrinhoFisico(id);
    }

    @PutMapping("/{id}")
    public CarrinhoFisico editar(@PathVariable Long id, @RequestBody CarrinhoFisico obj) {
        return facade.editarCarrinhoFisico(id, obj);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        facade.deletarCarrinhoFisico(id);
    }

    @GetMapping
    public List<CarrinhoFisico> listar() {
        return facade.listarCarrinhosFisicos();
    }
}
