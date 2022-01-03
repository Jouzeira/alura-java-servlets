package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<Empresa>();
	private static List<Usuario> listaUsuario = new ArrayList<Usuario>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Joseph");
		empresa.setId(chaveSequencial++);
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Gael");
		empresa2.setId(chaveSequencial++);
		lista.add(empresa);
		lista.add(empresa2);
		
		Usuario usuario1 = new Usuario();
		usuario1.setLogin("Jou");
		usuario1.setSenha("123");
		Usuario usuario2 = new Usuario();
		usuario2.setLogin("Nay");
		usuario2.setSenha("123");
		listaUsuario.add(usuario1);
		listaUsuario.add(usuario2);
		
		
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		Banco.lista.add(empresa);
		
		for (Empresa emp : lista) {
			System.out.println(emp.getNome());
		}
	}
	
	public List<Empresa> getEmpresas (){
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		
		Iterator<Empresa> it = lista.iterator();
		while (it.hasNext()) {
			Empresa emp = (Empresa) it.next();
			if (emp.getId() == id) {
				it.remove();
			}
		}
		
//		for (Empresa empresa : lista) {
//			if (empresa.getId() == id) {
//				lista.remove(empresa);
//			}
//		}
	}

	public Empresa buscaEmpresaPeloId(Integer id) {
		
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		
		for (Usuario usuario : listaUsuario) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		
		return null;
	}

}
