package com.mycompany.week6assignment;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
//for importing ctrl+space

/**
 * JavaFX App
 */
public class App extends Application {
    Group sp;

    @Override
    public void start(Stage stage) {
        sp = new Group();
        var scene = new Scene(sp, 500, 500);
        //create sky
        Rectangle sky = new Rectangle(0, 0, 500, 200);
        sky.setFill(Color.LIGHTBLUE);
        sp.getChildren().add(sky);
        
        //create grass
        Rectangle grass = new Rectangle(0, 200, 500, 300);
        grass.setFill(Color.GREEN);
        sp.getChildren().add(grass);
        
        //create roof
        Polygon roof = new Polygon(50.0, 100.0, 250.0, 0.0, 450.0, 100.0);
        roof.setFill(Color.WHITE);
        roof.setStroke(Color.BLACK);
        sp.getChildren().add(roof);
        
        //create house base
        Rectangle house = new Rectangle(75, 100, 350, 300);
        house.setFill(Color.DARKRED);
        house.setStroke(Color.BLACK);
        sp.getChildren().add(house);
        
        //create top rail
        Rectangle rail = new Rectangle(75, 100, 350, 20);
        rail.setFill(Color.WHITE);
        rail.setStroke(Color.BLACK);
        sp.getChildren().add(rail);
        
        //create plaque
        Rectangle plaque = new Rectangle (225, 150, 50, 25);
        plaque.setFill(Color.GRAY);
        plaque.setStroke(Color.BLACK);
        sp.getChildren().add(plaque);
        
        //create left door with windows
        Rectangle doorLeft = new Rectangle (125, 230,50, 105);
        doorLeft.setFill(Color.WHITE);
        doorLeft.setStroke(Color.BLACK);
        sp.getChildren().add(doorLeft);
        doorWindows(135, 235);
        
        //create center door with windows
        Rectangle doorCenter = new Rectangle (225, 205, 50, 130);
        doorCenter.setFill(Color.WHITE);
        doorCenter.setStroke(Color.BLACK);
        sp.getChildren().add(doorCenter);
        doorWindows(235, 235);
        
        //create right door with windows
        Rectangle doorRight = new Rectangle (325, 230, 50, 105);
        doorRight.setFill(Color.WHITE);
        doorRight.setStroke(Color.BLACK);
        sp.getChildren().add(doorRight);
        doorWindows(335, 235);
        
        //create floor
        Rectangle floor = new Rectangle (75, 335, 350, 3);
        floor.setFill(Color.GRAY);
        floor.setStroke(Color.BLACK);
        sp.getChildren().add(floor);

        //create pillars
        createPillars(85, 120);
        
        //create stairs
        createStairs(120, 335);
        
        stage.setScene(scene);
        stage.setTitle("A House");
        stage.show();
    }
    
    //creates the black windows with a for loop
    public void doorWindows(int x, int y){
        int j = 0;
        for (int i = 0; i < 5; i++){
            if (i == 0){
                Rectangle window = new Rectangle(x, y + j, 10, 10);        
                sp.getChildren().add(window);
            
                Rectangle window2 = new Rectangle(x+20, y + j, 10, 10);        
                sp.getChildren().add(window2);
                
                j+=20;
            }
            else{
                Rectangle window = new Rectangle(x, y + j, 10, 15);        
                sp.getChildren().add(window);
            
                Rectangle window2 = new Rectangle(x+20, y + j, 10, 15);        
                sp.getChildren().add(window2);
            
                j+= 20;
            }
        }
        
    }
    
    //creates the pillars using a for loop
    public void createPillars (int x, int y){
        int j = 0;
        
        for (int i = 0; i < 4; i++){
            Rectangle pillar = new Rectangle(x+j, y, 30, 205);
            pillar.setFill(Color.WHITE);
            pillar.setStroke(Color.BLACK);
            sp.getChildren().add(pillar);

            Rectangle base = new Rectangle((x-5)+j, 325, 40, 10);
            base.setFill(Color.WHITE);
            base.setStroke(Color.BLACK);
            sp.getChildren().add(base);

            Circle circleLeft = new Circle();
            circleLeft.setCenterX(x+j);
            circleLeft.setCenterY(y+10);
            circleLeft.setRadius(10);
            circleLeft.setFill(Color.WHITE);
            circleLeft.setStroke(Color.BLACK);
            sp.getChildren().add(circleLeft);


            Circle circleRight = new Circle();
            circleRight.setCenterX(x+30+j);
            circleRight.setCenterY(y+10);
            circleRight.setRadius(10);
            circleRight.setFill(Color.WHITE);
            circleRight.setStroke(Color.BLACK);
            sp.getChildren().add(circleRight);

            j+=100;
        }

    }
    
    //create stairs using a for loop
    public void createStairs(int x, int y){
        int j = 0;
        int lengthMult = 0;
        int pushBack = 0;
        for (int i = 0; i < 11; i++){
            Rectangle stair = new Rectangle(x - pushBack, y+j, 260+lengthMult, 6);
            stair.setFill(Color.GRAY);
            stair.setStroke(Color.BLACK);
            sp.getChildren().add(stair);
            
            j+=6;
            lengthMult += 12;
            pushBack += 6;
        }
    }

    public static void main(String[] args) {
        launch();
    }

}