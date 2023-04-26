# Java + Jetty Example

This example shows how to build a simple REST service with Jetty embedded, how to create the same service using Spring Boot and Jetty embedded, and how to secure the service with Okta and Auth0.

Please read [Get Started with Jetty, Java, and OAuth](https://developer.okta.com/blog/2023/04/26/java-jetty-oauth) to see how this example was created.

**Prerequisites:** [Java 17](https://sdkman.io), [HTTPie](https://httpie.org/doc#installation), and an [Okta Developer Account](https://developer.okta.com/signup).

> [Okta](https://developer.okta.com/) has Authentication and User Management APIs that reduce development time with instant-on, scalable user infrastructure. Okta's intuitive API and expert support make it easy for developers to authenticate, manage, and secure users and roles in any application.

* [Getting Started](#getting-started)
* [Links](#links)
* [Help](#help)
* [License](#license)

## Getting Started

Clone this repository to your local hard drive using Git.

```
git clone https://github.com/oktadev/okta-spring-boot-jetty-example.git spring-boot-jetty
```

This repository has several projects:

- `maven-jetty`: web service using Maven
- `gradle-jetty`: web service using Gradle
- `spring-boot-jetty-maven-no-auth`: web service using Spring Boot and Maven
- `spring-boot-jetty-maven-okta`: web service using Spring Boot and Maven secured with Okta
- `spring-boot-jetty-maven-auth0`: web service using Spring Boot and Maven secured with Auth0

## Configure Spring Boot and Jetty with Okta

To run the Okta example, you will need to create an OIDC Application in Okta. 

1. Log in to your developer account on [developer.okta.com](https://developer.okta.com).
2. Navigate to **Applications** and click on **Add Application**.
3. Select **Web** and click **Next**. 
4. Give the application a name (e.g., `Spring Boot Jetty`) and add the following as Login redirect URIs:
    * `http://localhost:8080/login/oauth2/code/okta`
    * `https://oidcdebugger.com/debug`

Go to **Security** > **API** and copy the `Issuer URI` from the **default** Authorization Server into `spring-boot-jetty-maven-okta/src/main/resources/application.properties`:

```properties
okta.oauth2.issuer=https://<your-okta-domain>/oauth2/default
```

Then, modify `spring-boot-jetty-maven-okta/pom.xml` to uncomment the Okta Spring Boot starter. 

Now, you should now be able to run the Spring Boot app from a shell with:

```bash
cd spring-boot-jetty-maven-okta
./mvnw spring-boot:run 
```

## Configure Spring Boot and Jetty with Auth0

Install the [Auth0 CLI](https://github.com/auth0/auth0-cli) and run `auth0 login` in a terminal.

You need to find your Auth0 domain. One way to do this is to use the following command.

```bash
auth0 tenants list
```

Take the resulting domain and replace the placeholder in the `issuer` property in the `spring-boot-jetty-maven-auth0/src/main/resources/application.properties` file. **Don't remove the trailing slash!**

```properties
okta.oauth2.issuer=https://<your-auth0-domain>/
okta.oauth2.audience=https://<your-auth0-domain>/api/v2/
```

Then, modify `spring-boot-jetty-maven-auth0/pom.xml` to uncomment the Okta Spring Boot starter.

Now, you should now be able to run the Spring Boot app from a shell with:

```bash
cd spring-boot-jetty-maven-auth0
./mvnw spring-boot:run 
```

## Links

This example uses the following open source libraries:

* [Okta's Spring Boot Starter](https://github.com/okta/okta-spring-boot)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Eclipse Jetty](https://www.eclipse.org/jetty/)

## Help

Please post any questions as comments on the [blog post](https://developer.okta.com/blog/2023/04/26/java-jetty-oauth), or visit our [Okta Developer Forums](https://devforum.okta.com/).

## License

Apache 2.0, see [LICENSE](LICENSE).
