package com.soft.sol.notes.app.NotesApp.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="note")
public class NoteDoc {
	@Id
	private String id;
	
	private String note;
	private Date date;
	
	/*public NoteDoc(String note, Date date) {
		this.note = note;
		this.date = date;
	}*/
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
