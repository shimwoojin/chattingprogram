package com.swj.Test.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@Slf4j
public class UserController {

  private final UserService userService;

  @PostMapping("/signup")
  public ResponseEntity<Void> signup(UserInfoDto infoDto) { // 회원 추가 submit 버튼 누를 시
	log.info("signup: " + infoDto.toString());
	
	this.userService.save(infoDto);
    
	return ResponseEntity.noContent().build();
  }
  
  @GetMapping("/signup")
  public String signupGet() { // 회원 추가 페이지 접근시
	  log.info("회원 추가 페이지 접근!");
		
    return "signup";
  }
  
  
  @GetMapping(value = "/logout")
  public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
    new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
    return "redirect:/login";
  }
}