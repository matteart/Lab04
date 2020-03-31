package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {
	
	
	public List<Corso> getTuttiICorsi() {
        
		Corso tempC; 
		
		final String sql = "SELECT * FROM corso";
   
		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				

				tempC= new Corso(codins, numeroCrediti, nome, periodoDidattico);
				corsi.add(tempC);
			}

			conn.close();
			
			return corsi;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	
	
	public Corso getCorso(String codins) {
		Corso tempC=null;
		
		String sql = "SELECT * FROM corso WHERE codins = ?";
		try {
			
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st= conn.prepareStatement(sql);
		
		st.setString(1, codins);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			String codin = rs.getString("codins");
			int numeroCrediti = rs.getInt("crediti");
			String nome = rs.getString("nome");
			int periodoDidattico = rs.getInt("pd");

			

			tempC= new Corso(codin, numeroCrediti, nome, periodoDidattico);
		}
		conn.close();
		return tempC;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	
	public List <String> getCorsiStudente(Studente s) {
		
		List <String > tempL = new ArrayList<String>();
		
		
		final String sql = "SELECT * FROM iscrizione WHERE matricola = ?";
		try {
			
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setInt(1, s.getMatricola());
		
		ResultSet res = st.executeQuery();
		
		while(res.next()) {
			String tempS = res.getString("codins");
			tempL.add(tempS);
		}
		conn.close();
		return tempL;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	
	
	
	public boolean iscriviStudenteACorso(Studente studente, Corso corso) {
		
		
		return false;
	}

}
