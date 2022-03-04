package io.ahad.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ahad.Entity.AboutMe;
import io.ahad.Repository.AboutMe_Repo;

@Service
public class AboutMeServiceImpl implements AboutMeService {

	@Autowired
	public AboutMe_Repo repository;
	
	@Override
	public AboutMe add(AboutMe abtMe) {
		return repository.save(abtMe);	
	}
}
