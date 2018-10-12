package javafxView;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author nguyenminhkhoa
 */
public class Lab6 extends Application  {

    Label label1 = new Label();
    Label label2 = new Label(); 
   
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Button[][] button = new Button [3][3];
        
        Button button1 = new Button("   x   ");
        Button button2 = new Button("   o   ");
        Button button3 = new Button("   x   ");
        Button button4 = new Button("   o   ");
        Button button5 = new Button("   +   ");
        Button button6 = new Button("   +   ");
        Button button7 = new Button("   +   ");
        Button button8 = new Button("   x   ");
        Button button9 = new Button("   o   ");
        Button button10 = new Button(" Start ");
              
        
        button[0][0]=button1;
        button[0][1]=button2;
        button[0][2]=button3;
        button[1][0]=button4;
        button[1][1]=button5;
        button[1][2]=button6;
        button[2][0]=button7;
        button[2][1]=button8;
        button[2][2]=button9;
        
        

        GridPane gridPane = new GridPane();

        gridPane.add(button[0][0], 0, 0, 1, 1);
        gridPane.add(button[0][1], 1, 0, 1, 1);
        gridPane.add(button[0][2], 2, 0, 1, 1);
        gridPane.add(button[1][0], 0, 1, 1, 1);
        gridPane.add(button[1][1], 1, 1, 1, 1);
        gridPane.add(button[1][2], 2, 1, 1, 1);
        gridPane.add(button[2][0], 0, 2, 1, 1);
        gridPane.add(button[2][1], 1, 2, 1, 1);
        gridPane.add(button[2][2], 2, 2, 1, 1);
        gridPane.add(button10, 0, 15, 4, 4);

        gridPane.add(label1,6,6,6,6);
        gridPane.add(label2,15,15,15,15);
        
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++)
                button[i][j].setVisible(false);
        
        
        button10.setOnAction(event -> {
            
        button10.setText(" Reset ");
        
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++) {
                button[i][j].setVisible(true);
                button[i][j].setStyle("-fx-default-button: #ABD8ED");
                label1.setVisible(false);
                label2.setVisible(false);
                final Button myButton1 = button[i][j];
                
                int x = i;
                int y = j;
                
                myButton1.setOnAction((ActionEvent event1) -> {
                    myButton1.setStyle("-fx-background-color: #ABD8ED");
                    for (int a = 0; a<3; a++) {
                        for (int b = 0; b<3; b++) {
                            final Button myButton2 = button[a][b];
                            int c = a;
                            int d = b;
                            myButton2.setOnAction((ActionEvent event2) -> {
                                if((Math.abs(x - c) + Math.abs(y - d)) == 1) {
                                    label1.setVisible(true);
                                    label1.setText("ValidMove");
                                    label2.setVisible(true);
                                    label2.setText("["+x+","+y+"] "+"vs ["+c+","+d+"]");
                                    
                                    
                                } else  {
                                    label1.setVisible(true);
                                    label1.setText("NonValidMove");
                                    label2.setVisible(true);
                                    label2.setText("["+x+","+y+"] "+"vs ["+c+","+d+"]");
                                    
                                }
                            });
                        }
                    }
                });
        }
        });
        
        Scene scene = new Scene(gridPane, 340, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
       
         
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
