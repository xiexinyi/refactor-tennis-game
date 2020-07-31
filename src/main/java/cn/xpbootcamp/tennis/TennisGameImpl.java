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

        setPlayerResult(player1);
        setPlayerResult(player2);

        if (player1Point == player2Point) {
            return getScoreWhenPointsAreEqual(player1Point);
        }

        if (player1Point != player2Point) {
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

    private String getScoreWhenPointsAreEqual(int playerPoints) {
          if (playerPoints < 3) {
              return player1.getPlayerResult() +  "-All";
          } else {
              return "Deuce";
          }
      }

    private void setPlayerResult(Player player) {
        int playerPoint = player.getPlayerPoint();
        if (playerPoint == 0) {
            player.setPlayerResult("Love");
        }
        if (playerPoint == 1) {
            player.setPlayerResult("Fifteen");
        }
        if (playerPoint == 2) {
            player.setPlayerResult("Thirty");
        }
        if (playerPoint == 3) {
            player.setPlayerResult("Forty");
        }
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
}