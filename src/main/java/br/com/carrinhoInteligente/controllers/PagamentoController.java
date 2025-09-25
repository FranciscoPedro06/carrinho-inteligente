import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoFacade facade;

    public PagamentoController(PagamentoFacade facade) {
        this.facade = facade;
    }

    @PostMapping
    public Pagamento criar(@RequestBody Pagamento obj) {
        return facade.criarPagamento(obj);
    }

    @GetMapping("/{id}")
    public Pagamento obter(@PathVariable Long id) {
        return facade.obterPagamento(id);
    }

    @PutMapping("/{id}")
    public Pagamento editar(@PathVariable Long id, @RequestBody Pagamento obj) {
        return facade.editarPagamento(id, obj);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        facade.deletarPagamento(id);
    }

    @GetMapping
    public List<Pagamento> listar() {
        return facade.listarPagamentos();
    }
}
