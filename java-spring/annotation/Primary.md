---
id: Primary
aliases: []
tags: []
---

[[Qualifier|@Qualifier]]

```java
@Autowired
// @Qualifier not needed
public void setCoach(Coach theCoach) {
    myCoach = theCoach;
}

@Component
@Primary
public class TrackCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "..."
    }
}

@Component
public class BaseBallCoach implements Coach {
}

@Component
public class TennisCoach implements Coach {
}
```
Out of the multiple implementations, this is the primary implemention that Spring should use.
