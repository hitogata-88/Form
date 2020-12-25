package com.example.demo.domain.dao;

import java.util.List;

import com.example.demo.app.inquiry.InquiryForm;
import com.example.demo.domain.entity.Inquiry;

public interface InquiryDao {
	void create(InquiryForm inquiryForm ,Inquiry inquiry);

	Inquiry findById(int id);

	List<Inquiry> getAll();

	void delete(int id);
}