
# ✅ Secure Todo App

A robust and secure To-Do application built with **Spring Boot**, featuring **JWT-based authentication**, **PostgreSQL** for persistence, and **Docker** for containerization. This project highlights modern backend best practices, including REST API design, role-based access control, and CI/CD automation.

---

## 🚀 Features

### 🔐 Authentication & Authorization
- **User Registration**: Secure signup with encrypted password storage.
- **JWT Login**: Issue and validate tokens for authenticated sessions.
- **JWT Filter**: Validates JWTs for protected endpoints.
- **Role-Based Access Control**: Differentiates between regular users and admins.
- **Admin Endpoint**: Allows admins to view all todo items across users.

### 📋 Todo Management
- **Todo Entity & Repository**: JPA-based model linked to the authenticated user.
- **Todo CRUD Service**: Secure, user-scoped business logic.
- **RESTful API**: Controller exposing clean and testable REST endpoints.

### 🏗️ Infrastructure
- **PostgreSQL**: Used as the persistent relational database.
- **Dockerfile**: Multi-stage build for a lean production image.
- **Docker Compose**: Bundled configuration for Spring Boot + PostgreSQL.

### 🧰 Bonus Features
- **Swagger/OpenAPI**: Auto-generated interactive API docs.
- **EC2 Deployment**: Sample guide to deploy on AWS EC2 using Docker Compose.

---

## 🧑‍💻 Getting Started

### ✅ Prerequisites
- Java 17+
- Maven
- Docker & Docker Compose
- IDE (IntelliJ, VS Code, etc.)

---

## 🛠️ Installation

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/secure-todo-app.git
cd secure-todo-app
```
---

## 🐳 Running with Docker Compose

```bash
docker-compose up --build
```

- App: [http://localhost:8080](http://localhost:8080)
- Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 🔧 Running Without Docker

1. Ensure PostgreSQL is running.
2. Build the project:

```bash
mvn clean install
```

3. Run the application:

```bash
java -jar target/secure-todo-app-0.0.1-SNAPSHOT.jar
```

---

## 🔗 API Endpoints

**Authentication**
| Method | Endpoint           | Description           |
|--------|--------------------|-----------------------|
| POST   | `/auth/register`   | Register new user     |
| POST   | `/auth/login`      | Authenticate and get JWT |

**Todo**
| Method | Endpoint              | Description                |
|--------|-----------------------|----------------------------|
| GET    | `/api/todos`          | List user's todos          |
| POST   | `/api/todos`          | Create a todo              |
| PUT    | `/api/todos/{id}`     | Update todo by ID          |
| DELETE | `/api/todos/{id}`     | Delete todo by ID          |

**Admin**
| Method | Endpoint              | Description                     |
|--------|-----------------------|---------------------------------|
| GET    | `/api/admin/todos`    | View all todos (admin only)     |

---

## ⚙️ CI/CD – GitHub Actions

### `.github/workflows/ci.yml`

- ✅ **CI Pipeline**: Linting, tests, builds
- 🛡️ **Security**: Docker image scanning with Trivy
- 🔐 **Secrets**: Uses GitHub Secrets for secure variables

### Future Extensions:
- 📦 Docker image build & push on tags
- ☁️ Automated EC2 deployment on `main` pushes
- ✅ PR quality checks enforced before merging

---

## ☁️ AWS EC2 Deployment (Bonus)

1. Launch EC2 (Ubuntu preferred)
2. Install Docker & Docker Compose
3. Copy `docker-compose.yml` to EC2
4. Open ports (e.g., 8080, 22)
5. Run:

```bash
docker-compose up -d
```

✅ Your app will be live at:  
`http://<EC2_PUBLIC_IP>:8080`

---

## 🙌 Contributing

Pull requests, feature requests, and suggestions are welcome!  
Please fork the repo and submit your changes via PR.

---


## 📫 Contact

Maintained by [Your Name](https://github.com/your-username)  
For any inquiries, feel free to reach out!
