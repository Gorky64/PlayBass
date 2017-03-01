package com.example.goran.playbass;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean doubleBackToExitPressOne;
    private Handler mHandler = new Handler();

    ImageView ivVrat;
    ScrollView svScrollview;
    Button btnEzica;
    Button btnAzica;
    Button btnGzica;
    Button btnDzica;
    Button btnE1;
    Button btnE2;
    Button btnE3;
    Button btnE4;
    Button btnE5;
    Button btnE6;
    Button btnE7;
    Button btnE8;
    Button btnE9;
    Button btnE10;
    Button btnE11;
    Button btnE12;
    Button btnA1;
    Button btnA2;
    Button btnA3;
    Button btnA4;
    Button btnA5;
    Button btnA6;
    Button btnA7;
    Button btnA8;
    Button btnA9;
    Button btnA10;
    Button btnA11;
    Button btnA12;
    Button btnG1;
    Button btnG2;
    Button btnG3;
    Button btnG4;
    Button btnG5;
    Button btnG6;
    Button btnG7;
    Button btnG8;
    Button btnG9;
    Button btnG10;
    Button btnG11;
    Button btnG12;
    Button btnD1;
    Button btnD2;
    Button btnD3;
    Button btnD4;
    Button btnD5;
    Button btnD6;
    Button btnD7;
    Button btnD8;
    Button btnD9;
    Button btnD10;
    Button btnD11;
    Button btnD12;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstStart();
        initWidgets();
        initMediaReproduction();

    }
    //Starts AppIntro on first app run
    public void firstStart() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences getPrefs = PreferenceManager
                        .getDefaultSharedPreferences(getBaseContext());

                boolean isFirstStart = getPrefs.getBoolean("firstStart", true);

               if (isFirstStart) {

                    Intent i = new Intent(MainActivity.this, Intro.class);
                    startActivity(i);

                    SharedPreferences.Editor e = getPrefs.edit();

                    e.putBoolean("firstStart", false);

                    e.apply();
                }
            }
        });

        t.start();
    }

    //ACTION BAR menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings, menu);
        return true;
    }

    //Starts the shared preferences
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menuSettings) {
            Intent settingsIntent = new Intent(this, CustomPreferenceActivity.class);
            startActivity(settingsIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    //Double back to exit app
    private final Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            doubleBackToExitPressOne = false;
        }
    };

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressOne) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressOne = true;
        Toast.makeText(this, R.string.double_back, Toast.LENGTH_SHORT).show();
        mHandler.postDelayed(mRunnable, 2000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        super.finish();


        if (mHandler != null) {
            mHandler.removeCallbacks(mRunnable);
        }
    }
    //Initializes widgets
    public void initWidgets() {

        btnEzica = (Button) findViewById(R.id.btnEzica);
        btnAzica = (Button) findViewById(R.id.btnAzica);
        btnDzica = (Button) findViewById(R.id.btnDzica);
        btnGzica = (Button) findViewById(R.id.btnGzica);
        svScrollview = (ScrollView) findViewById(R.id.svScrollview);
        ivVrat = (ImageView) findViewById(R.id.ivVrat);

        btnE1 = (Button) findViewById(R.id.btnE1);
        btnE2 = (Button) findViewById(R.id.btnE2);
        btnE3 = (Button) findViewById(R.id.btnE3);
        btnE4 = (Button) findViewById(R.id.btnE4);
        btnE5 = (Button) findViewById(R.id.btnE5);
        btnE6 = (Button) findViewById(R.id.btnE6);
        btnE7 = (Button) findViewById(R.id.btnE7);
        btnE8 = (Button) findViewById(R.id.btnE8);
        btnE9 = (Button) findViewById(R.id.btnE9);
        btnE10 = (Button) findViewById(R.id.btnE10);
        btnE11 = (Button) findViewById(R.id.btnE11);
        btnE12 = (Button) findViewById(R.id.btnE12);

        btnA1 = (Button) findViewById(R.id.btnA1);
        btnA2 = (Button) findViewById(R.id.btnA2);
        btnA3 = (Button) findViewById(R.id.btnA3);
        btnA4 = (Button) findViewById(R.id.btnA4);
        btnA5 = (Button) findViewById(R.id.btnA5);
        btnA6 = (Button) findViewById(R.id.btnA6);
        btnA7 = (Button) findViewById(R.id.btnA7);
        btnA8 = (Button) findViewById(R.id.btnA8);
        btnA9 = (Button) findViewById(R.id.btnA9);
        btnA10 = (Button) findViewById(R.id.btnA10);
        btnA11 = (Button) findViewById(R.id.btnA11);
        btnA12 = (Button) findViewById(R.id.btnA12);

        btnD1 = (Button) findViewById(R.id.btnD1);
        btnD2 = (Button) findViewById(R.id.btnD2);
        btnD3 = (Button) findViewById(R.id.btnD3);
        btnD4 = (Button) findViewById(R.id.btnD4);
        btnD5 = (Button) findViewById(R.id.btnD5);
        btnD6 = (Button) findViewById(R.id.btnD6);
        btnD7 = (Button) findViewById(R.id.btnD7);
        btnD8 = (Button) findViewById(R.id.btnD8);
        btnD9 = (Button) findViewById(R.id.btnD9);
        btnD10 = (Button) findViewById(R.id.btnD10);
        btnD11 = (Button) findViewById(R.id.btnD11);
        btnD12 = (Button) findViewById(R.id.btnD12);

        btnG1 = (Button) findViewById(R.id.btnG1);
        btnG2 = (Button) findViewById(R.id.btnG2);
        btnG3 = (Button) findViewById(R.id.btnG3);
        btnG4 = (Button) findViewById(R.id.btnG4);
        btnG5 = (Button) findViewById(R.id.btnG5);
        btnG6 = (Button) findViewById(R.id.btnG6);
        btnG7 = (Button) findViewById(R.id.btnG7);
        btnG8 = (Button) findViewById(R.id.btnG8);
        btnG9 = (Button) findViewById(R.id.btnG9);
        btnG10 = (Button) findViewById(R.id.btnG10);
        btnG11 = (Button) findViewById(R.id.btnG11);
        btnG12 = (Button) findViewById(R.id.btnG12);
    }
    //Initializes  On Touch Listeners
    public void initMediaReproduction() {
        //MEDIA PLAYER

        //E ŽICA
        btnEzica.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    e0();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });

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
        btnE2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnEzica.setText("F♯");
                    e2();
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
        btnE3.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnEzica.setText("G");
                    e3();
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
        btnE4.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnEzica.setText("G♯");
                    e4();
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
        btnE5.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnEzica.setText("A");
                    e5();
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
        btnE6.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnEzica.setText("A♯");
                    e6();
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
        btnE7.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnEzica.setText("B");
                    e7();
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
        btnE8.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnEzica.setText("C");
                    e8();
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
        btnE9.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnEzica.setText("C♯");
                    e9();
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
        btnE10.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnEzica.setText("D");
                    e10();
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
        btnE11.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnEzica.setText("D♯");
                    e11();
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
        btnE12.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    e12();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });

        //A ŽICA

        btnAzica.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

                    a0();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnA1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnAzica.setText("A♯");
                    a1();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnAzica.setText("A");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnA2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnAzica.setText("B");
                    a2();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnAzica.setText("A");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnA3.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnAzica.setText("C");
                    a3();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnAzica.setText("A");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnA4.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnAzica.setText("C♯");
                    a4();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnAzica.setText("A");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnA5.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnAzica.setText("D");
                    a5();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnAzica.setText("A");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnA6.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnAzica.setText("D♯");
                    a6();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnAzica.setText("A");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnA7.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnAzica.setText("E");
                    a7();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnAzica.setText("A");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnA8.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnAzica.setText("F");
                    a8();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnAzica.setText("A");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnA9.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnAzica.setText("F♯");
                    a9();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnAzica.setText("A");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnA10.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnAzica.setText("G");
                    a10();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnAzica.setText("A");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnA11.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnAzica.setText("G♯");
                    a11();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnAzica.setText("A");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnA12.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    a12();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });

        //D ŽICA

        btnDzica.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

                    d0();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnD1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnDzica.setText("E♭");
                    d1();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnDzica.setText("D");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnD2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnDzica.setText("E");
                    d2();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnDzica.setText("D");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnD3.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnDzica.setText("F");
                    d3();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnDzica.setText("D");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnD4.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnDzica.setText("F♯");
                    d4();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnDzica.setText("D");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnD5.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnDzica.setText("G");
                    d5();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnDzica.setText("D");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnD6.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnDzica.setText("G♯");
                    d6();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnDzica.setText("D");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnD7.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnDzica.setText("A");
                    d7();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnDzica.setText("D");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnD8.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnDzica.setText("A♯");
                    d8();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnDzica.setText("D");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnD9.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnDzica.setText("B");
                    d9();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnDzica.setText("D");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnD10.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnDzica.setText("C");
                    d10();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnDzica.setText("D");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnD11.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnDzica.setText("C♯");
                    d11();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnDzica.setText("D");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnD12.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    d12();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });

        // G ŽICA
        btnGzica.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    g0();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnG1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnGzica.setText("G♯");
                    g1();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnGzica.setText("G");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnG2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnGzica.setText("A");
                    g2();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnGzica.setText("G");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnG3.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnGzica.setText("A♯");
                    g3();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnGzica.setText("G");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnG4.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnGzica.setText("B");
                    g4();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnGzica.setText("G");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnG5.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnGzica.setText("C");
                    g5();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnGzica.setText("G");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnG6.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnGzica.setText("C♯");
                    g6();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnGzica.setText("G");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnG7.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnGzica.setText("D");
                    g7();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnGzica.setText("G");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnG8.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnGzica.setText("D♯");
                    g8();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnGzica.setText("G");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnG9.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnGzica.setText("E");
                    g9();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnGzica.setText("G");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnG10.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnGzica.setText("F");
                    g10();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnGzica.setText("G");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnG11.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnGzica.setText("F♯");
                    g11();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnGzica.setText("G");
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
        btnG12.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    g12();
                    mediaPlayer.start();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                return false;
            }
        });
    }

    // MEDIA PLAYER Methods
    // E String
    private void e0() {
        mediaPlayer = MediaPlayer.create(this, R.raw.e0_mp3);
    }

    private void e1() {
        mediaPlayer = MediaPlayer.create(this, R.raw.e1_mp3);
    }

    private void e2() {
        mediaPlayer = MediaPlayer.create(this, R.raw.e2_mp3);
    }

    private void e3() {
        mediaPlayer = MediaPlayer.create(this, R.raw.e3_mp3);
    }

    private void e4() {
        mediaPlayer = MediaPlayer.create(this, R.raw.e4_mp3);
    }

    private void e5() {
        mediaPlayer = MediaPlayer.create(this, R.raw.e5_mp3);
    }

    private void e6() {
        mediaPlayer = MediaPlayer.create(this, R.raw.e6_mp3);
    }

    private void e7() {
        mediaPlayer = MediaPlayer.create(this, R.raw.e7_mp3);
    }

    private void e8() {
        mediaPlayer = MediaPlayer.create(this, R.raw.e8_mp3);
    }

    private void e9() {
        mediaPlayer = MediaPlayer.create(this, R.raw.e9_mp3);
    }

    private void e10() {
        mediaPlayer = MediaPlayer.create(this, R.raw.e10_mp3);
    }

    private void e11() {
        mediaPlayer = MediaPlayer.create(this, R.raw.e11_mp3);
    }

    private void e12() {
        mediaPlayer = MediaPlayer.create(this, R.raw.e12_mp3);
    }

    // A String
    private void a0() {
        mediaPlayer = MediaPlayer.create(this, R.raw.a0_mp3);
    }

    private void a1() {
        mediaPlayer = MediaPlayer.create(this, R.raw.a1_mp3);
    }

    private void a2() {
        mediaPlayer = MediaPlayer.create(this, R.raw.a2_mp3);
    }

    private void a3() {
        mediaPlayer = MediaPlayer.create(this, R.raw.a3_mp3);
    }

    private void a4() {
        mediaPlayer = MediaPlayer.create(this, R.raw.a4_mp3);
    }

    private void a5() {
        mediaPlayer = MediaPlayer.create(this, R.raw.a5_mp3);
    }

    private void a6() {
        mediaPlayer = MediaPlayer.create(this, R.raw.a6_mp3);
    }

    private void a7() {
        mediaPlayer = MediaPlayer.create(this, R.raw.a7_mp3);
    }

    private void a8() {
        mediaPlayer = MediaPlayer.create(this, R.raw.a8_mp3);
    }

    private void a9() {
        mediaPlayer = MediaPlayer.create(this, R.raw.a9_mp3);
    }

    private void a10() {
        mediaPlayer = MediaPlayer.create(this, R.raw.a10_mp3);
    }

    private void a11() {
        mediaPlayer = MediaPlayer.create(this, R.raw.a11_mp3);
    }

    private void a12() {
        mediaPlayer = MediaPlayer.create(this, R.raw.a12_mp3);
    }

    // D String
    private void d0() {
        mediaPlayer = MediaPlayer.create(this, R.raw.d0_mp3);
    }

    private void d1() {
        mediaPlayer = MediaPlayer.create(this, R.raw.d1_mp3);
    }

    private void d2() {
        mediaPlayer = MediaPlayer.create(this, R.raw.d2_mp3);
    }

    private void d3() {
        mediaPlayer = MediaPlayer.create(this, R.raw.d3_mp3);
    }

    private void d4() {
        mediaPlayer = MediaPlayer.create(this, R.raw.d4_mp3);
    }

    private void d5() {
        mediaPlayer = MediaPlayer.create(this, R.raw.d5_mp3);
    }

    private void d6() {
        mediaPlayer = MediaPlayer.create(this, R.raw.d6_mp3);
    }

    private void d7() {
        mediaPlayer = MediaPlayer.create(this, R.raw.d7_mp3);
    }

    private void d8() {
        mediaPlayer = MediaPlayer.create(this, R.raw.d8_mp3);
    }

    private void d9() {
        mediaPlayer = MediaPlayer.create(this, R.raw.d9_mp3);
    }

    private void d10() {
        mediaPlayer = MediaPlayer.create(this, R.raw.d10_mp3);
    }

    private void d11() {
        mediaPlayer = MediaPlayer.create(this, R.raw.d11_mp3);
    }

    private void d12() {
        mediaPlayer = MediaPlayer.create(this, R.raw.d12_mp3);
    }

    // G String
    private void g0() {
        mediaPlayer = MediaPlayer.create(this, R.raw.g0_mp3);
    }

    private void g1() {
        mediaPlayer = MediaPlayer.create(this, R.raw.g1_mp3);
    }

    private void g2() {
        mediaPlayer = MediaPlayer.create(this, R.raw.g2_mp3);
    }

    private void g3() {
        mediaPlayer = MediaPlayer.create(this, R.raw.g3_mp3);
    }

    private void g4() {
        mediaPlayer = MediaPlayer.create(this, R.raw.g4_mp3);
    }

    private void g5() {
        mediaPlayer = MediaPlayer.create(this, R.raw.g5_mp3);
    }

    private void g6() {
        mediaPlayer = MediaPlayer.create(this, R.raw.g6_mp3);
    }

    private void g7() {
        mediaPlayer = MediaPlayer.create(this, R.raw.g7_mp3);
    }

    private void g8() {
        mediaPlayer = MediaPlayer.create(this, R.raw.g8_mp3);
    }

    private void g9() {
        mediaPlayer = MediaPlayer.create(this, R.raw.g9_mp3);
    }

    private void g10() {
        mediaPlayer = MediaPlayer.create(this, R.raw.g10_mp3);
    }

    private void g11() {
        mediaPlayer = MediaPlayer.create(this, R.raw.g11_mp3);
    }

    private void g12() {
        mediaPlayer = MediaPlayer.create(this, R.raw.g12_mp3);
    }

}
