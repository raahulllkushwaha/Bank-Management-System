# Bank Management System

A comprehensive RESTful API-based Bank Management System built with Spring Boot that provides complete CRUD operations for managing bank accounts and transactions.

## Features

- **Account Management**
    - Create new bank accounts
    - View account details by account number
    - View all accounts
    - Close/delete accounts

- **Transaction Operations**
    - Deposit money into accounts
    - Withdraw money from accounts
    - Transfer money between accounts
    - Transaction validation and error handling

## Technologies Used

- **Java 21**
- **Spring Boot 3.5.7**
- **Spring Data JPA** - For database operations
- **Spring Web** - For RESTful API
- **MySQL** - Database
- **Maven** - Dependency management

## Prerequisites

Before running this application, make sure you have:

- Java 21 or higher installed
- MySQL Server installed and running
- Maven installed (or use the included Maven wrapper)
- Git (optional, for cloning the repository)

## Database Setup

1. Create a MySQL database named `bank_management`:

```sql
CREATE DATABASE bank_management;
```

2. Update the database credentials in `src/main/resources/application.properties` if needed:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bank_management
spring.datasource.username=root
spring.datasource.password=123456
```

## Installation & Running

### Using Maven Wrapper (Recommended)

**On Linux/Mac:**
```bash
./mvnw clean install
./mvnw spring-boot:run
```

**On Windows:**
```cmd
mvnw.cmd clean install
mvnw.cmd spring-boot:run
```

### Using Maven

```bash
mvn clean install
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### Account Management

#### Create Account
```http
POST /account/create
Content-Type: application/json

{
  "accountHolderName": "John Doe",
  "accountBal": 1000.00
}
```

#### Get Account Details
```http
GET /account/{accountNum}
```

#### Get All Accounts
```http
GET /account/getallaccounts
```

#### Delete Account
```http
DELETE /account/delete/{accountNum}
```

### Transaction Operations

#### Deposit Money
```http
PUT /account/deposit/{accountNum}/{amount}
```
Example: `PUT /account/deposit/1/500.00`

#### Withdraw Money
```http
PUT /account/withdraw/{accountNum}/{amount}
```
Example: `PUT /account/withdraw/1/200.00`

#### Transfer Money
```http
PUT /account/transfer/{fromAccountNum}/{toAccountNum}/{amount}
```
Example: `PUT /account/transfer/1/2/300.00`

## Project Structure

```
Bank-Management-System/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/rahul/bankManagement/Bank/Management/System/
│   │   │       ├── controller/
│   │   │       │   └── AccountController.java
│   │   │       ├── entity/
│   │   │       │   └── Account.java
│   │   │       ├── repo/
│   │   │       │   └── AccountRepo.java
│   │   │       ├── service/
│   │   │       │   ├── AccountService.java
│   │   │       │   └── AccountServiceImplementation.java
│   │   │       └── BankManagementSystemApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## Entity Schema

### Account
| Field | Type | Description |
|-------|------|-------------|
| accountNum | Long | Primary Key (Auto-generated) |
| accountHolderName | String | Name of the account holder |
| accountBal | Double | Current account balance |

## Testing the API

You can test the API using:

- **Postman** - Import the endpoints and test
- **cURL** - Command line testing
- **Browser** - For GET requests only
- **Swagger UI** - (Can be added for API documentation)

### Example cURL Commands

**Create Account:**
```bash
curl -X POST http://localhost:8080/account/create \
  -H "Content-Type: application/json" \
  -d '{"accountHolderName":"John Doe","accountBal":1000.00}'
```

**Get Account:**
```bash
curl -X GET http://localhost:8080/account/1
```

**Deposit:**
```bash
curl -X PUT http://localhost:8080/account/deposit/1/500.00
```

**Transfer:**
```bash
curl -X PUT http://localhost:8080/account/transfer/1/2/300.00
```

## Error Handling

The application handles various error scenarios:

- Account not found
- Insufficient balance for withdrawal/transfer
- Invalid account numbers
- Invalid transaction amounts

Errors return appropriate HTTP status codes and descriptive messages.

## Future Enhancements

Potential features for future versions:

- User authentication and authorization
- Transaction history and statements
- Different account types (Savings, Current)
- Interest calculation
- Email notifications
- API documentation with Swagger
- Unit and integration tests

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is open source and available under the [MIT License](LICENSE).

## Author

**Rahul Kushwaha**

## Support

For support, please open an issue in the repository or contact the development team.

---

**Note:** This is a learning project.