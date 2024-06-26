package com.examples.counter.mvc;

import com.jbroadcast.mvc.model.Model;

public class CounterModel extends Model<Integer> implements ICounter {

    public static final String INCREMENT_COMMAND = "increment";

    @Override
    public void evaluateCommand(final String aCommand) {
        super.evaluateCommand(aCommand);
        if (INCREMENT_COMMAND.equals(aCommand)) {
            this.increment();
        }
    }

    @Override
    public void increment() {
        super.setResult(this.getResult() + 1);
    }
}
