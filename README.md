# mrf-payments-gateway

Payments API for **Maple Ridge Financial**, a fictional bank used in a Databricks Lakewatch demo
(SBOM-driven supply-chain detection, AI triage, and automated remediation pull requests).

> **Demo repository. Intentionally vulnerable.** The dependency versions here are deliberately out
> of date so that the demo's detection fires. Do not deploy this code.

- Java 21, Spring Boot 4, Log4j 2 for audit logging (`docs/logging.md`)
- `POST /v1/payments` accepts a payment and routes it to Interac or Lynx
- SBOM: GitHub dependency graph (SPDX), pulled into Lakewatch by the demo's collector job
