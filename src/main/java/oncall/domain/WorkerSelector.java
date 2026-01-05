package oncall.domain;

import oncall.dto.Workers;
import oncall.repository.WorkRecordRepository;

public class WorkerSelector {

    private final Workers workers;
    private int weekdayIndex;
    private int holidayIndex;

    public WorkerSelector(Workers workers) {
        this.workers = workers;
        this.weekdayIndex = 0;
        this.holidayIndex = 0;
    }

    public String selectWeekdayWorker(int day) {
        if (WorkRecordRepository.isEmpty()) {
            weekdayIndex++;
            return workers.weekdayWorkers().get(0);
        }
        if (weekdayIndex % workers.weekdayWorkers().size() == 0) {
            weekdayIndex = 0;
        }
        String selectedWorker = workers.weekdayWorkers().get(weekdayIndex);
        if (WorkRecordRepository.findByDay(day-1).getWorker().equals(selectedWorker)) {
            weekdayIndex++;
            selectedWorker = workers.weekdayWorkers().get(weekdayIndex);
        }
        weekdayIndex++;
        return selectedWorker;
    }

    public String selectHolidayWorker(int day) {
        if (WorkRecordRepository.isEmpty()) {
            holidayIndex++;
            return workers.holidayWorkers().get(0);
        }
        if (holidayIndex % workers.holidayWorkers().size() == 0) {
            holidayIndex = 0;
        }
        String selectedWorker = workers.holidayWorkers().get(holidayIndex);
        if (WorkRecordRepository.findByDay(day-1).getWorker().equals(selectedWorker)) {
            holidayIndex++;
            selectedWorker = workers.holidayWorkers().get(holidayIndex);
        }
        holidayIndex++;
        return selectedWorker;
    }
}
