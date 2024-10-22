# Weather Application

## Overview
The Weather Application is a web-based application that allows users to retrieve, create, update, and delete weather records. It provides functionalities to log user preferences and fetch weather data based on user input.

## Features
- Retrieve all weather records.
- Fetch weather data for a specific city.
- Create new weather records.
- Update existing weather records.
- Delete weather records.
- Log user preferences for recent city searches.

## Technologies Used
- **Backend**: [Node.js](https://nodejs.org/) (or your preferred backend framework)
- **Database**: [MongoDB](https://www.mongodb.com/) (or your preferred database)
- **Frontend**: [React](https://reactjs.org/) (or your preferred frontend framework)

## API Endpoints
- `GET /api/weather/all`: Retrieve all weather records.
- `GET /api/weather/{city}`: Fetch weather data for a specific city.
- `POST /api/weather/create`: Create a new weather record.
- `PUT /api/weather/{city}`: Update an existing weather record.
- `DELETE /api/weather/{city}`: Delete a weather record.

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/madhumedisetty/Weather_App_Using_Spring.git
   ```
2. Navigate to the project directory:
   ```bash
   cd weather-app
   ```
3. Install dependencies:
   ```bash
   npm install
   ```
4. Set up your database and update the configuration files as necessary.
5. Start the application:
   ```bash
   npm start
   ```

## Usage
- Access the application through your web browser at `http://localhost:3000` (or the specified port).
- Use the provided API endpoints to interact with the weather records.
