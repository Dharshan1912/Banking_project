# Bank Microservices Project

A comprehensive Spring Boot microservices application for banking operations with KYC (Know Your Customer) verification, account management, and customer services.

## 🏗️ Architecture

This project consists of 5 microservices:

1. **RegistryServer** - Eureka Service Discovery (Port: 4567)
2. **CustomerMS** - Customer Management Service (Port: 8081)
3. **AccountMS** - Account Management Service (Port: 8084)
4. **KycDocumentMS** - KYC Document Management Service (Port: 8082)
5. **KycVerificationMS** - KYC Verification Service (Port: 8083)

## 📋 Prerequisites

### Software Requirements
- **Java 17** (OpenJDK or Oracle JDK)
- **Spring Tool Suite (STS) 4.x** or **Eclipse IDE**
- **Oracle Database 11g** (11.2.0.4 or later)
- **Maven 3.6+**
- **Git**

### System Requirements
- **OS**: Windows 10/11
- **RAM**: Minimum 8GB (Recommended 16GB)
- **Disk Space**: 10GB free space

## 🚀 Quick Start Guide

### Step 1: Clone the Repository
```bash
git clone <repository-url>
cd Bankkkk_pro
```

### Step 2: Database Setup

#### 2.1 Install Oracle Database 11g
1. Download Oracle Database 11g from Oracle's official website
2. Install Oracle Database 11g with default settings
3. Create a database instance (e.g., `XE` or `ORCL`)
4. Note down the connection details:
   - **Host**: localhost
   - **Port**: 1521
   - **SID**: XE (or your SID)
   - **Username**: system
   - **Password**: (your admin password)

#### 2.2 Create Database Schema
```sql
-- Connect to Oracle as system user
sqlplus system/password@localhost:1521/XE

-- Create tablespace (optional)
CREATE TABLESPACE bank_data
DATAFILE 'C:\oracle\oradata\XE\bank_data.dbf' SIZE 100M
AUTOEXTEND ON;

-- Create user for the application
CREATE USER bank_user IDENTIFIED BY bank_password;
GRANT CONNECT, RESOURCE TO bank_user;
GRANT CREATE TABLE, CREATE SEQUENCE TO bank_user;
GRANT UNLIMITED TABLESPACE TO bank_user;
```

### Step 3: Configure Database Connection

#### 3.1 Update Application Properties
Update the `application.yml` files in each microservice to use Oracle Database:

**CustomerMS/src/main/resources/application.yml:**
```yaml
spring:
  application:
    name: CustomerMS
  datasource:
    url: jdbc:oracle:thin:@localhost:1521:XE
    username: bank_user
    password: bank_password
    driver-class-name: oracle.jdbc.OracleDriver
  jpa:
    hibernate:
      ddl-auto: create-drop
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.Oracle12cDialect
        format_sql: true
```

**AccountMS/src/main/resources/application.yml:**
```yaml
spring:
  application:
    name: AccountMS
  datasource:
    url: jdbc:oracle:thin:@localhost:1521:XE
    username: bank_user
    password: bank_password
    driver-class-name: oracle.jdbc.OracleDriver
  jpa:
    hibernate:
      ddl-auto: create-drop
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.Oracle12cDialect
        format_sql: true
```

**KycDocumentMS/src/main/resources/application.yml:**
```yaml
spring:
  application:
    name: KycDocumentMS
  datasource:
    url: jdbc:oracle:thin:@localhost:1521:XE
    username: bank_user
    password: bank_password
    driver-class-name: oracle.jdbc.OracleDriver
  jpa:
    hibernate:
      ddl-auto: create-drop
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.Oracle12cDialect
```

**KycVerificationMS/src/main/resources/application.yml:**
```yaml
spring:
  application:
    name: KycVerificationMS
  datasource:
    url: jdbc:oracle:thin:@localhost:1521:XE
    username: bank_user
    password: bank_password
    driver-class-name: oracle.jdbc.OracleDriver
  jpa:
    hibernate:
      ddl-auto: create-drop
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.Oracle12cDialect
```

#### 3.2 Update Maven Dependencies
Ensure each `pom.xml` includes Oracle JDBC driver:

```xml
<dependency>
    <groupId>com.oracle.database.jdbc</groupId>
    <artifactId>ojdbc8</artifactId>
    <scope>runtime</scope>
</dependency>
```

### Step 4: Import Project in STS

#### 4.1 Import Maven Projects
1. Open **Spring Tool Suite (STS)**
2. Go to **File** → **Import**
3. Select **Maven** → **Existing Maven Projects**
4. Browse to the project root directory
5. Select all 5 projects:
   - RegistryServer
   - CustomerMS
   - AccountMS
   - KycDocumentMS
   - KycVerificationMS
6. Click **Finish**

#### 4.2 Configure Java Version
1. Right-click on each project → **Properties**
2. Go to **Java Build Path** → **Libraries**
3. Remove any existing JRE
4. Add **Modulepath** → **Add Library** → **JRE System Library**
5. Select **Java 17**

### Step 5: Run the Application

#### 5.1 Start Services in Order
**Important**: Start services in the following order:

1. **RegistryServer** (Eureka)
2. **CustomerMS**
3. **AccountMS**
4. **KycDocumentMS**
5. **KycVerificationMS**

