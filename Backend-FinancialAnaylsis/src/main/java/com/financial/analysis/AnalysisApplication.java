package com.financial.analysis;

import com.financial.analysis.entitys.Authority;
import com.financial.analysis.entitys.User;
import com.financial.analysis.persistence.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class AnalysisApplication {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserDetailsRepository userDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(AnalysisApplication.class, args);
	}

	@PostConstruct
	protected void init(){
		List<Authority> authorities = new ArrayList<>();

		authorities.add(createAuthority("USER","User Role"));
		authorities.add(createAuthority("ADMIN","Admin Role"));

//		User user = new User();
//		user.setUsername("jun940126");
//		user.setFirstName("yj");
//		user.setLastName("lee");
//		user.setEmail("dldudwns72@gmail.com");
//		user.setCreatedAt(new Date());
//		user.setAuthroityies(authorities);
//		user.setPassword(passwordEncoder.encode("lee1234"));
//		user.setEnabled(true);

		//userDetailsRepository.save(user);

	}

	private Authority createAuthority(String roleCode, String roleDescription) {
		Authority authority = new Authority();
		authority.setRoleCode(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}

}
