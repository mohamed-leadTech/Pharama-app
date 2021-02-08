package com.pharmacy.view;

import java.util.ResourceBundle;

public enum FxmlView {

	USER {
		@Override
		public String getTitle() {
			return getStringFromResourceBundle("user.title");
		}

		@Override
		public String getFxmlFile() {
			return "/fxml/User.fxml";
		}
	},
	LOGIN {
		@Override
		public String getTitle() {
			return getStringFromResourceBundle("login.title");
		}

		@Override
		public String getFxmlFile() {
			return "/fxml/Login.fxml";
		}
	},
	MAIN_PANE {
		@Override
		public String getTitle() {
			return getStringFromResourceBundle("main_pane.title");
		}

		@Override
		public String getFxmlFile() {
			return "/fxml/MainPane.fxml";
		}
	},

	AJOUT_FAMILLE_PRODUIT {
		@Override
		public String getTitle() {
			return getStringFromResourceBundle("produits_ajout_famille_produit.title");
		}

		@Override
		public String getFxmlFile() {
			// get fxml file name
			return "/fxml/produits/Produits_ajout_famille_produit.fxml";
		}
	};

	public abstract String getTitle();

	public abstract String getFxmlFile();

	String getStringFromResourceBundle(String key) {
		return ResourceBundle.getBundle("Bundle").getString(key);
	}

}
