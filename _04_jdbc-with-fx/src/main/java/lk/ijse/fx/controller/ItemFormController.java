package lk.ijse.fx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.fx.db.DbConnection;

import java.sql.*;

public class ItemFormController {
    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTel;

    @FXML
    private TableView<?> tblItem;

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String code = txtCode.getText();
        String description = txtDescription.getText();
        int qtyOnHand = Integer.parseInt(txtQtyOnHand.getText());
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());

        try {
            DbConnection dbConnection = DbConnection.getInstance();
            Connection connection = dbConnection.getConnection();

            String sql = "INSERT INTO item VALUES(?, ?, ?, ?)";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, code);
            pstm.setString(2, description);
            pstm.setDouble(3, unitPrice);
            pstm.setInt(4, qtyOnHand);

            boolean isSaved = pstm.executeUpdate() > 0;
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "item saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {
        String code = txtCode.getText();

        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String sql = "SELECT * FROM item WHERE code = ?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, code);

            ResultSet resultSet = pstm.executeQuery();

            if (resultSet.next()) {
                String item_code = resultSet.getString(1);
                String item_description = resultSet.getString(2);
                double item_unit_price = resultSet.getDouble(3);
                int item_qty_on_hand = resultSet.getInt(4);

                txtDescription.setText(item_code);
                txtUnitPrice.setText(String.valueOf(item_unit_price));
                txtQtyOnHand.setText(String.valueOf(item_qty_on_hand));
            } else {
                new Alert(Alert.AlertType.INFORMATION, "item not found!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}
