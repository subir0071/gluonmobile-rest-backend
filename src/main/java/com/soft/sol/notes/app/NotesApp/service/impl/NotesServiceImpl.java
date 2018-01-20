package com.soft.sol.notes.app.NotesApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.sol.notes.app.NotesApp.mapper.NotesMapper;
import com.soft.sol.notes.app.NotesApp.model.NoteDoc;
import com.soft.sol.notes.app.NotesApp.repository.NotesRepository;
import com.soft.sol.notes.app.NotesApp.service.NotesService;
import com.soft.sol.notes.app.beans.NotesBean;
import com.soft.sol.notes.app.beans.NotesBeanWrapper;

@Service
public class NotesServiceImpl implements NotesService {

	@Autowired
	NotesRepository notesRepository;
	
	@Autowired
	NotesMapper notesMapper;

	@Override
	public boolean insertNotes(NotesBean notesBean) {
		notesMapper.convertBeanToDoc(notesBean);
		//notesBean.setDate(new Date());
		NoteDoc noteDoc = notesRepository.insert(notesMapper.convertBeanToDoc(notesBean));
		return true;
	}
	public NotesBeanWrapper retrieveNotesList(){
		List<NoteDoc> noteDocList = notesRepository.findAll();
		NotesBeanWrapper notesBeanWrapper = notesMapper.convertNoteDocToNotesBeanList(noteDocList);
		return notesBeanWrapper;
	}
	
	public void deleteNote(String noteId){
		NoteDoc noteDoc = new NoteDoc();
		noteDoc = notesRepository.findOne(noteId);
		notesRepository.delete(noteDoc);
		System.out.println("Done");
	}
}
