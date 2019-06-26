//面高一輝17B03867
package para.calc;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.geometry.Pos;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

/**
 * JavaFX 電卓アプリケーションのメインクラス
 */

public class Calculator extends Application{
  Label input;
  Label output;
  StringBuilder buff;
  Executor ex;
  int j = 0;
  public Calculator(){
    input = new Label();
    output = new Label();
    buff = new StringBuilder();
    ex = new Executor1();
  }
  String[] buttonname = {"9","8","7","+",
                         "6","5","4","-",
                         "3","2","1","*",
                         "0",".",",","/"};

  public void start(Stage stage){
    VBox root = new VBox();
    root.setAlignment(Pos.TOP_CENTER);
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.TOP_CENTER);
    Scene scene = new Scene(root, 200,300);
    Button[] buttons = new Button[16];
    
    Button buttoncal = new Button("=");
    buttoncal.setPrefHeight(56);
    Button buttondel = new Button("<");
    buttondel.setPrefHeight(56);
    StackPane stack = new StackPane();
    stack.getChildren().add(new Rectangle(140,30,Color.WHITE));
    stack.getChildren().add(input);
    root.getChildren().addAll(stack, output);
    for(int i=0;i<16;i++){
      buttons[i] = new Button(buttonname[i]);
      buttons[i].setPrefWidth(28);
      buttons[i].setPrefHeight(28);
      if (i < 4) {
        grid.add(buttons[i],i,0);
      }else if(i < 8) {
        grid.add(buttons[i],i-4,1);
      }else if(i < 12) {
        grid.add(buttons[i],i-8,2);
      }else {
        grid.add(buttons[i],i-12,3);
      }    
    }

    grid.add(buttondel, 5, 0,1,2);
    grid.add(buttoncal, 5, 2,1,2);
    
    buttondel.setOnAction(e->{
      buff.deleteCharAt(buff.length()-1);
      input.setText(buff.toString());
      });
    buttoncal.setOnAction(e->{
      output.setText(ex.operation(buff.toString()));
      });
    buttons[0].setOnAction(e->{
      buff.append(buttonname[0]);
      input.setText(buff.toString());
      });
    buttons[1].setOnAction(e->{
      buff.append(buttonname[1]);
      input.setText(buff.toString());
      });
    buttons[2].setOnAction(e->{
      buff.append(buttonname[2]);
      input.setText(buff.toString());
      });
    buttons[3].setOnAction(e->{
      buff.append(buttonname[3]);
      input.setText(buff.toString());
      });
    buttons[4].setOnAction(e->{
      buff.append(buttonname[4]);
      input.setText(buff.toString());
      });
    buttons[5].setOnAction(e->{
      buff.append(buttonname[5]);
      input.setText(buff.toString());
      });
    buttons[6].setOnAction(e->{
      buff.append(buttonname[6]);
      input.setText(buff.toString());
      });
    buttons[7].setOnAction(e->{
      buff.append(buttonname[7]);
      input.setText(buff.toString());
      });
    buttons[8].setOnAction(e->{
      buff.append(buttonname[8]);
      input.setText(buff.toString());
      });
    buttons[9].setOnAction(e->{
      buff.append(buttonname[9]);
      input.setText(buff.toString());
      });
    buttons[10].setOnAction(e->{
      buff.append(buttonname[10]);
      input.setText(buff.toString());
      });
    buttons[11].setOnAction(e->{
      buff.append(buttonname[11]);
      input.setText(buff.toString());
      });
    buttons[12].setOnAction(e->{
      buff.append(buttonname[12]);
      input.setText(buff.toString());
      });
    buttons[13].setOnAction(e->{
      buff.append(buttonname[13]);
      input.setText(buff.toString());
      });
    buttons[14].setOnAction(e->{
      buff.append(buttonname[14]);
      input.setText(buff.toString());
      });
    buttons[15].setOnAction(e->{
      buff.append(buttonname[15]);
      input.setText(buff.toString());
      });
    




    











    root.getChildren().add(grid);
    stage.setWidth(200);
    stage.setHeight(200);
    stage.setScene(scene);
    stage.setTitle("JavaFX Calc");
    stage.show();
  }
}
