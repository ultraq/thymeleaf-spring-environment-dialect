
Thymeleaf + Spring Environment Dialect
======================================

[![Build Status](https://github.com/ultraq/thymeleaf-spring-environment-dialect/actions/workflows/build.yml/badge.svg)](https://github.com/ultraq/thymeleaf-spring-environment-dialect/actions)
[![codecov](https://codecov.io/gh/ultraq/thymeleaf-spring-environment-dialect/branch/main/graph/badge.svg?token=cUY2X9Ssuy)](https://codecov.io/gh/ultraq/thymeleaf-spring-environment-dialect)
[![Maven Central](https://img.shields.io/maven-central/v/nz.net.ultraq.thymeleaf/thymeleaf-spring-environment-dialect.svg?maxAge=3600)](http://search.maven.org/#search|ga|1|g%3A%22nz.net.ultraq.thymeleaf%22%20AND%20a%3A%22thymeleaf-spring-environment-dialect%22)

Render a portion of a Thymeleaf template based on the current Spring environment.


Installation
------------

Minimum of Java 8, Thymeleaf 3.0, and Spring 5 required.

### For Maven and Maven-compatible dependency managers

Add a dependency to your project with the following co-ordinates:

 - GroupId: `nz.net.ultraq.thymeleaf`
 - ArtifactId: `thymeleaf-spring-environment-dialect`
 - Version: `1.2.0`

Check the [project releases](https://github.com/ultraq/thymeleaf-spring-environment-dialect/releases)
for a list of available versions.  Each release page also includes a
downloadable JAR if you want to manually add it to your project classpath.


Usage
-----

Add the Spring Environment Dialect to your existing Thymeleaf template engine:

```java
@Bean
public SpringEnvironmentDialect springEnvironmentDialect() {
  return new SpringEnvironmentDialect();
}
```

Then, in your Thymeleaf templates, you can choose whether or not to render
sections of markup using the `env:if`/`data-env-if` and `env:unless`/`data-env-unless`
attributes:

```html
<div env:if="development">
  <p>You're currently in the development environment</p>
</div>

<div env:unless="development">
  <p>This is not the development environment</p>
</div>
```
