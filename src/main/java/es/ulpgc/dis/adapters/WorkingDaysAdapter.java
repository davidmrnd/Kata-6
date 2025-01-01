package es.ulpgc.dis.adapters;

import es.ulpgc.dis.control.commands.WorkingDaysCommand;
import spark.Request;
import spark.Response;

import java.time.LocalDate;

public class WorkingDaysAdapter {
    public static WorkingDaysCommand.Input adapt(Request request) {
        return new WorkingDaysCommand.Input() {
            @Override
            public LocalDate startDate() {
                return LocalDate.parse(request.queryParams("startDate"));
            }

            @Override
            public LocalDate endDate() {
                return LocalDate.parse(request.queryParams("endDate"));
            }
        };
    }
    public static WorkingDaysCommand.Output adapt(Response response) {
        return new WorkingDaysCommand.Output() {
            @Override
            public void days(int days) {
                response.body(String.valueOf(days));
            }
        };
    }
}
