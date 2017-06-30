package com.spring.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.FileUpload;

@Controller
public class MultipleFileUplaodController {

	private static final String UPLOAD_DIRECTORY ="C://Images//";
	
	
	@RequestMapping(method=RequestMethod.GET,value="indexa")
	public String registerPage(ModelMap model)
	{
		model.addAttribute("uploadFile", new FileUpload());
		return "uploadFileIndex";
	}
	
	//@RequestParam("fileName")CommonsMultipartFile file //this is for single file
	
	@RequestMapping(value="uploada",method=RequestMethod.POST)  
    public ModelAndView saveimage(@RequestParam("fileName")MultipartFile[] files,  
           HttpSession session) throws Exception{  
  
		for (MultipartFile  file : files) 
		{
				try {
					byte[] bytes = file.getBytes();
					Path path1 = Paths.get(UPLOAD_DIRECTORY + file.getOriginalFilename());
					Files.write(path1, bytes);
					System.out.println("path..="+path1);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}

        
    ModelAndView modelAndView =new ModelAndView("uploadFileIndex");
    		modelAndView.addObject("uploadFile", new FileUpload());
    return modelAndView;  
    }  
	
	
	}
