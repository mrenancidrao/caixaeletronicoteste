package teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinacaoCedulas {

	public static void main(String[] args) {
		
		List<Integer[]> opcoesDisponiveis = new ArrayList<Integer[]>();
		List<List<Integer[]>> lista = new ArrayList<List<Integer[]>>();
		List<Integer> cedulas = new ArrayList<Integer>();
		List<String> listaAux = new ArrayList<String>();
		cedulas.add(100);
		cedulas.add(50);
		cedulas.add(20);
		cedulas.add(10);
	
		for (int i=0; i<50; i++) {
			Integer contCedulasDistintas = 0;
			String aux = new String();
			opcoesDisponiveis = buscaCombinacaoCedulas(270, cedulas);		
			
			for (Integer[] qCedulas : opcoesDisponiveis) {
				contCedulasDistintas++;
			//	System.out.print(qCedulas[0] + "x R$" + qCedulas[1] + ",00 ");
				aux += qCedulas[0] + "x R$" + qCedulas[1] + ",00 ";
			}
			if (!listaAux.contains(aux) && contCedulasDistintas <= 3) {
				lista.add(opcoesDisponiveis);
				listaAux.add(aux);
			}
		//	System.out.println();
		}
		
		System.out.println("List: "+lista.size());
		
		
		
		/*buscaCombinacoesDisponiveis(buscaCombinacaoCedulas(270, cedulas), cedulas);*/
	}
	
	private static List<Integer[]> buscaCombinacaoCedulas(Integer valorSaque, List<Integer> cedulas) {
		List<Integer[]> quantidades = new ArrayList<Integer[]>();
		Collections.shuffle(cedulas);
		
		while (valorSaque > 0) {
			
			for (Integer valorCedula : cedulas) {
				
				int q = valorSaque / valorCedula;
				
				if (q > 0) {
					
					Integer[] qCedulas = new Integer[2];
					qCedulas[0] = q;
					qCedulas[1] = valorCedula;
					quantidades.add(qCedulas);
					
					//System.out.print(q + "x R$" + valorCedula + ",00");
				
					valorSaque = valorSaque % valorCedula;
					
					//if (valorSaque > 0)
					//	System.out.print(" + ");
				}
				
			}
			//System.out.println();
		}
		
		return quantidades;
		
	}
	
	private static void buscaCombinacoesDisponiveis(List<Integer[]> opcaoPrimaria) {
		
		List<List<Integer[]>> opcoes = new ArrayList<List<Integer[]>>();
		opcoes.add(opcaoPrimaria);
		
		for (int i = 0; i < opcaoPrimaria.size(); i++) {
			System.out.print(opcaoPrimaria.get(i)[0] + "x R$" + opcaoPrimaria.get(i)[1] + ",00");
			if (i != opcaoPrimaria.size()-1)
				System.out.print(" + ");
			else System.out.println();
		}
	}
	
	
	
}
