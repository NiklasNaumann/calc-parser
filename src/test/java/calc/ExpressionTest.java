package calc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ExpressionTest {
    @Test
    void test1(){
        String input = "a * 2 + b";
        Expression e = Parser.parse(input);
        String output = Printer.toString(e);
        assertEquals(input, output);
    }

    @Test
    void test2(){
        HashMap<String, Integer> vars = new HashMap<>();
        vars.put("a", 3);
        vars.put("b", 8);
        Expression e = Parser.parse("a * 2 + b");
        int output = Evaluator.evaluate(e, vars);
        assertEquals(14, output);
    }

    @Test
    void test3(){
        String input = "a / (b - (c + d))";
        Expression e = Parser.parse(input);
        String output = Printer.toString(e);
        assertEquals(input, output);
    }

    @Test
    void test4(){
        Expression e = Parser.parse("a / (b + (c + d))");
        String output = Printer.toString(e);
        assertEquals("a / (b + c + d)", output);
    } 
}