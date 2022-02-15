import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * fileName     : Main
 * author       : jungwoo
 * description  :
 */
public class Main {

  public static void main(String[] args) throws IOException, ParseException {


    System.out.println("안녕하세요!");
    System.out.println("신용카드 할부 계산입니다.");
    System.out.println("1. 몇 달까지 계산할지?");
    System.out.println("2. 해당 날짜 명세서 조회");
    System.out.println("메뉴를 선택해주세요(해당 인덱스를 입력) : ");
    Scanner sc = new Scanner(System.in);
    int menuSelector = sc.nextInt();
    switch (menuSelector){
      case 1:

        calculateTotalCost(sc);
        break;
      case 2:
        calculateBill(sc);

    }




  }

  private static void calculateBill(Scanner sc) throws IOException, ParseException {

    System.out.println("몇년 몇월을 검색할까요?(ex. 2022-03)");
    String targetDate = sc.next();

    String path = "/Users/jungwoo/Desktop/git/CalculaterBill/CreditCardCalculator/hyundai.csv";

    Csv hyundaiCsv = new Csv();
    Calculator hyundaiCalculator = new Calculator(hyundaiCsv.loadCsv(path));

    hyundaiCalculator.calculateBillPrint(targetDate);


    path = "/Users/jungwoo/Desktop/git/CalculaterBill/CreditCardCalculator/Sinhan.csv";
    Csv sinhanCsv = new Csv();
    Calculator sinhanCalculator = new Calculator(sinhanCsv.loadCsv(path));

    sinhanCalculator.calculateBillPrint(targetDate);

  }

  private static void calculateTotalCost(Scanner sc) throws IOException, ParseException {
    System.out.println("지금으로부터 몇달까지 계산할까요?");
    int targetMonth = sc.nextInt();

    String path = "/Users/jungwoo/Desktop/git/CalculaterBill/CreditCardCalculater/hyundai.csv";

    Csv hyundaiCsv = new Csv();
    Calculator hyundaiCalculator = new Calculator(hyundaiCsv.loadCsv(path));


    System.out.println("현대카드");
    hyundaiCalculator.resultTotalCostPrint(targetMonth);

    System.out.println("------------------------------------------------------------------------");
    System.out.println("신한카드");

    path = "/Users/jungwoo/Desktop/git/CalculaterBill/CreditCardCalculater/Sinhan.csv";
    Csv sinhanCsv = new Csv();
    Calculator sinhanCalculator = new Calculator(sinhanCsv.loadCsv(path));

    sinhanCalculator.resultTotalCostPrint(targetMonth);
  }


}
