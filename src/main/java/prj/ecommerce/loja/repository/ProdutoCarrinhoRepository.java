package prj.ecommerce.loja.repository;

import org.springframework.data.repository.CrudRepository;
import prj.ecommerce.loja.entity.ProdutoCarrinho;

public interface ProdutoCarrinhoRepository extends CrudRepository<ProdutoCarrinho, Integer>{
    
}
