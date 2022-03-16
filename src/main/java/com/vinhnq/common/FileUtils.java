package com.vinhnq.common;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileUtils {
    public static void appendStringFile(String my_file_name, String string) throws IOException {
        try {
            Writer output;
            output = new BufferedWriter(new FileWriter(my_file_name, true));
            output.append(string + System.lineSeparator());
            output.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
