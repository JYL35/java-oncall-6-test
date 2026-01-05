package oncall.view;

import java.util.List;
import oncall.domain.Calendar;
import oncall.domain.WorkRecord;
import oncall.dto.StartOption;
import oncall.repository.WorkRecordRepository;

public class OutputView {
    private static final List<String> WEEKDAY = List.of("월", "화", "수", "목", "금");

    public void printResult(StartOption startOption) {
        int month = startOption.month();
        int lastDay = Calendar.lastDayOfMonth(month);

        for (int day = 1; day <= lastDay; day++) {
            WorkRecord workRecord = WorkRecordRepository.findByDay(day);
            String dayOfTheWeek = workRecord.getDayOfTheWeek();
            if (WEEKDAY.contains(dayOfTheWeek) && workRecord.isHoliday()) {
                dayOfTheWeek += "(휴일)";
            }
            System.out.printf("%d월 %d일 %s %s", month, day, dayOfTheWeek, workRecord.getWorker());
            printNewLine();
        }
    }

    public void printError(RuntimeException e) {
        System.out.println(e.getMessage());
        printNewLine();
    }

    private static void printNewLine() {
        System.out.print(System.lineSeparator());
    }
}
