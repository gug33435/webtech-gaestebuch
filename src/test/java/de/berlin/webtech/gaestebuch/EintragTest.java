package de.berlin.webtech.gaestebuch;

import de.berlin.webtech.gaestebuch.web.Eintrag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EintragTest {
    @Test
    void testGetter() {
        // Zu benutzende Daten
        String text = "test123";
        int restID = 2;
        double visitRating = 5.0;
        String name = "Peter Max Meier";
        String email = "test123@gmail.com";

        // Neuen Eintrag erstellen
        Eintrag eintrag = new Eintrag(text, restID, visitRating, name, email);
        eintrag.setId(1L);

        // Erwartetes Ergebnis festlegen
        String erwartet = "test123/2/5.0/Peter Max Meier/test123@gmail.com/1";

        // Wirkliches Ergebnis bestimmen
        String wirklich = eintrag.getText() + "/" + eintrag.getRestID() + "/" + eintrag.getVisitRating() + "/" + eintrag.getName() + "/" + eintrag.getEmail() + "/" + eintrag.getId();

        // Vergleichen
        assertEquals(erwartet, wirklich);
    }
}
