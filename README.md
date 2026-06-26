# 🤖 AI ChatBot

An AI-powered chatbot built with Spring Boot and Spring AI that provides intelligent, real-time conversations using Large Language Models (LLMs). The application supports chat history, streaming responses, and REST APIs for seamless integration.

## 🚀 Features

- 💬 AI-powered conversational chatbot
- ⚡ Real-time streaming responses
- 📝 Chat history management
- 🔒 RESTful API architecture
- 🗄️ Database integration for storing chats
- 🧩 Clean layered architecture
- 🌐 Easy integration with frontend applications

## 🛠️ Tech Stack

- Java 24
- Spring Boot
- Spring AI
- Maven
- MySQL
- JPA / Hibernate
- Lombok
- REST API

## 📂 Project Structure

```
src
├── controller
├── service
├── repository
├── entity
├── payload
├── config
└── exception
```

## ⚙️ Installation

### Clone the repository

```bash
git clone https://github.com/your-username/ai-chatbot.git
```

### Navigate to the project

```bash
cd ai-chatbot
```

### Configure Database

Update `application.properties` with your database credentials.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/chatbot
spring.datasource.username=root
spring.datasource.password=your_password
```

### Run the project

```bash
mvn spring-boot:run
```

## 📡 API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/chat` | Send a message to the AI |
| GET | `/api/chat/history` | Get chat history |

## 📷 Screenshots

Add screenshots here after deployment.

## 🤝 Contributing

Contributions are welcome! Feel free to fork this repository and submit pull requests.

## 📜 License

This project is licensed under the MIT License.

## 👨‍💻 Author

**Dipankar Dey**

- GitHub: https://github.com/your-username
- Email: your-email@example.com

---

⭐ If you like this project, don't forget to **Star** the repository!
