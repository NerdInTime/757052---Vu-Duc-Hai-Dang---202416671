package hust.soict.dsai.garbage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NoGarbage {
    public static void main(String[] args) {
        String filePath = "biggiefilee.txt"; 
        StringBuffer sb = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String content = sb.toString();
        System.out.println("File loaded! Total length = " + content.length());
    }
}