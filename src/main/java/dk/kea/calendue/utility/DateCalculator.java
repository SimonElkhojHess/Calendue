package dk.kea.calendue.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateCalculator
{
    //Calculates the difference between start and end date on our project
    public static int returnDateDifference(String inputString1, String inputString2)
    {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    LocalDate date1 = LocalDate.parse(inputString1, dtf);
    LocalDate date2 = LocalDate.parse(inputString2, dtf);
    int daysBetween = (int) ChronoUnit.DAYS.between(date1, date2);

    return daysBetween;
    }
}
