package org.kaje.kudosu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static android.view.View.TEXT_ALIGNMENT_CENTER;

public class KudosuAdapter extends BaseAdapter {

    private Context m_context;
    private Matrix m_mx;
    private int m_cursor = 0;
    private Collection<Integer> m_helpArray = null;

    //----------------------------------------------------------------------------------------------

    KudosuAdapter(Context p_c, Matrix p_mx) {

        m_context = p_c;
        this.m_mx = p_mx;

    }

    //----------------------------------------------------------------------------------------------

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 81;
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
            tv.setTextAppearance(R.style.normStyle);
            tv.setTextAlignment(TEXT_ALIGNMENT_CENTER);

        } else {
            tv = (TextView) convertView;
        }

        tv.setText( String.valueOf(m_mx.getItem(position)) );

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

        return tv;
    }

    //----------------------------------------------------------------------------------------------

    void setCursor( int p_position ) {

        m_cursor = p_position;
        notifyDataSetChanged();

    }

    //----------------------------------------------------------------------------------------------

    void setValue(int p_val) {

        clearHelp();
        m_mx.setItem( m_cursor, p_val );
        notifyDataSetChanged();

    }

    //----------------------------------------------------------------------------------------------

    void help() {

        m_helpArray = m_mx.getHelp(m_cursor);
        notifyDataSetChanged();

    }

    //----------------------------------------------------------------------------------------------

    void check() {

        notifyDataSetChanged();

    }

    //----------------------------------------------------------------------------------------------

    void clearHelp() {

        if ( m_helpArray != null ) {
            m_helpArray.clear();
        }
        m_helpArray = null;
    }

}
