package com.soft.sol.notes.app.beans;

import java.util.ArrayList;
import java.util.List;

public class NotesBeanWrapper {
private List<NotesBean> notesBeanList;

public List<NotesBean> getNotesBeanList() {
	if(notesBeanList == null){
		notesBeanList = new ArrayList<>();
	}
	return notesBeanList;
}


}
