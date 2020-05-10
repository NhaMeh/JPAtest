package be.vdab.toysforboys.repositories;

import be.vdab.toysforboys.domain.Country;

import java.util.Optional;

public interface CountryRepository {
    Optional<Country> findById(long id);
}
