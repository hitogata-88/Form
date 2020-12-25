package com.example.demo.domain.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public void create(InquiryForm inquiryForm,Inquiry inquiry) {


		inquiry.setName(inquiryForm.getName());
		inquiry.setEmail(inquiryForm.getEmail());
		inquiry.setContents(inquiryForm.getContents());
		String name = inquiry.getName();
		String email = inquiry.getEmail();
		String contents = inquiry.getContents();


		jdbcTemplate.update("INSERT INTO inquiry (name, email, contents) VALUES (?, ?, ?)",
				name, email, contents);
	}

//	詳細
	@Override
	public Inquiry findById(int id) {
	  Map<String, Object> map = jdbcTemplate.queryForMap("SELECT * FROM inquiry WHERE id = ?", id);
	  Inquiry inquiry = new Inquiry();
	  inquiry.setId((int) map.get("id"));
	  inquiry.setName((String) map.get("name"));
	  inquiry.setEmail((String) map.get("email"));
	  inquiry.setContents((String) map.get("contents"));
	  inquiry.setCreated(((Timestamp) map.get("created")).toLocalDateTime());
	  return inquiry;
	}


//	一覧
	@Override
	public  List<Inquiry> getAll() {
	  List<Inquiry> inquirys = new ArrayList<>();
	  for (Map<String, Object> row : jdbcTemplate.queryForList("SELECT * FROM inquiry ORDER BY id")) {
	    Inquiry inquiry = new Inquiry();
	    inquiry.setId((int) row.get("id"));
	    inquiry.setName((String) row.get("name"));
	    inquiry.setEmail((String) row.get("email"));
	    inquiry.setContents((String) row.get("contents"));
	    inquiry.setCreated(((Timestamp) row.get("created")).toLocalDateTime());
	    inquirys.add(inquiry);
	  }
	  return inquirys;
	}

//	削除
	public void delete(int id) {
	  jdbcTemplate.update("DELETE  FROM inquiry WHERE id = ?", id);
	}
}