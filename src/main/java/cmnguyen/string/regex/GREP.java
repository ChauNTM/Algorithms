package main.java.cmnguyen.string.regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GREP {
    public static void main(String[] args) {
        BufferedReader reader = null;
        String fileName = "tinyL.txt";
        NFA nfa = new NFA("(A*B|AC)D");
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/" + fileName));

            String line;
            while((line = reader.readLine()) != null) {
                if (nfa.recognizes(line)) System.out.println(line);
            }

        } catch (Exception ex) {
            System.out.println("Exception while reading file " + ex);
            ex.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                // handle an exception, or often we just ignore it
            }
        }

    }
}
