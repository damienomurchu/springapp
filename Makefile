.PHONY: start-server
start-server:
	mvn spring-boot:run

.PHONY: dev-server
dev-server:
	mvn spring-boot:run -Dspring.profiles.active=dev