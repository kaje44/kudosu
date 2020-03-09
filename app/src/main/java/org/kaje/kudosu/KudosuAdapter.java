package org.kaje.kudosu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class KudosuAdapter extends BaseAdapter {

    private Context mContext;
    private Matrix m_mx;
    private final int COUNT = 81;


    public KudosuAdapter(Context c, Matrix p_mx ) {

        mContext = c;
        this.m_mx = p_mx;

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
        // TODO Auto-generated method stub
        TextView tv;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            tv = new TextView(mContext);
            tv.setText( String.valueOf(m_mx.getItem(position)) );

        } else {
            tv = (TextView) convertView;
        }

        return tv;
    }

}
