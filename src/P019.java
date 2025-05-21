public final class P019 implements Solution {


    public static void main(String[] args) {
        System.out.println(new P019().run());
    }

    public String run() {
        int year = 1900;
        int dayOfMonth = 1; // 1 based
        int month = 0; // 0 based
        WeekDay dayOfWeek = WeekDay.MONDAY;

        int counter = 0;

        while (year <= 2000) {
            dayOfMonth++;
            dayOfWeek = WeekDay.values()[(dayOfWeek.ordinal() + 1)%7];

            if (dayOfMonth > getDayInMonth(month, year)) {
                dayOfMonth = dayOfMonth%getDayInMonth(month, year);
                month++;
            }

            if (month > 11) {
                month = month%12;
                year++;
            }

            if (year >= 1901 && year <= 2000) {
                if (dayOfMonth == 1 && dayOfWeek == WeekDay.SUNDAY) {
                    counter++;
                }
            }
        }

        return Integer.toString(counter);
    }

    public enum WeekDay {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY;
    }

    public int getDayInMonth(int month, int year) {
        if (month == 3 || month == 5 || month == 8 || month == 10) {
            return 30;
        }
        if (month == 1) {
            if (UtilLibrary.isLeapYear(year)) {
                return 29;
            }
            else {
                return 28;
            }
        }
        return 31;
    }
}
