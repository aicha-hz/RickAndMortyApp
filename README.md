# Rick and Morty App 

A simple Android app that displays characters from the **Rick and Morty API**, built with **Kotlin**, **MVVM**, and **Retrofit**.

## 🚀 Features

- Displays characters in a beautiful **RecyclerView grid**
- **Pagination** for smooth scrolling
- **Search** functionality to find specific characters
- Click on a character to open a **details screen**
- Clean architecture with **ViewModel + LiveData**
- Follows **MVVM pattern** and uses **coroutines** for background API calls

## 💻 API Used

[The Rick and Morty API](https://rickandmortyapi.com/)  
A free RESTful API providing character, location, and episode data.

## Instructions for Building and Running

-Prerequisites
Android Studio Giraffe or later
JDK 17+
Internet connection (for fetching API data)

-Steps to Run
Clone the repository
Open the project in Android Studio
Run the app on an emulator or a physical device

-Architectural Choices

The app follows the MVVM (Model-View-ViewModel) pattern for a clean and organized structure:
Model: Handles the data and API calls.
ViewModel: Manages the logic and prepares data for the UI.
View: Displays the data and observes changes from the ViewModel.

-Assumptions & Design Decisions
The app assumes stable network connectivity (no offline caching implemented).
Used Retrofit for simplicity and reliability in REST API calls.
Pagination is implemented manually using info.next from the API response


## 📱 Screenshots

