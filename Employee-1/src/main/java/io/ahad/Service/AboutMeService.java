package io.ahad.Service;

import org.springframework.stereotype.Service;

import io.ahad.Entity.AboutMe;


@Service
public interface AboutMeService {
	public AboutMe add(AboutMe abtMe);
	
}
