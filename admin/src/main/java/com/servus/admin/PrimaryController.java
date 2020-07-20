package com.servus.admin;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;

import com.servus.db.Conn;
import com.servus.db.Login;
import com.servus.db.sql.LoginSQL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class PrimaryController implements Initializable {
	Alert alerta;
	private Connection connection;
	private LoginSQL bd_lg;
	private Login loginselect;
	private Set<Login> lusers;
	// COMPONENTES
	@FXML
	private TextField tMail;
	@FXML
	private TextField tCode;
	@FXML
	private CheckBox cActive;
	@FXML
	private TextField tUserId;
	
	@FXML
	private Button bSave;
	@FXML
	private Button bClear;
	@FXML
	private Button bUpdate;
	@FXML
	private Button bDelete;
	// TABLE
	@FXML
	private TableView<Login> tableLogin;
	// COLUMNS
	@FXML
	private TableColumn<Login, String> columnMail;
	@FXML
	private TableColumn<Login, String> columnCode;
	@FXML
	private TableColumn<Login, Boolean> columnActive;
	@FXML
	private TableColumn<Login, String> columnUserId;
	@FXML
	private Pane paneDescripcion;
	// COLECCIONS
	private ObservableList<Login> listLogin;

	public void initialize(URL url, ResourceBundle rb) {
		loadFormulary();
	}

	public void loadFormulary() {
		bd_lg = new LoginSQL();
		try {
			conectar();
			lusers = bd_lg.consultLogin();
			listLogin = FXCollections.observableArrayList(lusers);
			tableLogin.setItems(listLogin);
			tableLogin.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			columnMail.setCellValueFactory(new PropertyValueFactory<>("mail"));
			columnCode.setCellValueFactory(new PropertyValueFactory<>("code"));

			columnActive.setCellValueFactory(new PropertyValueFactory<>("active"));
			columnUserId.setCellValueFactory(new PropertyValueFactory<>("userId"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void conectar() throws SQLException {
		Conn conn = new Conn();
		connection = conn.getConnection();
	}

	@FXML
	private void SAVELOGIN(ActionEvent event) {
		bd_lg = new LoginSQL();

		Login lg = new Login();
		lg.setMail(tMail.getText());
		lg.setCode(tCode.getText());
		lg.setUserId(tUserId.getText());

		if (cActive.isSelected()) {
			lg.setActive(true);
			;

		} else {
			lg.setActive(false);
			;

		}

		try {
			bd_lg.insert(lg);

		} catch (SQLException e) {
			alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setTitle("Error - SAVE.");
			alerta.setHeaderText("Could not save Login.");
			alerta.setContentText(e.getMessage());
			alerta.showAndWait();
			e.printStackTrace();
		}
		clear();
		loadFormulary();
		
		
	}

	@FXML
	private void SELECTLOGIN(MouseEvent event) {
		try {
			loginselect = tableLogin.getSelectionModel().getSelectedItem();
			if (loginselect != null) {
			tMail.setText(loginselect.getMail());
			tCode.setText(loginselect.getCode());
			cActive.setSelected(loginselect.isActive());
			tUserId.setText(loginselect.getUserId());
			}
		} catch (NullPointerException e) {
			
			e.printStackTrace();
		}

	}

	@FXML
	private void DELETELOGIN(ActionEvent event) {
		  bd_lg = new LoginSQL();

		
		if (loginselect != null) {

			alerta = new Alert(Alert.AlertType.CONFIRMATION);
			alerta.setTitle("CONFIRM");
			alerta.setHeaderText("CONFIRM THE CHANGES");
			alerta.setContentText(" Want to delete Login: " + loginselect.getMail() + "?");

			Optional<ButtonType> respuestaUsuario = alerta.showAndWait();

			if (respuestaUsuario.get() == ButtonType.OK) {

				try {
					bd_lg.deleteLogin(loginselect);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				clear();

				loadFormulary();

			}
		}
	}
	

	@FXML
	private void UPDATELOGIN(ActionEvent event) {
		  bd_lg = new LoginSQL();

		
		if (loginselect != null) {

			alerta = new Alert(Alert.AlertType.CONFIRMATION);
			alerta.setTitle("CONFIRM");
			alerta.setHeaderText("CONFIRM THE CHANGES");
			alerta.setContentText("Want to update Login: " + loginselect.getMail() + "?");

			Optional<ButtonType> respuestaUsuario = alerta.showAndWait();

			if (respuestaUsuario.get() == ButtonType.OK) {

				try {
					bd_lg.modifyLogin(loginselect);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				loadFormulary();

			}
		}
	}
	@FXML
	private void CLEARLOGIN(ActionEvent event) {
		clear();
		
	}
	private void clear() {
		
		tMail.clear();
		tCode.clear();
		cActive.setSelected(false);
		tUserId.clear();
		
		
		
		
	}
	
}
