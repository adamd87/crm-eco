package pl.adamd.crmsrv.client.controller;

import db.init.SqlTruncateTables;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SqlTruncateTables
@ActiveProfiles("test")
class ClientControllerTest {

    @LocalServerPort
    private int port;

}