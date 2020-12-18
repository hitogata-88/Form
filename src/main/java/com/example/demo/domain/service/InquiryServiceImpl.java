package com.example.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.dao.InquiryDao;
import com.example.demo.domain.entity.Inquiry;

@Service
public class InquiryServiceImpl implements InquiryService {

  private InquiryDao dao;

  @Autowired
  public InquiryServiceImpl(InquiryDao dao) {
    this.dao = dao;
  }

  @Override
  public void save(Inquiry inquiry) {
    dao.create(inquiry);
  }
}