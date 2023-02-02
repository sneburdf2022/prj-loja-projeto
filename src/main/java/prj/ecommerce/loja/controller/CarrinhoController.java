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

import prj.ecommerce.loja.entity.Carrinho;
import prj.ecommerce.loja.repository.CarrinhoRepository;


@Controller
@RequestMapping("/api/carrinho")
@CrossOrigin("*")
public class CarrinhoController {
    @Autowired
    CarrinhoRepository rCarrinho;

    @PostMapping("/")
    public @ResponseBody Carrinho addCarrinho(@RequestBody Carrinho obj) {
        rCarrinho.save(obj);
        return obj;
    }

    @GetMapping("/")
    public @ResponseBody Iterable<Carrinho> buscarCarrinho() {
        return rCarrinho.findAll();
    }

    @PutMapping("/")
    public @ResponseBody Carrinho atualizarCarrinho(@RequestBody Carrinho obj) {
        rCarrinho.save(obj);
        return obj;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String apagarCarrinho(@PathVariable Integer id) {
        rCarrinho.deleteById(id);
        return "Ok ao apagar";
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Carrinho> localizarCarrinho(@PathVariable Integer id) {
        return rCarrinho.findById(id);
    }
}
