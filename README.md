# onlineexamination_CipherByteTechnologies

Overview

This project implements a simple console-based exam system in Java. It allows users to log in, update their profiles, change their passwords, and take exams with a set time limit.
Features

    User Authentication:
        Users can log in with a username and password.
        Simple authentication using a predefined set of users.

    Profile Management:
        Users can update their profile information.
        Users can change their password.

    Exams:
        Users can take an exam with multiple-choice questions.
        The exam has a time limit, after which it will automatically submit.

Structure

The project consists of two classes:

    ExamSystem: The main class that handles the application's logic and user interactions.
    User: A class representing a user with attributes for username, password, and profile information.

Getting Started
Prerequisites

    Java Development Kit (JDK) installed.
    An IDE or text editor for Java development.

Running the Program

    Clone the Repository:

    sh

git clone https://github.com/your-repo/exam-system.git

Navigate to the Project Directory:

sh

cd exam-system

Compile the Java Files:

sh

javac com/exam/*.java

Run the Main Class:

sh

    java com.exam.ExamSystem

Usage
Main Menu

    Login:
        Prompts the user to enter their username and password.
        If credentials are valid, the user is logged in and the main menu is displayed.
    Exit:
        Exits the application.

User Menu

    Update Profile:
        Allows the user to update their profile information.
    Update Password:
        Allows the user to change their password.
    Take Exam:
        Presents the user with a series of multiple-choice questions.
        The user must answer within the specified time limit (60 seconds by default).
        The exam is automatically submitted when the time limit is reached or the user finishes answering all questions.
    Logout:
        Logs the user out and returns to the main menu.

Code Overview
ExamSystem Class

    Main Method:
        Displays the main menu and handles user input.
        Manages user authentication and navigation to the user menu.

    Login Method:
        Prompts the user for their username and password.
        Validates the credentials and sets the currentUser.

    Show Menu Method:
        Displays the user menu and handles user input for profile management and exams.

    Update Profile Method:
        Allows the user to update their profile information.

    Update Password Method:
        Allows the user to change their password.

    Take Exam Method:
        Presents multiple-choice questions to the user.
        Uses a timer to enforce the exam's time limit.
        Submits the exam automatically when the time limit is reached.

    Auto Submit Method:
        Handles the submission of the exam answers.
        Can be used to evaluate answers or perform other required actions.

User Class

    Attributes:
        username: The user's username.
        password: The user's password.
        profileInfo: Additional profile information.

    Methods:
        Getter and setter methods for username, password, and profileInfo.

Future Enhancements

    Add more detailed evaluation of exam answers.
    Store user data persistently using a database or file system.
    Implement more comprehensive error handling.
    Add more features such as registration, admin roles, and exam management.

License

This project is open-source and available under the MIT License.

Feel free to modify the code to suit your needs or contribute to the project by submitting pull requests. If you encounter any issues or have suggestions for improvement, please open an issue on GitHub.
