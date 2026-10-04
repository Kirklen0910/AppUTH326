import fs from "fs";
import path from "path";
import fetch from "node-fetch"; // instala con: npm install node-fetch

// Función para enviar texto a Ollama
async function askOllama(prompt) {
  const response = await fetch("http://localhost:11434/api/generate", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      model: "llama3", // puedes usar mistral, codellama, etc.
      prompt: prompt,
      stream: false
    })
  });

  const data = await response.json();
  return data.response;
}

// Función para recorrer carpetas y analizar archivos
async function analyzeProject(dir) {
  const files = fs.readdirSync(dir);
  for (const file of files) {
    const fullPath = path.join(dir, file);
    const stat = fs.statSync(fullPath);

    if (stat.isDirectory()) {
      await analyzeProject(fullPath);
    } else if (file.endsWith(".java") || file === "build.gradle") {
      const code = fs.readFileSync(fullPath, "utf8");
      console.log(`\n📄 Analizando: ${fullPath}`);
      const result = await askOllama(
        `Eres un experto en Android Studio y Gradle. 
        Revisa este archivo y dime posibles errores de compilación o mejoras:\n\n${code}`
      );
      console.log(result);
    }
  }
}

// Ajusta la ruta a tu proyecto
analyzeProject("C:/Users/crobe/AndroidStudioProjects/AppUTH326/app/src/main/java");
