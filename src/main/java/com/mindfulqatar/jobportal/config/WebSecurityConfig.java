package com.mindfulqatar.jobportal.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mindfulqatar.jobportal.security.JobportalAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService customUserDetailsService;

	@Autowired
	private DataSource dataSource;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().sameOrigin().and().authorizeRequests()
				.antMatchers("/resources/**", "/webjars/**", "/assets/**").permitAll()
				.antMatchers("/", "/registration", "/search/**", "/jobs/**", "/salaries/**", "/contactus", "/aboutus",
						"/employer", "/company/reviews", "/error/**", "/custom-message/**", "/email/**",
						"/advertisement-images/**", "/drop/email", "/facebook/login", "/forward/facebook/login",
						"/linkedin/login", "/forward/linkedin/login")
				.permitAll().antMatchers(HttpMethod.POST, "/search/**").permitAll().and().csrf().disable();
		http.headers().frameOptions().sameOrigin().and().authorizeRequests().antMatchers("/employer/**")
				.hasRole("EMPLOYER").antMatchers("/jobseeker/**").hasRole("JOBSEEKER").antMatchers("/admin/**")
				.hasRole("ADMIN").anyRequest().authenticated().and().formLogin().loginPage("/login")
				.successHandler(jobportalAuthenticationSuccessHandler()).failureUrl("/login?error").permitAll().and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
				.deleteCookies("my-remember-me-cookie").permitAll().and().rememberMe()
				// .key("my-secure-key")
				.rememberMeCookieName("my-remember-me-cookie").tokenRepository(persistentTokenRepository())
				.tokenValiditySeconds(24 * 60 * 60).and().exceptionHandling();
	}

	PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
		tokenRepositoryImpl.setDataSource(dataSource);
		return tokenRepositoryImpl;
	}

	@Bean
	public AuthenticationSuccessHandler jobportalAuthenticationSuccessHandler() {
		return new JobportalAuthenticationSuccessHandler();
	}
}
