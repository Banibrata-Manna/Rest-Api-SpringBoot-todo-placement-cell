package com.in28minutes.rest.webservices.restfulwebservices.jwt;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.in28minutes.rest.webservices.restfulwebservices.admin.Admin;
import com.in28minutes.rest.webservices.restfulwebservices.admin.AdminRepository;
import com.in28minutes.rest.webservices.restfulwebservices.hods.Hod;
import com.in28minutes.rest.webservices.restfulwebservices.hods.HodRepository;
import com.in28minutes.rest.webservices.restfulwebservices.student.Student;
import com.in28minutes.rest.webservices.restfulwebservices.student.StudentRepository;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class JwtSecurityConfig {
	
	private StudentRepository studentRepository;
	
	private AdminRepository adminRepository;
	
	private HodRepository hodRepository;
	
	public JwtSecurityConfig(StudentRepository studentRepository,
			AdminRepository adminRepository, HodRepository hodRepository) {
		this.studentRepository = studentRepository;
		this.adminRepository = adminRepository;
		this.hodRepository = hodRepository;
	}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, HandlerMappingIntrospector introspector) throws Exception {
        
        // h2-console is a servlet 
        // https://github.com/spring-projects/spring-security/issues/12310
        return httpSecurity
                .authorizeHttpRequests(auth -> auth
                    .antMatchers("/authenticate").permitAll()
//                    .requestMatchers(PathRequest.toH2Console()).permitAll() // h2-console is a servlet and NOT recommended for a production
                    .antMatchers(HttpMethod.OPTIONS,"/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.
                    sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(
                        OAuth2ResourceServerConfigurer::jwt)
                .httpBasic(
                        Customizer.withDefaults())
                .headers(header -> {header.
                    frameOptions().sameOrigin();})
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService) {
        var authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        return new ProviderManager(authenticationProvider);
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withUsername("Banibrata")
//                                .password("{noop}dummy")
//                                .authorities("read")
//                                .roles("USER")
//                                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
    
    @Bean
    public UserDetailsService userDetailsService() {
        return id -> {
            UserDetails userDetails = null;

            if (studentRepository.findById(id).isPresent()) {
                Student student = studentRepository.findById(id).get();
                userDetails = User.withUsername(student.getId())
                        .password(student.getPassword())
                        .roles("STUDENT")
                        .build();
                System.out.println(student.toString());
            } else if (hodRepository.findById(id).isPresent()) {
                Hod hod = hodRepository.findById(id).get();
                userDetails = User.withUsername(hod.getId())
                        .password(hod.getPassword())
                        .roles("HOD")
                        .build();
                System.out.println(hod.toString());
            } else if (adminRepository.findById(id).isPresent()) {
                Admin admin = adminRepository.findById(id).get();
                userDetails = User.withUsername(admin.getId())
                        .password(admin.getPassword())
                        .roles("ADMIN")
                        .build();
                System.out.println(admin.toString());
            }

            if (userDetails == null) {
                throw new UsernameNotFoundException("User not found with email: " + id);
            }
//            System.out.println(userDetails.toString());
            return userDetails;
        };
    }


    @Bean
    public JWKSource<SecurityContext> jwkSource() {
        JWKSet jwkSet = new JWKSet(rsaKey());
        return (((jwkSelector, securityContext) 
                        -> jwkSelector.select(jwkSet)));
    }

    @Bean
    JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource) {
        return new NimbusJwtEncoder(jwkSource);
    }

    @Bean
    JwtDecoder jwtDecoder() throws JOSEException {
        return NimbusJwtDecoder
                .withPublicKey(rsaKey().toRSAPublicKey())
                .build();
    }
    
    @Bean
    public RSAKey rsaKey() {
        
        KeyPair keyPair = keyPair();
        
        return new RSAKey
                .Builder((RSAPublicKey) keyPair.getPublic())
                .privateKey((RSAPrivateKey) keyPair.getPrivate())
                .keyID(UUID.randomUUID().toString())
                .build();
    }

    @Bean
    public KeyPair keyPair() {
        try {
            var keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            return keyPairGenerator.generateKeyPair();
        } catch (Exception e) {
            throw new IllegalStateException(
                    "Unable to generate an RSA Key Pair", e);
        }
    }
    
}

