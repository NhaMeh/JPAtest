package be.vdab.toysforboys.services;

import be.vdab.toysforboys.domain.Country;
import be.vdab.toysforboys.repositories.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class DefaultCountryService implements CountryService {
    private final CountryRepository countryRepository;

    public DefaultCountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> findById(long id) {
        return countryRepository.findById(id);
    }

    @Override
    public String findCountryNameById(long id) {
        Optional<Country> optionalCountry = countryRepository.findById(id);

        return optionalCountry.map(Country::getName).orElse(null);
    }
}
