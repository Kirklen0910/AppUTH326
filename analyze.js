import fs from "fs";
import path from "path";
import OpenAI from "openai";

const client = new OpenAI({ apiKey: process.env.OPENAI_API_KEY });

async function analyzeAllJavaFiles(dir) {
  const files = fs.readdirSync(dir);
  for (const file of files) {
    const fullPath = path.join(dir, file);
    const stat = fs.statSync(fullPath);

    if (stat.isDirectory()) {
      await analyzeAllJavaFiles(fullPath);
    } else if (file.endsWith(".java") || file === "build.gradle") {
      const code = fs.readFileSync(fullPath, "utf8");

      try {
        const response = await client.chat.completions.create({
          model: "gpt-4.1",
          messages: [
            { role: "system", content: "Eres un experto en Android Studio y Gradle." },
            { role: "user", content: `Revisa este archivo:\n${code}` }
          ]
        });

        console.log(`\n📄 Archivo: ${fullPath}`);
        console.log(response.choices[0].message.content);
      } catch (error) {
        console.error(`❌ Error analizando ${fullPath}:`, error);
      }
    }
  }
}

// Ajusta la ruta según tu proyecto
analyzeAllJavaFiles("app/src/main/java/com/uth/apputh326");
