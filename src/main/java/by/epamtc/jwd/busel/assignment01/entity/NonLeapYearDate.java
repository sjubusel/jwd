package by.epamtc.jwd.busel.assignment01.entity;

public class NonLeapYearDate {
    private int dayNumber;
    private int monthNumber;

    public NonLeapYearDate() {
    }

    public NonLeapYearDate(int dayNumber, int monthNumber) {
        this.dayNumber = dayNumber;
        this.monthNumber = monthNumber;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }
}
