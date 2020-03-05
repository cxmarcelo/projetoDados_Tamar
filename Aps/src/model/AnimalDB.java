package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import estruturas.ListaLigada;

public class AnimalDB {

	public void create() {
		Connection con = ConectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("INSERT INTO Tartarugas(id, especie, Nome_popular, Tipo_de_localizador, Risco_de_extincao) VALUES (?, ?, ?, ?, ?)");
			stmt.setInt(1, 1);
			stmt.setString(2, "");
			stmt.setString(3, "");
			stmt.setString(4, "");
			stmt.setInt(5, 2019);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erro");
		}finally {
			ConectionFactory.closeConnection(con, stmt);
		}
	}

	public boolean create(int id, String especie, String Nome_popular, String Tipo_de_localizador, String Risco_de_extincao) {
		Connection con = ConectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("INSERT INTO Tartarugas(id, especie, Nome_popular, Tipo_de_localizador, Risco_de_extincao) VALUES (?, ?, ?, ?, ?)");
			stmt.setInt(1, id);
			stmt.setString(2, especie);
			stmt.setString(3, Nome_popular);
			stmt.setString(4, Tipo_de_localizador);
			stmt.setString(5, Risco_de_extincao);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Id de tartaruga já existente no BD");
			return false;
		}finally {
			ConectionFactory.closeConnection(con, stmt);
		}
	}


	public ListaLigada read() {
		Connection con = ConectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ListaLigada listatartarugas = new ListaLigada();

		try {
			stmt = con.prepareStatement("Select * from Tartarugas");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Tartaruga tartaruga = new Tartaruga();
				tartaruga.setId(rs.getInt("id"));
				tartaruga.setEspecie(rs.getString("especie"));
				tartaruga.setNome_popular(rs.getString("nome_popular"));
				tartaruga.setTipo_de_localizador(rs.getString("Tipo_de_localizador"));
				tartaruga.setRisco_de_extincao(rs.getString("Risco_de_extincao"));
				listatartarugas.adiciona(tartaruga);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erro");
		}finally {
			ConectionFactory.closeConnection(con, stmt, rs);
		}
		return listatartarugas;
	}

	
	public ListaLigada read(String busca) {
		Connection con = ConectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ListaLigada listatartarugas = new ListaLigada();

		try {
			stmt = con.prepareStatement("Select * from tartarugas where " + busca);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Tartaruga tartaruga = new Tartaruga();
				tartaruga.setId(rs.getInt("id"));
				tartaruga.setEspecie(rs.getString("especie"));
				tartaruga.setNome_popular(rs.getString("nome"));
				tartaruga.setTipo_de_localizador(rs.getString("Tipo_de_localizador"));
				tartaruga.setRisco_de_extincao(rs.getString("Risco_de_extincao"));
				listatartarugas.adiciona(tartaruga);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erro");
		}finally {
			ConectionFactory.closeConnection(con, stmt, rs);
		}
		return listatartarugas;
	}

	public ListaLigada readId(int id){
		Connection con = ConectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ListaLigada listatartarugas = new ListaLigada();

		try {
			stmt = con.prepareStatement("Select * from tartarugas where id = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Tartaruga tartaruga = new Tartaruga();
				tartaruga.setId(rs.getInt("id"));
				tartaruga.setEspecie(rs.getString("especie"));
				tartaruga.setNome_popular(rs.getString("nome_popular"));
				tartaruga.setTipo_de_localizador(rs.getString("Tipo_de_localizador"));
				tartaruga.setRisco_de_extincao(rs.getString("Risco_de_extincao"));
				listatartarugas.adiciona(tartaruga);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erro");
		}finally {
			ConectionFactory.closeConnection(con, stmt, rs);
		}
		return listatartarugas;
	}

	
	public ListaLigada readNome(String nome){
		Connection con = ConectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ListaLigada listatartarugas = new ListaLigada();

		try {
			stmt = con.prepareStatement("Select * from tartarugas where nome_popular like ?");
			String n = "%" + nome + "%";
			stmt.setString(1, n);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Tartaruga tartaruga = new Tartaruga();
				tartaruga.setId(rs.getInt("id"));
				tartaruga.setEspecie(rs.getString("especie"));
				tartaruga.setNome_popular(rs.getString("nome_popular"));
				tartaruga.setTipo_de_localizador(rs.getString("Tipo_de_localizador"));
				tartaruga.setRisco_de_extincao(rs.getString("Risco_de_extincao"));
				listatartarugas.adiciona(tartaruga);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erro");
		}finally {
			ConectionFactory.closeConnection(con, stmt, rs);
		}
		return listatartarugas;
	}


	public ListaLigada readEspecie(String especie){
		Connection con = ConectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ListaLigada listatartarugas = new ListaLigada();

		try {
			stmt = con.prepareStatement("Select * from tartarugas where especie like ?");
			String esp = "%" + especie + "%";
			stmt.setString(1, esp);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Tartaruga tartaruga = new Tartaruga();
				tartaruga.setId(rs.getInt("id"));
				tartaruga.setEspecie(rs.getString("especie"));
				tartaruga.setNome_popular(rs.getString("nome_popular"));
				tartaruga.setTipo_de_localizador(rs.getString("Tipo_de_localizador"));
				tartaruga.setRisco_de_extincao(rs.getString("Risco_de_extincao"));
				listatartarugas.adiciona(tartaruga);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erro");
		}finally {
			ConectionFactory.closeConnection(con, stmt, rs);
		}
		return listatartarugas;
	}


	public ListaLigada readLocalizador(String localizador){
		Connection con = ConectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ListaLigada listatartarugas = new ListaLigada();

		try {
			stmt = con.prepareStatement("Select * from tartarugas where tipo_de_localizador like ?");
			String loc = "%" + localizador + "%";
			stmt.setString(1, loc);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Tartaruga tartaruga = new Tartaruga();
				tartaruga.setId(rs.getInt("id"));
				tartaruga.setEspecie(rs.getString("especie"));
				tartaruga.setNome_popular(rs.getString("nome_popular"));
				tartaruga.setTipo_de_localizador(rs.getString("Tipo_de_localizador"));
				tartaruga.setRisco_de_extincao(rs.getString("Risco_de_extincao"));
				listatartarugas.adiciona(tartaruga);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erro");
		}finally {
			ConectionFactory.closeConnection(con, stmt, rs);
		}
		return listatartarugas;

	}


	public ListaLigada readExtincao(String extincao){
		Connection con = ConectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ListaLigada listatartarugas = new ListaLigada();

		try {
			stmt = con.prepareStatement("Select * from tartarugas where risco_de_extincao like ? ");
			String ext = "%" + extincao + "%";
			stmt.setString(1, ext);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Tartaruga tartaruga = new Tartaruga();
				tartaruga.setId(rs.getInt("id"));
				tartaruga.setEspecie(rs.getString("especie"));
				tartaruga.setNome_popular(rs.getString("nome_popular"));
				tartaruga.setTipo_de_localizador(rs.getString("Tipo_de_localizador"));
				tartaruga.setRisco_de_extincao(rs.getString("Risco_de_extincao"));
				listatartarugas.adiciona(tartaruga);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erro aqui from animaldb metodo readExtincao");
		}finally {
			ConectionFactory.closeConnection(con, stmt, rs);
		}
		return listatartarugas;
	}


	public void Update(int id, String especie, String Nome_popular, String Tipo_de_localizador, String Risco_de_extincao) {
		Connection con = ConectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("update Tartarugas set Especie = ?, Nome_popular = ?, Tipo_de_localizador = ?, Risco_de_extincao = ? where id = ?");
			stmt.setString(1, especie);
			stmt.setString(2, Nome_popular);
			stmt.setString(3, Tipo_de_localizador);
			stmt.setString(4, Risco_de_extincao);
			stmt.setInt(5, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erro: " + e);
		}finally {
			ConectionFactory.closeConnection(con, stmt);
		}
	}

	
	public boolean delete(int id) {
		Connection con = ConectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("delete from tartarugas where id = ?");
			stmt.setInt(1, id);
			if(stmt.executeUpdate() ==1) {
				return true;
			}else {
				return false;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			ConectionFactory.closeConnection(con, stmt);
		}
	}
}
