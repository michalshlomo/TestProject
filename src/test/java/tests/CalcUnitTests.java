package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import inputParams.CalcInputParams;
import services.CalcService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {CalcService.class, CalcInputParams.class})
public class CalcUnitTests {

	@Autowired
	CalcService calcService;
	
	@Test
	public void validTest() {
		assertEquals(calcService.calcPrinter("plus", 5, 7), "5+7=12");
	}
	
	@Test
	public void nullValueTest() {
		assertEquals(calcService.calcPrinter(null, null, null),"have null value");
	}
	
	@Test
	public void emptyValueTest() {
		assertEquals(calcService.calcPrinter("", 0, 0),"operator not found");
	}
	
	@Test
	public void operatorNotFoundTest() {
		assertEquals(calcService.calcPrinter("aaa", 5, 7), "operator not found");
	}
}


