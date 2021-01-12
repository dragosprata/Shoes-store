package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product {

	private IntegerProperty id_produs;
	private StringProperty denumire;
	private StringProperty producator;
	private IntegerProperty pret;
	private IntegerProperty marime;
	private StringProperty culoare;
	
	//Constructor
	public Product(){
		this.id_produs = new SimpleIntegerProperty();
		this.denumire = new SimpleStringProperty();
		this.producator = new SimpleStringProperty();
		this.pret = new SimpleIntegerProperty();
		this.marime = new SimpleIntegerProperty();
		this.culoare = new SimpleStringProperty();
	}
	
	//product_id
	public int getProductId() {
        return id_produs.get();
    }

    public void setProductId(int id_produs){
        this.id_produs.set(id_produs);
    }

    public IntegerProperty productIdProperty(){
        return id_produs;
    }
    
    //denumire_produs
    public String getDenumire(){
    	return denumire.get();
    }
    
    public void setDenumire(String denumire){
    	this.denumire.set(denumire);
    }
    
    public StringProperty denumireProperty(){
    	return denumire;
    }
    
    //producator
    public String getProducator(){
    	return producator.get();
    }
    
    public void setProducator(String producator){
    	this.producator.set(producator);
    }
    
    public StringProperty producatorProperty(){
    	return producator;
    }
    
    //pret
    public int getPrice(){
    	return pret.get();
    }
    
    public void setPrice(int pret){
    	this.pret.set(pret);
    }
    
    public IntegerProperty priceProperty(){
    	return pret;
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
		return "Product [id_produs=" + id_produs + ", denumire=" + denumire + ", producator=" + producator + ", pret="
				+ pret + ", marime=" + marime + ", culoare=" + culoare + "]";
	}
}
