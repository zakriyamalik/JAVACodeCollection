import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    @Test
    public void test_init_brd() {
        TicTacToe.init_brd();
        char[][] expected_brd = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };
        assertArrayEquals(expected_brd, TicTacToe.brd);
    }

    @Test
    public void test_chk_win_row() {
        TicTacToe.init_brd();
        TicTacToe.brd[0][0] = 'X';
        TicTacToe.brd[0][1] = 'X';
        TicTacToe.brd[0][2] = 'X';
        TicTacToe.curr_plr = 'X';
        assertTrue(TicTacToe.chk_win());
    }

    @Test
    public void test_chk_win_col() {
        TicTacToe.init_brd();
        TicTacToe.brd[0][0] = 'O';
        TicTacToe.brd[1][0] = 'O';
        TicTacToe.brd[2][0] = 'O';
        TicTacToe.curr_plr = 'O';
        assertTrue(TicTacToe.chk_win());
    }

    @Test
    public void test_chk_win_diag() {
        TicTacToe.init_brd();
        TicTacToe.brd[0][0] = 'X';
        TicTacToe.brd[1][1] = 'X';
        TicTacToe.brd[2][2] = 'X';
        TicTacToe.curr_plr = 'X';
        assertTrue(TicTacToe.chk_win());
    }

    @Test
    public void test_chk_full_false() {
        TicTacToe.init_brd();
        TicTacToe.brd[0][0] = 'X';
        assertFalse(TicTacToe.chk_full());
    }

    @Test
    public void test_chk_full_true() {
        TicTacToe.init_brd();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                TicTacToe.brd[i][j] = 'X';
            }
        }
        assertTrue(TicTacToe.chk_full());
    }

    @Test
    public void test_switch_plr() {
        TicTacToe.curr_plr = 'X';
        TicTacToe.switch_plr();
        assertEquals('O', TicTacToe.curr_plr);

        TicTacToe.switch_plr();
        assertEquals('X', TicTacToe.curr_plr);
    }
}
