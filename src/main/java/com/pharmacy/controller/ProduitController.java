package com.pharmacy.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.pharmacy.bean.FamilleProduit;
import com.pharmacy.config.StageManager;
import com.pharmacy.service.FamilleProduitService;
import com.pharmacy.view.FxmlView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

@Controller
public class ProduitController implements Initializable {

	@Lazy
	@Autowired
	private StageManager stageManager;

	@FXML
	private TableView<FamilleProduit> familleProduitTable;

	@FXML
	private TableColumn<FamilleProduit, String> colCodeFam;

	@FXML
	private TableColumn<FamilleProduit, String> colNomFam;

	@FXML
	private TableColumn<FamilleProduit, Boolean> colEdit;

	@FXML
	private TextField codeFam;

	@FXML
	private TextField nomFam;

	@Autowired
	private FamilleProduitService familleProduitService;
	private ObservableList<FamilleProduit> famProduitsList = FXCollections.observableArrayList();

	@FXML
	protected void ajouterFamilleProduit(ActionEvent event) throws IOException {
		stageManager.switchScene(FxmlView.AJOUT_FAMILLE_PRODUIT);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		familleProduitTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		setColumnProperties();

		// add famille produits dans la table
		loadFamilleProduitsDetails();
	}

	void setColumnProperties() {
		colCodeFam.setCellValueFactory(new PropertyValueFactory<>("codeFam"));
		colNomFam.setCellValueFactory(new PropertyValueFactory<>("nomFam"));
		colEdit.setCellFactory(cellFactory);
	}

	Callback<TableColumn<FamilleProduit, Boolean>, TableCell<FamilleProduit, Boolean>> cellFactory = new Callback<TableColumn<FamilleProduit, Boolean>, TableCell<FamilleProduit, Boolean>>() {
		@Override
		public TableCell<FamilleProduit, Boolean> call(final TableColumn<FamilleProduit, Boolean> param) {
			final TableCell<FamilleProduit, Boolean> cell = new TableCell<FamilleProduit, Boolean>() {
				Image imgEdit = new Image(getClass().getResourceAsStream("/images/edit.png"));
				final Button btnEdit = new Button();

				@Override
				public void updateItem(Boolean check, boolean empty) {
					super.updateItem(check, empty);
					if (empty) {
						setGraphic(null);
						setText(null);
					} else {
						btnEdit.setOnAction(e -> {
							FamilleProduit familleProduit = getTableView().getItems().get(getIndex());
							updateFamilleProduit(familleProduit);
						});

						btnEdit.setStyle("-fx-background-color: transparent;");
						ImageView iv = new ImageView();
						iv.setImage(imgEdit);
						iv.setPreserveRatio(true);
						iv.setSmooth(true);
						iv.setCache(true);
						btnEdit.setGraphic(iv);

						setGraphic(btnEdit);
						setAlignment(Pos.CENTER);
						setText(null);
					}
				}

				private void updateFamilleProduit(FamilleProduit familleProduit) {
					codeFam.setText(familleProduit.getCodeFam());
					nomFam.setText(familleProduit.getNomFam());
				}
			};
			return cell;
		}
	};

	/*
	 * Add All users to observable list and update table
	 */
	private void loadFamilleProduitsDetails() {
		famProduitsList.clear();
		List<FamilleProduit> list = familleProduitService.findAll();
		famProduitsList.addAll(list);

		familleProduitTable.setItems(famProduitsList);
	}

}
