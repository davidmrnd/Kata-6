package es.ulpgc.dis.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

public class Calendar {
    private static final Set<DayOfWeek> workingDays = EnumSet.allOf(DayOfWeek.class);

    public Iterable<LocalDate> from(LocalDate date) {
        return () -> iteratorFrom(date);}

    private Iterator<LocalDate> iteratorFrom(LocalDate date) {
        return new Iterator<LocalDate>() {
            private LocalDate current = date.minusDays(1);

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public LocalDate next() {
                while (true){
                    current = current.plusDays(1);
                    if(isWorkingDate()){
                        return current;
                    }
                }
            }

            private boolean isWorkingDate() {
                return workingDays.contains(current.getDayOfWeek());
            }
        };
}



}
