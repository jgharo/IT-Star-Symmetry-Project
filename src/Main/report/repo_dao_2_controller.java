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

public class repo_dao_2_controller implements Initializable {

    @FXML
    private TableView<repo_dao_2> table;
    @FXML
    private TableColumn<repo_dao_2, String> col_stu_id;
    @FXML
    private TableColumn<repo_dao_2, String> col_stu_fname;
    @FXML
    private TableColumn<repo_dao_2, String> col_stu_lname;
    @FXML
    private TableColumn<repo_dao_2, String> col_course_name;
    @FXML
    private TableColumn<repo_dao_2, String> col_sac_type;

    ObservableList<repo_dao_2> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {

            Connection con = DBconnect.getConnection();

            CallableStatement stmt = con.prepareCall("{CALL repo_dao_2()}");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                oblist.add(new repo_dao_2(rs.getString("Stu_ID"),rs.getString("Stu_FName"), rs.getString("Stu_LName"), rs.getString("Course_Name"),
                        rs.getString("Sac_Type")));


            }

        } catch (SQLException ex) {
            Logger.getLogger(repo_dao_2.class.getName()).log(Level.SEVERE, null, ex);
        }


        col_stu_id.setCellValueFactory(new PropertyValueFactory<>("Stu_ID"));
        col_stu_fname.setCellValueFactory(new PropertyValueFactory<>("Stu_FName"));
        col_stu_lname.setCellValueFactory(new PropertyValueFactory<>("Stu_LName"));
        col_course_name.setCellValueFactory(new PropertyValueFactory<>("Course_Name"));
        col_sac_type.setCellValueFactory(new PropertyValueFactory<>("Sac_Type"));


        table.setItems(oblist);


    }
}