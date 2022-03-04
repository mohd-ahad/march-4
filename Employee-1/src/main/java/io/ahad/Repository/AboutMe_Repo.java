package io.ahad.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import io.ahad.Entity.AboutMe;
import io.ahad.Service.NotFoundException;

@Repository
public interface AboutMe_Repo extends JpaRepository<AboutMe, String>{
	
	@Query(value="DELETE FROM skills WHERE title=?1",nativeQuery=true)
	void deleteByTitle(String title)throws NotFoundException;
}
