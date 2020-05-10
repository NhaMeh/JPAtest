package be.vdab.toysforboys.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    private long id;
    String name;
    @Version
    private long version;

    protected Country() {
    }

    public Country(long id,
                   String name,
                   long version) {
        this.id = id;
        this.name = name;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getVersion() {
        return version;
    }
}
