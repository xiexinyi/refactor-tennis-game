package cn.xpbootcamp.tennis;

public class TennisGameImpl implements TennisGame {

    private Player player1 = new Player();
    private Player player2 = new Player();

    public TennisGameImpl(String player1Name, String player2Name) {
        this.player1.setPlayerName(player1Name);
        this.player2.setPlayerName(player2Name);
    }

    public String getScore() {
        String score = "";
        int player1Point = player1.getPlayerPoint();
        int player2Point = player2.getPlayerPoint();
        if (player1Point == player2Point && player1Point < 4) {
            if (player1Point == 0)
                score = "Love";
            if (player1Point == 1)
                score = "Fifteen";
            if (player1Point == 2)
                score = "Thirty";
            score += "-All";
        }
        if (player1Point == player2Point && player1Point >= 3)
            score = "Deuce";

        if (player1Point > 0 && player2Point == 0) {
            setResultsWhenOnePlayerPointIsZero(player1, player2);
            score = player1.getPlayerResult() + "-" + player2.getPlayerResult();
        }
        if (player2Point > 0 && player1Point == 0) {
            setResultsWhenOnePlayerPointIsZero(player2, player1);
            score = player1.getPlayerResult() + "-" + player2.getPlayerResult();
        }

        if (player1Point > player2Point && player1Point < 4) {
            if (player1Point == 2)
                player1.setPlayerResult("Thirty");
            if (player1Point == 3)
                player1.setPlayerResult("Forty");
            if (player2Point == 1)
                player2.setPlayerResult("Fifteen");
            if (player2Point == 2)
                player2.setPlayerResult("Thirty");

            score = player1.getPlayerResult() + "-" + player2.getPlayerResult();
        }
        if (player2Point > player1Point && player2Point < 4) {
            if (player2Point == 2)
                player2.setPlayerResult("Thirty");
            if (player2Point == 3)
                player2.setPlayerResult("Forty");
            if (player1Point == 1)
                player1.setPlayerResult("Fifteen");
            if (player1Point == 2)
                player1.setPlayerResult("Thirty");

            score = player1.getPlayerResult() + "-" + player2.getPlayerResult();
        }

        if (player1Point > player2Point && player2Point >= 3) {
            score = "Advantage player1";
        }

        if (player2Point > player1Point && player1Point >= 3) {
            score = "Advantage player2";
        }

        if (player1Point >= 4 && player2Point >= 0 && (player1Point - player2Point) >= 2) {
            score = "Win for player1";
        }
        if (player2Point >= 4 && player1Point >= 0 && (player2Point - player1Point) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    public void setPlayer1Score(int number) {

        for (int i = 0; i < number; i++) {
            player1Score();
        }

    }

    public void setPlayer2Score(int number) {

        for (int i = 0; i < number; i++) {
            player2Score();
        }

    }

    public void player1Score() {
      int player1Point = player1.getPlayerPoint();
      player1.setPlayerPoint(player1Point + 1);
    }

    public void player2Score() {
      int player2Point = player2.getPlayerPoint();
      player2.setPlayerPoint(player2Point + 1);
    }

    public void wonPoint(String player) {
        if (player == "player1")
            player1Score();
        else
            player2Score();
    }

    private void setResultsWhenOnePlayerPointIsZero(Player advantagedPlayer, Player zeroPointPlayer) {
        if (advantagedPlayer.getPlayerPoint() == 1)
            advantagedPlayer.setPlayerResult("Fifteen");
        if (advantagedPlayer.getPlayerPoint() == 2)
            advantagedPlayer.setPlayerResult("Thirty");
        if (advantagedPlayer.getPlayerPoint() == 3)
            advantagedPlayer.setPlayerResult("Forty");

        zeroPointPlayer.setPlayerResult("Love");
    }
}