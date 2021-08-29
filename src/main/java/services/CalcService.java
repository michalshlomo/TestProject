package services;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Service;

import caching.Cachable;

@Service
public class CalcService {

	@Cachable
	public String calcPrinter(String operator, Integer left, Integer right) {
		StringBuilder response = new StringBuilder();
		try {
			response.append(left);
			response.append(getOperator(operator));
			response.append(right);
			ExpressionParser parser = new SpelExpressionParser();
			response.append("=" + String.valueOf(parser.parseExpression(response.toString()).getValue()));
		} catch (NullPointerException e) {
			response = new StringBuilder("you have null value");
		}catch (Exception e) {
			response = new StringBuilder(e.getMessage());
		}
		return response.toString();
	}
	
	private Object getOperator(String operator) throws Exception {
		switch (operator) {
			case "plus": return "+";
			case "minus": return "-";
			case "multiply": return "*";
			case "divide": return "/";
			default: throw new Exception("operator not found");
		}
	}
}
