package de.berlin.webtech.gaestebuch;

import de.berlin.webtech.gaestebuch.web.Eintrag;
import de.berlin.webtech.gaestebuch.web.EintragRepository;
import de.berlin.webtech.gaestebuch.web.EintragService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class EintragServiceTest {

    // Notwendige Testinstanzen anlegen
    @Autowired
    private EintragService service;
    @MockBean
    private EintragRepository repo;

    @Test
    @DisplayName("Sucht einen Eintrag anhand seiner ID")
    void testGet() {
        // Erwartete Rückgabe vom Service anlegen
        var t1 = new Eintrag("text123", 2, 2.0, "Müller Meier", "meier28@gmail.com");

        // Antwort des Service mocken
        doReturn(Optional.of(t1)).when(repo).findById(55L);

        // Abfrage des Service nach ID 55
        Eintrag ergebnis = service.get(55L);

        // Vergleichen des zu erwartenden und des realen Ergebnisses
        assertEquals(ergebnis.getName(), "Müller Meier");
    }
}
