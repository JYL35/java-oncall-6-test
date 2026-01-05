package oncall;

import oncall.controller.OnCallController;
import oncall.service.OnCallService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OnCallController onCallController = new OnCallController(
                new OnCallService(), new InputView(), new OutputView()
        );
        onCallController.start();
    }
}
