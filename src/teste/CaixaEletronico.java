package teste;

import java.util.ArrayList;
import java.util.List;

public class CaixaEletronico {

	public static void main(String[] args) {
		List<List<Integer[]>> result = new ArrayList<List<Integer[]>>();
		List<Integer> cedulas = new ArrayList<Integer>();
		cedulas.add(100);
		cedulas.add(50);
		cedulas.add(20);
		cedulas.add(10);
		
		result = combinaCedulas(200, cedulas);
		
		for (List<Integer[]> opcoes : result) {
			for (Integer[] opcao : opcoes) {
				System.out.print(opcao[0] + "x R$" + opcao[1] + " ");
			}
			System.out.println();
		}
		System.out.println(result);

	}
	
	private static List<List<Integer[]>> combinaCedulas(Integer valorSaque, List<Integer> cedulas) {
		
		
		List<List<Integer[]>> opcoesDisponiveis = new ArrayList<List<Integer[]>>();  
		
		for (int c = 0; c < cedulas.size(); c++) {
			
			for (int i = (valorSaque/cedulas.get(c)); i > 0; i--) {
				
				int tmp = i * cedulas.get(c);
				if (tmp == valorSaque) {
					List<Integer[]> bloco = new ArrayList<Integer[]>();
					Integer[] qCedula = new Integer[2];
					
					qCedula[0] = i;
					qCedula[1] = cedulas.get(c);
					
					bloco.add(qCedula);
					
					opcoesDisponiveis.add(bloco);
				}
				
				else {
					if (tmp < valorSaque && tmp != 0) {
						List<Integer[]> bloco = new ArrayList<Integer[]>();
						Integer[] qCedula = new Integer[2];
						
						qCedula[0] = i;
						qCedula[1] = cedulas.get(c);
						
						bloco.add(qCedula);
						
						if (c+1 < cedulas.size()) {
							for (int j = (valorSaque/cedulas.get(c+1)); j > 0; j--) {
								
								int tmp2 = j * cedulas.get(c+1);
								
								if (tmp + tmp2 == valorSaque) {
									Integer[] qCedula2 = new Integer[2];
									qCedula2[0] = j;
									qCedula2[1] = cedulas.get(c+1);
									
									bloco.add(qCedula2);
									
									opcoesDisponiveis.add(bloco);
								}
								
								else {
									if (tmp + tmp2 < valorSaque) {
										if (c+2 < cedulas.size()) {
											for (int k = (valorSaque/cedulas.get(c+2)); k > 0; k--) {
												int tmp3 = k * cedulas.get(c+2);
												if (tmp + tmp2 + tmp3 == valorSaque) {
													Integer[] qCedula3 = new Integer[2];
													qCedula3[0] = k;
													qCedula3[1] = cedulas.get(c+2);
													
													bloco.add(qCedula3);
													opcoesDisponiveis.add(bloco);
												}
											}
										}
									}
								}
							}
						}
						
					}
				}
				
			}
			
		}
		
		return opcoesDisponiveis;
		
	}

}
