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
        hamletParser.changeHamletToLeon();
        Pattern p = Pattern.compile("(?i)Hamlet");
        Matcher m = p.matcher("Leon.txt");
        int count = 0;
        while(m.find()) count++;
        Assert.assertEquals(0, count);
    }

    @Test
    public void testChangeHoratioToTariq() {
        hamletParser.changeHoratioToTariq();
        Pattern p = Pattern.compile("(?i)Horatio");
        Matcher m = p.matcher("Leon.txt");
        int count = 0;
        while(m.find()) count++;
        Assert.assertEquals(0, count);
    }

    @Test
    public void hamletDataToFile() {
        hamletParser.hamletDataToFile();
        Assert.assertNotNull("Leon.txt");
    }
}
