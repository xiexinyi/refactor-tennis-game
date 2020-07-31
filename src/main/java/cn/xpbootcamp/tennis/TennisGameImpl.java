package cn.xpbootcamp.tennis;

import static java.lang.Integer.min;

public class TennisGameImpl implements TennisGame {

    private Player player1 = new Player();
    private Player player2 = new Player();

    public TennisGameImpl(String player1Name, String player2Name) {
        this.player1.setPlayerName(player1Name);
        this.player2.setPlayerName(player2Name);
    }

    public String getScore() {
        int player1Point = player1.getPlayerPoint();
        int player2Point = player2.getPlayerPoint();

        setPlayerResult(player1);
        setPlayerResult(player2);

        if (player1Point == player2Point) {
            return getScoreWhenPointsAreEqual(player1Point);
        } else {
            return getScoreWhenPointsAreNotEqual(player1Point, player2Point);
        }
    }

    private String getScoreWhenPointsAreNotEqual(int player1Point, int player2Point) {
        String score = player1.getPlayerResult() + "-" + player2.getPlayerResult();
        Player advantagedPlayer;
        Player laggingPlayer;
        if (player1Point > player2Point) {
            advantagedPlayer = player1;
            laggingPlayer = player2;
        } else {
            advantagedPlayer = player2;
            laggingPlayer = player1;
        }

        if (laggingPlayer.getPlayerPoint() >= 3) {
            score = "Advantage " + advantagedPlayer.getPlayerName();
        }

        if (advantagedPlayer.getPlayerPoint() >= 4 && laggingPlayer.getPlayerPoint() >= 0
            && (advantagedPlayer.getPlayerPoint() - laggingPlayer.getPlayerPoint() >= 2)) {
            score = "Win for " + advantagedPlayer.getPlayerName();
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