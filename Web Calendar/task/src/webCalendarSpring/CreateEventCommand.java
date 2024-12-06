package webCalendarSpring;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record CreateEventCommand(
        @NotNull @NotBlank String event,
        @NotNull @NotBlank @Pattern(regexp = "^([0-9]{4}-[0-9]{2}-[0-9]{2})$") String date
) {
    public Event toEvent() {
        return new Event(
                event(),
                LocalDate.parse(date())
        );
    }
}
