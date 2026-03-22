
# Ollama
#### what is Ollama?
Ollama is an open-source tool designed to run Large Language Models (LLMs) locally on your own machine (macOS, Windows, Linux) rather than in the cloud. It simplifies the process of downloading, installing, and running models.

#### Installation.
- curl -fsSL https://ollama.com/install.sh | sh
- systemctl status ollama
- ollama run llama3
- ollama run qwen2.5-coder
- 127.0.0.1:11434

#### Terminal commands
- ollama list
- ollama serve
- ollama ps
- ollama rm <model_name>
- ollama pull <model>
- ollama push <model>
- ollama stop <model>
- ollama run <model>
- ollama create <model>
- ollama show <model>
- ollama cp <source> <dest>
- ollama launch [integration]
- ollama help
- ollama signin / signout
- ollama -v
- bye

#### Rest API Calls
```bash
curl http://localhost:11434/api/generate -d '{
  "model": "llama3.1",
  "prompt": "Why is the sky blue?"
}'
```

```bash
curl http://localhost:11434/api/chat -d '{
  "model": "llama3.1",
  "messages": [
    { "role": "user", "content": "Hello! What is your purpose?" }
  ]
}'
```

#### Ollama Integration with VS code IDE
- install ollama chat
- install continue
- ollama serve
- systemctl ollama status
- 127.0.0.1:11434
- add chat models from you local after running the servers

#### Ollama models integration with Springboot code

