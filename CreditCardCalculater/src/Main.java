import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * fileName     : Main
 * author       : jungwoo
 * description  :
 */
public class Main {

  public static void main(String[] args) throws IOException, ParseException {

    String path = "/Users/jungwoo/Desktop/git/CreditCardCalculater/hundai.csv";

    Csv csv = new Csv();
    Calculater calculater = new Calculater(csv.loadCsv(path), csv);

    Scanner sc = new Scanner(System.in);
    System.out.println("지금으로부터 몇달까지 계산할까요?");
    int targetMonth = sc.nextInt();

    calculater.resultPrint(targetMonth);




  }




}
