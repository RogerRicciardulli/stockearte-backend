package stockearte.unla.edu.ar.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 20)
    private String username;
    @Column(nullable = false, length = 20)
    private String password;
    @Column(nullable = false, length = 20)
    private String firstName;
    @Column(nullable = false, length = 20)
    private String lastName;
    @Column(nullable = false)
    private boolean enabled;
    @ManyToOne
    @JoinColumn(name = "store_id")  // Especifica la columna en la tabla de usuarios
    private StoreModel store;
	public UserModel(String username, String password, String firstName, String lastName, boolean enabled,
			StoreModel store) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.enabled = enabled;
		this.store = store;
	}
	public UserModel() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public StoreModel getStore() {
		return store;
	}
	public void setStore(StoreModel store) {
		this.store = store;
	}
	
}