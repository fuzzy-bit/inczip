package inczip.options;

import inczip.Main;

public class Verbose implements Option {
    public static String name = "v";

    @Override
    public void handle() {
        Main.verbose = true;
    }
}
