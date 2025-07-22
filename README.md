# QRCode-Generator
O QR Code Generator é uma API desenvolvida em Java 21 com Spring Boot, responsável por gerar códigos QR utilizando a biblioteca ZXing (Google). Após a geração, os QR Codes são armazenados no Amazon S3.
A aplicação segue uma arquitetura modular com separação clara entre camadas de controller, service, ports e infraestrutura, permitindo fácil manutenção e extensibilidade.

# Arquitetura
O projeto adota a Arquitetura Hexagonal (Ports & Adapters), promovendo baixo acoplamento e alta testabilidade.

# Camadas do projeto:
- Controller - Exposição da API via REST (Spring Web).
- DTO (records) - Objetos de requisição e resposta com record, promovendo imutabilidade e segurança no transporte de dados.
- Service - Contém as regras de negócio (geração de QR Code e integração com storage).
- Ports (interfaces) - Definem contratos de comunicação com sistemas externos (ex: StoragePort).
- Infrastructure - Implementação concreta das ports, como o S3StorageAdapter.

# Uso de Records e Interfaces
Records
A aplicação utiliza records do Java 21 para representar DTOs e modelos simples, garantindo:
- Imutabilidade
- Redução de boilerplate
- Clareza e simplicidade

Interfaces
O projeto usa interfaces para definir ports, permitindo que a camada de serviço fique desacoplada das implementações específicas.
Essa abordagem facilita:
- Testes unitários com mocks
- Mudança de implementação sem impacto no core da aplicação

# Contêiner Docker
A aplicação foi preparada para ser executada em ambiente Docker, garantindo portabilidade e facilidade de deploy.

# Como Executar

Pré-requisitos:
- Java 21 instalado
- AWS CLI configurado ou credenciais válidas
- Bucket S3 existente e configurado

Comandos:
- ./mvn clean install
- ./mvnw spring-boot:run

A API estará disponível em:
- http://localhost:8080/api/v1/qrcode

# Autor
Desenvolvido por Lucas Nunes.
