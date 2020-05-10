package be.vdab.toysforboys.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private long id;
    private String name, streetAndNumber, city, state, postalCode;
    private long countryId;
    @Version
    private long version;

    protected Customer() {
    }

    public Customer(long id,
                    String name,
                    String streetAndNumber,
                    String city,
                    String state,
                    String postalCode,
                    long countryId,
                    long version) {
        this.id = id;
        this.name = name;
        this.streetAndNumber = streetAndNumber;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.countryId = countryId;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public long getCountryId() {
        return countryId;
    }

    public long getVersion() {
        return version;
    }
}
