package oncall.controller;

import java.util.List;
import java.util.Map;
import oncall.dto.StartOption;
import oncall.dto.Workers;
import oncall.util.Parser;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OnCallController {

    private final InputView inputView;
    private final OutputView outputView;

    public OnCallController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        StartOption startOption = readStartOption();
        Workers workers = readWorkers();

        // 배치 시작
    }

    private StartOption readStartOption() {
        while (true) {
            try {
                String inputMonthAndDayOfWeek = inputView.readMonthAndVip();
                return Parser.parseStartOption(inputMonthAndDayOfWeek);
            } catch (RuntimeException e) {
                outputView.printError(e);
            }
        }
    }

    private Workers readWorkers() {
        while (true) {
            try {
                String inputWeekdayWorkers = inputView.readWeekdayEmployeeNicknames();
                List<String> weekdayWorkers = Parser.parseWeekdayWorkers(inputWeekdayWorkers);


                String inputHolidayWorkers = inputView.readHolidayEmployeeNicknames();
                List<String> holidayWorkers = Parser.parseHolidayWorkers(inputHolidayWorkers, weekdayWorkers);

                return new Workers(weekdayWorkers, holidayWorkers);
            } catch (RuntimeException e) {
                outputView.printError(e);
            }
        }
    }
}
