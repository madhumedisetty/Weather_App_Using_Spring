Here’s a detailed `README.md` file for your project:

---

# Weather API Application

This project is a **Spring Boot-based Weather API** that allows users to **fetch and update weather conditions** for cities. It uses in-memory storage to manage weather data and provides a simple structure to demonstrate RESTful APIs, Spring configurations, and exception handling.

---

## Features

- **GET Weather by City:** Retrieve the weather condition for a specific city (or with an optional country).
- **POST Weather Condition:** Update the weather condition for a city with optional country input.
- **Default Weather Condition:** Returns "Sunny" (or configured default) if no weather data exists for a city.
- **Basic Validation and Exception Handling:** Handles null/empty inputs with meaningful error messages.

---

## Tech Stack

- **Java 21**  
- **Spring Boot 3.3.4**  
- **Spring Web**  
- **Spring Validation API**  
- **Maven**  

---

## How to Run the Application

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/your-username/weather-api.git
   cd weather-api
   ```

2. **Update Maven Dependencies:**

   Ensure all dependencies are downloaded by running:

   ```bash
   mvn clean install
   ```

3. **Run the Application:**

   Use the following command to start the application:

   ```bash
   mvn spring-boot:run
   ```

4. **Access the API:**

   Once the application is running, it will be available at:
   ```
   http://localhost:8080/api
   ```

---

## API Endpoints

### 1. **GET /api/weather**  
**Description:** Retrieve the weather condition for a given city and optional country.  
**Example Request:**  
```bash
GET http://localhost:8080/api/weather?city=Visakhapatnam&country=India
```
**Response:**  
- If data exists:  
  ```text
  Cloudy
  ```
- If data does not exist:  
  ```text
  Sunny (Default)
  ```

### 2. **POST /api/weather**  
**Description:** Update the weather condition for a given city and optional country.  
**Example Request:**  
```bash
POST http://localhost:8080/api/weather
```
**Parameters:**
- **city**: Name of the city (Required)  
- **country**: Name of the country (Optional)  
- **condition**: New weather condition (Optional)  

**Example Request with Parameters:**
```bash
POST http://localhost:8080/api/weather?city=Visakhapatnam&country=India&condition=Rainy
```
**Response:**
```text
Madhu updated the weather condition for Visakhapatnam, India to: Rainy
```

---

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com.example.demo
│   │       ├── WeatherApiApplication.java  // Main application entry point
│   │       ├── WeatherConfig.java          // Configuration for default condition
│   │       ├── WeatherController.java      // REST controller for API endpoints
│   │       └── WeatherService.java         // Service layer managing weather logic
│   └── resources
│       ├── application.properties          // Application configuration
```

---

## application.properties

This file configures the **default weather condition**:

```properties
spring.application.name=demo
weather.default-condition=Sunny
```

- If a city’s weather condition is not updated, it defaults to **Sunny**.

---


## How It Works

1. **Weather Data Storage:**  
   The weather conditions are stored in-memory using a `HashMap`.  
   - Key: `"city,country"` (e.g., `Visakhapatnam,India`)
   - Value: Weather condition (e.g., `Cloudy`)

2. **Default Condition Handling:**  
   If a city’s weather condition is not found, the **default condition** ("Sunny") from the `WeatherConfig` is returned.
