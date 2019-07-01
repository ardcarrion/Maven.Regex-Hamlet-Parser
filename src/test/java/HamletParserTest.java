import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        hamletParser.hamletDataToFile();
        Pattern p = Pattern.compile("(?i)Hamlet");
        String leon = hamletParser.loadFile("Leon.txt");
        Matcher m = p.matcher(leon);
        int count = 0;
        while(m.find()) count++;
        Assert.assertEquals(0, count);
    }

    @Test
    public void testChangeHoratioToTariq() {
        hamletParser.hamletDataToFile();
        Pattern p = Pattern.compile("(?i)Horatio");
        String leon = hamletParser.loadFile("Leon.txt");
        Matcher m = p.matcher(leon);
        int count = 0;
        while(m.find()) count++;
        Assert.assertEquals(0, count);
    }

}
