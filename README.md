# Farmer-sMarket
Hack@CEWIT 2024 - JavaFX Farmer's Market Application

Farmer's Market App
Description
The Farmer's Market app is a JavaFX desktop application designed to connect users directly with farmers, allowing them to buy groceries seamlessly. It features a unique page where users can request food recipes and record their favorite ones. The application leverages Firebase for backend services and OpenAI's ChatGPT API to generate and suggest recipes.

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

bash
Copy code
git clone https://github.com/yourusername/FarmersMarket.git
cd FarmersMarket
Configure Firebase

Set up a Firebase project in the Firebase Console.
Download the firebase-admin-sdk.json file and place it in the src/main/resources directory.
Configure OpenAI API Key

Obtain an API key from OpenAI.
Store the API key in a properties file or as an environment variable.
Build the Project

go
Copy code
mvn package
Run the Application

bash
Copy code
java -jar target/farmersmarket-1.0-SNAPSHOT.jar
Usage
After launching the Farmer's Market app, users can:

Log in or Sign up using their email.
Browse available produce listed by farmers.
Add items to their cart and complete the purchase.
Request and view food recipes.
Save and manage their favorite recipes.
Contributing
We welcome contributions to the Farmer's Market app! Please read our contributing guidelines (CONTRIBUTING.md) for details on our code of conduct and the process for submitting pull requests.

License
This project is licensed under the MIT License - see the LICENSE.md file for details.

Acknowledgments
Farmers who provide fresh produce
OpenAI for the ChatGPT API
Firebase for backend solutions
