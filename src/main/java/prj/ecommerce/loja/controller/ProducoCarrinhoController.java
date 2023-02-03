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
import prj.ecommerce.loja.entity.Produto;
import prj.ecommerce.loja.entity.ProdutoCarrinho;
import prj.ecommerce.loja.repository.ProdutoCarrinhoRepository;
import prj.ecommerce.loja.repository.ProdutoRepository;

@Controller
@RequestMapping("/api/carrinhoproduto")
@CrossOrigin("*")
public class ProducoCarrinhoController {
    @Autowired
    ProdutoCarrinhoRepository rProdutoCarrinho;
    @Autowired
    ProdutoRepository rProdutoItem;

    @PostMapping("/")
    public @ResponseBody ProdutoCarrinho addProduto(@RequestBody ProdutoCarrinho obj) {
        rProdutoCarrinho.save(obj);
        return obj;
    }

    @GetMapping("/")
    public @ResponseBody Iterable<ProdutoCarrinho> buscarProduto() {
        return rProdutoCarrinho.findAll();
    }

    @PutMapping("/")
    public @ResponseBody ProdutoCarrinho atualizarProduto(@RequestBody ProdutoCarrinho obj) {
        rProdutoCarrinho.save(obj);
        return obj;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String apagarProduto(@PathVariable Integer id) {
        rProdutoCarrinho.deleteById(id);
        return "Ok ao apagar";
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<ProdutoCarrinho> localizarProduto(@PathVariable Integer id) {
        return rProdutoCarrinho.findById(id);
    }

    @PostMapping("/valor/")
    public @ResponseBody Float buscarValorCarrinho(@RequestBody Carrinho obj) {
        Iterable<ProdutoCarrinho> item = rProdutoCarrinho.findAll();
        float valor = 0;
        for (ProdutoCarrinho produtoCarrinho : item) {
            if(produtoCarrinho.getIdCarrinho() == obj.getId()){
                Integer prodItem = produtoCarrinho.getIdProduto();
                Optional<Produto> prod = rProdutoItem.findById(prodItem) ;
                if(prod!=null){
                    valor +=  prod.get().getPreco();
                }
            }
        }
        return valor;
    }
}
