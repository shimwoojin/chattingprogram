package com.swj.Test.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Component
public class UserService implements UserDetailsService {

  @Autowired
	private final UserRepository userRepository;

  /**
   * Spring Security 필수 메소드 구현
   *
   * @param email 이메일
   * @return UserDetails
   * @throws UsernameNotFoundException 유저가 없을 때 예외 발생
   */
  @Override // 기본적인 반환 타입은 UserDetails, UserDetails를 상속받은 UserInfo로 반환 타입 지정 (자동으로 다운 캐스팅됨)
  @Transactional
  public UserInfo loadUserByUsername(String email) throws UsernameNotFoundException { // 시큐리티에서 지정한 서비스이기 때문에 이 메소드를 필수로 구현
    return userRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException((email)));
  }
  
  @Transactional
  public Long save(UserInfoDto infoDto) {
	    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	    infoDto.setPassword(encoder.encode(infoDto.getPassword()));

	    return userRepository.save(UserInfo.builder()
	        .email(infoDto.getEmail())
	        .auth(infoDto.getAuth())
	        .password(infoDto.getPassword()).build()).getCode();
	  }	
}