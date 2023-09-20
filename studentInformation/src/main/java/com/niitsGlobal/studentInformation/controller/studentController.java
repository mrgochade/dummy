package com.niitsGlobal.studentInformation.controller;

import java.util.ArrayList;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niitsGlobal.studentInformation.entity.student;

@RestController
public class studentController
{

	
	ArrayList<student>list=new ArrayList<student>();

	
	@RequestMapping("/send")
	public String send()
	{
		return "hello nits Global";
	}
	
	
	@PostMapping("saveStudent")
	public String saveStudent(@RequestBody student stu )
	{
		list.add(stu);
		return "the data successfully saved";
	}
	
	@GetMapping("getAllStudent")
	public  ArrayList<student> getAllStudent()
	{
		System.out.println(list);
		return list;
		
	}
	
	
	@GetMapping("getStudentById/{studentId}")
	public student getStudentById(@PathVariable int studentId)
	{
		student std=null;
		for(student stu:list)
		{
			if(stu.getStudentId()==studentId)
			{
				std=stu;
				break;
			}
		}
		return std;
	}
	
	
	@GetMapping("getStudentByName/{name}")
	public student getStudentByName(@PathVariable String name )
	{
		student std=null;
		for(student stu:list)
		{
			
			if(stu.getStudentName().equals(name))
			{
				std=stu;
				break;
			}
		}
		
		return std;
		
	}
	
	
	
	@PutMapping("updateStudent")
	public String updateStudent(@RequestBody student student)
	{
		String msg="in correct student id";
		for(student stu:list)
		{
			if(stu.getStudentId()==student.getStudentId())
			{
				list.remove(stu);
				list.add(student);
				msg="record update successfully";
				
			}
		}
		
		return msg ;	
	}
	
	
@DeleteMapping("deleteStudent/{studentId}")
public String deleteStudent(@PathVariable int studentId  )
{
	String msg="invalid id";
	
	for(student stu:list)
	{
		if(stu.getStudentId()==studentId)
		{
			list.remove(stu);
		
			msg="record deleted successfully";
			break;
		}
	}
	
	
	
	return msg;
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
