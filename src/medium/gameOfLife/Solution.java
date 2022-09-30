package medium.gameOfLife;

class Solution {
    private int countNeighbors( int[][] board, int x, int y ) {
        final int MIN_X = 0, MIN_Y = 0;
        final int MAX_X = board.length-1, MAX_Y = board[0].length-1;
        
        int count = 0;
        for ( int i = x-1; i <= x+1; i++ ) {
            if ( i<MIN_X || i>MAX_X ) continue;
            for ( int j = y-1; j <= y+1; j++ ) {
                if (i == x && j == y) continue;
                if ( j<MIN_Y || j>MAX_Y ) continue;
                
                if ( board[i][j] == 1 ) count++;
                else continue;
            }
        }
        return count;
        
    }
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;

        int[][] newBoard = new int[board.length][board[0].length];
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[i].length; j++ ) {
                newBoard[i][j] = board[i][j];
            }
        }
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[i].length; j++ ) {
                int n = countNeighbors(board,i,j);
                System.out.print(n + " ");
                
                // live cell
                if ( board[i][j] == 1 ) {
                    if ( n<2 ) newBoard[i][j] = 0;
                    if ( n==2 || n==3 ) newBoard[i][j] = 1;
                    if ( n>3 ) newBoard[i][j] = 0;
                } 
                
                // dead cell
                else {
                    if ( n==3 ) newBoard[i][j] = 1; 
                }
            }
            System.out.println("");
        }
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[i].length; j++ ) {
                board[i][j] = newBoard[i][j];
            }
        }
    }
}
