package Model;

public class Checkers {

  public Colour checkerColour;

  public Checkers(Colour checkerColour) {
    this.checkerColour = checkerColour;
  }

  /**
   * @return Colour
   */
  public Colour getCheckerColour() {
    return checkerColour;
  }

  /**
   * @param checkerColour
   */
  public void setCheckerColour(Colour checkerColour) {
    this.checkerColour = checkerColour;
  }

}
