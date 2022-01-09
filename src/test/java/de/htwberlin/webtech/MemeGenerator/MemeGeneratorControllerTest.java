package de.htwberlin.webtech.MemeGenerator;

import de.htwberlin.webtech.MemeGenerator.API.MemeCaptionRequest;
import de.htwberlin.webtech.MemeGenerator.service.MemeService;
import de.htwberlin.webtech.MemeGenerator.web.CreatedMeme;
import de.htwberlin.webtech.MemeGenerator.web.Memes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemeGeneratorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemeService memeService;

    Memes mockMemes = new Memes();

    String exampleMemeJson = "";

    @Test
    void createCaptions() throws Exception {
        String uri = "/api/v1/caption";
        MemeCaptionRequest memeCaptionRequest = new MemeCaptionRequest();
        memeCaptionRequest.setId("1");
        memeCaptionRequest.setPassword("password");
        memeCaptionRequest.setTx0("123");
        memeCaptionRequest.setTx1("abc");
        memeCaptionRequest.setUsername("username");


        String inputJson = super.mapToJson(memeCaptionRequest);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "MemeCaptionRequest is created successfully");

    }

    @Test
    void getMemes() throws Exception {
        String uri = "/api/v1/created";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CreatedMeme[] createdMemes = super.mapFromJson(content, CreatedMeme[].class);
        assertTrue(createdMemes.length > 0);
    }

    @Test
    void shouldShowsSimpleAssertion(){
        Assertions.assertEquals(1,1 );
    }

    @Test
    public void fetchMemeTemplates() throws Exception {
        Memes mockMemes = new Memes();
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/memeTemplates")
                .accept(MediaType.APPLICATION_JSON).content(exampleMemeJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        Assertions.assertEquals(HttpStatus.CREATED.value(),- response.getStatus());
        Assertions.assertEquals("http:localhost/api/v1/memeTemplates/1", response
                .getHeader(HttpHeaders.LOCATION));
    }
}
