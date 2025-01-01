package es.ulpgc.dis.control;

import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CommandFactory implements Iterable<String>{
    private final Map<String, CommandBuilder> builders;

    public CommandFactory() {
        this.builders = new HashMap<>();
    }

    public CommandFactory add(String name, CommandBuilder builder) {
        builders.put(name, builder);
        return this;
    }

    @Override
    public Iterator<String> iterator() {
        return builders.keySet().iterator();
    }

    public interface CommandBuilder {
        Command build(Request request, Response response);
    }

    public interface Executing{
        Command get(String name);
    }

    public Executing given(Request req, Response res) {
        return name -> builders.get(name).build(req, res);
    }
}
