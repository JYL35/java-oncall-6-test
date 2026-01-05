package oncall.repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import oncall.domain.WorkRecord;

public class WorkRecordRepository {
    private static final Map<Integer, WorkRecord> workRecords = new HashMap<>();

    public static Map<Integer, WorkRecord> workRecords() {
        return Collections.unmodifiableMap(workRecords);
    }

    public static void addWorkRecord(int day, WorkRecord workRecord) {
        workRecords.put(day, workRecord);
    }

    public static WorkRecord deleteWorkRecord(int day) {
        return workRecords.remove(day);
    }

    public static void deleteAll() {
        workRecords.clear();
    }

    public static WorkRecord findByDay(int day) {
        if (workRecords.containsKey(day)) {
            return workRecords.get(day);
        }
        throw new IllegalArgumentException("해당 날짜의 업무 기록이 없습니다.");
    }

    public static boolean isEmpty() {
        return workRecords.isEmpty();
    }
}
