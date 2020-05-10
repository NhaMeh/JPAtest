package be.vdab.toysforboys.services;

import be.vdab.toysforboys.domain.Country;

import java.util.Optional;

public interface CountryService {
    Optional<Country> findById(long id);

    String findCountryNameById(long id);
}
