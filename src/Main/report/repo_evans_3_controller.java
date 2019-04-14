package report;
import Information.DBconnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class repo_evans_3_controller implements Initializable {

    @FXML
    private TableView<repo_evans_3> table;
    @FXML
    private TableColumn<repo_evans_3, String> col_stu_id;
    @FXML
    private TableColumn<repo_evans_3, String> col_stu_fname;
    @FXML
    private TableColumn<repo_evans_3, String> col_stu_lname;
    @FXML
    private TableColumn<repo_evans_3, String> col_stu_email;
    @FXML
    private TableColumn<repo_evans_3, String> col_stu_address;
    @FXML
    private TableColumn<repo_evans_3, String> col_fath_fname;
    @FXML
    private TableColumn<repo_evans_3, String> col_fath_lname;
    @FXML
    private TableColumn<repo_evans_3, String> col_fath_phone;
    @FXML
    private TableColumn<repo_evans_3, String> col_fath_email;
    @FXML
    private TableColumn<repo_evans_3, String> col_moth_fname;
    @FXML
    private TableColumn<repo_evans_3, String> col_moth_lname;
    @FXML
    private TableColumn<repo_evans_3, String> col_moth_phone;
    @FXML
    private TableColumn<repo_evans_3, String> col_moth_email;
    @FXML
    private TableColumn<repo_evans_3, String> col_class_name;
    @FXML
    private TableColumn<repo_evans_3, String> col_class_room;


    ObservableList<repo_evans_3> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {

            Connection con = DBconnect.getConnection();

            CallableStatement stmt = con.prepareCall("{CALL repo_evans_3()}");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                oblist.add(new repo_evans_3(rs.getString("Stu_ID"), rs.getString("Stu_FName"), rs.getString("Stu_LName"), rs.getString("Stu_Email"),
                        rs.getString("Stu_Address"),rs.getString("Fath_FName"),rs.getString("Fath_LName"), rs.getString("Fath_Phone"), rs.getString("Fath_Email"),
                        rs.getString("Moth_FName"),rs.getString("Moth_LName"), rs.getString("Moth_Phone"), rs.getString("Moth_Email"), rs.getString("Class_Name"), rs.getString("Class_Room")));


            }

        } catch (SQLException ex) {
            Logger.getLogger(repo_evans_3.class.getName()).log(Level.SEVERE, null, ex);
        }


        col_stu_id.setCellValueFactory(new PropertyValueFactory<>("Stu_ID"));
        col_stu_fname.setCellValueFactory(new PropertyValueFactory<>("Stu_FName"));
        col_stu_lname.setCellValueFactory(new PropertyValueFactory<>("Stu_LName"));
        col_stu_email.setCellValueFactory(new PropertyValueFactory<>("Stu_Email"));
        col_stu_address.setCellValueFactory(new PropertyValueFactory<>("Class_Name"));
        col_fath_fname.setCellValueFactory(new PropertyValueFactory<>("Fath_FName"));
        col_fath_lname.setCellValueFactory(new PropertyValueFactory<>("Fath_LName"));
        col_fath_phone.setCellValueFactory(new PropertyValueFactory<>("Fath_Phone"));
        col_fath_email.setCellValueFactory(new PropertyValueFactory<>("Fath_Email"));
        col_moth_fname.setCellValueFactory(new PropertyValueFactory<>("Moth_FName"));
        col_moth_lname.setCellValueFactory(new PropertyValueFactory<>("Moth_LName"));
        col_moth_phone.setCellValueFactory(new PropertyValueFactory<>("Moth_Phone"));
        col_moth_email.setCellValueFactory(new PropertyValueFactory<>("Moth_Email"));
        col_class_name.setCellValueFactory(new PropertyValueFactory<>("Class_Name"));
        col_class_room.setCellValueFactory(new PropertyValueFactory<>("Class_Room"));




        table.setItems(oblist);


    }
}