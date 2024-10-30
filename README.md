# Steel Plant Delay Management System

A Java-based full-stack application designed to manage and monitor delays in a steel plant’s machinery operations. The project records equipment downtime, analyzes delays by categories, and visualizes them with graphs, providing insights into areas like shop-wise delays, continuous delays, and agency-related delays.

## Table of Contents
- [Overview](#Overview)
- [Features](#Features)
- [Technologies Used](#Technologies-used)
- [Prerequisites](#Prerequisites)
- [Installation_](#Installation)
   

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

### Installation
1. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/steel-plant-delay-management.git
