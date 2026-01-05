package oncall.util;

import oncall.dto.StartOption;

public class Parser {

    public static StartOption parseStartOption(String input) {
        String[] startOption = input.split(",");

        int month = Validator.validateMonth(startOption[0].strip());
        String dayOfTheWeek = Validator.validateDayOfTheWeek(startOption[1].strip());

        return new StartOption(month, startOption[1]);
    }
}
