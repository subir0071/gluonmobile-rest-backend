package com.soft.sol.notes.app.NotesApp.service;

import com.soft.sol.notes.app.beans.NotesBean;
import com.soft.sol.notes.app.beans.NotesBeanWrapper;


public interface NotesService {
	public boolean insertNotes(NotesBean notesBean);
	public NotesBeanWrapper retrieveNotesList();
	public void deleteNote(String noteId);
}
