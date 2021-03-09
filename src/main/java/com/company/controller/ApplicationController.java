package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import com.company.entity.Data;
import com.company.service.DataService;
import com.company.service.MyUserDetails;

@Controller
public class ApplicationController {
	
	@Autowired
	DataService dataService;
	
	@RequestMapping("/")
	public String viewLoginPage(Model model, @AuthenticationPrincipal MyUserDetails userDetails ) {		
		List<Data> lists = dataService.listAll(userDetails.getId());
		model.addAttribute("lists", lists);
		return "index";
	}
	
	@RequestMapping("/newfile")
	public String viewNewfilePage(Model model) {
		Data data = new Data();
		model.addAttribute("data", data);
		return "new_file";
	}
	
	@RequestMapping(value = "/savefile", method = RequestMethod.POST)
	public String saveData(@RequestParam("files") MultipartFile[] multipartFiles, @AuthenticationPrincipal MyUserDetails userDetails) {
		
		for (int i = 0; i < multipartFiles.length; i++) {
			Data data = new Data();
			data.setDataName(multipartFiles[i].getOriginalFilename());
			data.setUser(userDetails.getUser());
			try {
				dataService.save(data);
				Path uploadPath = Paths.get("C:\\FileUpload\\");
				if (!Files.exists(uploadPath)) {
		            Files.createDirectories(uploadPath);
		        }
				multipartFiles[i].transferTo(new File(uploadPath +"\\"+ multipartFiles[i].getOriginalFilename()));				
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return "redirect:/";
	}
	

	@RequestMapping("/delete/{id}")
	public String deleteData(@PathVariable(name = "id") Integer id) {
		dataService.deleteData(id);
		return "redirect:/";
	}
	
	@GetMapping("/access_denied")
	public String access_denied() {
		return "access_denied";
	}
	
}
