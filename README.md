🚀 HumbleBot – AI Chat Application (Android)

HumbleBot is a modern Android chat application powered by Google's Gemini AI API.
It allows users to interact with AI in real-time using a clean and simple UI built with Kotlin + Jetpack Compose.

✨ Features

✅ Real-time AI chat using Gemini API
✅ Jetpack Compose UI
✅ Kotlin Coroutines & ViewModel
✅ Internet permission + secure API key handling
✅ Modern Material 3 UI components

📂 Tech Stack
Layer	Technology
Language	Kotlin
UI Framework	Jetpack Compose
Architecture	MVVM
Networking	Retrofit
State Mgmt	ViewModel + LiveData/State
AI	Google Gemini API
🛠️ Setup Instructions
1️⃣ Clone the repository
git clone https://github.com/Laxmanredd/Humble_Coders_Chart_Application.git
cd Humble_Coders_Chart_Application

2️⃣ Get Gemini API Key

Visit: https://ai.google.dev

Click Get API Key

Copy your key

3️⃣ Add API Key to project

In your project, open local.properties file (do not push to GitHub):

GEMINI_API_KEY=YOUR_API_KEY_HERE


❗ Never hardcode API keys in code — keep them in local.properties

4️⃣ Run in Android Studio

Open Android Studio

Select Open Project

Choose this project folder

Run on emulator or physical device

📦 Project Folder Structure
HumbleBot/
 ├── app/
 │   ├── src/main/java/.../ui
 │   ├── src/main/java/.../network
 │   ├── src/main/java/.../viewmodel
 ├── local.properties (API Key)
 └── README.md

✅ Future Enhancements

🔊 Voice chat support

💬 Chat message history storage (Room DB)

🌐 Multiple language support

🤖 AI personality modes (fun, study, coding)

🧑‍💻 Author

Laxman Reddy

🛡 License

This project is open-source for learning purposes.
Feel free to use & modify.

⭐ Support this Project

If this project helped you, please give it a ⭐ on GitHub!
