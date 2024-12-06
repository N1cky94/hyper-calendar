package webCalendarSpring;

public record EventCreatedDto(String message, String event, String date) {
    public static EventCreatedDto from(Event event) {
        return new EventCreatedDto(
                "The event has been added!",
                event.event(),
                event.date()
        );
    }
}
