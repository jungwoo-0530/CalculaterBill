import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * fileName     : Csv
 * author       : jungwoo
 * description  :
 */
public class Csv {


  public List<List<String>> loadCsv(String path) throws IOException {

    File csv = new File(path);
    BufferedReader br = null;
    br = new BufferedReader(new FileReader(csv));

    String line = "";
    List<List<String>> result = new ArrayList<>();
    while ((line = br.readLine()) != null) {
      String[] token = line.split(",");
      List<String> tempList = new ArrayList<>(Arrays.asList(token));
      result.add(tempList);
    }

    return result;
  }




}
