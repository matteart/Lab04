package it.polito.tdp.lab04;

import java.net.URL;
import java.util.*;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
    Model model;
    
    ObservableList<String> choiceMenuList=FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> choicheMenu;

    @FXML
    private Button btnCercaIscritti;

    @FXML
    private TextField txtMatricola;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtResult;

    
    @FXML
    private Button btnCerca;
    
    @FXML
    private Button btnReset;

    @FXML
    void handleCercaCorsi(ActionEvent event) {
        
       int matricola = Integer.parseInt(this.txtMatricola.getText());
    	
    	Studente tempS = model.getStudente(matricola);
    	
    	List <Corso> tempL= new ArrayList<Corso>(model.getCorsiStudente(tempS));
    	
    	String result = "";
    	for(Corso c:tempL)
    		if(c!=null)
    	result+= c.getNome()+"\n";
    	
    	this.txtResult.setText(result);
    }

    @FXML
    void handleCercaIscritti(ActionEvent event) {
        
    	List <Corso> tempL = new ArrayList<Corso>(model.getTuttiCorsi());
    	Corso tempC= null ;
    	
    	String nome = this.choicheMenu.getValue();
    	
    	for(Corso c:tempL)
    		if(c!= null && c.getNome().contentEquals(nome))
    			tempC=c;
    	
    	List <Studente> tempS = new ArrayList<Studente> (this.model.getStudentiIscritti(tempC.getCodins()));
    	
    	String result ="";
    	for(Studente s:tempS) 
    		if(s!=null) {
    			result+= s.getNome() + " " + s.getCognome() +" " + s.getMatricola() +"\n";
    		}
    	
    	this.txtResult.setText(result);
    	
    }

    @FXML
    void handleIscrivi(ActionEvent event) {

         int matricola = Integer.parseInt(this.txtMatricola.getText());
    	
    	Studente tempS = model.getStudente(matricola);
    	
    	List <Corso> tempL = new ArrayList<Corso>(model.getTuttiCorsi());
    	Corso tempC= null ;
    	
    	String nome = this.choicheMenu.getValue();
    	
    	for(Corso c:tempL)
    		if(c!= null && c.getNome().contentEquals(nome))
    			tempC=c;
    	
    	List <Studente> tempStudenti = new ArrayList<Studente> (this.model.getStudentiIscritti(tempC.getCodins()));
    	
    	String result="";
    	
      for(Studente s:tempStudenti)
    	  if(s!=null && s.getMatricola()==tempS.getMatricola())
    		  result="Studente iscritto";
      
      this.txtResult.setText(result);
    }

    @FXML
    void handleCerca(ActionEvent event) {

    	int matricola = Integer.parseInt(this.txtMatricola.getText());
    	
    	Studente tempS = model.getStudente(matricola);
    	
    	if(tempS!=null) {
    		this.txtCognome.setText(tempS.getCognome());
    		this.txtNome.setText(tempS.getNome());
    	}
    	else {
    		this.txtCognome.setText("NON TROVATO");
    		this.txtNome.setText("NON TROVATO");
    	}
    }
    
    @FXML
    void handleReset(ActionEvent event) {
    String result ="";
    this.txtResult.setText(result);
    }

    public void setModel(Model m) {
    	this.model=m;
    	m.run();
    	List <Corso> tempL = new ArrayList<Corso>(model.getTuttiCorsi());
        for(Corso c:tempL)
        	if(c!=null)
        		this.choiceMenuList.add(c.getNome());
        this.choicheMenu.setItems(this.choiceMenuList);
        this.choicheMenu.setValue("Seleziona");
    }
     
    @FXML
    void initialize() {
        assert choicheMenu != null : "fx:id=\"choicheMenu\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        
        
        
    }
}