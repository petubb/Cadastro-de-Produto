package produtoController;

import java.util.Scanner;
import produtoView.ProdutoView;

public class ProdutoController {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			ProdutoView prodView = new ProdutoView();
			Integer opcPrincipal; 

			do {
				prodView.menu();
				opcPrincipal = sc.nextInt();

				if(opcPrincipal == 1) {
					prodView.menuInserirProdOpcao1();
				}

				else if(opcPrincipal == 2) {
					prodView.menuListarProdOpcao2();
				}

				else if(opcPrincipal == 3) {
					prodView.menuProcurarProdOpcao3();
				}

				else if(opcPrincipal == 4) {
					prodView.menuAlterarProdOpcao4();
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
