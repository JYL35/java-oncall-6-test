package oncall.util;

import java.util.Arrays;
import java.util.List;
import oncall.dto.StartOption;

public class Parser {

    public static StartOption parseStartOption(String input) {
        String[] startOption = input.split(",");

        int month = Validator.validateMonth(startOption[0].strip());
        String dayOfTheWeek = Validator.validateDayOfTheWeek(startOption[1].strip());

        return new StartOption(month, dayOfTheWeek);
    }

    public static List<String> parseWeekdayWorkers(String input) {
        return Validator.validateWeekdayWorkers(Arrays
                .stream(input.split(","))
                .map(String::strip)
                .toList());
    }

    public static List<String> parseHolidayWorkers(String input, List<String> weekdayWorkers) {
        List<String> holidayWorkers = Arrays.stream(input.split(","))
                .map(String::strip)
                .toList();

        return Validator.validateHolidayWorkers(holidayWorkers, weekdayWorkers);
    }
}
