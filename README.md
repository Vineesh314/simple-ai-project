# AI Transaction API – Setup Guide

This project exposes APIs to query AI models such as **Llama3, Phi3, and DeepSeek-Coder**.

## Swagger API

After starting the application, access the API documentation using Swagger:

```
http://localhost:9091/swagger-ui/index.html
```

This UI allows you to test the **AI Query API**.

---

# 1. Install Ollama

Ollama is required to run the AI models locally.

### macOS (Homebrew)

```bash
brew install ollama
```

### Linux

```bash
curl -fsSL https://ollama.com/install.sh | sh
```

### Windows

Download and install from:

```
https://ollama.com/download
```

---

# 2. Start Ollama

Start the Ollama service:

```bash
ollama serve
```

---

# 3. Verify Ollama is Running

Open the following URL in the browser:

```
http://localhost:11434
```

If Ollama is running, it will return a response indicating the service is active.

---

# 4. Install Required Models

Download the models required for this application.

### Phi3

```bash
ollama pull phi3
```

### Llama3

```bash
ollama pull llama3
```

### DeepSeek Coder

```bash
ollama pull deepseek-coder
```

---

# 5. Verify Installed Models

Run:

```bash
ollama list
```

You should see:

```
phi3
llama3
deepseek-coder
```

---

# 6. Run the Application

Start the Spring Boot application.

The API will be available at:

```
http://localhost:9091
```

Use Swagger to test the API:

```
POST /api/ai/query
```

Example request:

```json
{
  "question": "Explain microservices architecture"
}
```

The API will automatically route the query to the appropriate AI model.
