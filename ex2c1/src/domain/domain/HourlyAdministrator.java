package domain.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
public class HourlyAdministrator extends Administrator {
    private double hourlyRate;
    private ArrayList<TimeCard> timesCards new ArrayList<TimeCard>();

    public HourlyAdministrator(int personId, String firstName, String lastName, String userName,
                               LocalDateTime birthDate, String ssn, String phone, LocalDateTime employmentStartDate, double hourlyRate) {
        super(personId, firstName, lastName, userName);
        this.birthDate= birthDate;
        this.ssn = ssn;
        this.phone =phone;
        this.employmentStartDate=employmentStartDate;
        this.hourlyRate=hourlyRate;
    }

    public void addTimeCard(LocalDateTime startDateTime, LocalDateTime endDateTime) { this.timeCardId = DbContext.getNextTimeCardId();
        this.timeCardId = DbContext.getNextTimeCardId();
        this.startDateTime=startDateTime;
        this.endDateTime=endDateTime;
    }

    public double calcTotalHours() {
        double totalHours = 0.0;

        return totalHours;
    }
    public double calcGrossPay() {
        return this.calcTotalHours() * this.hourlyRate;
    }



}
