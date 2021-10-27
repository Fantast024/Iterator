package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import sample.Methods.ImageCollection;
import sample.Methods.Iterator;



public class Controller {
    public ImageCollection imgs =new ImageCollection("Picture");
    public Iterator iter_main = imgs.getIterator();
    public Timeline timeline =new Timeline();
    public ImageView imageCurr;
    public Slider slider;
    public TextField text;
    int key = 0;

    public void MDrop(MouseEvent mouseEvent) {
        text.setText(Math.round(slider.getValue()) + "");
    }

            public void ButtonPlay (ActionEvent actionEvent){
            if (key != 1) {
                timeline = new Timeline();
                timeline.setCycleCount(Timeline.INDEFINITE);

                timeline.getKeyFrames().add(new KeyFrame(new Duration(40 * (100 - Integer.valueOf(text.getText()))), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {

                        if (iter_main.hasNext()) {
                            Image name = (Image) iter_main.next();
                            imageCurr.setImage(name);
                        }
                    }
                }));

                timeline.play();
                key = 1;
            }else{
                System.out.println("Двойное нажатие кнопки <Play>");
            }
        }

    public void ButtonStop(ActionEvent actionEvent) {
        timeline.stop();
        key = 0;
    }


    public void ButtonNext(ActionEvent actionEvent) {
        timeline.stop();
        if (iter_main.hasNext()) {
            Image name = (Image) iter_main.next();
            imageCurr.setImage(name);
        }
    }

    public void ButtonPrevious(ActionEvent actionEvent) {
        timeline.stop();
        if (iter_main.hasNext()) {
            Image name = (Image) iter_main.back();
            imageCurr.setImage(name);
        }
    }


}
