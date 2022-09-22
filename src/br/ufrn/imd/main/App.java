package br.ufrn.imd.main;

import java.util.Date;
import java.util.Scanner;

import br.ufrn.imd.dominio.Deposito;
import br.ufrn.imd.dominio.Produto;
import br.ufrn.imd.dominio.ProdutoDuravel;
import br.ufrn.imd.dominio.ProdutoNaoDuravel;

public class App {
    public static void main(String[] args) throws Exception {
        Deposito deposito = new Deposito();

        ProdutoDuravel produto1 = new ProdutoDuravel("Carro", 55000, "Hyundai", "Carrin", new Date(), 20);
        ProdutoDuravel produto2 = new ProdutoDuravel("Livro: Capitão América Guerra civil", 150, "sei la", "livrin",
                new Date(), 30);
        ProdutoDuravel produto3 = new ProdutoDuravel("Notebook", 5000, "DELL", "notebook i7", new Date(), 10);

        deposito.adicionarProduto(produto1);
        deposito.adicionarProduto(produto2);
        deposito.adicionarProduto(produto3);

        ProdutoNaoDuravel produto4 = new ProdutoNaoDuravel("Chocolate Ao leite", 50, "Nestle", "chocolate ao leite",
                new Date(), new Date(), "alimentício");
        ProdutoNaoDuravel produto5 = new ProdutoNaoDuravel("Chocolate Amargo ", 100, "Garoto", "chocolate amargo",
                new Date(), new Date(), "alimentício");
        ProdutoNaoDuravel produto6 = new ProdutoNaoDuravel("Pastel de chocolate", 10, "Tangará",
                "Pastel de chocolate ao leite", new Date(), new Date(), "alimentício");

        deposito.adicionarProduto(produto4);
        deposito.adicionarProduto(produto5);
        deposito.adicionarProduto(produto6);

        for (Produto produto : deposito.getProdutos()) {
            System.out.println(produto + "\n");
        }
        int opcaoEscolha = -1;
        Scanner s = new Scanner(System.in);
        try {
            do {
                System.out.println("Digite 1 para listar os produtos;");
                System.out.println("Digite 2 para remover um novo produto;");
                System.out.println("Digite 3 para ver a quantidade de produtos no depósitos;");
                System.out.println("Digite 4 para conferir se o depósito está vazio;");
                System.out.println("Digite 5 para ver o produto com o maior preço;");
                System.out.println("Digite 0 para sair do programa;");
                opcaoEscolha = s.nextInt();
                switch (opcaoEscolha) {
                    case 1:
                        for (Produto produto : deposito.getProdutos()) {
                            System.out.println(produto + "\n");
                        }
                        break;
                    case 2:
                        for (int i = 0; i < deposito.informarQuantidadeProdutos(); i++) {
                            System.out.println(i + " -> " + deposito.getProdutos().get(i) + "\n");
                        }
                        System.out.println("\nDigite o index de qual o produto deseja remover: ");
                        int indexProdutoToRemove = s.nextInt();
                        boolean removeuComSucesso = deposito
                                .removerProduto(deposito.getProdutos().get(indexProdutoToRemove));

                        if(removeuComSucesso) System.out.println("Produto removido com sucesso.");
                        else System.out.println("Falha ao remover");
                        break;
                    case 3:
                        System.out
                                .println(deposito.informarQuantidadeProdutos() + " Produtos cadastrados no depósito.");
                        break;
                    case 4:
                        if (deposito.estaVazio()) {
                            System.out.println("O depósito está vazio.");
                        } else {
                            System.out.println("O depósito não está vazio.");
                        }
                        break;
                    case 5:
                        if (deposito.estaVazio()) {
                            System.out.println("O deposito está vazio.");
                        } else {
                            System.out
                                    .println("O produto de maior preço é: " + deposito.informarProdutoComMaiorPreco());
                        }
                        break;
                    default:
                        System.out.println("Programa encerrado.");

                }

            } while (opcaoEscolha != 0);
        } finally {
            s.close();
        }
    }
}
