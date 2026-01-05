package oncall.domain;

public class WorkRecord {

    private final String worker;
    private final String dayOfTheWeek;

    public WorkRecord(String worker, String dayOfTheWeek) {
        this.worker = worker;
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public String getWorker() {
        return worker;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }
}
