# 🛒 Requisitos do Sistema - Carrinho MVP

## 📌 Requisitos Funcionais

1. **Gerenciamento de lojas**
   - O sistema deve permitir o cadastro, consulta e gerenciamento de lojas.
   - Cada produto e cada carrinho físico deve estar vinculado a uma loja.

2. **Gerenciamento de clientes**
   - O sistema deve permitir o cadastro e a identificação de clientes.
   - Um cliente pode utilizar diferentes carrinhos e ter múltiplas sessões de compra.

3. **Gerenciamento de produtos**
   - O sistema deve permitir o cadastro de produtos por loja.
   - Cada produto deve ter um código de barras único, nome, preço e loja associada.
   - O sistema deve permitir a consulta de produtos disponíveis em cada loja.

4. **Gerenciamento de carrinhos físicos**
   - O sistema deve permitir o cadastro de carrinhos físicos com código QR único.
   - O status do carrinho deve ser atualizado entre **DISPONÍVEL** e **EM_USO**.

5. **Sessões de carrinho**
   - O sistema deve permitir a criação de uma sessão ao associar um carrinho físico a um cliente.
   - Cada carrinho físico pode ter apenas **uma sessão ativa por vez**.
   - O status da sessão deve poder ser atualizado entre **ATIVO, FINALIZANDO, PAGO, CANCELADO**.
   - O total da sessão deve ser calculado automaticamente com base nos itens adicionados.

6. **Itens do carrinho**
   - O sistema deve permitir adicionar e remover produtos na sessão de um carrinho.
   - O sistema deve calcular automaticamente o **preço total** de cada item (quantidade × preço unitário).
   - Caso uma sessão seja encerrada, todos os itens associados devem ser removidos.

7. **Pagamentos**
   - O sistema deve registrar pagamentos vinculados a uma sessão.
   - O pagamento deve registrar o **método** (PIX, crédito, débito, dinheiro, mock).
   - O pagamento deve ter um **status** (pendente, confirmado, falhou).
   - O pagamento deve ser atualizado em caso de confirmação ou falha.

8. **Reserva de estoque**
   - O sistema deve reservar produtos para sessões de carrinho, evitando **overselling**.
   - Cada reserva deve ter prazo de expiração (`expira_em`).
   - Quando a sessão for finalizada ou cancelada, a reserva deve ser liberada.

---

## 📌 Requisitos Não Funcionais

1. **Desempenho**
   - O sistema deve ser capaz de lidar com múltiplas sessões de carrinho simultâneas.
   - As operações de adição e remoção de itens no carrinho devem ser executadas em tempo real (< 1 segundo).

2. **Segurança**
   - Deve garantir consistência nos pagamentos, evitando alterações indevidas no valor pago.
   - O acesso a dados sensíveis (como sessões de clientes e pagamentos) deve ser restrito.

3. **Disponibilidade e Confiabilidade**
   - O sistema deve garantir que um carrinho físico não tenha mais de uma sessão ativa.
   - Em caso de falha no pagamento, o status deve refletir corretamente o resultado.

4. **Escalabilidade**
   - A solução deve suportar expansão do número de lojas, clientes e produtos sem necessidade de alteração estrutural.
   - A reserva de estoque deve funcionar corretamente mesmo com grande volume de transações simultâneas.

5. **Usabilidade e Operacionalidade**
   - O sistema deve ser simples de operar para clientes e funcionários.
   - O status dos carrinhos deve ser facilmente identificado (**disponível/em uso**).
