package com.example.demo.Controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	
	@Autowired
	StudentService studserv;
	
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> delStudent(@PathVariable int id){
		studserv.delStudent(id);
		return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	
	public Student updateStudent(@PathVariable("id") int id, @RequestBody Student obj){
		return studserv.updateStudent(id, obj);
	}
	
//	@GetMapping("/show")
//	public List<Student> showStudent(){
//		return studserv.showStudent();
//	}
//	
//	@PostMapping("/add")
//	public Student getStudent(@RequestBody Student obj){
//		return studserv.getStudent(obj);
//	}
}
