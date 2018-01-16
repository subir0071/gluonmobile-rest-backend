package com.soft.sol.notes.app.NotesApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.soft.sol.notes.app.NotesApp.model.NoteDoc;

public interface NotesRepository extends MongoRepository<NoteDoc, String>{


}
