package org.kaje.kudosu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    KudosuAdapter m_adapter;
    GridView board;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Matrix matrix = new Matrix();
        m_adapter = new KudosuAdapter(this, matrix);

        initUi();
    }

    //----------------------------------------------------------------------------------------------


    private void initUi() {

        board = (GridView) findViewById(R.id.board_grid);
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
