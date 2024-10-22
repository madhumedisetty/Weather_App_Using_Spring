# Weather Application

## Overview
This is a simple **Spring Boot-based Weather Application** that provides weather information for various cities. It allows you to update and retrieve weather conditions based on temperature inputs. The application demonstrates the use of **Spring Configuration Properties**, **Service Layer logic**, and **Dependency Injection** using `ApplicationContext`.

---
![Screenshot 2024-10-16 154547](https://github.com/user-attachments/assets/c1810ba0-61ab-4700-878b-d694ecf5ec92)


## Features
- **Get weather for a city:** Returns the current temperature and condition for a specified city.
- **Update weather for a city:** Updates the temperature and automatically adjusts the weather condition (Cold, Pleasant, or Hot).
- **Fetch all weather data:** Retrieve the weather details for all cities in the system.

---

## API Endpoints
1. **Get Weather for a City**  
   **`GET /api/weather/{city}`**  
   **Response Example:**  
   ```
   The temperature in New York is 22°C. Condition: Pleasant
   ```

2. **Update Weather for a City**  
   **`POST /api/weather/{city}?temperature={temperature}`**  
   **Response Example:**  
   ```
   Weather updated for New York
   ```

3. **Get All Weather Data**  
   **`GET /api/weather`**  
   **Response Example:**  
   ```
   {
     "New York": "22°C, Pleasant",
     "London": "15°C, Pleasant"
   }
   ```

---

## Configuration
Modify weather settings in the **`application.properties`** file.

```properties
weather.default-condition=Moderate
weather.city-temperatures.new-york.min=10
weather.city-temperatures.new-york.max=25
weather.city-temperatures.london.min=5
weather.city-temperatures.london.max=20
weather.city-temperatures.tokyo.min=15
weather.city-temperatures.tokyo.max=30
```

---

## Explanation of `ApplicationContext.getBean()`
Instead of manually creating `WeatherRecord` objects using the `new` keyword, this application utilizes **Spring's `ApplicationContext`** to fetch beans. This ensures that the instances are managed by Spring, improving **scalability** and **maintainability**.

---

## How to Run
1. Clone the repository.
2. Run `mvn spring-boot:run` to start the application.
3. Access the API at `http://localhost:8080/api/weather`.

---

## Technologies Used
- **Spring Boot**
- **Spring Configuration Properties**
- **Java 11+**
- **Maven**
