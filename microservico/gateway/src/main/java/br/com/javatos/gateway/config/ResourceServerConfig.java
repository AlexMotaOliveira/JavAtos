package br.com.javatos.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

  @Autowired
  private JwtTokenStore tokenStore;

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
    resources.tokenStore(tokenStore);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests()
      .antMatchers("/auth/**").permitAll()
      .antMatchers("/usuarios/**").hasAnyRole("USER", "ADMIN")
      .antMatchers("/usuarios/**").hasRole("ADMIN")
      .anyRequest().authenticated();

    http.cors().configurationSource(corsConfigurationSource());
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration corsConfig = new CorsConfiguration();
    corsConfig.setAllowedOrigins(Arrays.asList("*"));
    corsConfig.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "PATCH"));
    corsConfig.setAllowCredentials(true);
    corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfig);
    return source;
  }

  @Bean
  public FilterRegistrationBean<CorsFilter> corsFilter() {
    FilterRegistrationBean<CorsFilter> bean
      = new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
    bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
    return bean;
  }
}
