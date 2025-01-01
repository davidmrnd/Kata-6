package es.ulpgc.dis;

import es.ulpgc.dis.adapters.WorkingDateAdapter;
import es.ulpgc.dis.adapters.WorkingDaysAdapter;
import es.ulpgc.dis.control.CommandFactory;
import es.ulpgc.dis.control.commands.WorkingDateCommand;
import es.ulpgc.dis.control.commands.WorkingDaysCommand;
import es.ulpgc.dis.model.Calendar;
import spark.Request;
import spark.Response;

public class Main {
    public static void main(String[] args) {
        new WebService(
                new CommandFactory()
                        .add("/working-days",(Main::createWorkingDaysCommand))
                        .add("/working-date",(Main::createWorkingDateCommand))
        ).init();
    }

    private static WorkingDateCommand createWorkingDateCommand(Request request, Response response) {
        return new WorkingDateCommand(
                WorkingDateAdapter.adapt(request),
                WorkingDateAdapter.adapt(response),
                new Calendar()
        );
    }

    private static WorkingDaysCommand createWorkingDaysCommand(Request request, Response response) {
        return new WorkingDaysCommand(
                WorkingDaysAdapter.adapt(request),
                WorkingDaysAdapter.adapt(response),
                new Calendar()
        );
    }


}