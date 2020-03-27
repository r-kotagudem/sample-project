
package com.barryku.springboot.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloWorldController {
 
 @RequestMapping("/")
 public ModelAndView hello(OAuth2AuthenticationToken principal, ModelMap model) {
 
	 String email="";
	 String picture="";
	  if(principal!=null){
	  email=principal.getPrincipal().getAttribute("name");
	  picture=principal.getPrincipal().getAttribute("picture");
	  }
	  model.addAttribute("email", email);
	  model.addAttribute("picture", picture);
  return new ModelAndView("welcome", model);
 }
 
}
