package emp.portal;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JacksonException;

import emp.portal.entity.AboutMe;
import emp.portal.entity.Employee;
import emp.portal.entity.SkillSet;
import emp.portal.repository.AboutMe_Repo;
import emp.portal.repository.Emp_Direct_Repo;
import emp.portal.repository.SkillSet_Repo;
import emp.portal.service.AboutMePojo;
import emp.portal.service.AboutMeService;
import emp.portal.service.AppConstants;
import emp.portal.service.Emp_Service;
import emp.portal.service.NotFoundException;
import emp.portal.service.SkillService;

//@RestController
//@RequestMapping("/emp")
//public class Emp_Controller {
//
//	
//	    @Autowired
//	    private Emp_Service service;
//	    
//	    @Autowired
//	    private Emp_Direct_Repo repository;
//
//	    
////	    @GetMapping
////	    public List<Employee> getAll(){
////	        return this.service.getAll();
////	    }
//	        
////	    @GetMapping("/name/{name}")
////	      public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable("name") String name)throws NotFoundException{
////	      List<Employee> response=service.findAllByName(name);
////          return ResponseEntity.ok(response);
////	    }
////	    
////	    @GetMapping("/id/{id}")
////	      public ResponseEntity<List<Employee>> getEmployeeById(@PathVariable("id") long id)throws NotFoundException{
////	 List<Employee> response=repository.findAllById(id);
////	    return ResponseEntity.ok(response);
////	    }
//
//	    
//	    @GetMapping
//	    //("/pagination/{offset}/{pageSize}")
//	    private List<Employee> getEmployeesWithPagination(
//	    		@RequestParam(value = "offset", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int offset,
//	            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int pageSize) {
//	        Page<Employee> employeesWithPagination = service.findEmployeeWithPagination(offset, pageSize);
//	        List<Employee> emp=employeesWithPagination.getContent();
//	        return  emp;
//	    }
//	    @GetMapping("/name/{name}")
//	    //("/pagination/{offset}/{pageSize}")
//	    private ResponseEntity<List<Employee>> getNewEmployeesWithPagination(@PathVariable("name") String name,
//	    		@RequestParam(value = "offset", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int offset,
//	            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int pageSize)throws NotFoundException
//	    {
//	        Page<Employee> employeesWithPagination = service.findNewEmployeeWithPagination(name,offset, pageSize);
//	        List<Employee> emp=employeesWithPagination.getContent();
//	        if(CollectionUtils.isEmpty(emp)){
//	            throw new NotFoundException("Name", "name", name);
//	 			}
//	        return ResponseEntity.ok(emp); 
//	    }
//	    @GetMapping("/id/{id}")
//	    //("/pagination/{offset}/{pageSize}")
//	    private ResponseEntity<List<Employee>> getIdEmployeesWithPagination(@PathVariable("id") int id,
//	    		@RequestParam(value = "offset", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int offset,
//	            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int pageSize)throws NotFoundException
//	    {
//	        Page<Employee> employeesWithPagination = service.findIdEmployeeWithPagination(id,offset, pageSize);
//	        List<Employee> emp=employeesWithPagination.getContent();
//	        String idString=Integer.toString(id);
//	        if(CollectionUtils.isEmpty(emp)){
//	            throw new NotFoundException("Id", "emp_id",idString);
//	 			}
//	        return ResponseEntity.ok(emp);
//	    }
//	    
//	    @PostMapping("/add")
//	    public Employee addEmployee(@RequestBody Employee employee){
//	        return this.service.add(employee);
//	    }
//	    
//	    @DeleteMapping("/id/{id}")
//	    public  void delete(@PathVariable("id") long id){
//	        this.service.delete(id);
//	    }
//	    
//}


@CrossOrigin
@RestController
@RequestMapping("/emp")
public class Emp_Controller {

	
	    @Autowired
	    private Emp_Service service;
	    
	    @Autowired
	    private Emp_Direct_Repo repository;
	    
	    @Autowired
	    private SkillService skillService;
	    
	    @Autowired
	    private SkillSet_Repo skillRepository;
	    
	    
	    @Autowired
	    private AboutMeService abtService;
	    
