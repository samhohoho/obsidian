Tags: [[annotation]], [[domain]]

https://docs.spring.io/spring-data/jpa/reference/auditing.html#auditing.auditor-aware

Auditing infrastructure become aware of the current principal.

```java
class SpringSecurityAuditorAware implements AuditorAware<User> {

  @Override
  public Optional<User> getCurrentAuditor() {

    return Optional.ofNullable(SecurityContextHolder.getContext())
            .map(SecurityContext::getAuthentication)
            .filter(Authentication::isAuthenticated)
            .map(Authentication::getPrincipal)
            .map(User.class::cast);
  }
}
```