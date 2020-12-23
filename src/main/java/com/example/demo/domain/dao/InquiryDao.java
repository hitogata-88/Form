package com.example.demo.domain.dao;

import com.example.demo.app.inquiry.InquiryForm;
import com.example.demo.domain.entity.Inquiry;

public interface InquiryDao {
	  void create(InquiryForm inquiryForm ,Inquiry inquiry);
}