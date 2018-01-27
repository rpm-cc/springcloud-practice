package cn.rpm.goods.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by renpiming on 2018/1/17.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //内存形式
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("user");
        //数据库形式
//        auth.jdbcAuthentication().dataSource(dataSource).withUser().usersByUsernameQuery("select username from user").
//                authoritiesByUsernameQuery("").passwordEncoder(new StandardPasswordEncoder());
    }
}
