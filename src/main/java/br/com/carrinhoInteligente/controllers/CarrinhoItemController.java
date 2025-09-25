import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/carrinho-item")
public class CarrinhoItemController {

    private final CarrinhoItemFacade carrinhoItemFacade;

    public CarrinhoItemController(CarrinhoItemFacade carrinhoItemFacade) {
        this.carrinhoItemFacade = carrinhoItemFacade;
    }

    @PostMapping
    public CarrinhoItem criar(@RequestBody CarrinhoItem item) {
        return carrinhoItemFacade.criarCarrinhoItem(item);
    }

    @GetMapping("/{id}")
    public CarrinhoItem obter(@PathVariable Long id) {
        return carrinhoItemFacade.obterCarrinhoItem(id);
    }

    @PutMapping("/{id}")
    public CarrinhoItem editar(@PathVariable Long id, @RequestBody CarrinhoItem item) {
        return carrinhoItemFacade.editarCarrinhoItem(id, item);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        carrinhoItemFacade.deletarCarrinhoItem(id);
    }

    @GetMapping
    public List<CarrinhoItem> listar() {
        return carrinhoItemFacade.listarCarrinhoItens();
    }
}
