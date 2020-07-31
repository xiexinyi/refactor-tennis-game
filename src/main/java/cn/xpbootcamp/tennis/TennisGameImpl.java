package cn.xpbootcamp.tennis;

public class TennisGameImpl implements TennisGame {

    private int SCORE_GAP_FOR_WIN = 2;
    private int MIN_SCORE_FOR_ADVANTAGE = 3;
    private int MIN_SCORE_FOR_DEUCE = 3;
    private int MIN_SCORE_FOR_WIN = 4;

    private Player player1 = new Player();
    private Player player2 = new Player();

    public TennisGameImpl(String player1Name, String player2Name) {
        this.player1.setPlayerName(player1Name);
        this.player2.setPlayerName(player2Name);
    }

    public String getScore() {
        player1.setPlayerResult();
        player2.setPlayerResult();

        if (player1.getPlayerPoint() == player2.getPlayerPoint()) {
            return getScoreWhenPointsAreEqual();
        } else {
            return getScoreWhenPointsAreNotEqual();
        }
    }

    private String getScoreWhenPointsAreNotEqual() {
        Player advantagedPlayer;
        Player laggingPlayer;
        if (player1.getPlayerPoint() > player2.getPlayerPoint()) {
            advantagedPlayer = player1;
            laggingPlayer = player2;
        } else {
            advantagedPlayer = player2;
            laggingPlayer = player1;
        }

        if (isAdvantage(advantagedPlayer, laggingPlayer)) {
            return "Advantage " + advantagedPlayer.getPlayerName();
        }

        if (isWin(advantagedPlayer, laggingPlayer)) {
            return "Win for " + advantagedPlayer.getPlayerName();
        }

        return player1.getPlayerResult() + "-" + player2.getPlayerResult();
    }

    private boolean isWin(Player advantagedPlayer, Player laggingPlayer) {
        return advantagedPlayer.getPlayerPoint() >= MIN_SCORE_FOR_WIN
            && (advantagedPlayer.getPlayerPoint() - laggingPlayer.getPlayerPoint() >= SCORE_GAP_FOR_WIN);
    }

    private boolean isAdvantage(Player advantagedPlayer, Player laggingPlayer) {
        return laggingPlayer.getPlayerPoint() >= MIN_SCORE_FOR_ADVANTAGE
            && (advantagedPlayer.getPlayerPoint() - laggingPlayer.getPlayerPoint() < SCORE_GAP_FOR_WIN);
    }

    private String getScoreWhenPointsAreEqual() {
          if (player1.getPlayerPoint() < MIN_SCORE_FOR_DEUCE) {
              return player1.getPlayerResult() +  "-All";
          } else {
              return "Deuce";
          }
      }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getPlayerName()))
            player1.addPlayerPoint();
        else
            player2.addPlayerPoint();
    }
}