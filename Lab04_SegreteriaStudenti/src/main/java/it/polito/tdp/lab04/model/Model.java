package it.polito.tdp.lab04.model;

import java.util.*;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	CorsoDAO corsoDAO;
	StudenteDAO studenteDAO;
	
	public void run() {
		corsoDAO= new CorsoDAO();
		studenteDAO= new StudenteDAO();
	}
	
	public List<Corso> getTuttiCorsi(){
		List <Corso> tempL= new ArrayList<Corso>();
		tempL = corsoDAO.getTuttiICorsi();
		
		return tempL;
	}
	public List<Studente> getTuttiStudenti(){
		List<Studente> tempL = new ArrayList<Studente>(studenteDAO.getTuttiStudenti());
	    return tempL;
	}
	public Studente getStudente(int matricola) {
		Studente tempS = this.studenteDAO.getStudente(matricola);
		return tempS;
	}
	public List< Studente> getStudentiIscritti (String codins){
		List <Integer> tempListInteger = new ArrayList<Integer> (this.studenteDAO.getStudenteIscrittoCorso(codins));
		List <Studente> tempL = new ArrayList<Studente>();
		
		for(int i:tempListInteger)
			if(i!=0)
			{
				Studente tempS = this.getStudente(i);
				tempL.add(tempS);
			}
		
		return tempL;
	}
	public Corso getCorso(String codins) {
		Corso tempC= this.corsoDAO.getCorso(codins);
		return tempC;
	}
	public List <Corso> getCorsiStudente(Studente s){
		List<Corso> tempListCorso= new ArrayList<Corso>();
		List<String> tempL= new ArrayList<String>(this.corsoDAO.getCorsiStudente(s));
		
		for(String st:tempL)
			if(st!=null) {
				Corso tempC = this.getCorso(st);
				tempListCorso.add(tempC);
			}
			return tempListCorso;	
	}
}
