package controller;

import java.util.HashMap;
import java.util.Scanner;
import view.ProdutoView;
import bean.ProdutoBean;

public class ProdutoController {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			ProdutoView prodView = new ProdutoView();
			ProdutoBean prodBean = new ProdutoBean();
			HashMap<Integer, ProdutoBean> map = new HashMap<>();
			Integer opcPrincipal; 
			Integer id = 1;

			do {
				prodView.menu();
				opcPrincipal = sc.nextInt();

				if(opcPrincipal == 1) {
					prodBean = new ProdutoBean();
					prodView.InserirNomeProduto();
					prodBean.setNome(sc.nextLine());
					prodBean.setNome(sc.nextLine());

					prodView.InserirCategoriaProduto();
					prodBean.setCategoria(sc.nextLine());

					prodView.InserirValorProduto();
					prodBean.setValor(sc.nextDouble());

					prodView.ProdutoInseridoMensagem(prodBean);
					map.put(id, prodBean);
					++id;
				}

				else if(opcPrincipal == 2) {
					prodView.menuListarProdOpcao2(map);
				}

				else if(opcPrincipal == 3) {
					prodView.menuProcurarProdOpcao3(map);
				}

				else if(opcPrincipal == 4) {
					prodView.menuAlterarProdOpcao4(map);
				}

				else if(opcPrincipal == 5) {
					prodView.menuProdRemoverOpcao5();
				}
				else if(opcPrincipal >= 7 || opcPrincipal <= 0) {
					prodView.menuOpcaoInexistente();
				}
			} while(opcPrincipal != 6);
		}
	}
}
