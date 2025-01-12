

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        return loadFile("hamlet.txt");
    }

    protected String loadFile(String path){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(path).getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public void changeHamletToLeon() {
        Pattern p = Pattern.compile("(?)Hamlet");
        Matcher m = p.matcher(hamletData);
        hamletData = m.replaceAll("Leon");
        Pattern p2 = Pattern.compile("(?i)HAMLET");
        Matcher m2 = p2.matcher(hamletData);
        hamletData = m2.replaceAll("LEON");
    }
    public void changeHoratioToTariq() {
        Pattern p = Pattern.compile("Horatio");
        Matcher m = p.matcher(hamletData);
        hamletData = m.replaceAll("Tariq");
        Pattern p2 = Pattern.compile("(?i)HORATIO");
        Matcher m2 = p2.matcher(hamletData);
        hamletData = m2.replaceAll("TARIQ");
    }

    public void hamletDataToFile() {
        changeHoratioToTariq();
        changeHamletToLeon();
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileOutputStream("Leon.txt"));
            writer.write(hamletData);
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) writer.close();
        }
    }



}
