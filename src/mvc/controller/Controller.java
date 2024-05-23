package src.mvc.controller;

import src.mvc.model.IModel;
import src.utils.Tracer;

import java.util.Scanner;

public class Controller implements IController {

    private final IModel model;

    public Controller(final IModel aModel) {
        this.model = aModel;
    }

    @Override
    public void processCommands() {
        final Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter a command: ");
            final String userInput = scanner.nextLine().toLowerCase();
            if (Tracer.QUIT.equals(userInput)) {
                try {
                    this.model.terminate();
                    System.out.println(Tracer.TERMINATE);
                    break;
                } catch (final Exception e) {
                    throw new RuntimeException(e);
                }
            }

            try {
                this.model.setCommand(userInput);
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        }
        scanner.close();
    }
}
