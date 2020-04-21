package ua.cluster;

import ua.cluster.model.Note;

public class RepoSingleton {

    private Note[] notes;

    private static RepoSingleton repoSingleton = new RepoSingleton();

    private RepoSingleton() {
        notes = new Note[100];
        notes[0] = new Note("a test note", "14.04.2020", false, "work");
        notes[1] = new Note("a test note2", "15.04.2020", false, "work");
        notes[2] = new Note("a test note3", "16.04.2020", false, "home");
    }

    public static RepoSingleton getInsance() {
        return repoSingleton;
    }

    public Note[] getNotes() {
        return notes;
    }
}
