package utils;

import org.junit.Test;

import java.io.IOException;

public class Instruments {



    @Test
    public void test() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("instruments -s devices | grep 'iPhone'");
    }
}
