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
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
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
        Pattern p = Pattern.compile("(?i)Hamlet");
        Matcher m = p.matcher(hamletData);
        hamletData = m.replaceAll("Leon");
        m.usePattern(Pattern.compile("(?i)HAMLET"));
        hamletData = m.replaceAll("LEON");
    }
    public void changeHoratioToTariq() {
        Pattern p = Pattern.compile("HORATIO");
        Matcher m = p.matcher(hamletData);
        hamletData = m.replaceAll("TARIQ");
    }

    public void hamletDataToFile() {
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
