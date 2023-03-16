package inczip;

import inczip.options.*;

import java.util.HashMap;

public class Main {
    public static boolean verbose = false;

    static HashMap<String, Option> optionMap = new HashMap<String, Option>() {{
        put(Verbose.name, new Verbose());
    }};

    private static void handleArguments(String[] arguments) {
        for (int i = 0; i < arguments.length; i++) {
            int dashIndex = arguments[i].indexOf("-");
            String argument = arguments[i].replaceFirst("-", "");

            if (optionMap.containsKey(argument)) {
                optionMap.get(argument).handle();
            } else {
                throw new IllegalArgumentException("Invalid argument \"" + arguments[i] + "\"");
            }
        }
    }

    public static void main(String[] arguments) {
        handleArguments(arguments);

        if (verbose) {
            System.out.printf("\nArguments: %d\n", arguments.length);
        }
    }
}