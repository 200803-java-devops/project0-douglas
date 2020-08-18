# Welcome to the project Health Checker
The purpose of the project is to develop a reliable COVID tracking information managment system that also gives you recommendation based on your location. In addition, it will store the exporsure information and generate your rate of exposure and give recommendation based on your input.

# Gather user information
- [x] Allow user to input location
- [x] Check if they are in danger of COVID
- [x] Check Cases
- [x] Check Exposure Rate

# Gather COVID information
- [x] Government website - found Times data instead
- [x] Merge CSV to local database
- [x] Enable server and sql


# To Run
docker build -t coviddb .
docker run -p 2345:5432 -d coviddb

