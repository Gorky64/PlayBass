# PlayBass

![alt text](http://i.imgur.com/3W6CZvA.jpg "Play Bass")

This is my first Android application.

#App Intro
This application uses App Intro library which you can check out [here.](https://github.com/apl-devs/AppIntro)

#About the application
* The app uses MediaPlayer to reproduce notes on a bass guitar. 
* The goal was to play a sound while the button is pressed and then stop the sound on button release.


#The code
Lets start with a basic On Touch Listener used for the buttons.

```java
        btnE1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnEzica.setText("F");
                    e1();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnEzica.setText("E");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
```
Each button has its own MediaPlayer method to produce sound.
```java
 private void e1() {
        mediaPlayer = MediaPlayer.create(this, R.raw.e0_mp3);
    }
```
Since I used ```.stop();``` and ```.release();``` methods on each button I had to disable multi touch in my application.
This was done by adding ```android:splitMotionEvents="false"``` in the ```ScrollView``` of ```activity_main.xml```.

```
<item name="android:splitMotionEvents">false</item>
<item name="android:windowEnableSplitTouch">false</item>
```
Was also added in the values directory ```styles.xml```

To display a note diagram i used a simple intent
```
 <intent
     android:action="android.intent.action.MAIN"
     android:targetPackage="com.example.goran.playbass"
     android:targetClass="com.example.goran.playbass.NotesActivity">
 </intent>
 ``` 
 in xml directory ```preferences.xml```. 
 This intent just starts up an Activity used for viewing the diagram.
 ![alt text](http://i.imgur.com/4ZVM52S.png "Notes diagram")

And that's it, pretty simple and straightforward app.
        
