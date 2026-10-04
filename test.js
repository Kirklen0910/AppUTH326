import OpenAI from "openai";

const client = new OpenAI({
  apiKey: process.env.OPENAI_API_KEY
});

async function test() {
  try {
    const response = await client.chat.completions.create({
      model: "gpt-4.1-mini",
      messages: [{ role: "user", content: "Hola, prueba de conexión con Service Account Key." }]
    });
    console.log("✅ Conexión exitosa:");
    console.log(response.choices[0].message.content);
  } catch (error) {
    console.error("❌ Error en la conexión:", error);
  }
}

test();
