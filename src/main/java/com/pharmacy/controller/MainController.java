package com.pharmacy.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.pharmacy.config.StageManager;
import com.pharmacy.view.FxmlView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

@Controller
public class MainController implements Initializable{
		    
	    @Lazy
	    @Autowired
	    private StageManager stageManager;
	    
	    @FXML
	    private BorderPane mainPane;
	        
	@FXML
	void seConnecter (ActionEvent e) {
		Parent view = stageManager.getPage(FxmlView.LOGIN);
		mainPane.setCenter(view);
	}
	
	@FXML
	protected void ajouterFamilleProduit( ActionEvent event) throws IOException {
    	stageManager.displayForm(FxmlView.AJOUT_FAMILLE_PRODUIT); 
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
