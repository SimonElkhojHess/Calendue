package dk.kea.calendue.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class DateCalculator
{
    //Calculates the difference between start and end date on our project
    //Cathes exception for wrong date format.
    public static int returnDateDifference(String inputString1, String inputString2)
    {
        int daysBetween;
        LocalDate date1;
        LocalDate date2;

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            date1 = LocalDate.parse(inputString1, dtf);
            date2 = LocalDate.parse(inputString2, dtf);
        }
        catch(DateTimeParseException e)
        {
            System.out.println("Wrong date format");
            return 0;
        }
        daysBetween = (int) ChronoUnit.DAYS.between(date1, date2);
    return daysBetween;
    }
}
