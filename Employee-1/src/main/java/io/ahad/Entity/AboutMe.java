package io.ahad.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(
        name = "AboutMe")
public class AboutMe {
			
	 	@Id
	    @Column(
	    		name="Emp_Email"
	    		)
	    private String empEmail;
	 
		    @Column(
		    		name="First_Name"
		    		)
		    
		    private String firstName;
		    
		    @Column(
		    		name="Last_Name"
		    		)
		    private String lastName;
		    
		   
		    
		    @Column(
		    		name="Emp_PhoneNo"
		    		)
		    private long empPhoneNo;
		    
		    @Column(
		    		name="Experience"
		    		)
		    private String  empExp;
		    
		    @Column(
		    		name="NL_Experience"
		    		)
		    private String  empNLExp;
		    
		    @Column(
		    		name="About_Me"
		    		)
		    private String  empAboutMe;
		    
//		    @Column(
//		    		name="Skills"
//		    		)
//		    private ArrayList<String>  empSkills;
		    
		    
		    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		    @JoinTable(name = "user_skills",
		        joinColumns = @JoinColumn(name = "email", referencedColumnName = "Emp_Email"),
		        inverseJoinColumns = @JoinColumn(name = "skills_id", referencedColumnName = "title"))
		    

		    
		    
//		    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
//		    @JoinTable(name = "user_skills",
//		        joinColumns = @JoinColumn(name = "email", referencedColumnName = "Emp_Email"),
//		        inverseJoinColumns = @JoinColumn(name = "skills_id", referencedColumnName = "title"))
//		    
		     private Set<SkillSet> skills;
		    
		    public void addSkills(SkillSet skillSet) {
		        skills.add(skillSet);
		    }

		    public void removeRoles(SkillSet skillSet) {
		        skills.remove(skillSet);
		    }
		    
		    
		    public Set<SkillSet> getSkills() {
				return skills;
			}

			public void setSkills(Set<SkillSet> skills) {
				this.skills = skills;}
			
			public AboutMe() {}

			public AboutMe(String firstName, String lastName, String empEmail, long empPhoneNo, String empExp,
					String empNLExp, String empAboutMe) {
				this.firstName = firstName;
				this.lastName = lastName;
				this.empEmail = empEmail;
				this.empPhoneNo = empPhoneNo;
				this.empExp = empExp;
				this.empNLExp = empNLExp;
				this.empAboutMe = empAboutMe;
			}

			public String getFirstName() {
				return firstName;
			}

			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}

			public String getLastName() {
				return lastName;
			}

			public void setLastName(String lastName) {
				this.lastName = lastName;
			}

			public String getEmpEmail() {
				return empEmail;
			}

			public void setEmpEmail(String empEmail) {
				this.empEmail = empEmail;
			}

			public long getEmpPhoneNo() {
				return empPhoneNo;
			}

			public void setEmpPhoneNo(long empPhoneNo) {
				this.empPhoneNo = empPhoneNo;
			}

			public String getEmpExp() {
				return empExp;
			}

			public void setEmpExp(String empExp) {
				this.empExp = empExp;
			}

			public String getEmpNLExp() {
				return empNLExp;
			}

			public void setEmpNLExp(String empNLExp) {
				this.empNLExp = empNLExp;
			}

			public String getEmpAboutMe() {
				return empAboutMe;
			}

			public void setEmpAboutMe(String empAboutMe) {
				this.empAboutMe = empAboutMe;
			}
			
			
			
//			public void removeSkill(SkillSet skillSet) {
//				this.skills.remove(skillSet);
//			}
			
//		    public void removeSkillSet(SkillSet b) {
//		        skills.remove(b);
//		    }  
		}

