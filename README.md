# Explanation of the Project

Make a simple web interface where users can inform LIMIT results as an integer and a
MIN_VALUE as a double between 0 and 1, as well as upload a CSV file consisting of a column
called Id (consisting of unique int identifiers) and an arbitrary number of other columns
consisting a numbers between 0 and 1.

# Project Structure

In the model folder there is only one class:
- Column: where I store the column position and the actual number

I created a Utilities folder that will help to read the file we want to parse.

The Parser folder will hold the Restful calls methods in the system.

To run the project you have two options: 
- Pull the project from Git and running in your local machine configuring a Tomcat server for it.
- Pull the project from Git, build the war file of the project, drop in a server you have available and go to the address: whateverserveraddress/Warwick.
