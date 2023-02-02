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

import prj.ecommerce.loja.entity.Cliente;
import prj.ecommerce.loja.repository.ClienteRepository;

@Controller
@RequestMapping("/api/cliente")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    ClienteRepository rCliente;

    @PostMapping("/")
    public @ResponseBody Cliente addCliente(@RequestBody Cliente obj) {
        rCliente.save(obj);
        return obj;
    }

    @GetMapping("/")
    public @ResponseBody Iterable<Cliente> buscarCliente() {
        return rCliente.findAll();
    }

    @PutMapping("/")
    public @ResponseBody Cliente atualizarCliente(@RequestBody Cliente obj) {
        rCliente.save(obj);
        return obj;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String apagarCliente(@PathVariable Integer id) {
        rCliente.deleteById(id);
        return "Ok ao apagar";
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Cliente> localizarCliente(@PathVariable Integer id) {
        return rCliente.findById(id);
    }
}
