import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.Period;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;
    private final Pattern hamletPattern = Pattern.compile("Hamlet");
    private final Pattern bigHam = Pattern.compile("HAMLET");
    private final Pattern horatioPattern = Pattern.compile("Horatio");
    private final Pattern bigHor = Pattern.compile("HORATIO");
    private final String hamTris = "Tristan";
    private final String bigTris = "TRISTAN";
    private final String horaTariq = "Tariq";
    private final String bigTariq = "TARIQ";
    private Matcher matcher;

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

    public String hamletToTris(String data) {
        matcher = hamletPattern.matcher(data);
        hamletData = matcher.replaceAll(hamTris);
        return hamletData;
    }

    public String horatioToTariq(String data) {
        matcher = horatioPattern.matcher(data);
        hamletData = matcher.replaceAll(horaTariq);
        return hamletData;
    }

    public boolean findHoratio(String data) {
        return horatioPattern.matcher(data).find();
    }

    public boolean findHamlet(String data) {
        return hamletPattern.matcher(data).find();
    }

    public String bigHamChanger(String data) {
        matcher = bigHam.matcher(data);
        hamletData = matcher.replaceAll(bigTris);
        return hamletData;
    }

    public String bigHorChanger(String data) {
        matcher = bigHor.matcher(data);
        hamletData = matcher.replaceAll(bigTariq);
        return hamletData;
    }

}
