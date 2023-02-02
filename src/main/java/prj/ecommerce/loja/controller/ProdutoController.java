package prj.ecommerce.loja.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import prj.ecommerce.loja.entity.Produto;
import prj.ecommerce.loja.repository.ProdutoRepository;

@Controller
@RequestMapping("/api/produto")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    ProdutoRepository rProduto;

    @PostMapping("/")
    public @ResponseBody Produto addProduto(@RequestBody Produto obj) {
        rProduto.save(obj);
        return obj;
    }

    @GetMapping("/")
    public @ResponseBody Iterable<Produto> buscarProduto() {
        return rProduto.findAll();
    }

    @PutMapping("/")
    public @ResponseBody Produto atualizarProduto(@RequestBody Produto obj) {
        rProduto.save(obj);
        return obj;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String apagarProduto(@PathVariable Integer id) {
        rProduto.deleteById(id);
        return "Ok ao apagar";
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Produto> localizarProduto(@PathVariable Integer id) {
        return rProduto.findById(id);
    }
}
