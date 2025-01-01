package es.ulpgc.dis.adapters;

import es.ulpgc.dis.control.commands.WorkingDateCommand;
import spark.Request;
import spark.Response;

import java.time.LocalDate;

public class WorkingDateAdapter {
    public static WorkingDateCommand.Input adapt(Request request) {
        return new WorkingDateCommand.Input() {
            @Override
            public LocalDate startDate() {
                return LocalDate.parse(request.queryParams("startDate"));
            }

            @Override
            public int workDays() {
                return Integer.parseInt(request.queryParams("workDays"));
            }
        };
    }
    public static WorkingDateCommand.Output adapt(Response response) {
        return new WorkingDateCommand.Output() {
            @Override
            public void end(LocalDate date) {
                response.body(date.toString());
            }
        };
    }
}