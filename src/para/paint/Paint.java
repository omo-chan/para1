//面高一輝17B03867
package para.paint;

import javafx.application.Application;

import javafx.stage.*;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.canvas.*;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.beans.value.ObservableValue;

import java.io.File;
import java.io.IOException;

import javax.imageio.*;
import javafx.embed.swing.*;
/**
 * JavaFX お絵描きアプリケーションのメインクラス
 */
public class Paint extends Application{
  Canvas canvas;
  GraphicsContext gc;
  /** 直前のポインタのx座標 */
  double oldx;
  /** 直前のポインタのy座標 */
  double oldy;
  /** 描画領域の大きさ */
  final int SIZE=600;
  Button clear;
  int i=0;
  /**
   * お絵描きプログラムの準備をして、ウィンドウを開きます
   */
  public void start(Stage stage){
    //Group group = new Group();
    canvas = new Canvas(SIZE,SIZE);
    gc = canvas.getGraphicsContext2D();
    drawShapes(gc);
    canvas.setOnMousePressed(ev->{
        oldx = ev.getX();
        oldy = ev.getY();
      });

    canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                           new EventHandler<MouseEvent>(){
                             public void handle(MouseEvent ev){
                               gc.strokeLine(oldx, oldy, ev.getX(), ev.getY());
                               gc.setLineCap(StrokeLineCap.ROUND);
                               oldx = ev.getX();
                               oldy = ev.getY();
                             }
                           });
    clear = new Button("clear");
    clear.setOnAction(e->{
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,SIZE,SIZE);});
  //課題3.4
    Button rotate = new Button("rotate");  
    rotate.setOnAction(e->{   
        canvas.setRotate(90*i);
        i++;
        });
  //課題3.4
    Button save = new Button("save");  
    save.setOnAction(e->{
      WritableImage img = canvas.snapshot(new SnapshotParameters(), null);
      FileChooser fc = new FileChooser();
      File f = fc.showSaveDialog(stage);
      try{
        ImageIO.write(SwingFXUtils.fromFXImage(img, null), "png", f);
      }catch(IOException e1){
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
        });
    
    
    Rectangle rect = new Rectangle(25,30);//課題3.3
    rect.setFill(Color.color(0,0,1));//課題3.3
    

    BorderPane bp = new BorderPane();
    VBox vb = new VBox();
    HBox hb = new HBox();
    Slider sliderr = new Slider(0, 1, 0);
    Slider sliderg = new Slider(0, 1, 0);
    Slider sliderb = new Slider(0, 1, 1);
    Slider slidero = new Slider(0, 1, 1);//課題3.2
    Slider sliderw = new Slider(0, 20, 5);//課題3.2
    //課題3.4
    Button background = new Button("背景塗りつぶし");
    background.setOnAction(e->{
      float colorr = (float)sliderr.getValue();
      float colorg = (float)sliderg.getValue();
      float colorb = (float)sliderb.getValue();
      gc.setFill(Color.color(colorr,colorg,colorb));
      gc.fillRect(0,0,SIZE,SIZE);});
    //課題3.1
    
    sliderr.valueProperty().addListener((ObservableValue<? extends Number> ov,
                                         Number oldv, Number nv)->{
                                           float colorr = (float)sliderr.getValue();
                                           float colorg = (float)sliderg.getValue();
                                           float colorb = (float)sliderb.getValue();
                                           float opacity = (float)slidero.getValue();
                                           canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                                               new EventHandler<MouseEvent>(){
                                                 public void handle(MouseEvent ev){
                                                   gc.setStroke(Color.color(colorr,colorg,colorb,opacity));                                                  
                                                 }                                             
                                               });
                                           rect.setFill(Color.color(colorr,colorg,colorb));//課題3.3

      });
    sliderg.valueProperty().addListener((ObservableValue<? extends Number> ov,
                                           Number oldv, Number nv)->{
                                             float colorr = (float)sliderr.getValue();
                                             float colorg = (float)sliderg.getValue();
                                             float colorb = (float)sliderb.getValue();
                                             float opacity = (float)slidero.getValue();
                                             canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                                                 new EventHandler<MouseEvent>(){
                                                   public void handle(MouseEvent ev){
                                                     gc.setStroke(Color.color(colorr,colorg,colorb,opacity));
                                                   }
                                                 });
                                             rect.setFill(Color.color(colorr,colorg,colorb));//課題3.3

        }) ;
    sliderb.valueProperty().addListener((ObservableValue<? extends Number> ov,
                                           Number oldv, Number nv)->{
                                             float colorr = (float)sliderr.getValue();
                                             float colorg = (float)sliderg.getValue();
                                             float colorb = (float)sliderb.getValue();
                                             float opacity = (float)slidero.getValue();
                                             canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                                                 new EventHandler<MouseEvent>(){
                                                   public void handle(MouseEvent ev){
                                                     gc.setStroke(Color.color(colorr,colorg,colorb,opacity));
                                                   }
                                                 });
                                             rect.setFill(Color.color(colorr,colorg,colorb));//課題3.3

        }) ;
    //課題3.1ここまで
    //課題3.2
    slidero.valueProperty().addListener((ObservableValue<? extends Number> ov,
        Number oldv, Number nv)->{
          float colorr = (float)sliderr.getValue();
          float colorg = (float)sliderg.getValue();
          float colorb = (float)sliderb.getValue();
          float opacity = (float)slidero.getValue();
          canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
              new EventHandler<MouseEvent>(){
                public void handle(MouseEvent ev){
                  gc.setStroke(Color.color(colorr,colorg,colorb,opacity));
                }
              });

});
    //課題3.2
    sliderw.valueProperty().addListener((ObservableValue<? extends Number> ov,
        Number oldv, Number nv)->{
          float colorr = (float)sliderr.getValue();
          float colorg = (float)sliderg.getValue();
          float colorb = (float)sliderb.getValue();
          float opacity = (float)slidero.getValue();
          float width = (float)sliderw.getValue();
          canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
              new EventHandler<MouseEvent>(){
                public void handle(MouseEvent ev){
                  
                  gc.setStroke(Color.color(colorr,colorg,colorb,opacity));
                  gc.setLineWidth(width);
                }
              });

});
    vb.setAlignment(Pos.CENTER);
    vb.getChildren().add(sliderr);//課題3.1
    vb.getChildren().add(sliderg);//課題3.1
    vb.getChildren().add(sliderb);//課題3.1
    vb.getChildren().add(slidero);//課題3.2
    vb.getChildren().add(sliderw);//課題3.2
    hb.setAlignment(Pos.CENTER);
    hb.getChildren().add(rotate);//課題3.4
    hb.getChildren().add(save);//課題3.4
    hb.getChildren().add(background);//課題3.4
    hb.getChildren().add(clear);
    hb.getChildren().add(rect);//課題3.3
    vb.getChildren().add(hb);
    bp.setTop(vb);
    bp.setBottom(canvas);
    Scene scene = new Scene(bp);
    stage.setScene(scene);
    stage.setTitle("JavaFX Draw");
    stage.show();
  }

  /**
   * 初期化メソッド、startメソッドの呼び出され方とは異なる呼び出され方をする。必要ならば定義する
   */
  public void init(){
  }

  /**
   * 図形を描きます。
   * 図形描画の実装サンプルです
   */
  private void drawShapes(GraphicsContext gc) {
    gc.setFill(Color.WHITE);
    gc.fillRect(0,0,SIZE,SIZE);
    gc.setFill(Color.GREEN);
    gc.setStroke(Color.BLUE);
    gc.setLineWidth(4);
    gc.strokeLine(40, 10, 10, 40);
    gc.fillOval(60, 10, 30, 30);
    gc.strokeOval(110, 10, 30, 30);
    gc.fillRoundRect(160, 10, 30, 30, 10, 10);
  }
}
