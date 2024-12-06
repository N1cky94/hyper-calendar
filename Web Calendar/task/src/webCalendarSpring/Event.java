package webCalendarSpring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @NotBlank
    private String event;
    @NotNull
    private LocalDate date;

    protected Event() {

    }

    public Event(String event, LocalDate date) {
        this.event = event;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public String getEvent() {
        return event;
    }

    public LocalDate getDate() {
        return date;
    }
}
