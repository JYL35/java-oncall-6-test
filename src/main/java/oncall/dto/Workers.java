package oncall.dto;

import java.util.List;

public record Workers(
        List<String> weekdayWorkers,
        List<String> holidayWorkers
) {
}
