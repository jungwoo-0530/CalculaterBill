import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * fileName     : Calculator
 * author       : jungwoo
 * description  :
 */
public class Calculator {

  private final List<List<String>> originalCsvList;

  public Calculator(List<List<String>> csvList) {
    this.originalCsvList = csvList;
  }


  public void resultPrint(int targetMonth) throws ParseException {


    for(int i = 0; i<targetMonth; i++) {

      List<List<String>> lists = makeList(originalCsvList, i);

      int totalCost = getTotalCost(lists);

      System.out.println(lists.get(0).get(0));
      System.out.println("총 내야할 금액은 "+ totalCost +"입니다.");
      System.out.println("=======================================");
    }
  }


  public List<List<String>> makeList(List<List<String>> list, int addMonth) throws ParseException {


    List<List<String>> result = new ArrayList<>();
    String currentDate = getNextMonth(originalCsvList.get(0).get(0), addMonth);

    result.add(new ArrayList<>(){{
      add(currentDate);
    }});

      for (int j = 1; j < list.size(); j++) {

        //할부가 몇개월 남앗는지 계산하기 위한 parse
        String strTemp = list.get(j).get(2);
        String[] strings = strTemp.split("/");

        //false면 추가안함.
        if (!calculaterInstallment(strings[0], strings[1], addMonth)) {
          continue;
        }


        String newInstallment = makeInstallment(plusNumString(strings[0], addMonth), strings[1]);


        List<String> tempList = new ArrayList<>();
        tempList.add(list.get(j).get(0));
        tempList.add(list.get(j).get(1));
        tempList.add(newInstallment);

        result.add(tempList);

      }

      return result;
  }

  //String에 int를 더해주는 메서드.
  public String plusNumString(String str, int num) {
    return Integer.toString(Integer.parseInt(str) + num);
  }

  //할부기간을 만들어주는 메서드.
  private String makeInstallment(String currentMonth, String maxMonth) {
    return currentMonth + "/" + maxMonth;
  }

  //다음달을 String으로 계산해주는 메소드.
  public String getNextMonth(String originDate, int addMonth) throws ParseException {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
    Date date = format.parse(originDate);

    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.MONTH, addMonth);

    return format.format(cal.getTime());
  }

  //true면 다음달도 나가야하는 것.
  public Boolean calculaterInstallment(String currentDate, String maximumDate, int addMonth) {
    int currentNum = Integer.parseInt(currentDate)+addMonth;
    int maxNum = Integer.parseInt(maximumDate);

    return maxNum - currentNum >= 0;
  }

  public int getTotalCost(List<List<String>> list) {

    int result = 0;
    for(int i = 1; i<list.size(); i++){
      String temp = list.get(i).get(1);
      result += Integer.parseInt(temp);
    }

    return result;
  }
}
