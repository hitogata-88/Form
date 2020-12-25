package com.example.demo.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.app.inquiry.InquiryForm;
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
  public void save(InquiryForm inquiryForm ,Inquiry inquiry) {
    dao.create(inquiryForm,inquiry);
  }
  @Override
  public List<Inquiry> getAll() {
    return dao.getAll();
  }

  @Override
  public Inquiry findById(int id) {
    return dao.findById(id);
  }

  @Override
  public void delete(int id) {
    dao.delete(id);
  }

}