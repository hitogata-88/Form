package com.example.demo.domain.service;

import java.util.List;

import com.example.demo.app.inquiry.InquiryForm;
import com.example.demo.domain.entity.Inquiry;

public interface InquiryService {
	void save(InquiryForm inquiryForm,Inquiry inquiry);

	List<Inquiry> getAll();

	Inquiry findById(int id);

	void delete(int id);
}