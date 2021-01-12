package presentation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import model.Order;
import dao.OrderDAO;

import java.sql.SQLException;

public class OrderController {

	 @FXML
	    private TextField produsText;
	    @FXML
	    private TextArea resultArea;
	    @FXML
	    private TextField numeText;
	    @FXML
	    private TextField marimeText;
	    @FXML
	    private TextField culoareText;
	    @FXML
	    private TextField orderIdText;
	    @FXML
	    private TextField newNameText;
	    @FXML
	    private TextField newSizeText;
	    @FXML
	    private TextField newColorText;
	    @FXML
	    private TableView orderTable;
	    @FXML
	    private TableColumn<Order, Integer>  orderIdColumn;
	    @FXML
	    private TableColumn<Order, String>  orderProdusColumn;
	    @FXML
	    private TableColumn<Order, String> orderCumparatorColumn;
	    @FXML
	    private TableColumn<Order, Integer> orderMarimeColumn;
	    @FXML
	    private TableColumn<Order, String> orderCuloareColumn;

	    //Search an order
	    @FXML
	    private void searchOrder (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
	        try {
	            //Get Order information
	            Order order = OrderDAO.searchOrder(orderIdText.getText());
	            //Populate Order on TableView and Display on TextArea
	            populateAndShowOrder(order);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            resultArea.setText("Error occurred while getting order information from DB.\n" + e);
	            throw e;
	        }
	    }

	    //Search all orders
	    @FXML
	    private void searchOrders(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
	        try {
	            //Get all Orders information
	            ObservableList<Order> orderData = OrderDAO.searchOrders();
	            //Populate Orders on TableView
	            populateOrders(orderData);
	        } catch (SQLException e){
	            System.out.println("Error occurred while getting orders information from DB.\n" + e);
	            throw e;
	        }
	    }

	    //Initializing the controller class.
	    //This method is automatically called after the fxml file has been loaded.
	    @FXML
	    private void initialize () {
	       
	    	orderIdColumn.setCellValueFactory(cellData -> cellData.getValue().orderIdProperty().asObject());
	    	orderProdusColumn.setCellValueFactory(cellData -> cellData.getValue().produsProperty());
	    	orderCumparatorColumn.setCellValueFactory(cellData -> cellData.getValue().cumparatorProperty());
	    	orderMarimeColumn.setCellValueFactory(cellData -> cellData.getValue().marimeProperty().asObject());
	    	orderCuloareColumn.setCellValueFactory(cellData -> cellData.getValue().culoareProperty());
	    }

	    //Populate Order
	    @FXML
	    private void populateOrder (Order order) throws ClassNotFoundException {
	        //Declare and ObservableList for table view
	        ObservableList<Order> orderData = FXCollections.observableArrayList();
	        //Add order to the ObservableList
	        orderData.add(order);
	        //Set items to the orderTable
	        orderTable.setItems(orderData);
	    }

	    //Set Order information to Text Area
	    @FXML
	    private void setOrderInfoToTextArea ( Order order) {
	        resultArea.setText("Denumire produs: " + order.getProduct() + "\n" +"Nume client: " + order.getCumparator() + "\n" + "Marime: " + order.getMarime() + "\n" + "Culoare: " + order.getCuloare() + "\n");
	    }

	    //Populate Order for TableView and Display Order on TextArea
	    @FXML
	    private void populateAndShowOrder(Order order) throws ClassNotFoundException {
	        if (order != null) {
	            populateOrder(order);
	            setOrderInfoToTextArea(order);
	        } else {
	            resultArea.setText("This order does not exist!\n");
	        }
	    }

	    //Populate Orders for TableView
	    @FXML
	    private void populateOrders (ObservableList<Order> orderData) throws ClassNotFoundException {
	        //Set items to the orderTable
	    	orderTable.setItems(orderData);
	    }

	    //Update order's name with the name which is written on newNameText field
	    @FXML
	    private void updateOrderName (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
	        try {
	        	OrderDAO.updateOrderName(orderIdText.getText(),newNameText.getText());
	            resultArea.setText("Name has been updated for, order id: " + orderIdText.getText() + "\n");
	        } catch (SQLException e) {
	            resultArea.setText("Problem occurred while updating name: " + e);
	        }
	    }
	    
	    //Update order's size with the size which is written on newSizeText field
	    @FXML
	    private void updateOrderSize (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
	        try {
	        	OrderDAO.updateOrderSize(orderIdText.getText(),newSizeText.getText());
	            resultArea.setText("Size has been updated for, order id: " + orderIdText.getText() + "\n");
	        } catch (SQLException e) {
	            resultArea.setText("Problem occurred while updating name: " + e);
	        }
	    }
	    
	    //Update order's color with the color which is written on newColorText field
	    @FXML
	    private void updateOrderColor (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
	        try {
	        	OrderDAO.updateOrderColor(orderIdText.getText(),newColorText.getText());
	            resultArea.setText("Color has been updated for, order id: " + orderIdText.getText() + "\n");
	        } catch (SQLException e) {
	            resultArea.setText("Problem occurred while updating name: " + e);
	        }
	    }

	    //Insert an order to the DB
	    @FXML
	    private void insertOrder (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
	        try {
	        	OrderDAO.insertOrder(produsText.getText(),numeText.getText(),marimeText.getText(),culoareText.getText());
	            resultArea.setText("Order inserted! \n");
	        } catch (SQLException e) {
	            resultArea.setText("Problem occurred while inserting order " + e);
	            throw e;
	        }
	    }

	    //Delete an order with a given order Id from DB
	    @FXML
	    private void deleteOrder (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
	        try {
	            OrderDAO.deleteOrderWithId(orderIdText.getText());
	            resultArea.setText("Order deleted! Order id: " + orderIdText.getText() + "\n");
	        } catch (SQLException e) {
	            resultArea.setText("Problem occurred while deleting order " + e);
	            throw e;
	        }
	    }
}
