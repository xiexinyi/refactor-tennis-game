package cn.xpbootcamp.tennis;

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

        player1.setPlayerResult();
        player2.setPlayerResult();

        if (player1Point == player2Point) {
            return getScoreWhenPointsAreEqual(player1Point);
        } else {
            return getScoreWhenPointsAreNotEqual(player1Point, player2Point);
        }
    }

    private String getScoreWhenPointsAreNotEqual(int player1Point, int player2Point) {
        Player advantagedPlayer;
        Player laggingPlayer;
        if (player1Point > player2Point) {
            advantagedPlayer = player1;
            laggingPlayer = player2;
        } else {
            advantagedPlayer = player2;
            laggingPlayer = player1;
        }

        if (laggingPlayer.getPlayerPoint() >= 3
            && (advantagedPlayer.getPlayerPoint() - laggingPlayer.getPlayerPoint() < 2)) {
            return "Advantage " + advantagedPlayer.getPlayerName();
        }

        if (advantagedPlayer.getPlayerPoint() >= 4
            && (advantagedPlayer.getPlayerPoint() - laggingPlayer.getPlayerPoint() >= 2)) {
            return "Win for " + advantagedPlayer.getPlayerName();
        }

        return player1.getPlayerResult() + "-" + player2.getPlayerResult();
    }

    private String getScoreWhenPointsAreEqual(int playerPoints) {
          if (playerPoints < 3) {
              return player1.getPlayerResult() +  "-All";
          } else {
              return "Deuce";
          }
      }

    public void wonPoint(String player) {
        if (player == "player1")
            player1.addPlayerPoint();
        else
            player2.addPlayerPoint();
    }
}