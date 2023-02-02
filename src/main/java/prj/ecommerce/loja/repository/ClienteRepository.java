package prj.ecommerce.loja.repository;

import org.springframework.data.repository.CrudRepository;
import prj.ecommerce.loja.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{
    
}
