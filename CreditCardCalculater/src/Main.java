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

    String path = "/Users/jungwoo/Desktop/git/CalculaterBill/CreditCardCalculater/hyundai.csv";

    Csv hyundaiCsv = new Csv();
    Calculater hyundaiCalculater = new Calculater(hyundaiCsv.loadCsv(path));

    Scanner sc = new Scanner(System.in);
    System.out.println("지금으로부터 몇달까지 계산할까요?");
    int targetMonth = sc.nextInt();

    System.out.println("현대카드");
    hyundaiCalculater.resultPrint(targetMonth);

    System.out.println("------------------------------------------------------------------------");
    System.out.println("신한카드");

    path = "/Users/jungwoo/Desktop/git/CalculaterBill/CreditCardCalculater/Sinhan.csv";
    Csv sinhanCsv = new Csv();
    Calculater sinhanCalculater = new Calculater(sinhanCsv.loadCsv(path));

    sinhanCalculater.resultPrint(targetMonth);






  }




}
