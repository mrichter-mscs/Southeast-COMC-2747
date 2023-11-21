package domain.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContractAdministrator extends Administrator {
    private double monthlyRate;


    public ContractAdministrator(int personId, String firstName, String lastName, String userName,
                                 LocalDateTime birthDate, String ssn, String phone,
                                 LocalDateTime employmentStartDate, double monthlyRate) {
        super(personId, firstName, lastName, userName);
        this.birthDate= birthDate;
        this.ssn = ssn;
        this.phone =phone;
        this.employmentStartDate=employmentStartDate;
        this.monthlyRate=monthlyRate;

    }


    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return "ContractAdministrator{" +
                "monthlyRate=" + monthlyRate +
                ", birthDate=" + birthDate.format(formatter) +
                ", ssn='" + ssn + '\'' +
                ", phone='" + phone + '\'' +
                ", employmentStartDate=" + employmentStartDate.format(formatter) +
                '}';
    }

    public double getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(double monthlyRate) {
        this.monthlyRate = monthlyRate;
    }
    public double calcGrossPay() {
        return this.monthlyRate;
    }
}