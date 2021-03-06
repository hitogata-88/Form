package com.example.demo.app.inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.entity.Inquiry;
import com.example.demo.domain.service.InquiryService;

@SpringBootApplication
@Controller
@RequestMapping("/inquiry")
public class InquiryController {

	@Autowired
	private InquiryService service;

	@GetMapping
	public String form() {
		return "inquiry/index.html";
	}
	@PostMapping("/confirm")
	public String confirm(@Validated InquiryForm inquiryForm, BindingResult result) {
		if (result.hasErrors()) {
			return "inquiry/index.html";
		}
		return "inquiry/confirm.html";
	}
	@PostMapping("/save")
	public String save(@Validated InquiryForm inquiryForm, BindingResult result) {
		if (result.hasErrors()) {
			//TODO Exception
		}
		Inquiry inquiry = new Inquiry();
		service.save(inquiryForm,inquiry);
		return "inquiry/complete.html";
	}

	@GetMapping("/list")
	public String list(Model model) {
	  model.addAttribute("inquirys", service.getAll());
	  return "inquiry/list.html";
	}

	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") int id, Model model) {
	  model.addAttribute("inquiry", service.findById(id));
	  return "inquiry/detail.html";
	}

	@PostMapping("/delete")
	public String detail(@RequestParam("id") int id) {
	  service.delete(id);
	  return "redirect:/inquiry/list";
	}

}