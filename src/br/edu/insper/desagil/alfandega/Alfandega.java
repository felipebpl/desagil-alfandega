package br.edu.insper.desagil.alfandega;

import java.util.ArrayList;
import java.util.List;

public class Alfandega {
	private List<Item> itens;
	private List<ItemTarifado> itensTarifados;

	public Alfandega() {
		this.itens = new ArrayList<>();
		this.itensTarifados = new ArrayList<>();
	}

	public void declara(Item item) {
		this.itens.add(item);
	}

	public void declara(ItemTarifado itemTarifado) {
		this.itensTarifados.add(itemTarifado);
	}

	public double getTotal(String caso) {
		double total = 0.0;
		if (caso == "Devido") {
			for (Item item : this.itens) {
				total += item.getRate() * item.getValor() * 0.01;
			}
			for (ItemTarifado itemTarifado : this.itensTarifados) {
				total += itemTarifado.getRate() * itemTarifado.getValor() * itemTarifado.getTarifa();
			}
			return total;
		}
		for (Item item : this.itens) {
			total += item.getRate() * item.getValor();
		}
		for (ItemTarifado itemTarifado : this.itensTarifados) {
			total += itemTarifado.getRate() * itemTarifado.getValor();
		}
		return total;
	}
	
	public double getTotalDeclarado() {
		double total = getTotal("Declarado");
		return total;
	}
	
	public double getTotalDevido() {
		double total = getTotal("Devido");
		return total;
	}
}
