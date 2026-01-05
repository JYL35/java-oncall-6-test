package oncall.service;

import java.util.List;
import oncall.domain.Calendar;
import oncall.domain.DateInformation;
import oncall.domain.DayOfTheWeek;
import oncall.domain.Holiday;
import oncall.domain.WorkRecord;
import oncall.domain.WorkerSelector;
import oncall.dto.StartOption;
import oncall.dto.Workers;
import oncall.repository.WorkRecordRepository;

public class OnCallService {
    private static final List<String> WEEKEND = List.of("토", "일");

    private final WorkerSelector workerSelector;

    public OnCallService(WorkerSelector workerSelector) {
        this.workerSelector = workerSelector;
    }

    public void createWorkSheet(StartOption startOption, Workers workers) {
        int month = startOption.month();
        String dayOfTheWeek = startOption.dayOfTheWeek();
        WorkRecordRepository.addWorkRecord(1, selectWorker(month, 1, dayOfTheWeek));

        int lastDay = Calendar.lastDayOfMonth(startOption.month());
        for (int day = 2; day <= lastDay; day++) {
            dayOfTheWeek = DayOfTheWeek.findNextDayOfTheWeek(dayOfTheWeek);
            WorkRecordRepository.addWorkRecord(day, selectWorker(month, day, dayOfTheWeek));
        }
    }

    private WorkRecord selectWorker(int month, int day, String dayOfTheWeek) {
        if (WEEKEND.contains(dayOfTheWeek) || Holiday.isExist(month, day)) {
            return new WorkRecord(workerSelector.selectHolidayWorker(day), new DateInformation(dayOfTheWeek, true));
        }
        return new WorkRecord(workerSelector.selectHolidayWorker(day), new DateInformation(dayOfTheWeek, false));
    }
}
