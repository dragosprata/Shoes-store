package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Order {

	private IntegerProperty id;
	private StringProperty produs;
	private StringProperty cumparator;
	private IntegerProperty marime;
	private StringProperty culoare;
	
	//Constructor
	public Order(){
		this.id = new SimpleIntegerProperty();
		this.produs = new SimpleStringProperty();
		this.cumparator = new SimpleStringProperty();
		this.marime = new SimpleIntegerProperty();
		this.culoare = new SimpleStringProperty();
		
	}
	
	//order_id
	public int getOrderId(){
		return id.get();
	}
	
	public void setOrderId(int id){
		this.id.set(id);
	}
	
	public IntegerProperty orderIdProperty(){
        return id;
    }
	
	//denumire_produs
	public String getProduct(){
		return produs.get();
	}
	
	public void setProduct(String produs){
		this.produs.set(produs);
	}
	
	public StringProperty produsProperty(){
		return produs;
	}
	
	//nume_cumparator
	
	public String getCumparator(){
		return cumparator.get();
	}
	
	public void setCumparator(String cumparator){
		this.cumparator.set(cumparator);
	}
	
	public StringProperty cumparatorProperty(){
		return cumparator;
	}
	
	//marime
	
	public int getMarime(){
		return marime.get();
	}
	
	public void setMarime(int marime){
		this.marime.set(marime);
	}
	
	public IntegerProperty marimeProperty(){
		return marime;
	}
	
	//culoare
	
	public String getCuloare(){
		return culoare.get();
	}
	
	public void setCuloare(String culoare){
		this.culoare.set(culoare);
	}
	
	public StringProperty culoareProperty(){
		return culoare;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", produs=" + produs + ", cumparator=" + cumparator + ", marime=" + marime + ", culoare=" + "]";
	}
}
