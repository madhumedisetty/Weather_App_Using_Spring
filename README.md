# Weather API Application

## Overview
This Weather API application allows users to manage weather records for different cities. Users can create, retrieve, and validate weather data, ensuring that the entries conform to specified conditions.

## Features
- Add new weather records.
- Retrieve all weather records or by specific city.
- Validate entries based on temperature and weather conditions.

## Technologies Used
- Java
- Spring Boot
- JPA/Hibernate
- Postman for API testing

## API Endpoints
### 1. Create Weather Record
- **Method:** POST
- **URL:** `/api/weather/create`
- **Request Body:**
  ```json
  {
      "city": "CityName",
      "temperature": TemperatureValue,
      "weatherCondition": "sunny|cloudy|rainy|snowy"
  }
  ```

### 2. Get All Weather Records
- **Method:** GET
- **URL:** `/api/weather/all`

### 3. Get Weather by City
- **Method:** GET
- **URL:** `/api/weather/{city}`

## Validation Rules
- Snowy weather is not allowed when the temperature is above 30°C.
- Sunny weather is not allowed when the temperature is below 0°C.

## Running the Application
1. Clone the repository.
2. Navigate to the project directory.
3. Run the application using `mvn spring-boot:run`.
4. Use Postman to test the API endpoints.

## Flowchart

![image](https://github.com/user-attachments/assets/c796dc94-a0e6-4fa9-8447-2c8cce26d758)



