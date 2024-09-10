package stockearte.unla.edu.ar.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "stocks")
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"store_id", "product_id"})
})
public class StockModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private StoreModel store;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductModel product;

    @Column(nullable = false)
    private int quantity = 0;
	public StockModel(StoreModel store, ProductModel product, int quantity) {
		super();
		this.store = store;
		this.product = product;
		this.quantity = quantity;
	}
	public StockModel() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public StoreModel getStore() {
		return store;
	}
	public void setStore(StoreModel store) {
		this.store = store;
	}
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}