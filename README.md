[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/pG3gvzt-)
# PCCCS495 – Term II Project

## Project Title
SMART COURSE REGISTRATION & ACADEMIC PLANNER SYSTEM

## Problem Statement (max 150 words)
In many colleges, course registration systems lack intelligent validation of academic constraints such as credit limits, prerequisites, time table conflicts, and course capacity. Students often register for incompatible or overloaded schedules, leading to inefficient planning and errors. 
This project aims to develop a Smart Course Registration & Academic Planner System using object-oriented principles. This system dynamically validates constraints such as credit limits, prerequisite completion, course capacity, and time table conflicts before allowing registration. It models real-world academic rules through structured class hierarchies and layered architecture. 
The goal is to demonstrate strong OOP design, modularity, and exception handling while simulating a realistic course registartion workflow. 

## Target User
- Undergraduate college students
- Academic administrators managing course offerings

## Core Features
- View available courses
- Register for courses with validation
- Credit Limit enforcement
- Prerequisite validation
- Timetable conflict detection
- Course capacity management
- View registered courses
- Persistent data storage using file handling
- Exception handling for invalid operations

## OOP Concepts Used
- Abstraction: Abstract classes like Course and User define common behaviour.
- Inheritance: Specialized classes such as CoreCourse, ElectiveCourse, LabCourse extend Course.
- Polymorphism: validateRegistration() method is overriden in different course types.
- Exception Handling: Custom exceptions like CreditLimitsExceededException, PrerequisiteNotMetException, CourseCapacityFullException, TimeTableConflictException. 
- Collections / Threads: ArrayList is used to manage dynamic data such as registered courses, completed courses and prerequisites. 

## Proposed Architecture Description
The system follows a layered architecture consisting of Model, Service, Repository, Exception and UI layers. 
The Model layer contains core entities like Student, Course, and its subclasses. The Service layer (RegistrationService) handles business logic including validation of credit limits, prerequisites, time table conflicts,a nd capacity constraints. 
The Repository layer manages data persistence using file handling and object serialization. The UI layer provides a console-based interactive menj for user-interaction. 
This seperation of concerns ensures modularity, maintainability, and scalability of the system. 

## How to Run
1. Compile all Java files: javac courseplanner/ui/MainMenu.java
2. Run the program: java courseplanner.ui.MainMenu
3. Follow the console menu to:
   - View courses
   - Register courses
   - View registered courses

## Git Discipline Notes
Minimum 10 meaningful commits required.

- Followed incremental development with meaningful commits.
- Implemented features step-by-step including model, service, exception handling and UI.
- Maintained proper commit messeges reflecting changes. 
