package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConnectionFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Client;
import model.Order;

public class OrderDAO {

	//*******************************
    //SELECT an Order
    //*******************************
	public static Order searchOrder(String orderId) throws SQLException,ClassNotFoundException{
		//Declare a SELECT statement
		String selectStmt = "SELECT * FROM comanda WHERE id_comanda="+orderId;
		
		//Execute SELECT statement
		try{
			//Get ResultSet from dbExecuteQuery method
			ResultSet rsComanda = ConnectionFactory.dbExecuteQuery(selectStmt);
			
			//Send ResultSet to the getOrderFromResultSet method and get order object
			Order comanda = getOrderFromResultSet(rsComanda);
			
			//Return order object
			return comanda; 
		}catch(SQLException e){
			System.out.println("While searching an order with " + orderId + " id, an error occurred: " + e);
			//Return exception
			throw e;
		}
	}
	
	//Use ResultSet from DB as parameter and set Order Object's attributes and return order object
	private static Order getOrderFromResultSet(ResultSet rs) throws SQLException{
		Order order = null;
		if(rs.next()){
			order = new Order();
			order.setOrderId(rs.getInt("ID_COMANDA"));
			order.setProduct(rs.getString("PRODUS"));
			order.setCumparator(rs.getString("CUMPARATOR"));
			order.setMarime(rs.getInt("MARIME"));
			order.setCuloare(rs.getString("CULOARE"));
		}
		return order;
	}
	
	//*******************************
    //SELECT Orders
    //*******************************
	public static ObservableList<Order> searchOrders () throws SQLException, ClassNotFoundException {
		//Declare a SELECT statement
		String selectStmt = "SELECT * FROM comanda";
		//Execute SELECT statement
		try{
			//Get ResultSet from dbExecuteQuery method
			ResultSet rsOrders = ConnectionFactory.dbExecuteQuery(selectStmt);
			//Send ResultSet to the getOrderList method and get order object
			ObservableList<Order> orderList = getOrderList(rsOrders);
			
			//Return order object
			return orderList;
		}catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			//Return exception
			throw e;
		}
	}
	
	//Select * from Order operation
	private static ObservableList<Order> getOrderList(ResultSet rs) throws SQLException, ClassNotFoundException {
		//Declare a observable List which comprises of Order objects
		ObservableList<Order> orderList = FXCollections.observableArrayList();
		
		while(rs.next()){
			Order order = new Order();
			order.setOrderId(rs.getInt("ID_COMANDA"));
			order.setProduct(rs.getString("PRODUS"));
			order.setCumparator(rs.getString("CUMPARATOR"));
			order.setMarime(rs.getInt("MARIME"));
			order.setCuloare(rs.getString("CULOARE"));
			//Add order to the ObservableList
			orderList.add(order);
		}
		//return orderList(ObservableList of Orders)
		return orderList;
	}
	
	 //*************************************
    //UPDATE an order's name
    //*************************************
	public static void updateOrderName (String orderId,String produs) throws SQLException, ClassNotFoundException {
		//Declare a UPDATE statement
		String updateStmt = "UPDATE comanda SET PRODUS='"+produs+"' WHERE ID_COMANDA = '"+orderId+"'";
		//Execute UPDATE operation
		try{
			ConnectionFactory.dbExecuteUpdate(updateStmt);
		} catch (SQLException e){
			System.out.print("Error occurred while UPDATE Operation: " + e);
			throw e;
		}
	}
	
	 //*************************************
    //UPDATE an order's size
    //*************************************
	public static void updateOrderSize (String orderId,String marime) throws SQLException, ClassNotFoundException {
		//Declare a UPDATE statement
		String updateStmt = "UPDATE comanda SET MARIME='"+marime+"' WHERE ID_COMANDA = '"+orderId+"'";
		//Execute UPDATE operation
		try{
			ConnectionFactory.dbExecuteUpdate(updateStmt);
		} catch (SQLException e){
			System.out.print("Error occurred while UPDATE Operation: " + e);
			throw e;
		}
	}
	
	 //*************************************
    //UPDATE an order's color
    //*************************************
	public static void updateOrderColor (String orderId,String culoare) throws SQLException, ClassNotFoundException {
		//Declare a UPDATE statement
		String updateStmt = "UPDATE comanda SET CULOARE='"+culoare+"' WHERE ID_COMANDA = '"+orderId+"'";
		//Execute UPDATE operation
		try{
			ConnectionFactory.dbExecuteUpdate(updateStmt);
		} catch (SQLException e){
			System.out.print("Error occurred while UPDATE Operation: " + e);
			throw e;
		}
	}
	
    //*************************************
    //DELETE an order
    //*************************************
	public static void deleteOrderWithId(String orderId) throws SQLException, ClassNotFoundException {
		//Declare a DELETE statement
		String deleteStmt = "DELETE FROM comanda WHERE id_comanda ="+orderId;
		
		//Execute DELETE operation
		try{
			ConnectionFactory.dbExecuteUpdate(deleteStmt);
		}catch(SQLException e){
			System.out.print("Error occurred while DELETE Operation: " + e);
			throw e;
		}
	}
	  //*************************************
    //INSERT an order
    //*************************************
	
	public static void insertOrder(String denumire,String nume,String marime,String culoare) throws SQLException, ClassNotFoundException{
		//Declare an INSERT statement
		String insertStmt = "INSERT INTO comanda(PRODUS,CUMPARATOR,MARIME,CULOARE) VALUES ('"+denumire+"','"+nume+"','"+marime+"','"+culoare+"')";
		//Execute INSERT operation
		try{
			ConnectionFactory.dbExecuteUpdate(insertStmt);
		}catch (SQLException e){
			System.out.print("Error occurred while INSERT Operation: " + e);
			throw e;
		}
	}
}