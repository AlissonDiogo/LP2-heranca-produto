package br.ufrn.imd.dominio;

import java.util.ArrayList;

public class Deposito {
    private ArrayList<Produto> produtos;

    public Deposito(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public Deposito(){
        this.produtos = new ArrayList<Produto>();
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public boolean adicionarProduto(Produto produtoToAdd) {
        produtos.add(produtoToAdd);
        return true;
    }

    public boolean removerProduto(Produto produtoToRemove) {
        if(this.estaVazio()){
            return false;
        }else{
            produtos.remove(produtoToRemove);
            return true;
        }
    
    }

    public int informarQuantidadeProdutos() {
        return produtos.size();
    }

    public boolean estaVazio() {
        return produtos.isEmpty();
    }

    public Produto informarProdutoComMaiorPreco() {
        Produto produtoComMaiorPreco = produtos.get(0);
        for (Produto produto : produtos) {
            if (produto.getPreco() > produtoComMaiorPreco.getPreco()) {
                produtoComMaiorPreco = produto;
            }
        }

        return produtoComMaiorPreco;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Deposito other = (Deposito) obj;
        if (produtos == null) {
            if (other.produtos != null)
                return false;
        } else if (!produtos.equals(other.produtos))
            return false;
        return true;
    }

    
}
