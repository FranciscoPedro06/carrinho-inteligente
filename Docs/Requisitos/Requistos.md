 📌 Requisitos do Sistema - Carrinho Inteligente (MVP)

## Requisitos Funcionais

### 1- Gerenciamento de Lojas
- O sistema deve permitir o cadastro, consulta e gerenciamento de lojas, contendo informações como *nome, endereço e identificação*.  
- Cada *produto* e cada *carrinho físico* deve estar vinculado a uma loja.  
- O sistema deve fornecer relatórios em tempo real para as lojas (*sessões abertas, estoque reservado, pagamentos confirmados*).  

### 2- Gerenciamento de Produtos
- O sistema deve permitir o *cadastro e gerenciamento de produtos*, com:
- Código de barras único, Nome, Preço, Estoque, Loja associada.  
- O sistema deve permitir a *consulta de produtos disponíveis* em cada loja.  

### 3- Gerenciamento de Clientes
- O sistema deve permitir o *cadastro e identificação de clientes*.  
- Um cliente pode utilizar diferentes carrinhos e ter múltiplas sessões de compra.  
- O sistema deve permitir *login com conta de cliente* ou uso como *visitante* (sem cadastro).  

### 4- Gerenciamento de Carrinhos Físicos
- O sistema deve permitir o *cadastro de carrinhos físicos, cada um com **código QR ou NFC único*.  
- O status de cada carrinho deve ser atualizado entre:  
  *DISPONÍVEL*    - *EM_USO*  

### 5- Sessões de Carrinho
- O sistema deve permitir a *criação de uma sessão de compra* ao associar um cliente (opcional) a um carrinho físico.  
- Cada carrinho físico pode ter *apenas uma sessão ativa* por vez.  
- O status da sessão deve ser atualizado entre:  
  - *ATIVO*  
  - *FINALIZANDO*  
  - *PAGO*  
  - *CANCELADO*  
- O total da sessão deve ser *calculado automaticamente* com base nos itens adicionados.  

### 6- Itens do Carrinho
- O sistema deve permitir *adicionar e remover produtos* na sessão de um carrinho.  
- O sistema deve calcular automaticamente o preço total de cada item (*quantidade × preço unitário*).  
- Caso uma sessão seja encerrada, todos os itens associados devem ser *removidos*.  
- O sistema deve permitir que o cliente *visualize em tempo real* os produtos adicionados, quantidades e valores.  

### 7- Reserva de Estoque
- RF16. O sistema deve *reservar produtos* para sessões de carrinho, evitando *overselling*.  
- RF17. Cada reserva deve ter um prazo de expiração (*expira_em*).  
- RF18. Quando a sessão for *finalizada ou cancelada*, a reserva deve ser liberada.  

### 8- Pagamentos
- O sistema deve permitir *pagamentos vinculados a uma sessão*, suportando métodos:  
  - PIX  
  - Crédito  
  - Débito  
  - Dinheiro  
  - Mock  
- O pagamento deve registrar:  
  - Método.  
  - Status (*pendente, confirmado, falhou*).  
- O pagamento deve ser atualizado em caso de *confirmação ou falha*.  
- O sistema deve permitir a *emissão de recibos digitais* após pagamento confirmado.  

### 9- Fidelidade, Promoções e Anúncios
- O sistema deve permitir integração com *programas de fidelidade*, vinculando pontos e descontos.  
- O sistema deve permitir a *exibição de promoções e anúncios personalizados* na tela do carrinho e no app.  


---


## 🚀 Requisitos Não Funcionais

### 1- Desempenho
- O sistema deve ser capaz de lidar com *múltiplas sessões de carrinho simultâneas*.  
- As operações de adição e remoção de itens devem ser executadas em tempo real (*< 1 segundo*).  

### 2- Segurança
- O sistema deve garantir *consistência nos pagamentos*, evitando alterações indevidas no valor pago.  
- O acesso a *dados sensíveis* (como sessões de clientes e pagamentos) deve ser restrito.  

### 3- Disponibilidade e Confiabilidade
- O sistema deve garantir que um carrinho físico *não tenha mais de uma sessão ativa*.  
- Em caso de falha no pagamento, o status deve refletir corretamente o resultado.  

### 4- Escalabilidade
- A solução deve suportar *expansão do número de lojas, clientes e produtos* sem necessidade de alteração estrutural.  
- A *reserva de estoque* deve funcionar corretamente mesmo com grande volume de transações simultâneas.  

### 5- Usabilidade e Operacionalidade
- O sistema deve ser *simples de operar* para clientes e funcionários.  
- O status dos carrinhos deve ser *facilmente identificado* (DISPONÍVEL / EM_USO).  

---