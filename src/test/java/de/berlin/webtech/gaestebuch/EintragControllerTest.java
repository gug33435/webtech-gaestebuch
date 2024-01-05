package de.berlin.webtech.gaestebuch;


import de.berlin.webtech.gaestebuch.web.Eintrag;
import de.berlin.webtech.gaestebuch.web.EintragController;
import de.berlin.webtech.gaestebuch.web.EintragService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EintragController.class)
public class EintragControllerTest {
    // Notwendige Testvariablen anlegen
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EintragService service;

    @Test
    public void testGetRoute() throws Exception {
        var t1 = new Eintrag("text123", 2, 2.0, "Müller Meier", "meier28@gmail.com");
        t1.setId(22L);
        when(service.get(22L)).thenReturn(t1);

        // Erwartetes Ergebnis
        String ergebnis = "{\"id\":22,\"text\":\"text123\",\"restID\":2,\"visitRating\":2.0,\"publishDate\":null,\"name\":\"MÃ¼ller Meier\",\"email\":\"meier28@gmail.com\"}";

        // Richtiges Ergebnis und Vergleich
        this.mockMvc.perform(get("/eintrag/22"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(ergebnis)));
    }


}
