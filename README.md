# AI-Market
Hack@CEWIT 2024 - JavaFX AI-Market Application

AI-Market App
Description
The AI-Market app is a JavaFX desktop application designed to connect users directly with farmers, allowing them to buy groceries seamlessly. It features a unique page where users can request food recipes and record their favorite ones. The application leverages Firebase for backend services and OpenAI's ChatGPT API to generate and suggest recipes.

Features
Direct Purchase from Farmers: Browse and purchase fresh produce directly from farmers.
Recipe Suggestions: Request food recipes based on the ingredients you have.
Recipe Recording: Keep a record of your favorite recipes within the app.
Integration with Firebase: For user authentication, data storage, and real-time updates.
ChatGPT API Integration: Leverages OpenAI's ChatGPT for dynamic recipe suggestions.
Installation
Prerequisites
Java Development Kit (JDK) 17 or above
Maven (for dependency management and build)
Firebase account (for backend services)
OpenAI API key (for ChatGPT integration)
Setup
Clone the repository

```bash
git clone https://github.com/yourusername/AI-Market.git
cd AI-Market
```

Configure Firebase

1. Set up a Firebase project in the Firebase Console.
2. Download the `firebase-admin-sdk.json` file and place it in the `src/main/resources` directory.
  
Configure OpenAI API Key

1. Obtain an API key from OpenAI.
2. Store the API key in a properties file or as an environment variable.

Build the Project

```bash
mvn package
```

Run the Application

```bash
java -jar target/ai-market-1.0-SNAPSHOT.jar
```

Usage
After launching the AI-Market app, users can:

1. Log in or Sign up using their email.
2. Browse available produce listed by farmers.
3. Add items to their cart and complete the purchase.
4. Request and view food recipes.
5. Save and manage their favorite recipes.

Contributing
We welcome contributions to the AI-Market app! Please read our contributing guidelines (CONTRIBUTING.md) for details on our code of conduct and the process for submitting pull requests.

License
This project is licensed under the MIT License - see the LICENSE.md file for details.

Acknowledgments
Farmers who provide fresh produce
OpenAI for the ChatGPT API
Firebase for backend solutions
