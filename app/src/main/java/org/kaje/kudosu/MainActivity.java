package org.kaje.kudosu;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;


public class MainActivity extends AppCompatActivity {

    KudosuAdapter m_adapter;
    GridView board;
    private int m_orientation = 1;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_portrait);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        m_adapter = new KudosuAdapter(this);
        m_adapter.newTable();

        initUi();
    }

    //----------------------------------------------------------------------------------------------


    private void initUi() {

        setContentView( ( m_orientation == 1 ) ? R.layout.activity_main_portrait : R.layout.activity_main_landscape);

        ActionBar toolbar = getSupportActionBar();
        if ( toolbar == null ) {
            setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
            toolbar = getSupportActionBar();
        }

        PackageInfo pInfo;
        try {
            pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            String ver = pInfo.versionName;
            String title = " Kudosu " + ver + " - KaJe 2020";
            setTitle(title);
            toolbar.setTitle(title);
        } catch (PackageManager.NameNotFoundException e) {

            e.printStackTrace();

        }//if

        if ( m_orientation == 1 ) {

            toolbar.show();

        } else {

            toolbar.hide();

        }

        board = findViewById(R.id.board_grid);
        board.setAdapter(m_adapter);
        board.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                m_adapter.setCursor(position);
            }
        });

        final Button buttonH = findViewById(R.id.buttonH);
        buttonH.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_adapter.help();
            }
        });

        final Button buttonC = findViewById(R.id.buttonC);
        buttonC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_adapter.check();
            }
        });

        final Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_adapter.setValue(1);
            }
        });

        final Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_adapter.setValue(2);
            }
        });

        final Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_adapter.setValue(3);
            }
        });

        final Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_adapter.setValue(4);
            }
        });

        final Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_adapter.setValue(5);
            }
        });

        final Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_adapter.setValue(6);
            }
        });

        final Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_adapter.setValue(7);
            }
        });

        final Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_adapter.setValue(8);
            }
        });

        final Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_adapter.setValue(9);
            }
        });

        final Button button0 = findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                m_adapter.setValue(0);
            }
        });

    }

    //----------------------------------------------------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {

            case R.id.menu_quit:
                finishAffinity();
                System.exit(0);
                return true;

            case R.id.menu_check:
                m_adapter.check();
                return true;

            case R.id.menu_newgame:
                m_adapter.newTable();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

    //----------------------------------------------------------------------------------------------

    @Override
    public void onConfigurationChanged(Configuration p_config) {

        super.onConfigurationChanged(p_config);
        m_orientation = p_config.orientation;
        initUi();

    }


}
