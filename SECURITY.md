##### To activate Spring security 
Uncomment the following line in build.gradle
`implementation 'org.springframework.boot:spring-boot-starter-security'`

#### User and Password 
User: user <br>
Password can be found in log as: `Using generated security password: <xxxxx>`

##### For Basic Auth
Implement a class ApplicationSecurityConfig
```
protected void configure(HttpSecurity http) throws Exception {
http
.authorizeRequests()
.anyRequest()
.authenticated()
.and()
.httpBasic();
}
```

#### To whitelist the root path and some other paths like /css/* and /js/*
```
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
```
