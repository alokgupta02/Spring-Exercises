package com.example.DummyPrpject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/dashboard")
	public String a() {
		return "dashboard";
	}
	
	@GetMapping("/orders")
	public String b() {
		return "orders";
	}
	
	@GetMapping("/admin/news")
	public String viewNews(Model model){
		//model.addAttribute("listNews",newsService.getAllNews());
		return "news";
	}
}
