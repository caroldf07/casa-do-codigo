package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>();
	private static Integer sequencial = 1;

	public void add(Empresa empresa) {
		empresa.setId(sequencial++);
		empresas.add(empresa);
		System.out.println(empresas);

	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void removeEmpresa(Integer id) {
		for (Empresa empresa : empresas) {
			if(empresa.getId() == id) {
				empresas.remove(empresa);
			}
		}
		
	}

	public Empresa mostraEmpresa(Integer id) {
		for(Empresa empresa : empresas) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
		
	}

}