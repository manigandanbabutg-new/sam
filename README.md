# 💬 Java Spring Boot ChatBot API (OpenAI Integration)

This is a Java-based Spring Boot REST API that integrates with **OpenAI's ChatGPT API**. It allows users to send their queries over to the AI agent as a prompt and receive intelligent responses directly from the bot.

---

## 🚀 Features

- ✅ RESTful API built using Spring Boot  
- 🧠 Integration with OpenAI ChatGPT API  
- 🔒 Secure and modular architecture  
- 📦 Easy to extend or deploy  
- 🌐 Ready for frontend integration (Angular/React/etc)

---

## 📦 Technologies Used

- Java 17  
- Spring Boot  
- Spring Web  
- OpenAI Chat API  
- Maven  

---

## 🛠️ Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/tejal04/JavaChatBotAPI.git
cd JavaChatBotAPI
```

### 2. Configure API Key
Add your OpenAI API key in application.properties:
```xml
openai.api.key=your_openai_api_key
```

### 3. Build and Run
Add your OpenAI API key in application.properties:
```bash
mvn clean install
mvn spring-boot:run
```
---

## 🔌 API Endpoint
### POST /api/chat
Description: Send a prompt to the chatbot and receive a response.


