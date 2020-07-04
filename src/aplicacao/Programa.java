package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entidades.Produto;
import entidades.ProdutoImportado;
import entidades.ProdutoUsado;

public class Programa {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Scanner ent = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Produto> produtos = new ArrayList<>();

		System.out.print("Informe o número de produtos: ");
		int n = ent.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Produto #" + i + " Dados:");
			System.out.print("Comum, Usado ou Importado? (c/u/i)? ");
			char resp = ent.next().charAt(0);
			System.out.print("Nome: ");
			ent.nextLine();
			String nome = ent.nextLine();
			System.out.print("Preço: ");
			Double preco = ent.nextDouble();
			//Estrutura de decisão para diferenciar os tipos de produtos com estiquetas diferentes.
			if (resp == 'c') {
				produtos.add(new Produto(nome, preco));
			}
			else if (resp == 'u') {
				System.out.print("Data de Fabricação (dd/MM/yyyy): ");
				Date dataFabricacao = sdf.parse(ent.next());
				produtos.add(new ProdutoUsado(nome, preco, dataFabricacao));
			}
			else {
				System.out.print("Taxa de Alfândega: ");
				double taxaAlfandega = ent.nextDouble();
				produtos.add(new ProdutoImportado(nome, preco, taxaAlfandega));
			}

		}
		System.out.println();//Impressão de cada etiqueta.
		System.out.println("Etiquetas: ");
		for (Produto produto : produtos) {
			System.out.println(produto.etiquetaPreco());
		}

		ent.close();
	}

}
