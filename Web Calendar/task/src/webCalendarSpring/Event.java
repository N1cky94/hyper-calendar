package webCalendarSpring;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record Event(
        @NotNull @NotBlank String event,
        @NotNull @NotBlank @Pattern(regexp = "^([0-9]{4}-[0-9]{2}-[0-9]{2})$") String date
) {
}