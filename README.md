# Task Setup and Execution

This guide outlines the steps to set up and run the task project. Please follow these instructions to get started.

## Prerequisites

- Eclipse IDE
- MySQL Workbench
- Git

## Setup

1. Clone the code from the GitHub repository:

   ```sh
   git clone https://github.com/yourusername/task-project.git

    
2. Clone the code from the GitHub repository:

   
 - Import the Project in Eclipse IDE
- Open Eclipse IDE.
- Click on File > Open Projects from File System.
- Browse to the cloned project folder and select it.
 - Click Finish to import the project.



3. Run these commands in MySQL Workbench:
 ```sh
CREATE DATABASE task;
USE task;
CREATE TABLE users (name VARCHAR(20), email VARCHAR(20), mobile VARCHAR(10));
 CREATE TABLE session(name VARCHAR(20), login DATETIME, logout DATETIME);
 CREATE TABLE messages(name VARCHAR(20), message VARCHAR(200));
  
```




  4. Run the program from Eclipse IDE.

 - Open your web browser and navigate to the following URL:

   ```sh
   http://localhost:8082/login
   ```
