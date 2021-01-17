package calc;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private Map<String, Integer> variables = new HashMap<>();

    private Optional<Integer> eval(String expression) {
        try {
            Expression e = Parser.parse(expression);
            System.out.println("--> " + e);
            int result = e.evaluate(variables);
            System.out.println("==> " + result);
            return Optional.of(result);
        } catch (CalcException e) {
            System.out.println("!!! " + e.getMessage());
            return Optional.empty();
        }
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(":=")) {
                String[] parts = line.split(":=");
                eval(parts[1]).ifPresent(v -> variables.put(parts[0].trim(), v));
            } else {
                eval(line);
            }
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}