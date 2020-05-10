package be.vdab.toysforboys.repositories;

import be.vdab.toysforboys.domain.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class JPACountryRepository implements CountryRepository {
    private final EntityManager manager;

    public JPACountryRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<Country> findById(long id) {
        return Optional.ofNullable(manager.find(Country.class, id));
    }
}
