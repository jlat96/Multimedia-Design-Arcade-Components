package arcade.elements;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import visual.dynamic.described.RuleBasedSprite;
import visual.statik.TransformableContent;

/**
 * Abstract encapsulation of a protagonist in a side-scrolling video game.
 * 
 * @author John Latino
 * 
 *         This work complies with the JMU Honor Code.
 *
 */
public abstract class AbstractProtagonistSprite extends RuleBasedSprite implements KeyListener
{
  protected double xInitial, yInitial;

  private int victoryTime;

  /**
   * Abstract class constructor. Passes the content to the parent sprite.
   * 
   * @param content
   *          the base content
   */
  public AbstractProtagonistSprite(TransformableContent content)
  {
    super(content);
  }

  /**
   * Returns victory time for current level.
   * 
   * @return victory time for current level
   */
  public int getVictoryTime()
  {
    return victoryTime;
  }

  /**
   * Reset for when the level is restarted.
   */
  public abstract void goToInitial();

  @Override
  public abstract void handleTick(int e);

  /**
   * Performs actions associated with a jump event.
   */
  public abstract void jump();

  @Override
  public abstract void keyPressed(KeyEvent e);

  @Override
  public void keyReleased(KeyEvent e)
  {

  }

  @Override
  public void keyTyped(KeyEvent e)
  {

  }

  /**
   * Creates a copy of the owning AbstractProtagonistSprite with its initial attributes.
   * 
   * @return regenerates sprite
   */
  public abstract AbstractProtagonistSprite regenerate();

  /**
   * Sets the time at which the protagonist will signal a victory event.
   * 
   * @param victoryTime
   *          time of a victory condition
   */
  public void setVictoryTime(int victoryTime)
  {
    this.victoryTime = victoryTime;
  }

  /**
   * Set the protagonist's initial horizontal location.
   * 
   * @param x
   *          new initial horizontal point
   */
  public void setXInitial(double x)
  {
    this.xInitial = x;
    if (this.x == 0)
      this.x = x;
  }

  /**
   * Set the protagonist's initial vertical location.
   * 
   * @param y
   *          new initial vertical point
   */
  public void setYInitial(double y)
  {
    this.yInitial = y;
    if (this.y == 0)
      this.y = y;
  }

}
