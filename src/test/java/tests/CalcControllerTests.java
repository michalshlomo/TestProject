package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import application.Application;
import inputParams.CalcInputParams;
import services.CalcService;

@SpringBootTest(classes = {CalcService.class, Application.class})
@AutoConfigureMockMvc
public class CalcControllerTests {

	@Autowired
    private MockMvc mvc;

	@Autowired
    private CalcService calcService;
    
    @Test
    public void callServiceTest()
      throws Exception {
        
    	String operator = "plus";
    	Integer left = 9; 
    	Integer right = 7;
    	
    	MvcResult result = mvc.perform(post("http://localhost:8080/calcPrinter")
    			.accept(TestUtil.APPLICATION_JSON_UTF8)
    			.content(TestUtil.convertObjectToJsonBytes(new CalcInputParams(operator, left, right)))
    			.contentType(TestUtil.APPLICATION_JSON_UTF8))
    			.andExpect(status().isOk()).andReturn();

        String resultCZ = result.getResponse().getContentAsString();
        assertNotNull(resultCZ);
        assertEquals(calcService.calcPrinter(operator, left, right), resultCZ);
    }
}


