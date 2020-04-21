package ua.cluster;

import ua.cluster.controller.NoteController;
import ua.cluster.model.Note;
import ua.cluster.view.NoteView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String command = "";

        System.out.println("Enter email please:");
        String email = input.nextLine();
        if (!checkEmail(email)) {
            System.out.println("Invalid email");
            return;
        }

        NoteController noteController = new NoteController();

        RepoSingleton repoSingleton = RepoSingleton.getInsance();

        // test case
        Note[] notes = repoSingleton.getNotes();

        System.out.println("Hello, let`s use notes");
        while (true) {
            System.out.println("Input command:");
            command = input.nextLine();

            command = command.toLowerCase().trim();
            switch (command) {
                case "exit":
                    System.out.println("Buy Buy");
                    System.exit(0);
                case "all":
                    NoteView noteView = new NoteView();
                    noteView.printNote(notes);
                    break;
                default:

                    if(noteController.checkCommand(command)) {
                        noteController.doCommand(command);
                        break;
                    }

                    System.out.println("All commands");
                    System.out.println("exit");
                    System.out.println("all");
                    for(String commandStr: noteController.getCommandsList()) {
                        System.out.println(commandStr);
                    }
            }
        }
    }

    private static boolean checkEmail(String email) {
        return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }
}