#### 5.2 Running in STS
For each service:
1. Right-click on the project
2. Select **Run As** → **Spring Boot App**
3. Wait for the service to start completely before starting the next one

#### 5.3 Verify Services
Check the Eureka Dashboard: http://localhost:4567

All services should be registered and show status as **UP**.

## 🔧 Configuration Details

### Service Ports
| Service | Port | Description |
|---------|------|-------------|
| RegistryServer | 4567 | Eureka Service Discovery |
| CustomerMS | 8081 | Customer Management |
| AccountMS | 8084 | Account Management |
| KycDocumentMS | 8082 | KYC Document Management |
| KycVerificationMS | 8083 | KYC Verification |

### Database Tables
The application will automatically create the following tables:
- `CUSTOMER_NEW`
- `ACCOUNT_NEW`
- `KYC_DOCUMENTS_NEW`
- `KYC_VERIFICATION_NEW`

## 📱 API Endpoints

### Customer Management
- **POST** `/api/customers/register` - Register new customer
- **GET** `/api/customers/{id}` - Get customer details

### Account Management
- **POST** `/api/accounts/create` - Create new account
- **GET** `/api/accounts` - Get customer accounts

### KYC Document Management
- **POST** `/api/kyc/upload` - Upload KYC documents
- **GET** `/api/kyc/{kycId}` - Get KYC document details

### KYC Verification
- **POST** `/api/kyc-verification/verify` - Verify KYC documents
- **GET** `/api/kyc-verification/status/{kycId}` - Get verification status

> 🔹 *Note:* Only key endpoints are listed here. The project includes several additional APIs for updating, deleting, and managing entities.

> 💡 *Tip:* You can explore all available endpoints with detailed request/response formats using Swagger UI:
> - CustomerMS → [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)
> - AccountMS → [http://localhost:8084/swagger-ui.html](http://localhost:8084/swagger-ui.html)
> - KycDocumentMS → [http://localhost:8082/swagger-ui.html](http://localhost:8082/swagger-ui.html)
> - KycVerificationMS → [http://localhost:8083/swagger-ui.html](http://localhost:8083/swagger-ui.html)




## 🧪 Testing the Application

### 1. Test Customer Registration
```bash
curl -X POST http://localhost:8081/api/customers/register \
  -H "Content-Type: application/json" \
  -d '{
    "fullName": "John Doe",
    "email": "john.doe@example.com",
    "phone": "1234567890",
    "pan": "ABCDE1234F",
    "aadhaar": "123456789012",
    "address": "123 Main St, City",
    "dob": "1990-01-01"
  }'
```

### 2. Test KYC Document Upload
```bash
curl -X POST http://localhost:8082/api/kyc/upload \
  -F "customerId=1" \
  -F "panFile=@pan.pdf" \
  -F "aadhaarFile=@aadhaar.pdf" \
  -F "photoFile=@photo.jpg"
```

### 3. Test KYC Verification
```bash
curl -X POST http://localhost:8083/api/kyc-verification/verify \
  -H "Content-Type: application/json" \
  -d '{
    "kycId": 1,
    "verifiedBy": "admin",
    "status": "APPROVED",
    "remarks": "All documents verified successfully"
  }'
```

### 4. Test Account Creation
```bash
curl -X POST http://localhost:8084/api/accounts/create \
  -H "Content-Type: application/json" \
  -d '{
    "customerId": 1,
    "accountType": "SAVINGS"
  }'
```

## 🐛 Troubleshooting

### Common Issues

#### 1. Database Connection Issues
- **Problem**: `ORA-12541: TNS:no listener`
- **Solution**: Ensure Oracle Database service is running
- **Check**: `services.msc` → Oracle services should be running

#### 2. Port Already in Use
- **Problem**: `Port 8081 is already in use`
- **Solution**: Kill the process using the port
- **Command**: `netstat -ano | findstr :8081` then `taskkill /PID <PID> /F`

#### 3. Java Version Issues
- **Problem**: `Unsupported major.minor version`
- **Solution**: Ensure Java 17 is installed and configured
- **Check**: `java -version` should show Java 17

#### 4. Maven Build Issues
- **Problem**: `Could not resolve dependencies`
- **Solution**: Update Maven settings and clear local repository
- **Command**: `mvn clean install -U`

### Logs and Debugging
- Check console output in STS for error messages
- Enable debug logging by adding to `application.yml`:
```yaml
logging:
  level:
    com.ofss: DEBUG
    org.springframework: DEBUG
```

## 📚 Additional Resources

### Swagger UI
Each service provides Swagger UI for API documentation:
- CustomerMS: http://localhost:8081/swagger-ui.html
- AccountMS: http://localhost:8084/swagger-ui.html
- KycDocumentMS: http://localhost:8082/swagger-ui.html
- KycVerificationMS: http://localhost:8083/swagger-ui.html

### Eureka Dashboard
- URL: http://localhost:4567
- Shows all registered services and their health status

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.


**Note**: This project is configured for development with H2 in-memory database by default. For production use with Oracle Database, follow the configuration steps above.
All examples are tested on Windows 11 + Oracle 11g XE setup.
