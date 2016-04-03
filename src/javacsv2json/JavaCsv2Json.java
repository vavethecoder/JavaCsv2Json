
package javacsv2json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Jiss Thomas
 */
public class JavaCsv2Json {

    public static void main(String[] args) {
        BufferedReader bufferReader = null;
        String splitBy = ",";
        try {
            bufferReader = new BufferedReader(new FileReader("Data - Sheet1.csv"));
            String[] heading = bufferReader.readLine().split(splitBy);
            String currentLine = bufferReader.readLine();           
            String nextLine = bufferReader.readLine();
            
            PrintWriter writer = new PrintWriter("data-sheet1.json", "UTF-8");
            writer.print("{");
            writer.print("\"data\": [");
            while (currentLine != null) {
                
                String[] line = currentLine.split(splitBy);
                
                writer.print("{");
                writer.print("\"" + heading[1] + "\""+ ":" + "\"" + line[1] + "\",");
                writer.print("\"" + heading[2] + "\""+ ":" + "\"" + line[2] + "\",");
                writer.print("\"" + heading[3] + "\""+ ":" + "\"" + line[3] + "\",");
                writer.print("\"" + heading[4] + "\""+ ":" + "\"" + line[4] + "\",");
                writer.print("\"" + heading[5] + "\""+ ":" + "\"" + line[5] + "\",");
                writer.print("\"" + heading[6] + "\""+ ":" + "\"" + line[6] + "\"");
                writer.print("}");
                
                if(nextLine != null) {
                    writer.print(",");
                }
                
                currentLine = nextLine;
                nextLine = bufferReader.readLine();
                
            }
            writer.print("]");
            writer.print("}");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferReader != null) {
                try {
                    bufferReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.print("Done");
    }

}