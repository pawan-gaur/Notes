package com.pgaur.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgaur.notes.model.Notes;

public interface NotesRepository extends JpaRepository<Notes, Integer> {

}
