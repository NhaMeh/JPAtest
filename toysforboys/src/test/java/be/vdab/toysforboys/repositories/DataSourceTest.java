package be.vdab.toysforboys.repositories;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@DataJpaTest
class DataSourceTest {
    private DataSource dataSource;

    DataSourceTest(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Test
    public void getConnection() throws SQLException {
        //noinspection EmptyTryBlock
        try (Connection connection = dataSource.getConnection()) {
        }
    }
}
