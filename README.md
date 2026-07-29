# Smart Bank Application

Smart Bank is a mini banking application developed to practice modern Android development concepts using Kotlin and Jetpack Compose.

The main purpose of this project was to understand and apply real-world Android application architecture patterns rather than only building a UI.

## What I learned and implemented

* **Modern Android UI development** with Jetpack Compose
* **Material 3** design system and custom theming
* **MVVM (Model-View-ViewModel)** architecture
* **State management** with StateFlow
* **Repository pattern** for clean data handling
* **Separation of concerns**: UI, business logic, and data layers
* **Kotlin Coroutines** for asynchronous operations
* **Immutable UI state management** using data classes and `copy()`
* **Reusable Compose components**

## Project Architecture

The project follows a layered MVVM structure:

`UI (Jetpack Compose) -> ViewModel -> Repository -> Service -> Models`

## Main Features

* **Account management**: Displaying account information.
* **Banking Operations**: Deposit and withdrawal operations.
* **Transaction History**: Tracking and displaying past transactions.
* **Dynamic UI**: Real-time updates based on application state.
* **State Handling**: Comprehensive loading and error state management.

This project was created as a learning project to build a strong foundation for developing larger Android applications, including SDK-based and real-time applications.
