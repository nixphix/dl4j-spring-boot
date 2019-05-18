package net.prabakaran.predictionserver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IrisControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private String featureSetosa = "{\"features\": [4.9, 3.6, 1.4, 0.1]}";
    private String responseSetosa = "{\"confidenceScore\":{\"setosa\":0.93845785,\"versicolor\":0.052866768,\"virginica\":0.00867543},\"result\":\"Setosa\"}";

    private String featureVersicolor = "{\"features\": [5.0 , 2.3, 3.3, 1.0 ]}";
    private String responseVersicolor = "{\"confidenceScore\":{\"setosa\":0.054286946,\"versicolor\":0.85215145,\"virginica\":0.093561545},\"result\":\"Versicolor\"}";

    private String featureVerginica = "{\"features\": [6.7, 3.3, 5.7, 2.1]}";
    private String responseVerginica = "{\"confidenceScore\":{\"setosa\":0.011676018,\"versicolor\":0.16991985,\"virginica\":0.81840414},\"result\":\"Virginica\"}";

    @Test
    public void predictSetosa() throws Exception {
        RequestBuilder requestBuilder = post("/predict")
                .accept(MediaType.APPLICATION_JSON)
                .content(this.featureSetosa)
                .contentType(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk()).andExpect(content().string(this.responseSetosa));
    }

    @Test
    public void predictVersicolor() throws Exception {
        RequestBuilder requestBuilder = post("/predict")
                .accept(MediaType.APPLICATION_JSON)
                .content(this.featureVersicolor)
                .contentType(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk()).andExpect(content().string(this.responseVersicolor));
    }


    @Test
    public void predictVerginica() throws Exception {
        RequestBuilder requestBuilder = post("/predict")
                .accept(MediaType.APPLICATION_JSON)
                .content(this.featureVerginica)
                .contentType(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk()).andExpect(content().string(this.responseVerginica));
    }

}
