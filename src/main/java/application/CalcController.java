package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import inputParams.CalcInputParams;
import services.CalcService;

@RestController
public class CalcController {

	@Autowired
	CalcService calcService;
	
	@PostMapping("/calcPrinter")
	public String calcPrinter(@RequestBody CalcInputParams inputParams) {
		return calcService.calcPrinter(inputParams.getOperator(), inputParams.getLeft(), inputParams.getRight());
	}
}
