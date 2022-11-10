package produtoView;

import java.util.HashMap;
import java.util.Scanner;

import produtoBean.ProdutoBean;


public class ProdutoView{

	ProdutoBean prodBean = new ProdutoBean();
	Scanner sc = new Scanner(System.in);
	HashMap<Integer, ProdutoBean> map = new HashMap<>();
	Integer id = 1;
	Integer adcOutra;
	Integer keyGet;
	Integer opcPrincipal;


	//eu sou falcao na pista tambem sou falcao no morro
	//Boy, 2022
	public void menu() {
		System.out.println("O QUE DESEJA FAZER");
		System.out.println("1 - Inserir um novo produto");
		System.out.println("2 - Listar produtos");
		System.out.println("3 - Procurar por um produto");
		System.out.println("4 - Alterar um produto");
		System.out.println("5 - Remover um produto");
		System.out.println("6 - encerrar");
	}

	public void menuInserirProdOpcao1() {
		prodBean = new ProdutoBean();
		System.out.println("digite o nome produto que deseja adicionar:");
		prodBean.setNome(sc.next());

		System.out.println("digite a categoria desse produto:");
		prodBean.setCategoria(sc.next());

		System.out.println("digite o valor produto que deseja adicionar:");
		prodBean.setValor(sc.nextDouble());

		System.out.println("produto '"+ prodBean.getNome() +"' adicionado");
		map.put(id, prodBean);
		id = id + 1;
	}

	public void menuListarProdOpcao2() {
		System.out.println("==============");
		for (Integer key : map.keySet()) {
			prodBean = map.get(key);
			System.out.println("");	
			System.out.println(key + " = " + prodBean.getNome());	
			System.out.println("categoria: "+  prodBean.getCategoria());	
			System.out.println("valor: " + prodBean.getValor());	
			System.out.println("");	
		}
		System.out.println("==============");
	}

	public void menuProcurarProdOpcao3() {
		System.out.println("Digite o numero do produto que vc quer ver");
		keyGet = sc.nextInt();
		if(map.containsKey(keyGet) == false) {
			System.err.println("este Id não esta registrado na lista");
		}

		else {
			System.out.println("nome: " + map.get(keyGet).getNome());
			System.out.println("categoria: " + map.get(keyGet).getCategoria());
			System.out.println("preço: " + map.get(keyGet).getValor());
			System.out.println("");
		}
	}

	public void menuAlterarProdOpcao4() {
		System.out.println("Digite o Id do produto que vc quer alterar");
		keyGet = sc.nextInt();
		System.out.println(keyGet + " é o produto: " + map.get(keyGet).getNome());

		System.out.println("certeza que deseja alterar essa produto?");
		System.out.println("1 - sim");
		System.out.println("2 - não");
		Integer alterar = sc.nextInt();
		System.out.println("");

		if(alterar == 1) {
			System.out.println("digite o nome do produto:");
			String produtoNovo = sc.next();
			prodBean.setNome(produtoNovo);

			System.out.println("digite a categoria do produto ");
			String categoriaNova = sc.next();
			prodBean.setCategoria(categoriaNova);

			System.out.println("digite o valor do produto");
			Double valorNovo = sc.nextDouble();
			prodBean.setValor(valorNovo);
			System.out.println("");

			ProdutoBean a = map.get(keyGet);

			System.out.println("nome " + a.getNome() + " alterado para: " + produtoNovo);
			System.out.println("categoria " + a.getCategoria() + " alterado para: " + categoriaNova);
			System.out.println("valor " + a.getValor() + " alterado para: " + valorNovo);
			System.out.println("");

			map.put(keyGet, prodBean);
		}
		else {
		}
	}

	public void menuProdRemoverOpcao5() {

		System.out.println("Digite o Id da produto que vc quer remover");
		keyGet = sc.nextInt();
		System.out.println(keyGet + " é o produto: " + map.get(keyGet).getNome());

		System.out.println("certeza que deseja remover essa produto?");
		System.out.println("1 - sim");
		System.out.println("2 - não");
		Integer remover = sc.nextInt();

		if(remover == 1) {
			System.out.println("produto " + map.get(keyGet).getNome() + " removida");
			map.remove(keyGet);
		}
	}

	public void menuOpcaoInexistente() {
		System.err.println("Insira uma opcao valida.");
	}
}
