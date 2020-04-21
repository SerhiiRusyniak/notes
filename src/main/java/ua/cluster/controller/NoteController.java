package ua.cluster.controller;

import ua.cluster.RepoSingleton;
import ua.cluster.model.Note;
import ua.cluster.view.NoteView;

public class NoteController {
    private String[] commandsList = {"new-note"};


    public NoteController() {
    }

    private void enterNote() {
        Note[] notes = RepoSingleton.getInsance().getNotes();
        NoteView noteView = new NoteView();
        notes[4] = noteView.inputNote();
    }

    public String[] getCommandsList() {
        return commandsList;
    }

    public boolean checkCommand(String command) {
        boolean isExistingComman = false;

        for(String commandStr: commandsList) {
            if (command.equals(commandStr)) {
                isExistingComman = true;
            }
        }

        return  isExistingComman;
    }

    public void doCommand(String command) {
        switch (command) {
            case "new-note":
                enterNote();
                break;
        }
    }
}
