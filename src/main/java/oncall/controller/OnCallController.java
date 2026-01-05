package oncall.controller;

import java.util.List;
import java.util.Map;
import oncall.dto.StartOption;
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
        Map<String, List<String>> workers = readWorkers();

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

    private Map<String, List<String>> readWorkers() {
        while (true) {
            try {
                String inputWeekdayWorkers = inputView.readWeekdayEmployeeNicknames();
                List<String> weekdayWokers = Parser.parseWeekdayWorkers(inputWeekdayWorkers);

                // 주말 근무자 입력, 파싱, 검증
            } catch (RuntimeException e) {
                outputView.printError(e);
            }
        }
    }
}
