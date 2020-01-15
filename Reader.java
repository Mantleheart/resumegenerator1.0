

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.Random;



public class Reader {

    private String[] data = new String[128];
    private int index = 0;
    public Reader(String filename) throws IOException

    {
        File f = new File( "Resources/" + filename);
        String currentline = new String("currentLine");
        BufferedReader reader = new BufferedReader(new FileReader(f));
        while (currentline != null)
        {
            currentline = reader.readLine();
            if (currentline != null) {
                if(currentline != "")
                {
                    data[index] = currentline;
                }
                index++;
            }
        }
        reader.close();
    }

    public String[] randomizer()
    {
        Random germ = new Random();
        int seed = Math.abs(germ.nextInt());
        String[] pkg = {data[seed % index], data[(seed + 1) % index]};
        return(pkg);
    }

    public String toParagraph()
    {
        String paragraph = new String("");

        for (String line: data)
        {
            if (line != null) {
                paragraph = paragraph + "\n" + line;

            }
        }
        return(paragraph);
    }
}
