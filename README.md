# Okta Spring Boot Jetty

This example shows how to build a simple REST service with Jetty embedded, how to create the same service using Spring Boot and Jetty embedded, and how to secure the service with Okta and OAuth/OIDC.

Please read [NEED A LINK]

**Prerequisites:** [Java 11](https://openjdk.java.net/install/), [HTTPie](https://httpie.org/doc#installation), and an [Okta Developer Account](https://developer.okta.com).

> [Okta](https://developer.okta.com/) has Authentication and User Management APIs that reduce development time with instant-on, scalable user infrastructure. Okta's intuitive API and expert support make it easy for developers to authenticate, manage, and secure users and roles in any application.

* [Getting Started](#getting-started)
* [Links](#links)
* [Help](#help)
* [License](#license)

## Getting Started

Clone this repository to your local hard drive using Git.

```
git clone https://<need.a.link> spring-boot-jetty
```

There are two separate applications within the project:
- `jettyembedded`: a Jetty embedded REST servlet app
- `SpringBootJava`: a Spring Boot REST service

You can run the `jettyembedded` app directly from the root directory of the project by running `gradle apprun`.

To run the Spring Boot app, you will need to create an OIDC Application in Okta. 

1. Log in to your developer account on [developer.okta.com](https://developer.okta.com).
2. Navigate to **Applications** and click on **Add Application**.
3. Select **Web** and click **Next**. 
4. Give the application a name (e.g., `Spring Boot Jetty`) and add the following as Login redirect URIs:
    * `https://oidcdebugger.com/debug`
4. Click **Done**, then edit the project and enable "Implicit (Hybrid)" as a grant type (allow ID and access tokens) and click **Save**.

Go to **API** and **Authorization Servers**. Look under the `default` server for the `Issuer URI`.

Copy the `Issuer URI` from your auth server into `SpringBootJetty/src/main/resources/application.properties`:

```properties
okta.oauth2.issuer=https://{yourOktaUri}/oauth2/default
```

You should now be able to run the Spring Boot app from a shell by going to the project base directory (not the repository base directory, but the base directory for the Spring Boot app, `SpringBootJetty`) and running `gradle bootRun`.

## Links

This example uses the following open source libraries:

* [Okta's React SDK](https://github.com/okta/okta-oidc-js/tree/master/packages/okta-react)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Jetty](https://www.eclipse.org/jetty/)

## Help

Please post any questions as comments on the [blog post](https://developer.okta.com/blog/2018/09/24/reactive-apis-with-spring-webflux), or visit our [Okta Developer Forums](https://devforum.okta.com/). You can also email developers@okta.com if you'd like to create a support ticket.

## License

Apache 2.0, see [LICENSE](LICENSE).
