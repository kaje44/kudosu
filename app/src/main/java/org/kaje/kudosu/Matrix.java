// code from https://www.baeldung.com/java-sudoku

package org.kaje.kudosu;

import java.util.ArrayList;
import java.util.Collection;

class Matrix {

    private static final int COUNT = 81;
    private static final int SIZE = 9;
    private static final int[] m_line = {1,2,3,4,5,6,7,8,9};
    //public static final int MEDIUM_LEVEL = 26;

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

    //----------------------------------------------------------------------------------------------

    Matrix() {

        int skip = random();
        //int skip = 2;
        fillTable( skip );
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
        m_mx[row][col] = p_val;

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
}
