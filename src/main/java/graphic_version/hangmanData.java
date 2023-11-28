package graphic_version;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class hangmanData {
    List<String> words = new ArrayList<>();

    public void readData() throws IOException {
        File f = new File("src\\main\\java\\cmd_version\\wfhm.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) break;
            words.add(line);
        }
        fr.close();
        br.close();
    }

}

