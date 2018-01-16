package com.soft.sol.notes.app.NotesApp.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.soft.sol.notes.app.NotesApp.model.NoteDoc;
import com.soft.sol.notes.app.beans.NotesBean;
import com.soft.sol.notes.app.beans.NotesBeanWrapper;

@Service
public class NotesMapper {

	
	public NoteDoc convertBeanToDoc(NotesBean notesBean){
		NoteDoc noteDoc = new NoteDoc(/*notesBean.getNote(), notesBean.getDate()*/);
		noteDoc.setNote(notesBean.getNote());
		//noteDoc.setDate(notesBean.getDate());
		return noteDoc;
	}
	
	public NotesBeanWrapper convertNoteDocToNotesBeanList(List<NoteDoc> noteDocList){
		NotesBeanWrapper notesBeanWrapper = new NotesBeanWrapper();
		List<NotesBean> notesBeanList = notesBeanWrapper.getNotesBeanList();
		for(NoteDoc noteDoc : noteDocList){
			notesBeanList.add(convertNoteDocToNotesBean(noteDoc));
		}
		return notesBeanWrapper;
	}
	
	private NotesBean convertNoteDocToNotesBean(NoteDoc noteDoc){
		NotesBean notesBean = new NotesBean();
		notesBean.setId(noteDoc.getId());
		notesBean.setNote(noteDoc.getNote());
		//notesBean.setDate(noteDoc.getDate());
		return notesBean;
	}
}
