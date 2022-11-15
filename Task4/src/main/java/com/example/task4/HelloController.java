package com.example.task4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.ImageCollection;
import model.Iterator;
import javafx.event.ActionEvent;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public ImageView view;

    public ImageCollection imgs = new ImageCollection();
    public Iterator iter_main = imgs.getIterator();

    public Timeline timeline = new Timeline();


    public void UpClick(ActionEvent actionEvent) {

        if (iter_main.hasNext()) {
            Image name = (Image) iter_main.next();
            view.setImage(name);
        }
    }

       /* view.setImage(new Image("/coin.jpeg"));

        System.out.println("111");
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Загрузка файла....");

        File file = fileChooser.showOpenDialog(view.getScene().getWindow());

        view.setImage(new Image(file.getName()));

        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath()); */


    public void DownClick(ActionEvent actionEvent) {
        if (iter_main.hasPreview()) {
            Image name = (Image) iter_main.preview();
            view.setImage(name);
        }
    }


    public void PlayClick(ActionEvent actionEvent) {
        timeline.play();
    }

    public void StopClick(ActionEvent actionEvent) {
        timeline.stop();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeline.setCycleCount(Timeline.INDEFINITE);//кол-во повторов
        timeline.getKeyFrames().add(new KeyFrame(new Duration(1500), new EventHandler() {
            @Override
            public void handle(Event event) {
                if (iter_main.hasNext()) {
                    Image name = (Image) iter_main.next();
                    view.setImage(name);
                }
            }
        }));
    }
}