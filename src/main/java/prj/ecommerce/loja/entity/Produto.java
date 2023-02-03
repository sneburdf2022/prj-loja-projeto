package prj.ecommerce.loja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer id;
    private String nome;
    private String descricao;
    private String informacao;
    private Integer aba;
    private Integer imagem;
    public Integer getImagem() {
        return imagem;
    }
    public void setImagem(Integer imagem) {
        this.imagem = imagem;
    }
    private Float preco;
    private boolean ativo;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getInformacao() {
        return informacao;
    }
    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }
    public Float getPreco() {
        return preco;
    }
    public void setPreco(Float preco) {
        this.preco = preco;
    }
    public Integer getAba() {
        return aba;
    }
    public void setAba(Integer aba) {
        this.aba = aba;
    }
    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }    
    
}
