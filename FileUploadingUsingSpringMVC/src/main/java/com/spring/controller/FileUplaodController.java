package com.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.FileUpload;

@Controller
public class FileUplaodController {

	private static final String UPLOAD_DIRECTORY = "D://JarvisData//EclipsSpringMaven//.metadata//.plugins//org.eclipse.wst.server.core//tmp1//wtpwebapps//FileUploadingUsingSpringMVC//Images//";
	//private static final String UPLOAD_DIRECTORY = "D://JarvisData//EclipsSpringMaven//FileUploadingUsingSpringMVC//src//main//webapp//Images//";
	List<String> images =null; 
	

	@RequestMapping(method = RequestMethod.GET, value = "index")
	public String registerPage(ModelMap model) {
		
		model.addAttribute("uploadFile", new FileUpload());
		return "uploadFileIndex";
	}

	// @RequestParam("fileName")CommonsMultipartFile file //this is for single
	// file

	
	@RequestMapping(value = {"upload"})
	public ModelAndView saveimage(@ModelAttribute @Valid FileUpload fileupload,BindingResult result) throws Exception 
	{
	
		images =new ArrayList<String>();
		if (result.hasErrors()) {
			System.out.println("ERROR");
			return new ModelAndView("uploadFileIndex");
		}

		System.out.println(fileupload.getFileName());
		
		CommonsMultipartFile[] file = fileupload.getFileup();
		
		
		for (CommonsMultipartFile commonsMultipartFile : file) {
			
			System.out.println("file name :"+commonsMultipartFile.getOriginalFilename());
			
			byte[] bytes = commonsMultipartFile.getBytes();
			Path path1= Paths.get(UPLOAD_DIRECTORY + commonsMultipartFile.getOriginalFilename());
			Files.write(path1, bytes);
			
			System.out.println("path..=" + path1);
			System.out.println("path..=" + path1.getFileName());
			
			images.add(commonsMultipartFile.getOriginalFilename());
		}
		

		ModelAndView modelAndView = new ModelAndView("showImage");
		
		modelAndView.addObject("uploadFileName", images);
		
		return modelAndView;
	}

}
