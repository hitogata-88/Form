package com.example.demo.app.inquiry;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class InquiryForm {

	@NotBlank
	@Size(max = 64)
	private String name;
	@NotBlank
	@Size(max = 128)
	@Email
	private String email;
	@NotBlank
	@Size(max = 512)
	private String contents;

	public InquiryForm(String name, String email, String contents) {
		this.name = name;
		this.email = email;
		this.contents = contents;
	}

	public InquiryForm() {
		this("", "", "");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}