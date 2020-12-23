package com.example.demo.domain.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.app.inquiry.InquiryForm;
import com.example.demo.domain.dao.InquiryDao;
import com.example.demo.domain.entity.Inquiry;

@Repository
public class InquiryDaoImpl implements InquiryDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public InquiryDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void create(InquiryForm inquiryForm,Inquiry inqiry) {


		String name = inquiryForm.getName();
		String email = inquiryForm.getEmail();
		String contents = inquiryForm.getContents();
//		String name = "name";
//		String email = "email";
//		String contents = "Contents";


		jdbcTemplate.update("INSERT INTO inquiry (name, email, contents) VALUES (?, ?, ?)",
				name, email, contents);
	}
}