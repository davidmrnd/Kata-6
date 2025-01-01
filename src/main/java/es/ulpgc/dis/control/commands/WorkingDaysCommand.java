package es.ulpgc.dis.control.commands;

import es.ulpgc.dis.control.Command;
import es.ulpgc.dis.model.Calendar;

import java.time.LocalDate;

public class WorkingDaysCommand implements Command {
    private final Input input;
    private final Output output;
    private final Calendar calendar;

    public WorkingDaysCommand(Input input, Output output, Calendar calendar) {
        this.input = input;
        this.output = output;
        this.calendar = calendar;
    }

    @Override
    public void execute() {
        int daysWorked = 0;
        for(LocalDate date : calendar.from(input.startDate())){
            if(date.isAfter(input.endDate())){
                break;
            }
            daysWorked++;
        }
        output.days(daysWorked);
    }

    public interface Input{
        LocalDate startDate();
        LocalDate endDate();
    }
    public interface Output{
        void days(int days);
    }
}
