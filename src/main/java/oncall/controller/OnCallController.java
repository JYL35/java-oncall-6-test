package oncall.controller;

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
        // 평일/휴일 비상 근무자 입력 -> 파싱 및 검증
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
}
