# Weather API Application

A simple Spring Boot application to manage weather data for cities using REST endpoints. It allows fetching and updating weather conditions for specific cities.

## Features
- **GET** weather data for a city.
- **POST** to update weather data for a city with optional condition.
- In-memory storage of weather data using a `Map`.
- Default weather condition can be configured via `application.properties`.

## Prerequisites
- **Java 17+** installed
- **Maven** installed
- **Spring Boot** framework

## Getting Started

### 1. Clone the Repository
```bash
git clone <repository-url>
cd <repository-directory>
```

### 2. Build and Run the Application
```bash
mvn clean install
mvn spring-boot:run
```

### 3. API Endpoints

#### GET Weather for a City
Fetch weather data for a specific city.

- **Endpoint**: `/api/weather/{city}`
- **Method**: `GET`
- **Example**:
  ```bash
  curl http://localhost:8080/api/weather/NewYork
  ```

#### POST Update Weather for a City
Update weather data for a specific city with an optional condition.

- **Endpoint**: `/api/weather/{city}`
- **Method**: `POST`
- **Query Param**: `condition` (Optional)
- **Example**:
  ```bash
  curl -X POST "http://localhost:8080/api/weather/NewYork?condition=Sunny"
  ```

### 4. Configuration
You can set a **default weather condition** in the `application.properties` file.

```properties
weather.default-condition=Cloudy
```

### 5. Example Response
For GET `/api/weather/NewYork`:

```
Sunny
```

For POST `/api/weather/NewYork?condition=Rainy`:

```
Weather updated for NewYork
```

### 6. Project Structure
```
src
├── main
│   ├── java/com/example/demo
│   │   ├── WeatherApiApplication.java  # Main class to run the application
│   │   ├── WeatherConfig.java          # Configuration for default conditions
│   │   ├── WeatherController.java      # REST Controller handling API endpoints
│   │   ├── WeatherService.java         # Service class for weather logic
│   │   └── WeatherRecord.java          # POJO class for weather data
│   └── resources
│       └── application.properties      # Configuration properties
```
