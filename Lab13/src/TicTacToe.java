import java.util.Scanner;

public class TicTacToe {
    static final char[][] brd = new char[3][3];
    static char curr_plr = 'X';

    public static void main(String[] args) {
        init_brd();
        while (true) {
            print_brd();
            plr_mv();
            if (chk_win()) {
                print_brd();
                System.out.println("Player " + curr_plr + " wins!");
                break;
            }
            if (chk_full()) {
                print_brd();
                System.out.println("It's a draw!");
                break;
            }
            switch_plr();
        }
    }

    static void init_brd() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                brd[i][j] = '-';
            }
        }
    }

    private static void print_brd() {
        for (char[] row : brd) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static void plr_mv() {
        Scanner sc = new Scanner(System.in);
        int rw, cl;
        while (true) {
            System.out.print("Player " + curr_plr + ", enter row (0-2) and column (0-2): ");
            rw = sc.nextInt();
            cl = sc.nextInt();
            if (rw >= 0 && rw < 3 && cl >= 0 && cl < 3 && brd[rw][cl] == '-') {
                brd[rw][cl] = curr_plr;
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    static boolean chk_win() {
        for (int i = 0; i < 3; i++) {
            if ((brd[i][0] == curr_plr && brd[i][1] == curr_plr && brd[i][2] == curr_plr) ||
                    (brd[0][i] == curr_plr && brd[1][i] == curr_plr && brd[2][i] == curr_plr)) {
                return true;
            }
        }
        return (brd[0][0] == curr_plr && brd[1][1] == curr_plr && brd[2][2] == curr_plr) ||
                (brd[0][2] == curr_plr && brd[1][1] == curr_plr && brd[2][0] == curr_plr);
    }

    static boolean chk_full() {
        for (char[] row : brd) {
            for (char cell : row) {
                if (cell == '-') return false;
            }
        }
        return true;
    }

    static void switch_plr() {
        curr_plr = (curr_plr == 'X') ? 'O' : 'X';
    }
}
