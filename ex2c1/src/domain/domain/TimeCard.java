package domain.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeCard {
    private int timeCardId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public TimeCard(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.timeCardId = DbContext.getNextTimeCardId();
        this.startDateTime=startDateTime;
        this.endDateTime=endDateTime;
    }
    private TimeCard(int timeCardId, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.timeCardId = timeCardId;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public TimeCard(TimeCard timeCard) {
        new TimeCard(this.timeCardId, this.startDateTime, this.endDateTime);
    }
    public TimeCard copy() {return new TimeCard(this.timeCardId, this.startDateTime, this.endDateTime); }

    public double calcHours() {
        return startDateTime.until(this.endDateTime, ChronoUnit.MINUTES) /60.0;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mma");
        return "TimeCard{" +
                "timecardId=" + timeCardId +
                ", startDateTime=" + startDateTime.format(formatter) +
                ", endDateTime=" + endDateTime.format(formatter) +
                '}' ;
    }

    public int getTimeCardId() {
        return timeCardId;
    }

    public void setTimeCardId(int timeCardId) {
        this.timeCardId = timeCardId;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }



    }

