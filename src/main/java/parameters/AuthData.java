package parameters;

import org.junit.runners.Parameterized.Parameters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthData {
    @Parameters
    public static Collection<Object[]> data() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/parameters/data.txt"));
        List<Object[]> res = new ArrayList<Object[]>();
        String s;
        while((s = reader.readLine()) != null) {
            String[] params = s.split(" ");
            Object[] curData = new Object[1];
            curData[0] =Double.parseDouble(params[0]);
            res.add(curData);
        }
        return res;
    }
}
