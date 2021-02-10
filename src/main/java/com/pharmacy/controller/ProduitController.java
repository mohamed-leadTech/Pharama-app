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
import com.pharmacy.utils.PharmacyUtils;
import com.pharmacy.view.FxmlView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	private TableColumn<FamilleProduit, Long> colCodeFam;

	@FXML
	private TableColumn<FamilleProduit, String> colNomFam;

	@FXML
	private TableColumn<FamilleProduit, String> colLibelle;

	@FXML
	private TableColumn<FamilleProduit, Boolean> colEdit;

	@FXML
	private TextField libelle;

	@FXML
	private TextField nomFam;

	@FXML
	private Label code;

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
		colCodeFam.setCellValueFactory(new PropertyValueFactory<>("code"));
		colLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
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
					libelle.setText(familleProduit.getLibelle());
					nomFam.setText(familleProduit.getNomFam());
					code.setText(familleProduit.getCode().toString());
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
	@FXML
	void reset(ActionEvent event) {
		clearFields();
	}


	@FXML
	private void saveFamilleProduit(ActionEvent event) {

		if (PharmacyUtils.emptyValidation("Libelle", libelle.getText().isEmpty())
				&& PharmacyUtils.emptyValidation("Nom famille", nomFam.getText().isEmpty())) {

			if (code.getText() == null || code.getText() == "") {

				FamilleProduit famProduit = new FamilleProduit();
				famProduit.setLibelle(libelle.getText());
				famProduit.setNomFam(nomFam.getText());
				FamilleProduit newFamProduit = familleProduitService.save(famProduit);

				saveAlert(newFamProduit);

			} else {
				FamilleProduit famProduit = familleProduitService.find(Long.parseLong(code.getText()));
				famProduit.setLibelle(libelle.getText());;
				famProduit.setNomFam(nomFam.getText());;
				
				FamilleProduit updatedFamilleProduit = familleProduitService.update(famProduit);
				updateAlert(updatedFamilleProduit);
			}

			clearFields();
			loadFamilleProduitsDetails();
		}

	}

	private void clearFields() {
		code.setText(null);
		nomFam.clear();
		libelle.clear();
	}

	private void saveAlert(FamilleProduit newFamProduit) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Family product saved successfully.");
		alert.setHeaderText(null);
		alert.setContentText("The product family " + newFamProduit.getLibelle() + " " + newFamProduit.getNomFam()
				+ " has been created and \n" + " code is " + newFamProduit.getCode() + ".");
		alert.showAndWait();
	}

	private void updateAlert(FamilleProduit famProduit) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Product family updated successfully.");
		alert.setHeaderText(null);
		alert.setContentText(
				"The product family " + famProduit.getLibelle() + " " + famProduit.getNomFam() + " has been updated.");
		alert.showAndWait();

	}
}
