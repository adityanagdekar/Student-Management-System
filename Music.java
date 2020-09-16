import java.io.File;
import javax.sound.sampled.*;
import java.awt.*;
import java.net.URL;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.awt.event.*;


class Music{

public static void music1(){
try{
File url = new File("pling.wav");
AudioInputStream audioIn=AudioSystem.getAudioInputStream(url);
Clip clip = AudioSystem.getClip();
clip.open(audioIn);
clip.start();
}
catch(Exception e){
System.out.println(e);
}
}

public static void music2(){
try{
File url = new File("alert.wav");
AudioInputStream audioIn=AudioSystem.getAudioInputStream(url);
Clip clip = AudioSystem.getClip();
clip.open(audioIn);
clip.start();
}
catch(Exception e){
System.out.println(e);
}
}
}
