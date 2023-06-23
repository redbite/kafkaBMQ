package redbite.io.kafkamanager.payload;

public class User {
	private long id;
	private String nat;
	private String name;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNat() {
		return nat;
	}
	public void setNat(String nat) {
		this.nat = nat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User(long id, String nat, String name) {
		super();
		this.id = id;
		this.nat = nat;
		this.name = name;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nat=" + nat + ", name=" + name + "]";
	}
	
	
}
