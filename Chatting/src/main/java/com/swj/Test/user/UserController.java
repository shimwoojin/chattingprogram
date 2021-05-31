package com.swj.Test.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@Slf4j
public class UserController {

  private final UserService userService;

  @RequestMapping("/signup")
  public String signup(UserInfoDto infoDto) { // 회원 추가
	log.info("func call");
	System.out.println("call");
	
    userService.save(infoDto);
    return "signup";
  }
  
  @GetMapping("/signup")
  public String signupGet() { // 회원 추가
    return "signup";
  }
  
  
  @GetMapping(value = "/logout")
  public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
    new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
    return "redirect:/login";
  }
}