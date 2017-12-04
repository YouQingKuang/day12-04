package com.exampl.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exampl.entity.User;

@Controller
//@RestController
class FirstController {

		@RequestMapping(value="getData1", method=RequestMethod.GET)
		public String getData1(@RequestParam String name,@RequestParam String pwd,Model model) {
			System.out.println(name);
			System.out.println(pwd);
			model.addAttribute("name",name);
			model.addAttribute("pwd",pwd);
			return "getData";
		}
		
		@RequestMapping(value="getData2")
		public String getData2(@RequestParam(value="name",defaultValue="1",required=true) String nana,
								@RequestParam(value="pwd",defaultValue="1",required=true) String pwd) {
			System.out.println(nana);
			System.out.println(pwd);
			return "getData";
		}
		
		@RequestMapping(value="getData3")
		public String getData3(HttpServletRequest request) {
			String name = request.getParameter("name");
			System.out.println(name);
			String pwd = request.getParameter("pwd");
			System.out.println(pwd);
			return "getData";
		}
		
		@RequestMapping(value="getData4")
		public String getData4(@RequestParam Map<String,String> map) {
			
			Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<String, String> next = iterator.next();
				System.out.print("key = "+next.getKey());
				System.out.println(",  value = "+next.getValue());
			}
			return "getData";
		}
		
		@RequestMapping(value="getData5")
		public String getData5(@ModelAttribute("User") User user,Model model) {
			System.out.println(user);
			model.addAttribute("user",user);
			return "getData";
		}
		
		@RequestMapping(value="getData6")
		public String getData6(@RequestHeader("User-Agent") String userAgent,
							   @RequestHeader("Accept-Encoding") String encoding,
							   @RequestHeader("name") String name,
							   HttpServletRequest request) {
			
			System.out.println(userAgent);
			System.out.println(encoding);
			System.out.println(name);
			System.out.println("-------------------------");
			System.out.println(request.getHeader("User-Agent"));
			System.out.println(request.getHeader("name"));
			return "getData";
			
		}
		
		@RequestMapping(value="getData7/{name}/{pwd}")
		public String getData7(@PathVariable("name") String name,
							   @PathVariable("pwd") String pwd) {
			System.out.println(name);
			System.out.println(pwd);
			return "getData";
		}
		
		@RequestMapping(value="getData8")
		public String getData8(@RequestParam String name,@RequestParam String pwd,Model model) {
			model.addAttribute("name",name);
			model.addAttribute("pwd",pwd);
			return "getData";
		}
		
		@RequestMapping(value="getData9")
		public String getData9(RedirectAttributes reA,Model model,@RequestParam String name,@RequestParam String pwd) {
			reA.addAttribute("name",name);
			reA.addFlashAttribute("pwd",pwd);
			return "redirect:getData1";
		}
		
		@RequestMapping(value="getData10")
		public String getData10(Model model,@RequestParam String name,@RequestParam String pwd) {
//			model.addAttribute("name",name);
//			model.addAttribute("pwd",pwd);
			return "forward:getData1";
		}
		
		@RequestMapping(value="getData11")
		@ResponseBody
		public User getData11(@ModelAttribute("User") User user,Model model) {
			return user;
		}
		
		@RequestMapping(value="getData12")
		@ResponseBody
		public Map getData12(@RequestParam Map<String,String> map) {
			
			Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<String, String> next = iterator.next();
				System.out.print("key = "+next.getKey());
				System.out.println(",  value = "+next.getValue());
			}
			return map;
		}
		
		@RequestMapping(value="homework1")
		@ResponseBody
		public String homeWork1(@RequestParam String jsonStr) {
			
//			JSONObject jsonObject = JSONObject.fromObject(jsonStr);
			
//			JSONObject jsonObject=JSONObject.fromObject(objectStr);
//			Student stu=(Student)JSONObject.toBean(jsonObject, Student.class);
			
			return "";
		}
		
		
}
