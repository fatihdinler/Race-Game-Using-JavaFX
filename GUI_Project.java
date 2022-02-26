package com.example.javafxdemo;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

/**********************************
 * Fatih Erkam Dinler : 150119567 *
 *********************************/

public class GUI_Project extends Application {

    int primaryPlayerScore = 0; // --> primaryPlayerScore shows that the total score of player1.
    int secondaryPlayerScore = 0; // ---> secondaryPlayerScore shows that the total score of player2.

    /** randomNumber1 and randomNumber1 are the created number with Math.random() method, they also used in the movement in cars.*/
    int randomNumber1;
    int randomNumber2;

    Image image1;
    ImageView car1;

    Image image2;
    ImageView car2;

    Image image3;
    ImageView flag1;

    Image image4;
    ImageView flag2;

    Image image5;
    ImageView finishline;

    Button buttonForPlayer1;
    Button buttonForPlayer2;

    Text whoWın;

    Bounds bounds1;
    Bounds bounds2;
    Bounds bounds3;

    TranslateTransition transitionForFirstCar = new TranslateTransition();
    TranslateTransition transitionForSecondCar = new TranslateTransition();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();


        /** Setting the text areas. (Player-1 and Player-2) */
        pane.setPadding(new Insets(5, 5, 5, 5));
        Text playerName1Text = new Text(750, 60, "Player 1");
        playerName1Text.setUnderline(true);
        playerName1Text.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));
        pane.getChildren().add(playerName1Text);

        Text playerName2Text = new Text(750, 600, "Player 2");
        pane.setPadding(new Insets(5, 5, 5, 5));
        playerName2Text.setUnderline(true);
        playerName2Text.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));
        pane.getChildren().add(playerName2Text);


        /** Creating the score table for player1 using both rectangle and Text.
         * While pressing the button, users will have a random number. scoreRectangle1 and scoreRectangle2
         * shows that the total number. */
        Rectangle scoreRectangle1 = new Rectangle(200, 100, 200, 70);
        scoreRectangle1.setStroke(Color.BLACK);
        scoreRectangle1.setFill(Color.WHITE);
        scoreRectangle1.setArcHeight(35);
        scoreRectangle1.setArcWidth(25);
        pane.getChildren().add(scoreRectangle1);

        pane.setPadding(new Insets(5, 5, 5, 5)); // --> Text inside the Rectangle.
        Text scoreTableText1 = new Text(260, 135, "Your score is : " + primaryPlayerScore);
        pane.getChildren().add(scoreTableText1);

        Rectangle scoreRectangle2 = new Rectangle(200, 640, 200, 70);
        scoreRectangle2.setStroke(Color.BLACK);
        scoreRectangle2.setFill(Color.WHITE);
        scoreRectangle2.setArcHeight(35);
        scoreRectangle2.setArcWidth(25);
        pane.getChildren().add(scoreRectangle2);

        pane.setPadding(new Insets(5, 5, 5, 5)); // --> Text inside the Rectangle.
        Text scoreTableText2 = new Text(260, 675, "Your score is : " + secondaryPlayerScore);
        pane.getChildren().add(scoreTableText2);

        /** After the pressing button, we are going to have a number between 0-4. This number
         * provides the movement of the cars. Users can see the numbers in the below rectangles. */
        Rectangle rectangleForShowingRandomNumber1 = new Rectangle(1170, 100, 200, 70);
        rectangleForShowingRandomNumber1.setStroke(Color.BLACK);
        rectangleForShowingRandomNumber1.setFill(Color.WHITE);
        rectangleForShowingRandomNumber1.setArcHeight(35);
        rectangleForShowingRandomNumber1.setArcWidth(25);
        pane.getChildren().add(rectangleForShowingRandomNumber1);

        pane.setPadding(new Insets(5, 5, 5, 5));
        Text textForRandomNumber1 = new Text(1190, 135, "Created Random Number is : " + randomNumber1);
        pane.getChildren().add(textForRandomNumber1);

        Rectangle rectangleForShowingRandomNumber2 = new Rectangle(1170, 640, 200, 70);
        rectangleForShowingRandomNumber2.setStroke(Color.BLACK);
        rectangleForShowingRandomNumber2.setFill(Color.WHITE);
        rectangleForShowingRandomNumber2.setArcHeight(35);
        rectangleForShowingRandomNumber2.setArcWidth(25);
        pane.getChildren().add(rectangleForShowingRandomNumber2);

        pane.setPadding(new Insets(5, 5, 5, 5));
        Text textForRandomNumber2 = new Text(1190, 675, "Created Random Number is : " + randomNumber2);
        pane.getChildren().add(textForRandomNumber2);

        /** I create 2 cars for both player1 and player2.  */
        pane.setPadding(new Insets(5, 5, 5, 5));
        image1 = new Image("file:src/main/resources/images/car1.png");
        car1 = new ImageView(image1);
        car1.setFitWidth(100);
        car1.setFitHeight(50);
        car1.setX(30);
        car1.setY(300);
        pane.getChildren().add(car1);

        pane.setPadding(new Insets(5, 5, 5, 5));
        image2 = new Image("file:src/main/resources/images/car2.png");
        car2 = new ImageView(image2);
        car2.setFitWidth(100);
        car2.setFitHeight(50);
        car2.setX(30);
        car2.setY(385);
        pane.getChildren().add(car2);


        /** I create a flag to highlight the finish line.  */
        pane.setPadding(new Insets(5, 5, 5, 5));
        image3 = new Image("file:src/main/resources/images/flag.png");
        flag1 = new ImageView(image3);
        flag1.setFitHeight(80);
        flag1.setFitWidth(50);
        flag1.setX(1420);
        flag1.setY(170);
        pane.getChildren().add(flag1);

        pane.setPadding(new Insets(5, 5, 5, 5));
        image4 = new Image("file:src/main/resources/images/flagg.png");
        flag2 = new ImageView(image4);
        flag2.setRotate(180);
        flag2.setFitHeight(80);
        flag2.setFitWidth(50);
        flag2.setX(1420);
        flag2.setY(480);
        pane.getChildren().add(flag2);

        /** I create a finish image for specifying that it's a finish line. */
        pane.setPadding(new Insets(5, 5, 5, 5));
        image5 = new Image("file:src/main/resources/images/finishline.jpeg");
        finishline = new ImageView(image5);
        finishline.setRotate(90);
        finishline.setFitHeight(10);
        finishline.setFitWidth(225);
        finishline.setX(1325);
        finishline.setY(360);
        pane.getChildren().add(finishline);


        /** Creating Buttons for both Player-1 and Player-2. We used these buttons for
         * movements of cars, getting scores and returning random numbers. */

        /** Button for Player 1*/
        buttonForPlayer1 = new Button();
        buttonForPlayer1.setText("PLAY");
        buttonForPlayer1.setLayoutX(740);
        buttonForPlayer1.setLayoutY(120);
        Font font = Font.font("Courier New", FontWeight.BOLD, 25);
        buttonForPlayer1.setFont(font);

        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Random rand1 = new Random();
                randomNumber1 = 1 + rand1.nextInt(7);

                textForRandomNumber1.setText("Created Random Number is : " + randomNumber1);

                primaryPlayerScore += randomNumber1;
                scoreTableText1.setText("Your Score is : " + primaryPlayerScore);

                moveFirstCar(car1, randomNumber1);


                buttonForPlayer1.setDisable(true);
                buttonForPlayer2.setDisable(false);

            }
        };

        buttonForPlayer1.setOnAction(event1);
        pane.getChildren().add(buttonForPlayer1);


        /** Button for Player 2*/
        buttonForPlayer2 = new Button();
        buttonForPlayer2.setText("PLAY");
        buttonForPlayer2.setLayoutX(740);
        buttonForPlayer2.setLayoutY(655);
        Font font2 = Font.font("Courier New", FontWeight.BOLD, 25);
        buttonForPlayer2.setFont(font2);

        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Random rand2 = new Random();
                randomNumber2 = 1 + rand2.nextInt(7);
                textForRandomNumber2.setText("Created Random Number is : " + randomNumber2);

                secondaryPlayerScore += randomNumber2;
                scoreTableText2.setText("Your Score is : " + secondaryPlayerScore);

                moveSecondCar(car2, randomNumber2);
                buttonForPlayer1.setDisable(false);
                buttonForPlayer2.setDisable(true);
            }
        };

        buttonForPlayer2.setOnAction(event2);
        pane.getChildren().add(buttonForPlayer2);


        /** I create 2 lines. (Yellow lines) */
        Line line1 = new Line(30, 250, 1450, 250);
        line1.setStrokeWidth(7);
        line1.setStroke(Color.YELLOW);
        pane.getChildren().add(line1);

        Line line2 = new Line(30, 480, 1450, 480);
        line2.setStrokeWidth(7);
        line2.setStroke(Color.YELLOW);
        pane.getChildren().add(line2);

        /** I created sets of dash lines for seperating the road into two parts. (White Lines) */

        Line dashLine1 = new Line(30.0, 367.5, 50.0, 367.5);
        dashLine1.setStrokeWidth(3);
        dashLine1.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine1);

        Line dashLine2 = new Line(60.0, 367.5, 80.0, 367.5);
        dashLine2.setStrokeWidth(3);
        dashLine2.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine2);

        Line dashLine3 = new Line(90.0, 367.5, 110.0, 367.5);
        dashLine3.setStrokeWidth(3);
        dashLine3.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine3);

        Line dashLine4 = new Line(120.0, 367.5, 140.0, 367.5);
        dashLine4.setStrokeWidth(3);
        dashLine4.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine4);

        Line dashLine5 = new Line(150.0, 367.5, 170.0, 367.5);
        dashLine5.setStrokeWidth(3);
        dashLine5.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine5);


        Line dashLine6 = new Line(180.0, 367.5, 200.0, 367.5);
        dashLine6.setStrokeWidth(3);
        dashLine6.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine6);

        Line dashLine7 = new Line(210.0, 367.5, 230.0, 367.5);
        dashLine7.setStrokeWidth(3);
        dashLine7.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine7);

        Line dashLine8 = new Line(240.0, 367.5, 260.0, 367.5);
        dashLine8.setStrokeWidth(3);
        dashLine8.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine8);

        Line dashLine9 = new Line(270.0, 367.5, 290.0, 367.5);
        dashLine9.setStrokeWidth(3);
        dashLine9.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine9);

        Line dashLine10 = new Line(300.0, 367.5, 320.0, 367.5);
        dashLine10.setStrokeWidth(3);
        dashLine10.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine10);

        Line dashLine11 = new Line(330.0, 367.5, 350.0, 367.5);
        dashLine11.setStrokeWidth(3);
        dashLine11.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine11);

        Line dashLine12 = new Line(360.0, 367.5, 380.0, 367.5);
        dashLine12.setStrokeWidth(3);
        dashLine12.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine12);

        Line dashLine13 = new Line(390.0, 367.5, 410.0, 367.5);
        dashLine13.setStrokeWidth(3);
        dashLine13.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine13);

        Line dashLine14 = new Line(420.0, 367.5, 440.0, 367.5);
        dashLine14.setStrokeWidth(3);
        dashLine14.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine14);

        Line dashLine15 = new Line(450.0, 367.5, 470.0, 367.5);
        dashLine15.setStrokeWidth(3);
        dashLine15.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine15);

        Line dashLine16 = new Line(480.0, 367.5, 500.0, 367.5);
        dashLine16.setStrokeWidth(3);
        dashLine16.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine16);

        Line dashLine17 = new Line(510.0, 367.5, 530.0, 367.5);
        dashLine17.setStrokeWidth(3);
        dashLine17.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine17);

        Line dashLine18 = new Line(540.0, 367.5, 560.0, 367.5);
        dashLine18.setStrokeWidth(3);
        dashLine18.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine18);

        Line dashLine19 = new Line(570.0, 367.5, 590.0, 367.5);
        dashLine19.setStrokeWidth(3);
        dashLine19.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine19);

        Line dashLine20 = new Line(600.0, 367.5, 620.0, 367.5);
        dashLine20.setStrokeWidth(3);
        dashLine20.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine20);

        Line dashLine21 = new Line(630.0, 367.5, 650.0, 367.5);
        dashLine21.setStrokeWidth(3);
        dashLine21.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine21);

        Line dashLine22 = new Line(660.0, 367.5, 680.0, 367.5);
        dashLine22.setStrokeWidth(3);
        dashLine22.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine22);

        Line dashLine23 = new Line(690.0, 367.5, 710.0, 367.5);
        dashLine23.setStrokeWidth(3);
        dashLine23.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine23);

        Line dashLine24 = new Line(720.0, 367.5, 740.0, 367.5);
        dashLine24.setStrokeWidth(3);
        dashLine24.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine24);

        Line dashLine25 = new Line(750.0, 367.5, 770.0, 367.5);
        dashLine25.setStrokeWidth(3);
        dashLine25.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine25);

        Line dashLine26 = new Line(780.0, 367.5, 800.0, 367.5);
        dashLine26.setStrokeWidth(3);
        dashLine26.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine26);

        Line dashLine27 = new Line(810.0, 367.5, 830.0, 367.5);
        dashLine27.setStrokeWidth(3);
        dashLine27.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine27);

        Line dashLine28 = new Line(840.0, 367.5, 860.0, 367.5);
        dashLine28.setStrokeWidth(3);
        dashLine28.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine28);

        Line dashLine29 = new Line(870.0, 367.5, 890.0, 367.5);
        dashLine29.setStrokeWidth(3);
        dashLine29.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine29);

        Line dashLine30 = new Line(900.0, 367.5, 920.0, 367.5);
        dashLine30.setStrokeWidth(3);
        dashLine30.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine30);

        Line dashLine31 = new Line(930.0, 367.5, 950.0, 367.5);
        dashLine31.setStrokeWidth(3);
        dashLine31.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine31);

        Line dashLine32 = new Line(960.0, 367.5, 980.0, 367.5);
        dashLine32.setStrokeWidth(3);
        dashLine32.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine32);

        Line dashLine33 = new Line(990.0, 367.5, 1010.0, 367.5);
        dashLine33.setStrokeWidth(3);
        dashLine33.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine33);

        Line dashLine34 = new Line(1020.0, 367.5, 1040.0, 367.5);
        dashLine34.setStrokeWidth(3);
        dashLine34.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine34);

        Line dashLine35 = new Line(1050.0, 367.5, 1070.0, 367.5);
        dashLine35.setStrokeWidth(3);
        dashLine35.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine35);

        Line dashLine36 = new Line(1080.0, 367.5, 1100.0, 367.5);
        dashLine36.setStrokeWidth(3);
        dashLine36.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine36);

        Line dashLine37 = new Line(1110.0, 367.5, 1130.0, 367.5);
        dashLine37.setStrokeWidth(3);
        dashLine37.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine37);

        Line dashLine38 = new Line(1140.0, 367.5, 1160.0, 367.5);
        dashLine38.setStrokeWidth(3);
        dashLine38.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine38);

        Line dashLine39 = new Line(1170.0, 367.5, 1190.0, 367.5);
        dashLine39.setStrokeWidth(3);
        dashLine39.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine39);

        Line dashLine40 = new Line(1200.0, 367.5, 1220.0, 367.5);
        dashLine40.setStrokeWidth(3);
        dashLine40.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine40);

        Line dashLine41 = new Line(1230.0, 367.5, 1250.0, 367.5);
        dashLine41.setStrokeWidth(3);
        dashLine41.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine41);

        Line dashLine42 = new Line(1260.0, 367.5, 1280.0, 367.5);
        dashLine42.setStrokeWidth(3);
        dashLine42.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine42);

        Line dashLine43 = new Line(1290.0, 367.5, 1310.0, 367.5);
        dashLine43.setStrokeWidth(3);
        dashLine43.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine43);

        Line dashLine44 = new Line(1320.0, 367.5, 1340.0, 367.5);
        dashLine44.setStrokeWidth(3);
        dashLine44.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine44);

        Line dashLine45 = new Line(1350.0, 367.5, 1370.0, 367.5);
        dashLine45.setStrokeWidth(3);
        dashLine45.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine45);

        Line dashLine46 = new Line(1380.0, 367.5, 1400.0, 367.5);
        dashLine46.setStrokeWidth(3);
        dashLine46.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine46);

        Line dashLine47 = new Line(1410.0, 367.5, 1430.0, 367.5);
        dashLine47.setStrokeWidth(3);
        dashLine47.setStroke(Color.WHITE);
        pane.getChildren().add(dashLine47);

        /** I create a text for emphasize the player that win the race. */
        pane.setPadding(new Insets(5,5,5,5));
        whoWın = new Text(700,560," ");
        Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 25);
        whoWın.setFont(font);
        pane.getChildren().add(whoWın);

        /** I control here the intersection of the finishline and the cars. */

        car1.translateXProperty().addListener(checkIntersection);
        car1.translateYProperty().addListener(checkIntersection);

        car2.translateXProperty().addListener(checkIntersection);
        car2.translateYProperty().addListener(checkIntersection);


        /** The below line provides the background color of pane. */
        pane.setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));

        /** Creating a scene and placing the scene into primaryStage. */
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Race Game!");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /** moveFirstCar and moveSecondCar methods provide that the movement of the cars and they take two parameters
     * in types of both ImageView and int. We used transifitonForFirstCar and transitionForSecondCar object
     * for providing the animation. */
    public void moveFirstCar(ImageView car, int number) {
        int positionX = (int) car.getX();
        int positionY = (int) car.getY();

        transitionForFirstCar.setByX(number * 30);
        transitionForFirstCar.setDuration(Duration.millis(1000));
        transitionForFirstCar.setAutoReverse(false);
        transitionForFirstCar.setNode(car);
        transitionForFirstCar.play();


    }

    public void moveSecondCar(ImageView car, int number) {
        int positionX = (int) car.getX();
        int positionY = (int) car.getY();

        transitionForSecondCar.setByX(number * 30);
        transitionForSecondCar.setDuration(Duration.millis(1000));
        transitionForSecondCar.setAutoReverse(false);
        transitionForSecondCar.setNode(car);
        transitionForSecondCar.play();

    }

    /** I used ChangeListener to control that the intersection of car1 and finishline and car2 and finishline. */
    public final ChangeListener<Number> checkIntersection = (ob, n, n1)->{
        /** If car1 intersects the finish line before car2, then it means the winner player is player1. */
        if (car1.getBoundsInParent().intersects(finishline.getBoundsInParent())){
            buttonForPlayer1.setDisable(true);
            buttonForPlayer2.setDisable(true);
            whoWın.setText("Player 1 is win !");
            transitionForFirstCar.stop();

        }
        /** If car2 intersects the finsih line before car1, then it means the winner playler is player2. */
        if(car2.getBoundsInParent().intersects(finishline.getBoundsInParent())) {
            buttonForPlayer1.setDisable(true);
            buttonForPlayer2.setDisable(true);
            whoWın.setText("Player 2 is win !");
            transitionForSecondCar.stop();
        }
    };

}
