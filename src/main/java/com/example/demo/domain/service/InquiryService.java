package com.example.demo.domain.service;

import com.example.demo.app.inquiry.InquiryForm;
import com.example.demo.domain.entity.Inquiry;

public interface InquiryService {
	void save(InquiryForm inquiryForm,Inquiry inquiry);
}