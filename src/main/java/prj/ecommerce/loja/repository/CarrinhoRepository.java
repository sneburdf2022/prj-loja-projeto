package prj.ecommerce.loja.repository;

import org.springframework.data.repository.CrudRepository;

import prj.ecommerce.loja.entity.Carrinho;

public interface CarrinhoRepository extends CrudRepository<Carrinho, Integer>{
    
}
