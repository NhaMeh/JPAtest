package be.vdab.toysforboys.services;

import be.vdab.toysforboys.domain.Country;
import be.vdab.toysforboys.repositories.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultCountryServiceTest {
    private DefaultCountryService service;
    @Mock
    private CountryRepository repository;
    private Country country;

    @BeforeEach
    void beforeEach() {
        country = new Country(0L, "Belgium", 1L);
        service = new DefaultCountryService(repository);
    }

    @Test
    void findCountryNameById() {
        when(repository.findById(0)).thenReturn(Optional.of(country));
        assertThat(service.findById(0).get().getName())
                .isEqualTo("Belgium");
    }

    @Test
    void findCountryNameByNonExistingId() {
        when(repository.findById(0)).thenReturn(Optional.empty());
        assertThat(service.findCountryNameById(0))
                .isNull();
    }
}
