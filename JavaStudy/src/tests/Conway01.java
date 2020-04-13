package tests;

public class Conway01 {

    public static boolean[][] tableOld;
    public static boolean[][] tableNext;
    public static int tableSize;

    public static void main(String[] args) throws InterruptedException {

        int limit = 100;
        tableSize = 30;
        tableOld = new boolean[tableSize][tableSize];
        tableNext = new boolean[tableSize][tableSize];

        // need init cells TODO
        init();

        int period = 0;
        while(period < limit){
            period ++;
            tableOld = tableNext;

            showTables(period);

            tableNext = new boolean[tableSize][tableSize];

            calcCells();

            Thread.sleep(1000);
        }



    }

    public static void calcCells(){
        for(int i = 0; i < tableSize; i ++ ) {
            for(int j = 0; j < tableSize ; j ++) {
                deadOrAlive(i,j);
            }
        }
    }

    public static void init(){
        // Cross
//        tableNext[5][5] = true;
//        tableNext[5][4] = true;
//        tableNext[5][6] = true;
//        tableNext[4][5] = true;
//        tableNext[6][5] = true;

        // R-pentomino
//        tableNext[15][15] = true;
//        tableNext[15][16] = true;
//        tableNext[16][14] = true;
//        tableNext[16][15] = true;
//        tableNext[17][15] = true;

        // frog
//        tableNext[14][14] = true;
//        tableNext[14][15] = true;
//        tableNext[14][16] = true;
//        tableNext[15][13] = true;
//        tableNext[15][14] = true;
//        tableNext[15][15] = true;

        // pulser
        tableNext[14][11] = true;
        tableNext[14][12] = true;
        tableNext[14][13] = true;
        tableNext[11][14] = true;
        tableNext[12][14] = true;
        tableNext[13][14] = true;
        tableNext[11][ 9] = true;
        tableNext[12][ 9] = true;
        tableNext[13][ 9] = true;
        tableNext[ 9][11] = true;
        tableNext[ 9][12] = true;
        tableNext[ 9][13] = true;

        tableNext[14][17] = true;
        tableNext[14][18] = true;
        tableNext[14][19] = true;
        tableNext[11][16] = true;
        tableNext[12][16] = true;
        tableNext[13][16] = true;
        tableNext[11][21] = true;
        tableNext[12][21] = true;
        tableNext[13][21] = true;
        tableNext[ 9][17] = true;
        tableNext[ 9][18] = true;
        tableNext[ 9][19] = true;

        tableNext[16][11] = true;
        tableNext[16][12] = true;
        tableNext[16][13] = true;
        tableNext[17][14] = true;
        tableNext[18][14] = true;
        tableNext[19][14] = true;
        tableNext[17][ 9] = true;
        tableNext[18][ 9] = true;
        tableNext[19][ 9] = true;
        tableNext[21][11] = true;
        tableNext[21][12] = true;
        tableNext[21][13] = true;

        tableNext[16][17] = true;
        tableNext[16][18] = true;
        tableNext[16][19] = true;
        tableNext[17][16] = true;
        tableNext[18][16] = true;
        tableNext[19][16] = true;
        tableNext[17][21] = true;
        tableNext[18][21] = true;
        tableNext[19][21] = true;
        tableNext[21][17] = true;
        tableNext[21][18] = true;
        tableNext[21][19] = true;
    }

    public static void showTables(int nowPeriod){
        StringBuffer sb = new StringBuffer();
        sb.append("-------------------------------------------------- nowPeriod : ").append(nowPeriod).append('\n');
        for(int i = 0; i < tableSize; i ++ ) {
            for(int j = 0; j < tableSize ; j ++) {
                sb.append(tableOld[i][j]?" ■ ":"   ");
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());

    }

    public static void deadOrAlive(int row, int col){
        int cnt = 0;

        boolean colMin = col>0;
        boolean colmax = col<tableSize-1;

        if(row>0){
            if(colMin && tableOld[row-1][col-1]){
                cnt ++;
            }
            if(          tableOld[row-1][col]){
                cnt ++;
            }
            if(colmax && tableOld[row-1][col+1]){
                cnt ++;
            }
        }

            if(colMin && tableOld[row  ][col-1]){
                cnt ++;
            }
//        if(tableOld[row  ][col])   cnt ++;
            if(colmax && tableOld[row  ][col+1]){
                cnt ++;
            }

        if(row<tableSize-1){
            if(colMin && tableOld[row+1][col-1]){
                cnt ++;
            }
            if(          tableOld[row+1][col]){
                cnt ++;
            }
            if(colmax && tableOld[row+1][col+1]){
                cnt ++;
            }
        }


        if(tableOld[row][col]) {
            //살아있는데
            if(cnt > 1 && cnt < 4){
                tableNext[row][col] = true;
            }else{
                tableNext[row][col] = false;
            }
        }else{
            //죽어있는데
            if(cnt == 3) {
                tableNext[row][col] = true;
            }
        }
    }

}
