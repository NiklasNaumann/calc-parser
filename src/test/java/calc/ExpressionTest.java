package calc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

public class ExpressionTest {
    
    @Test
    void TestParserOutputShouldBeSameAsInput_WithoutBrackets(){
        String input = "a * 2 + b";
        assertEquals(input,  Printer.toString(Parser.parse(input)));
    }

    @Test
    void TestEvaluator(){
        String input = "a * 2 + b";
        Map<String, Integer> variables = new HashMap<String, Integer>();
        variables.put("a", 3);
        variables.put("b", 8);
        Expression e = Parser.parse(input);
        assertEquals(14, Evaluator.evaluate(e, variables));
    }

    @Test
    void TestParserOutputShouldBeSameAsInput_WithBrackets(){
        String input = "a / (b - (c + d))";
        assertEquals(input,  Printer.toString(Parser.parse(input)));
    }

    @Test
    void TestParserOutputShouldBeDiffrentFromInput_WithBrackets(){
        String input = "a / (b + (c + d))";
        String output = "a / (b + c + d)";
        assertEquals(output,  Printer.toString(Parser.parse(input)));
    }
}
