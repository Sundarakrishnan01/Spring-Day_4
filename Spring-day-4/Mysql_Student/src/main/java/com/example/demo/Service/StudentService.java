package com.example.demo.Service;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository repo;

	public void delStudent(int id) {
		repo.deleteById(id);
	}

	public Student updateStudent(int id, Student obj) {
		Student stud = repo.findById(id).get();
		
		if(Objects.nonNull(stud) && (!(Objects.isNull(obj.getName())))) {
			stud.setName(obj.getName());
		}
		if(Objects.nonNull(stud) && (!(Objects.isNull(obj.getMailid())))) {
			stud.setMailid(obj.getMailid());
		}
		if(Objects.nonNull(stud) && (!Objects.isNull(obj.getDepartmentName()))) {
			stud.setDepartmentName(obj.getDepartmentName());
		}
		if(Objects.nonNull(stud) && (obj.getMark() != 0)) {
			stud.setMark(obj.getMark());
		}
		if(Objects.nonNull(stud) && (obj.getAvg() != 0.0)) {
			stud.setAvg(obj.getAvg());
		}
		return repo.save(stud);
	}
	
//	public List<Student> showStudent() {
//		List<Student> arr = new ArrayList<>();
//		arr = repo.findAll();
//		return arr;
//	}
//	
//	public Student getStudent(Student obj) {
//		return repo.save(obj);
//	}
}
