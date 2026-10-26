# Logging

The gateway logs through Log4j 2 (Spring Boot's default Logback starter is excluded). Every payment
request is written to the audit log with the merchant id and the client's `User-Agent`, which the
HSM audit appender forwards to the payments SIEM index.

`log4j2.version` is pinned in `pom.xml` (PAY-1187, 2021) because the vendor's HSM audit appender
was only certified against that release.
