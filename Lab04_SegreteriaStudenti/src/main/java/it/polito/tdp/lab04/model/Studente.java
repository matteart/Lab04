package it.polito.tdp.lab04.model;

public class Studente {
	private int matricola;
	private String cognome;
	private String nome;
	private String corso;
	public Studente(int matricola, String cognome, String nome, String corso) {
		
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		this.corso=corso;
	}
	public int getMatricola() {
		return matricola;
	}
	
	public String getCorso() {
		return corso;
	}
	public void setCorso(String corso) {
		this.corso = corso;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
