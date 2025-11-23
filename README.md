### Alvia Vaz - Elanco Backend Challenge
-------------------------------------------------------------------------------------------------------------------------------------------------

### Project Outline:
I have chose the backend challenge to create a MVP for a web application in order to process Tick Sighting Data. Through this project I made use of the following technology: java, javafx, maven and scenebuilder and the apache POI java library.

I designed main.fxml in scenebuilder to create the GUI which is displayed in the code in Main.java, the controller for this fxml file is ExcelController.java.This displays the tick sighting data,has active listeners for user filtering and creates and sends endpoints to a local server. The controller file references ExcelInitial.java, this gets rid of any incomplete and duplicate data. ExcelRow.java is referenced in both these files as it provides the format for how data is displayed.

All Java files are in TickData\src\main\java and fxml files and Tick Sightings .xlsx can be found in TickData\src\main\resources.

### How to run:
1) Install Java 21.0.7.
2) Install JavaFX 25.0.1.
3) Install Maven 3.9.9.
4) Install Apache POI library version 5.2.5
5) Copy Elanco-Backend-Challenge folder to IDE of choice eg: Visual Studio Code.
6) In launch.json, replace "vmArgs" module path with where you have installed javafx.
7) In settings.json replace paths od libraries with where you have installed them from javafx.
8) In ExcelController.java line 46, replace path of Tick Sightings.xls with your path.
9) Run in project terminal eg: in Visual Studio Code using mvn clean javafx:run in the TickData directory.

\* HTTPServer must be terminated eg: by using powershell before the program is run again

