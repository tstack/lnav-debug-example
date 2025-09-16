# java-logging-example

Small Maven Java project demonstrating basic logging with SLF4J and Logback.

Build and run:

```bash
mvn -f java-logging-example/pom.xml package
mvn -f java-logging-example/pom.xml exec:java
```

You should see INFO/DEBUG/ERROR messages on the console configured by `logback.xml`.
