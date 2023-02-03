package prj.ecommerce.loja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProdutoCarrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    private Integer id;
    private Integer idProduto;
    private Integer idCarrinho;
    private String nome;
    private Float valor;
    private Integer imagem;
    public Integer getImagem() {
        return imagem;
    }
    public void setImagem(Integer imagem) {
        this.imagem = imagem;
    }
    public Float getValor() {
        return valor;
    }
    public void setValor(Float valor) {
        this.valor = valor;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    private Integer quantidade;
    private boolean finalizado;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }
    public Integer getIdCarrinho() {
        return idCarrinho;
    }
    public void setIdCarrinho(Integer idCarrinho) {
        this.idCarrinho = idCarrinho;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public boolean isFinalizado() {
        return finalizado;
    }
    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }    
    
}