	    @Autowired
	    private AboutMe_Repo abtrepository;


	    
//	    @GetMapping
//	    public List<Employee> getAll(){
//	        return this.service.getAll();
//	    }
	        
//	    @GetMapping("/name/{name}")
//	      public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable("name") String name)throws NotFoundException{
//	      List<Employee> response=service.findAllByName(name);
//          return ResponseEntity.ok(response);
//	    }
//	    
//	    @GetMapping("/id/{id}")
//	      public ResponseEntity<List<Employee>> getEmployeeById(@PathVariable("id") long id)throws NotFoundException{
//	 List<Employee> response=repository.findAllById(id);
//	    return ResponseEntity.ok(response);
//	    }

	    
	    @GetMapping
	    //("/pagination/{offset}/{pageSize}")
	    private List<Employee> getEmployeesWithPagination(
	    		@RequestParam(value = "offset", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int offset,
	            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int pageSize) {
	        Page<Employee> employeesWithPagination = service.findEmployeeWithPagination(offset, pageSize);
	        List<Employee> emp=employeesWithPagination.getContent();
	        return  emp;
	    }
	    @GetMapping("/name/{name}")
	    //("/pagination/{offset}/{pageSize}")
	    private ResponseEntity<List<Employee>> getNewEmployeesWithPagination(@PathVariable("name") String name,
	    		@RequestParam(value = "offset", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int offset,
	            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int pageSize)throws NotFoundException
	    {
	        Page<Employee> employeesWithPagination = service.findNewEmployeeWithPagination(name,offset, pageSize);
	        List<Employee> emp=employeesWithPagination.getContent();
	        if(CollectionUtils.isEmpty(emp)){
	            throw new NotFoundException("Name", "name", name);
	 			}
	        return ResponseEntity.ok(emp); 
	    }
	    @GetMapping("/id/{id}")
	    //("/pagination/{offset}/{pageSize}")
	    private ResponseEntity<List<Employee>> getIdEmployeesWithPagination(@PathVariable("id") int id,
	    		@RequestParam(value = "offset", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int offset,
	            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int pageSize)throws NotFoundException
	    {
	        Page<Employee> employeesWithPagination = service.findIdEmployeeWithPagination(id,offset, pageSize);
	        List<Employee> emp=employeesWithPagination.getContent();
	        String idString=Integer.toString(id);
	        if(CollectionUtils.isEmpty(emp)){
	            throw new NotFoundException("Id", "emp_id",idString);
	 			}
	        return ResponseEntity.ok(emp);
	    }
	    
	    /*-----------------EMP-DIR-HR---------------------------*/
	    
	    @PostMapping("/add")
	    public Employee addEmployee(@RequestBody Employee employee){
	        return this.service.add(employee);
	    }
	    
	    @DeleteMapping("/id/{id}")
	    public  void delete(@PathVariable("id") long id){
	        this.service.delete(id);
	    }
	    
	    
	    /*----------------- SKILLS---------------------------*/
	    
//	    @GetMapping("/skill")
//	    public List<SkillSet> getAll(){
//	        return skillService.getAll();
//	    }
//	    @PostMapping("/skill/add")
//	    public SkillSet addSkill(@RequestBody SkillSet skillSet){
//	        return this.skillService.add(skillSet);
//	    }
//	    @DeleteMapping("/skill/{title}")
//	    public  void delete(@PathVariable("title") String title){
//	        this.skillService.delete(title);
//	    }
//	    @GetMapping("/skill/{title}")
//	    public SkillSet findByTitle(@PathVariable("title") String title)throws NotFoundException{
//	    	if(skillRepository.findById(title)==null)
//	    		throw new NotFoundException("title", "title",title);
//	        return skillService.findById(title);
//	    }
	    
	    /*----------------ABOUTME---------------------------*/
//	    @PostMapping("/aboutme")
//	    public AboutMe addAboutMe(@RequestBody AboutMe aboutMe) {
//	    	return this.abtService.add(aboutMe);
//	    }
	    
	    
	    @PostMapping("/aboutme")
	    public ResponseEntity<AboutMePojo> addAboutMe(@RequestBody AboutMe aboutMe)
	    throws JacksonException{
	    	
	    	AboutMePojo response;
	    	try {
	    		return new ResponseEntity<>(new AboutMePojo(true,this.abtService.add(aboutMe),"OK"),HttpStatus.OK);
	    	}catch(Error e) {
	    	return new ResponseEntity<>(new AboutMePojo(false,null,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	    }

	    
	    @PostMapping("/aboutme/skills")
	    public AboutMe addskillAboutMe(@RequestBody Set<SkillSet> skill) {
	    	AboutMe abt=new AboutMe();
	    	abt.setSkills(skill);
	    	//abtrepository.save(abt);
	    	return abt;
	    }
	    
	    @GetMapping("/skills/{title}")
	    public SkillSet searchSkill(@PathVariable String title) {
	    	return skillService.findById(title);
	    }
	    
	    /*------------------HR ADD SKILL---------------------*/
	    @PostMapping("/skills")
	    public List<SkillSet> postSkill(@RequestBody List<SkillSet> skill) {
	    	return this.skillService.add(skill);    	
	    }
	    
	    /*------------------HR DELETE SKILL---------------------*/
	    @DeleteMapping("/skills/{title}")
	    public void deleteSkill(@PathVariable("title") SkillSet title) {
//	    	AboutMe abt=new AboutMe();
//	    	abt.getSkills().remove(title);
////	    	for (SkillSet name :abt.getSkills()) {
////	    	    if(name.toString().equals(title))
////	    	    
////	    
	    	List<AboutMe> abt=abtrepository.findAll();
	    	for (AboutMe i :abt) {
	    		if(i.getSkills().contains(title))
	    			i.removeRoles(title);
	    	}
	    	this.skillService.delete(title);   
	    //	abtrepository.deleteByTitle(title);
	    	  	
	    }
	    
	    
	    /*----------------------GET PART.Empl--------------------*/
	    @GetMapping("/aboutme/{email}")
	    public AboutMe getAboutMe(@PathVariable("email") String email) {
	    	AboutMe abt=abtrepository.findById(email).get();
	    	return abt;
	    }
	    
	    @GetMapping("/aboutme/search/{title}")
	    public SkillSet getSkills(@PathVariable("title") String title) {
	    SkillSet skills=skillRepository.findByTitle(title);
		return skills;     
	    }
	    /*------------3rdMarch------------------*/
	    @GetMapping("aboutme/skills")
	    public List<SkillSet> getAllSkillsForEmployee(){
	    	List<SkillSet> skills=skillRepository.findAll();
	    	return skills;
	    }
	    
}





















