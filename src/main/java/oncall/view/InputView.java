package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MONTH_AND_VIP = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
    private static final String INPUT_WEEKDAY_EMPLOYEE_NICKNAMES = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";

    public String readMonthAndVip() {
        return userInput(INPUT_MONTH_AND_VIP);
    }

    public String readWeekdayEmployeeNicknames() {
        return userInput(INPUT_WEEKDAY_EMPLOYEE_NICKNAMES);
    }

    private String userInput(String message) {
        System.out.print(message);
        return Console.readLine();
    }
}
