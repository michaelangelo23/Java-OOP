Build and Run LE2 class

-> building the LE2.1
javac --module-path javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml GUI/src/main/java/LE2_1GUI.java
 
-> running the LE2_1
java --module-path javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml -cp GUI/src/main/java LE2_1GUI



for LE2.2

javac --module-path javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml GUI/src/main/java/LE2_2GUI.java   // build
java --module-path javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml -cp GUI/src/main/java LE2_2GUI     // run


for LE2.3

javac --module-path javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml GUI/src/main/java/LE2_3GUI.java
java --module-path javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml -cp GUI/src/main/java LE2_3GUI

