package com.douzone.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.guestbook.dao.GuestbookDao;
import com.douzone.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {
	
	@Autowired
	GuestbookDao guestbookDao;
	
	@RequestMapping({ "", "/list"} )
	public String list(Model model) {
		model.addAttribute("list", guestbookDao.getList());
		
		//forwarding
		return "list";
	}
	
	@RequestMapping("/delete")
	public String delete() {
		
		//forwarding
		return "deleteform";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(GuestbookVo vo) {
		guestbookDao.delete(vo);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(GuestbookVo vo) {
		guestbookDao.insert(vo);
		
		return "redirect:/";
	}
}
