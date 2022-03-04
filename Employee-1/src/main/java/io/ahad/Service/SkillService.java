package io.ahad.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.ahad.Entity.SkillSet;

@Service
public interface SkillService {
//	 public List<SkillSet> getAll();
//	 public SkillSet add(SkillSet skillSet);
	 public void delete(SkillSet title)throws NotFoundException;
	 SkillSet findById(String title);
    List<SkillSet> add(List<SkillSet> skillSet);

}