package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.applications.CarrinhoFisicoApplication;
import br.com.carrinhoInteligente.models.CarrinhoFisicoModel;
import br.com.carrinhoInteligente.models.LojaModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/carrinhos")
public class CarrinhoFisicoController {

    private final CarrinhoFisicoApplication application;

    public CarrinhoFisicoController(CarrinhoFisicoApplication application) {
        this.application = application;
    }

    @PostMapping
    public ResponseEntity<CarrinhoFisicoModel> criarCarrinho(@RequestBody CarrinhoFisicoModel request) {
        LojaModel loja = request.getLoja();
        CarrinhoFisicoModel novo = application.salvar(request.getCodigoQr(), request.getStatus(), loja);
        return ResponseEntity.ok(novo);
    }

    @GetMapping
    public ResponseEntity<List<CarrinhoFisicoModel>> listarTodos() {
        return ResponseEntity.ok(application.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoFisicoModel> buscarPorId(@PathVariable int id) {
        return application.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id, @RequestBody CarrinhoFisicoModel carrinho) {
        boolean atualizado = application.atualizar(id, carrinho);
        return atualizado ? ResponseEntity.ok("Atualizado com sucesso!") : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable int id) {
        boolean deletado = application.deletar(id);
        return deletado ? ResponseEntity.ok("Deletado com sucesso!") : ResponseEntity.notFound().build();
    }
}
