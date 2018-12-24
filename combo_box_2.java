package kursovaya;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.*;
import javafx.stage.Stage;
import javafx.scene.text.Text.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class combo_box_2 extends Application {

    ArrayList<File> files = new ArrayList<File>();
    File filename1 = new File("C://Users//yulii//IdeaProjects//OOP//src//kursovaya//document1");
    File filename2 = new File("C://Users//yulii//IdeaProjects//OOP//src//kursovaya//document2");
    File filename3 = new File("C://Users//yulii//IdeaProjects//OOP//src//kursovaya//document3");

    // Launch the application
    public void start(Stage stage) {

        files.add(filename1);
        files.add(filename2);
        files.add(filename3);

        // Set title for the stage
        stage.setTitle("ComboBox");

        // Create a tile pane
        TilePane r = new TilePane();

        // Create a label
        Label description_label =
                new Label("ComboBox");

        // Weekdays
        String variants_of_sorting[] =
                {"Sport", "Countries-Sport", "Olympic-Countries-Sport"};

        // Create a combo box
        ComboBox combo_box =
                new ComboBox(FXCollections
                        .observableArrayList(variants_of_sorting));

        // Label to display the selected menuitem
        Label selected = new Label("default item selected");


        // Create action event
        EventHandler<ActionEvent> event1 =
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        selected.setText(combo_box.getValue() + " selected");
                        Sport[] sports = Controller.makeSportsArray(files);
                        Arrays.sort(sports, new Comparator<Sport>() {
                            public int compare(Sport s1, Sport s2) {
                                int result = s1.getSport().compareTo(s2.getSport());
                                return result;
                            }
                        });
                        System.out.println(Arrays.toString(sports));
                        File result = new File("C://Users//yulii//IdeaProjects//OOP//src//kursovaya//result");
                        Controller.writeInFile(result, sports);
                        files.removeAll(files);

                    }
                };
        EventHandler<ActionEvent> event2 =
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        selected.setText(combo_box.getValue() + " selected");
                        Sport[] sports = Controller.makeSportsArray(files);
                        Arrays.sort(sports, new Comparator<Sport>() {
                            public int compare(Sport s1, Sport s2) {
                                int result = s1.countries - s2.countries;
                                if (result == 0) {
                                    return result;
                                }
                                result = s1.sport.compareTo(s2.sport);
                                if (result == 0) {

                                    return result;
                                }
                                return result;
                            }
                        });
                        System.out.println(Arrays.toString(sports));
                        File result = new File("C://Users//yulii//IdeaProjects//OOP//src//kursovaya//result");
                        Controller.writeInFile(result, sports);
                        files.removeAll(files);

                    }
                };
        EventHandler<ActionEvent> event3 =
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        selected.setText(combo_box.getValue() + " selected");
                        Sport[] sports = Controller.makeSportsArray(files);
                        Arrays.sort(sports, new Comparator<Sport>() {
                            public int compare(Sport s1, Sport s2) {
                                int result = s1.isOlympic.compareTo(s2.isOlympic);
                                if (result != 0) {
                                    return result;
                                }
                                result = s1.countries - s2.countries;
                                if (result != 0) {
                                    return result;
                                }
                                return s1.sport.compareTo(s2.sport);
                            }
                        });
                        System.out.println(Arrays.toString(sports));
                        File result = new File("C://Users//yulii//IdeaProjects//OOP//src//kursovaya//result3");
                        Controller.writeInFile(result, sports);
                        files.removeAll(files);

                    }
                };
// Set on action
        combo_box.setOnAction(event1);


        // Create a tile pane
        TilePane tile_pane = new TilePane(combo_box, selected);

        // Create a scene
        Scene scene = new Scene(tile_pane, 200, 200);

        // Set the scene
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String args[]) {
        // Launch the application
        launch(args);
    }
}