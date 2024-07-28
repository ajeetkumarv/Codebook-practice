package code.example.stream;

import java.util.ArrayList;
import java.util.List;

public class TimeSlotExample {
    public static void main(String[] args) {
        class TimeSlot {
            TimeSlot() {}

            boolean isAvailable() {
                return false; // just a placeholder
            }
            void schedule() {}
        }

        List<TimeSlot> timeSlots = new ArrayList<>();
        //assume some timeSlots added

        TimeSlot latestAvailableTimeSlot = timeSlots
                .stream()
                // this doesn't take every row and apply filter before proceeding
                // rather it takes an element and walk every operation in stream
                // this is counter-intuitive at first sight
                // so not all elements in collection are filtered, rather it is stopped at
                // first found of all down-streamed operations
                .filter(TimeSlot::isAvailable)
                .findFirst()
                .orElse(new TimeSlot()); // assume this is business logic

        latestAvailableTimeSlot.schedule();
    }
}
