

# Full-Stack Angular-Spring Application

This project is a full-stack application built with Angular for the frontend and Spring Boot for the backend. The application provides a comprehensive solution for managing payments and users.

## Frontend

The frontend of the application is built with Angular, a popular framework for building web applications. The application uses Angular Material for the UI components.

### Key Features

- **User Authentication**: The application uses the `AuthService` to manage user authentication. The `isAuth` variable in `auth.service.ts` is used to check if a user is authenticated.
- **User Authorization**: The `AuthorizationGuard` in `authorization.guard.ts` uses the `userRoles` variable to manage user roles and permissions.
- **User Interface**: The `AdmineTemplateComponent` in `admine-template.component.ts` uses the `isMenuOpen` variable to manage the state of the navigation menu.
- **Payment Management**: The `PayementsComponent` in `payements.component.ts` provides the functionality for managing payments.

## Backend

The backend of the application is built with Spring Boot, a framework for building stand-alone, production-grade Spring based applications.

### Key Features

- **Payment Service**: The `PayementService` in `PayementService.java` provides the core functionality for managing payments.
- **Student Management**: The `StudentRepository` in `StudentRepository.java` provides the functionality for managing students.
- **Payment REST Controller**: The `PayementRestController` in `PayementRestController.java` provides the REST API for managing payments.

## Technologies Used

- **Frontend**: Angular, Angular Material
- **Backend**: Spring Boot, JPA, H2 Database
- **Build Tool**: Maven
- **Version Control**: Git

## Getting Started

To get started with this project:

1. Clone the repository.
2. Navigate to the `frontend` directory and run `npm install` to install the dependencies.
3. Run `ng serve` to start the development server. Navigate to `http://localhost:4200/`.
4. Navigate to the `backend` directory and run the application.

For more detailed instructions, refer to the README files in the `frontend` and `backend` directories.
