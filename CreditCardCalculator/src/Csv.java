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

  private final String csvName;

  public Csv(String csvName) {
    this.csvName = csvName;
  }

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

  public void writeCsv(List<List<String>> dataList) throws IOException {
    File csv = new File("/Users/jungwoo/Desktop/git/CalculaterBill/CreditCardCalculator/csv/output/"+this.csvName);
    BufferedWriter bw = null; // 출력 스트림 생성

      bw = new BufferedWriter(new FileWriter(csv));

      String str = dataList.get(0).get(0);
      bw.write(str);
      bw.newLine();
      for (int i = 1; i < dataList.size(); i++) {

        StringBuilder tempStr = new StringBuilder();
        tempStr = new StringBuilder(dataList.get(i).get(0));
        for(int j = 1; j<dataList.get(i).size(); j++){
          tempStr.append(",").append(dataList.get(i).get(j));
        }
        bw.write(tempStr.toString());
        bw.newLine(); // 개행
      }

    bw.close();

  }




}
