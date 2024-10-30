# Steel Plant Delay Management System

A Java-based full-stack application designed to manage and monitor delays in a steel plant’s machinery operations. The project records equipment downtime, analyzes delays by categories, and visualizes them with graphs, providing insights into areas like shop-wise delays, continuous delays, and agency-related delays.

## Table of Contents
- [Overview](#Overview)
- [Features](#Features)
- [Technologies Used](#Technologies-used)
- [Prerequisites](#Prerequisites)
- [Database Setup](#Database-Setup)
- [Database Structure](#Database-Structure)
- [Running the Application](#Running-the-Application)
- [Usage](#Usage)
- [Installation](#Installation)
   

---

## Overview

The **Steel Plant Delay Management System** addresses the issue of machinery downtime in a steel plant, where numerous machines run continuously, occasionally causing operational delays. This system allows users to log and analyze delays by tracking the following data:
- Delay occurrences
- Duration of delay
- Affected equipment
- Types of delays (shop-wise, continuous, raw material delays, and agency delays)

The project uses an Excel sheet as the main data source, managed within the MySQL database in XAMPP.

## Features

- **User Authentication**: Login and registration for secure access.
- **Dashboard**: Provides an overview of delays and quick access to reports.
- **Menu Tree Navigation**: Organized view of various delay categories.
- **Data Fetching & Visualization**:
  - Shop-wise delays
  - Continuous equipment delays
  - Raw materials delays
  - Agency delays
- **Graphs**: Visual representation of delay data for quick analysis.

## Technologies Used

- **Frontend**: HTML, CSS, Bootstrap
- **Middleware**: Java Servlets
- **Backend**: MySQL (via XAMPP), Excel for initial data import
- **Server**: Apache Tomcat


### Prerequisites
1. **NetBeans IDE** (with Apache Tomcat configured)
2. **XAMPP** for MySQL
3. **Git** for version control (optional)

## Database Setup

1. **Start XAMPP** and activate **Apache** and **MySQL**.
2. **Import the Excel data into MySQL**:
   - Open **phpMyAdmin** and create a database (e.g., `steel_plant_db`).
   - Import the Excel sheet into the database as required tables.
3. **Update the database configurations in the project**:
   - Edit database connection details in `DatabaseConnection.java`.


## Database Structure

The Excel sheet imported to MySQL serves as the primary database and includes the following tables:

- **Delays**: Tracks delay details (equipment, duration, type).
- **Users**: Stores user information for authentication.
- **Metrics**: Provides data for graphing delay types.

Refer to the SQL script in the `database/` directory for detailed table schemas.


## Running the Application

1. **Deploy the project on Apache Tomcat** through NetBeans.
2. Access the application at `http://localhost:8080/steel-plant-delay-management`.


## Usage

1. **Start** at the Welcome page.
2. **Login** to access the dashboard.
3. Navigate through the **Dashboard Menu** to view delay reports:
   - **Shop-wise Delays**: View delays for each shop.
   - **Continuous Delays**: Identify any equipment with recurring issues.
   - **Raw Material Delays**: Track delays caused by material issues.
   - **Agency Delays**: Analyze delays caused by agency work.
4. **Graphs**: View graphical representations for better insights.


## Installation
1. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/steel-plant-delay-management.git
