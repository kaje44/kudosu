package org.kaje.kudosu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static android.view.View.TEXT_ALIGNMENT_CENTER;

public class KudosuAdapter extends BaseAdapter {

    private int COUNT = 81;
    private Context m_context;
    private Matrix m_mx = new Matrix();
    private int m_cursor = 0;
    private int m_error = -1;
    private Collection<Integer> m_helpArray = null;
    private Collection<Integer> m_fixArray;

    //----------------------------------------------------------------------------------------------

    KudosuAdapter(Context p_c) {

        m_context = p_c;

    }

    //----------------------------------------------------------------------------------------------

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return COUNT;
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView tv;
        Collection<Integer> grayArray = new ArrayList<>(Arrays.asList(  3,  4,  5,
                                                                       12, 13, 14,
                                                                       21, 22, 23,
                                                                       27, 28, 29,
                                                                       33, 34, 35, 36, 37, 38,
                                                                       42, 43, 44, 45, 46, 47,
                                                                       51, 52, 53,
                                                                       57, 58, 59,
                                                                       66, 67, 68,
                                                                       75, 76, 77
        ));

        if (convertView == null) {

            tv = new TextView(m_context);
            tv.setTextAlignment(TEXT_ALIGNMENT_CENTER);


        } else {

            tv = (TextView) convertView;

        }

        if ( m_fixArray.contains(position) ) {

            tv.setTextAppearance(R.style.fixStyle);

        } else {

            tv.setTextAppearance(R.style.normStyle);

        }

        int val = m_mx.getItem(position);
        if ( val > 0 ) {

            tv.setText(String.valueOf(val));

        } else {

            tv.setText("");

        }

        if ( grayArray.contains(position)) {

            tv.setBackgroundResource( R.color.darkBackground );

        } else {

            tv.setBackgroundResource( R.color.lightBackground );

        }

        if ( m_helpArray != null && m_helpArray.contains(position)) {

            tv.setBackgroundResource( R.color.helpBackground );

        }

        if ( position == m_cursor ) {

            tv.setBackgroundResource( R.color.cursorBackground );

        }

        if ( position == m_error ) {

            tv.setBackgroundResource( R.color.errorBackground );

        }

        return tv;
    }

    //----------------------------------------------------------------------------------------------

    void setCursor( int p_position ) {

        m_cursor = p_position;
        m_helpArray = m_mx.getHelp(m_cursor);
        notifyDataSetChanged();

    }

    //----------------------------------------------------------------------------------------------

    void setValue(int p_val) {

        m_mx.setItem( m_cursor, p_val );
        clearHelp();
        help();
        notifyDataSetChanged();

    }

    //----------------------------------------------------------------------------------------------

    void help() {

        m_helpArray = m_mx.getHelp(m_cursor);
        notifyDataSetChanged();

    }

    //----------------------------------------------------------------------------------------------

    void check() {

        m_error = -1;
        for( int i = 0; i < COUNT ; i++ ) {

            int cv = m_mx.getCheckItem(i);
            int iv = m_mx.getItem(i);
            if ( cv != iv ) {
                setCursor(i);
                m_error = i;
                break;
            }
        }
        notifyDataSetChanged();
        if ( m_error == -1) {
            Toast.makeText(m_context,"Sudoku", Toast.LENGTH_SHORT).show();
        }

    }

    //----------------------------------------------------------------------------------------------

    private void clearHelp() {

        m_error = -1;
        if ( m_helpArray != null ) {
            m_helpArray.clear();
        }
        m_helpArray = null;
    }

    //----------------------------------------------------------------------------------------------

    void newTable() {

        m_mx.newTable();
        m_fixArray = m_mx.getFixBoard();
        notifyDataSetChanged();

    }

}
