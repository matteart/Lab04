package it.polito.tdp.lab04.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;


public class StudenteDAO {

	public List<Studente> getTuttiStudenti(){
		
		final String sql= "SELECT * FROM studente";
		
		Studente tempS;
		List<Studente> tempL = new ArrayList<Studente>();
		try {
		Connection conn = ConnectDB.getConnection();
		
			PreparedStatement st= conn.prepareStatement(sql);
			
			
			ResultSet res = st.executeQuery();
			
			while(res.next()) {
				tempS= new Studente( res.getInt("matricola"),
						res.getString("cognome"),
						res.getString("nome"),
				        res.getString("CDS")						);
				tempL.add(tempS);
			}
			conn.close();
			return tempL;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	public Studente getStudente(int matricola) {
		final String sql = "SELECT * FROM studente WHERE matricola=?";
		Studente tempS=null;
		try {
		Connection conn = ConnectDB.getConnection();
		
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setInt(1, matricola);
			ResultSet res = st.executeQuery();
			
			while(res.next()) {
				tempS= new Studente( res.getInt("matricola"),
						res.getString("cognome"),
						res.getString("nome"),
				        res.getString("CDS")						);
			}
			
			conn.close();
			return tempS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List <Integer> getStudenteIscrittoCorso(String codins) {
	    
	    List <Integer> tempI = new ArrayList<Integer>();
	    
	    final String sql =" SELECT * FROM iscrizione WHERE codins =?";
	    try {
			
	    Connection conn = ConnectDB.getConnection();
	   PreparedStatement st= conn.prepareStatement(sql);
	   
	   st.setString(1,  codins);
	   
	   ResultSet res = st.executeQuery();
	   while(res.next()) {
		   int tempInt = res.getInt("matricola");
		   tempI.add(tempInt);
		   
	   }
	   conn.close();
	   return tempI;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return null;
	    
	}
}
