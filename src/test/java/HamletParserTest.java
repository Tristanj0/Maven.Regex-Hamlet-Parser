import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void testChangeHamletToTris() {
        String expected = "My name is Tris";
        String input = "My name is Hamlet";

        String actual = hamletParser.hamletToTris(input);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String expected = "My name is Tariq";
        String input = "My name is Horatio";

        String actual = hamletParser.horatioToTariq(input);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        String input = "My name is Horatio";

        Assert.assertTrue(hamletParser.findHoratio(input));
    }

    @Test
    public void testFindHamlet() {
        String input = "My name is Hamlet";

        Assert.assertTrue(hamletParser.findHamlet(input));
    }

    @Test
    public void hamletParserTest() {
        String hamToTris = hamletParser.hamletToTris(hamletText);
        String horToTariq = hamletParser.horatioToTariq(hamToTris);
        String bigHam = hamletParser.bigHamChanger(horToTariq);
        String bigTor = hamletParser.bigHorChanger(bigHam);
        System.out.println(bigTor);
    }
}