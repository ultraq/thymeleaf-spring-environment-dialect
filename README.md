
Thymeleaf + Spring Environment Dialect
======================================

[![Build Status](https://travis-ci.org/ultraq/thymeleaf-spring-environment-dialect.svg)](https://travis-ci.org/ultraq/thymeleaf-spring-environment-dialect)
[![GitHub Release](https://img.shields.io/github/release/ultraq/thymeleaf-spring-environment-dialect.svg?maxAge=3600)](https://github.com/ultraq/thymeleaf-spring-environment-dialect/releases/latest)
[![Maven Central](https://img.shields.io/maven-central/v/nz.net.ultraq.thymeleaf/thymeleaf-spring-environment-dialect.svg?maxAge=3600)](http://search.maven.org/#search|ga|1|g%3A%22nz.net.ultraq.thymeleaf%22%20AND%20a%3A%22thymeleaf-spring-environment-dialect%22)
[![License](https://img.shields.io/github/license/ultraq/thymeleaf-spring-environment-dialect.svg?maxAge=2592000)](https://github.com/ultraq/thymeleaf-spring-environment-dialect/blob/master/LICENSE.txt)

Render a portion of a Thymeleaf template based on the current Spring environment.

**STILL UNDER DEVELOPMENT**


Installation
------------

Minimum of Java 8, Thymeleaf 3.0, and Spring 4 required.

### For Maven and Maven-compatible dependency managers
Add a dependency to your project with the following co-ordinates:

 - GroupId: `nz.net.ultraq.thymeleaf`
 - ArtifactId: `thymeleaf-spring-environment-dialect`
 - Version: 0.1.0-SNAPSHOT


Usage
-----

In one of your Spring `@Configuration` classes (probably the same one you're
doing all your Thymeleaf config in), add the `nz.net.ultraq.thymeleaf.EnvironmentDialect`
dialect as a bean reference:

```java
@Bean
public EnvironmentDialect environmentDialect() {
	return new EnvironmentDialect();
}
```

Then, in your Thymeleaf templates, you can choose whether or not to render a
section of markup using the `env:if`/`data-env-if` attribute.  The value you
give it should be the name of the environment you want the markup rendered for:

```html
<div env:if="development">
  <p>You're currently in the development environment!</p>
</div>
```
