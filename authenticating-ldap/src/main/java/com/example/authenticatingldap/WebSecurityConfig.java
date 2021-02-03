package com.example.authenticatingldap;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests().antMatchers("/sw.js").permitAll().anyRequest().fullyAuthenticated().and()
				.formLogin().and().csrf().disable()
				.httpBasic();
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.anyRequest()
//				.authenticated().and()
//				.csrf().disable()
//				.httpBasic();
//
//	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.ldapAuthentication()
				.userSearchFilter(
						"(uid={0})")// .userSearchBase("o=TDec")
				// .groupRoleAttribute("cn").groupSearchFilter("(member={0})")
			
				// .userDnPatterns("uid={0}")
				// .groupSearchBase("ou=groups")
				.contextSource()
				.url("ldap://mcastro.tdec.com.br:389/O=TDec")
				.port(389)
				.managerDn("CN=Marcelo Castro, O=TDec").managerPassword("Hodge$404");
		// .and()
		// .passwordCompare()
		// .passwordEncoder(new
		// BCryptPasswordEncoder()).passwordAttribute("userpassword");
	}



//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.ldapAuthentication().userDnPatterns("cn={0}")
//				// .groupSearchBase("ou=groups")
//				.contextSource().url("ldap://prozac.tdec.com.br:389/DC=tdec,DC=com,DC=br").port(389)
//				.managerDn("CN=Marcelo Castro,OU=Diretoria,OU=SaoPaulo,OU=TDec,DC=tdec,DC=com,DC=br")
//				.managerPassword("Hodge$404tdec").and().passwordCompare().passwordEncoder(new BCryptPasswordEncoder())
//				.passwordAttribute("userpassword");
//	}

}
