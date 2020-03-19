// code from https://www.baeldung.com/java-sudoku

package org.kaje.kudosu;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;

class Matrix {

    private Collection<Integer> m_fixboard = new ArrayList<>();
    private static final int COUNT = 81;
    private static final int SIZE = 9;
    private static final int[] m_line = {1,2,3,4,5,6,7,8,9};

    private int[][] m_mi = {
            {  1,  2,  3, 10, 11, 12, 19, 20, 21},
            {  4,  5,  6, 13, 14, 15, 22, 23, 34},
            {  7,  8,  9, 16, 17, 18, 25, 26, 27},
            { 28, 29, 30, 37, 38, 39, 46, 47, 48},
            { 31, 32, 33, 40, 41, 42, 49, 50, 51},
            { 34, 35, 36, 43, 44, 45, 52, 53, 54},
            { 55, 56, 57, 64, 65, 66, 73, 74, 75},
            { 58, 59, 60, 67, 68, 69, 76, 77, 78},
            { 61, 62, 63, 70, 71, 72, 79, 80, 81},
    };

    private int[][] m_mx = {

            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},

    };

    private int[][] m_dmx = {

            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},

    };

    //----------------------------------------------------------------------------------------------

    Matrix() {
    }

    //----------------------------------------------------------------------------------------------

    void newTable() {
        int skip = random();
        //int skip = 2;
        fillTable( skip );
        makeShowTable();
    }

    //----------------------------------------------------------------------------------------------

    private void fillTable( int p_idx) {

        int skip = p_idx;
        fillLine(0, skip);
        skip += 12;
        fillLine(1, skip);
        skip += 12;
        fillLine(2, skip);
        skip += 4;
        fillLine(3, skip);
        skip += 12;
        fillLine(4, skip);
        skip += 12;
        fillLine(5, skip);
        skip += 4;
        skip += 12;
        fillLine(6, skip );
        skip += 12;
        fillLine(7, skip );
        skip += 12;
        fillLine(8, skip );

    }

    //----------------------------------------------------------------------------------------------

    private void fillLine( int p_row, int p_skip ) {

        int skip = p_skip;
        while ( skip > SIZE ) {

            skip -= SIZE;

        }
        int x = SIZE - skip;

        int[] line_idx = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < skip; i++,x++) {

            line_idx[i] = x;

        }
        x = 0;
        for (int i = skip; i < SIZE; i++,x++) {

            line_idx[i] = x;

        }

        for( int col = 0; col < SIZE; col++ ) {

            m_mx[p_row][col] = m_line[line_idx[col]];

        }

    }

    //----------------------------------------------------------------------------------------------

    // Random generator
    private int random() {

        return (int) (Math.random()*8+1);

    }

    //----------------------------------------------------------------------------------------------

    int getItem(int p_pos) {

        int row = 0;
        int col = 0;
        if ( p_pos > 0) {
            row = p_pos / SIZE;
            col = p_pos % SIZE;
        }
        return m_dmx[row][col];

    }

    //----------------------------------------------------------------------------------------------

    int getCheckItem(int p_pos) {

        int row = 0;
        int col = 0;
        if ( p_pos > 0) {
            row = p_pos / SIZE;
            col = p_pos % SIZE;
        }
        return m_mx[row][col];

    }

    //----------------------------------------------------------------------------------------------

    void setItem(int p_pos, int p_val) {

        int row = 0;
        int col = 0;
        if ( p_pos > 0) {
            row = p_pos / SIZE;
            col = p_pos % SIZE;
        }
        m_dmx[row][col] = p_val;

    }

    //----------------------------------------------------------------------------------------------

    Collection<Integer> getHelp(int p_pos) {

        int num = getItem( p_pos );
        Collection<Integer> ret = new ArrayList<>();

        for (int i = 0; i < COUNT; i++) {
            int inum = getItem( i );
            if ( inum == num ) {
                ret.add(i);
            }
        }

        return ret;
    }

    //----------------------------------------------------------------------------------------------

    private void makeShowTable() {

        int min = 3;
        int max = 4;
        ArrayList<Integer> line  = new ArrayList<>();
        for( int i = 0; i < SIZE; i++ ) {
            int xcount = (int) (Math.random() * ((max - min) + 1)) + min;
            int count = 0;
            line.clear();
            while ( count < xcount) {
                int ran = (int) (Math.random() * 8);
                if ( !line.contains(ran) ) {
                     line.add(ran);
                     count++;
                }//if
            }//while

            for( int ii = 0; ii < line.size(); ii++ ) {
                m_fixboard.add(m_mi[i][line.get(ii)]-1);
            }//for
        }//for

        for( int x = 0; x < m_fixboard.size(); x++ ) {

            int c = ((ArrayList<Integer>) m_fixboard).get(x);
            setItem(c,getCheckItem(c));

        }//for

    }

    //----------------------------------------------------------------------------------------------

    public Collection<Integer> getFixBoard() {

        return m_fixboard;

    }
}
