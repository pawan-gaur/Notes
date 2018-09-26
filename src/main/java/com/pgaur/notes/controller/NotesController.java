package com.pgaur.notes.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pgaur.notes.model.Notes;
import com.pgaur.notes.repository.NotesRepository;

@Controller
public class NotesController {
	
	@Autowired
	private NotesRepository noteRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showPage(Model model,@RequestParam(defaultValue="0") int page) {
		model.addAttribute("data", noteRepository.findAll(new PageRequest(page, 4)));
		model.addAttribute("currentPage", page);
		return "index";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Notes notes) {
		notes.setDoc(new Date());
		noteRepository.save(notes);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Integer id) {
		noteRepository.deleteById(id);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/findOne", method = RequestMethod.GET)
	@ResponseBody
	public Object findOne(Integer id) {
		return noteRepository.findById(id);
	}

}
