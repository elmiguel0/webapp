package webapp.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String Address;
    private String city;
    private String state; 
    private String zip;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books = new HashSet<>();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Publisher)) return false;

        Publisher publisher =  (Publisher) o;

        return getId() != null ? getId().equals(publisher.getId()) : publisher.getId() == null;
    }
    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode():0;
    }
    @Override
    public String toString() {
        return "Publisher{" +
        "id=" + id +
        ", Name=" + name + '\'' +
        ", address=" + Address + '\'' +
        ", city=" + city + '\'' +
        ", state=" + state + '\'' +
        ", zip=" + zip + '\'' +
        '}';
    }

    
}
