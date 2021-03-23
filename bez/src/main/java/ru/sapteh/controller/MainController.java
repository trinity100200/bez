package ru.sapteh.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.DAO.DAO;
import ru.sapteh.model.User;
import ru.sapteh.service.UserDaoImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    final SessionFactory factory;

  List<User> userList = new ArrayList<>();

    @FXML
    private TextField txtLogul;

    @FXML
    private PasswordField txtPass;

    @FXML
    private Label status;


    @FXML
    private Button bitton;

    public MainController() {
        factory = new Configuration().configure().buildSessionFactory();
    }


    @FXML
    public void initialize(){
        inUser();

    }


//    Проверка полей на оригинальность
    @FXML
    public void signIn() throws IOException {
        for (User user : userList){
            if (user.getLogun().equals(txtLogul.getText()) && user.getPassword().equals(txtPass.getText())){
                bitton.getScene().getWindow().hide();
                Parent parent = FXMLLoader.load(getClass().getResource("/view/ola.fxml"));
                Stage stage = new Stage();
                stage.setTitle("fa");
                stage.setScene(new Scene(parent));
                stage.show();
            }else status.setText("Неверный логин или пароль");
        }
    }



    public void inUser(){
        DAO<User, Integer> daoUser = new UserDaoImpl(factory);
        userList.addAll(daoUser.readAll());
    }


}
