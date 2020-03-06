package org.kaje.kudosu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    GridView board;
    int[][] matrix = {

         { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
         { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
         { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
         { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
         { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
         { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
         { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
         { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
         { 0, 9, 0, 0, 0, 0, 4, 0, 0 }

    };

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        KudosuAdapter adapter = new KudosuAdapter(this, matrix);
        board = (GridView)findViewById(R.id.board_grid);
        board.setAdapter(adapter);
        board.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "You Clicked at " +matrix[+ position], Toast.LENGTH_SHORT).show();

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
