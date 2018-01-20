package com.soft.sol.notes.app.NotesApp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soft.sol.notes.app.NotesApp.service.NotesService;
import com.soft.sol.notes.app.beans.NotesBean;
import com.soft.sol.notes.app.beans.NotesBeanWrapper;
import com.soft.sol.notes.app.beans.ResponseBean;

@RestController
@RequestMapping(path = "/note")
public class NotesController {
	private static final Logger LOGGER = LoggerFactory.getLogger(NotesController.class);

	@Autowired
	NotesService notesService;

	@RequestMapping(path = "/insert", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public NotesBean storeNote(@RequestBody NotesBean notesBean) {
		LOGGER.debug("LOGGING WORKING debug");
		notesService.insertNotes(notesBean);
		ResponseBean bean2 = new ResponseBean();
		bean2.setStatus("SUCCESS");
		return notesBean;
	}

	@RequestMapping(path = "/retrieveNoteList", method = RequestMethod.GET)
	public NotesBeanWrapper retrieveNotes() {
		return notesService.retrieveNotesList();
	}
	
	@RequestMapping(path = "/delete", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void deleteNote(NotesBean notesBean) {
		notesService.deleteNote(notesBean.getId());
	}
}
