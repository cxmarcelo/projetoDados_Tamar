package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import estruturas.ListaLigada;
import model.Tartaruga;

public class TartarugaTxt {


	public static long TempoParaLer;
	
	
	public boolean inserirFinal(Tartaruga tar) throws IOException {
		criarDiretorio();
		if(checarExistente(tar)){
			JOptionPane.showMessageDialog(null, "Tartaruga já existente no .txt");
			return false;
		}else {
			String dado = ""+ tar.getId() + ',' + tar.getEspecie() + "," + tar.getNome_popular() + "," + tar.getTipo_de_localizador()+ "," + tar.getRisco_de_extincao();
			try {
				PrintWriter arquivo = new PrintWriter(new FileWriter("c:/aps/4semestre/arquivo.txt", true));
				arquivo.println(dado);
				arquivo.flush();
				arquivo.close();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	public boolean inserirInicio(Tartaruga tar) throws IOException {
		if(checarExistente(tar)) {
			JOptionPane.showMessageDialog(null, "Tartaruga já existente no .txt");
			return false;
		}else {
			ListaLigada lista = new ListaLigada();
			lista.adiciona(tar);
			lista.addAll(read());
			rescrever(lista);
			return true;
		}
	}

	//READS(Leituras de arquivos / "selects do txt")

	public ListaLigada read() {
		long tempoInicial = System.currentTimeMillis();
		ListaLigada lista = new ListaLigada();
		BufferedReader arquivo;
		try {
			arquivo = new BufferedReader(new FileReader("c:/aps/4semestre/arquivo.txt"));

			while(arquivo.ready()) {
				try {
					String[] dados = arquivo.readLine().split(",");
					int id = Integer.parseInt(dados[0]);
					String especie = dados[1];
					String nome = dados[2];
					String tipo_loca = dados[3];
					String risco = dados[4];
					lista.adiciona((new Tartaruga(id, especie, nome, tipo_loca, risco)));
				}catch (Exception e) {
					continue;
				}
			}
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na leitura do arquivo - read()");
		}
		long tempoFinal = System.currentTimeMillis();
		tempoFinal = tempoFinal - tempoInicial;
		System.out.println("Lendo todos os registros: " + tempoFinal + "ms");
		ListaLigada retorno;
		retorno = bubbleSort(lista);
		return retorno;
	}


	public ListaLigada readId(int id){
		ListaLigada list = read();
		ListaLigada retorno = new ListaLigada();
		for (int x = 0; x < list.size(); x++) {
			if(((Tartaruga)list.pega(x)).getId() == id){
				retorno.adiciona(((Tartaruga)list.pega(x)));
			}
		}
		return retorno;
	}


	public ListaLigada readEspecie(String especie) {
		ListaLigada list = read();
		ListaLigada retorno = new ListaLigada();
		for (int x = 0; x < list.size(); x++) {
			if(((Tartaruga)list.pega(x)).getEspecie().toLowerCase().contains(especie.toLowerCase())){
				retorno.adiciona(((Tartaruga)list.pega(x)));
			}
		}
		return retorno;
	}


	public ListaLigada readNome(String nome) {
		ListaLigada list = read();
		ListaLigada retorno = new ListaLigada();
		for (int x = 0; x < list.size(); x++) {
			if(((Tartaruga)list.pega(x)).getNome_popular().toLowerCase().contains(nome.toLowerCase())){
				retorno.adiciona(((Tartaruga)list.pega(x)));
			}
		}
		return retorno;
	}


	public ListaLigada readExtincao(String extincao) {
		ListaLigada list = read();
		ListaLigada retorno = new ListaLigada();
		for (int x = 0; x < list.size(); x++) {
			if(((Tartaruga)list.pega(x)).getRisco_de_extincao().toLowerCase().contains(extincao.toLowerCase())){
				retorno.adiciona(((Tartaruga)list.pega(x)));
			}
		}
		return retorno;
	}

	
	public ListaLigada readLocalizador(String localizador) {
		ListaLigada list = read();
		ListaLigada retorno = new ListaLigada();
		for (int x = 0; x < list.size(); x++) {
			if(((Tartaruga)list.pega(x)).getTipo_de_localizador().toLowerCase().contains(localizador.toLowerCase())){
				retorno.adiciona(((Tartaruga)list.pega(x)));
			}
		}
		return retorno;
	}


	//Fim selects

	public void update(int id, Tartaruga tar) throws IOException {
		ListaLigada lista = read();

		for (int x = 0; x < lista.size(); x++) {
			if(((Tartaruga)lista.pega(x)).getId() == id) {
				//((Tartaruga)lista.pega(x)).setId(tar.getId());
				((Tartaruga)lista.pega(x)).setEspecie(tar.getEspecie());
				((Tartaruga)lista.pega(x)).setNome_popular(tar.getNome_popular());
				((Tartaruga)lista.pega(x)).setTipo_de_localizador(tar.getTipo_de_localizador());
				((Tartaruga)lista.pega(x)).setRisco_de_extincao(tar.getRisco_de_extincao());
				System.out.println("Tartaruga Atualizada!");
				break;
			}
		}
		rescrever(lista);
	}



	public boolean deletar(int id) {
		ListaLigada lista = read();
		boolean ret = false;
		for(int x = 0; x < lista.size(); x++) {
			if(((Tartaruga)lista.pega(x)).getId() == id) {
				lista.remove(x);
				ret = true;
			}			
		}
		rescrever(lista);
		return ret;
	}

	
	public void criarDiretorio() throws IOException {
		File dir = new File("c:/aps");
		if(!dir.exists()) {
			dir.mkdir();
		}
		dir = new File("c:/aps/4semestre");
		if(!dir.exists()) {
			dir.mkdir();
		}

		dir = new File("c:/aps/4semestre/arquivo.txt");
		if(!dir.exists()) {
			dir.createNewFile();
		}
	}
	
	public ListaLigada bubbleSort(ListaLigada lista) {
		Tartaruga[] vet = new Tartaruga[lista.size()];
		for (int i = 0; i < vet.length; i++) {
			vet[i] = (Tartaruga) lista.pega(i);
		}

		for (int i = 0; i < vet.length; i++) {
			for (int j = 0; j < vet.length; j++) {
				if (vet[i].getId() < vet[j].getId()) {
					Tartaruga aux = vet[i];
					vet[i] = vet[j];
					vet[j] = aux;
				}
			}
		}

		ListaLigada lista2 = new ListaLigada();
		for (int i = 0; i < vet.length; i++) {
			lista2.adiciona(vet[i]);
		}
		return lista2;
	}

	private void rescrever(ListaLigada lista) {
		try {
			PrintWriter arquivo = new PrintWriter(new FileWriter("c:/aps/4semestre/arquivo.txt", false));
			for (int x = 0; x < lista.size(); x++) {
				Tartaruga tar = (Tartaruga) lista.pega(x);
				String dado = ""+ tar.getId() + ',' + tar.getEspecie() + "," + tar.getNome_popular() + "," + tar.getTipo_de_localizador()+ "," + tar.getRisco_de_extincao();
				arquivo.println(dado);
			}
			arquivo.flush();
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean checarExistente(Tartaruga tar) throws IOException {
		ListaLigada lista = read();
		boolean tem = false;
		for(int x = 0; x < lista.size(); x++) {
			if(((Tartaruga)lista.pega(x)).getId() == tar.getId()) {
				tem= true;
			}
		}
		return tem;
	}

	public void removerFinal() throws IOException {
		ListaLigada lista = read();
		lista.removeDoFim();
		rescrever(lista);
	}

	public void removerInicio() {
		ListaLigada lista = read();
		lista.removeDoComeco();
		rescrever(lista);
	}

	public int qtdRegistros() {
		return read().size();
	}


	public static void main(String[] args) throws IOException {
		//Tartaruga t = new Tartaruga(2 , "Erickson Elfelics", "teste", "satelite", "alto");
		TartarugaTxt a = new TartarugaTxt();
		//a.inserirFinal(t);
		System.out.println(a.qtdRegistros());


		//System.out.println(a.readEspecie("far").get(0).getEspecie());
		System.out.println(((Tartaruga)a.read().pega(1)).getEspecie());
		//Tartaruga t2 = new Tartaruga(4 , "Juliao juh", "teste2", "GPS", "Baixo");
		//a.update(1, t2);

		//System.out.println(a.read().get(0).getEspecie() + "   Aqui tbm funfo");
	}

}
