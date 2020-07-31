package cn.xpbootcamp.tennis;

public class Player {

  private int playerPoint = 0;
  private String playerResult = "";
  private String playerName;

  public int getPlayerPoint() {
    return playerPoint;
  }

  public void setPlayerPoint(int playerPoint) {
    this.playerPoint = playerPoint;
  }

  public String getPlayerResult() {
    return playerResult;
  }

  public void setPlayerResult(String playerResult) {
    this.playerResult = playerResult;
  }

  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public void addPlayerPoint() {
    this.setPlayerPoint(this.getPlayerPoint() + 1);
  }
}
