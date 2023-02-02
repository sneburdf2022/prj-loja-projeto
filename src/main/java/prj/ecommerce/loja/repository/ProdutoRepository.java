package prj.ecommerce.loja.repository;

import org.springframework.data.repository.CrudRepository;
import prj.ecommerce.loja.entity.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
    
}
