package oncall.domain;

public class WorkRecord {

    private final String workerName;
    private final DateInformation dateInformation;

    public WorkRecord(String workerName, DateInformation dateInformation) {
        this.workerName = workerName;
        this.dateInformation = dateInformation;
    }

    public String getWorker() {
        return workerName;
    }

    public String getDayOfTheWeek() {
        return dateInformation.getDayOfTheWeek();
    }

    public boolean isHoliday() {
        return dateInformation.isHoliday();
    }
}
