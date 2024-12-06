package webCalendarSpring;

import java.time.LocalDate;

public record DateRange(
        LocalDate start,
        LocalDate end
) {

}
