# Smart School (independent microservices)

This scaffold contains two loosely-coupled microservices as independent projects inside the repository:

- `school-service` (port 8081) — manages schools (H2, JPA, REST, OpenAPI)
- `student-service` (port 8082) — manages students (H2, JPA, REST, OpenAPI)

Each service is a standalone Spring Boot project (its own parent POM) so they can be built, tested, and deployed independently.

How to build and run each service separately:

```bash
# Run school-service
cd /home/harish/Documents/ai-workspace/smart-school/school-service
mvn spring-boot:run

# In another terminal run student-service
cd /home/harish/Documents/ai-workspace/smart-school/student-service
mvn spring-boot:run
```

Swagger/OpenAPI UI:
- School Service: http://localhost:8081/swagger-ui.html
- Student Service: http://localhost:8082/swagger-ui.html

H2 console:
- http://localhost:8081/h2-console (jdbc url: jdbc:h2:mem:schooldb)
- http://localhost:8082/h2-console (jdbc url: jdbc:h2:mem:studentdb)

Notes / next steps:
- Add DTOs and validation annotations (DTO + MapStruct or manual mapping)
- Add integration and contract tests for inter-service behavior
- For production-grade microservices, add containerization (Dockerfiles), API gateway, and service discovery if needed

If you want, I can now:
- add DTOs and validation,
- add Dockerfiles for each service,
- implement JPA relations (ManyToOne) and a sample call from student-service to school-service (HTTP client),
- or remove the top-level `smart-school` folder and create two completely separate Git repos. 
Tell me which next step you prefer.
