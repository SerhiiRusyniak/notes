package ua.cluster.view;

import ua.cluster.model.Note;

import java.util.Scanner;

public class NoteView {
    public void printNote(Note[] note) {
        for (Note anote: note) {
            System.out.println(anote);
        }
    }

    public Note inputNote() {
        Note note = new Note();

        Scanner input = new Scanner(System.in);
        System.out.println("Input note text:");
        String noteText = input.nextLine();

        System.out.println("Input Label:");
        String labelText = input.nextLine();

        System.out.println("Input is Note complete 1 is complete:");
        String checkedText = input.nextLine();

        // check input if needed

        note.setNote(noteText);
        note.setLabel(labelText);
        note.setChecked("1".equals(checkedText));
        note.setDate("12.12.2020");
        return note;
    }
}
