package sprite;

import java.awt.geom.Point2D;

import arcade.elements.AbstractTerrainSprite;
import visual.statik.described.AggregateContent;

/**
 * SmallSquarePlatform sprite. A demonstration of how the AbstractTerrainSprite abstract class is
 * used.
 *
 * @author John Latino
 */
public class SmallSquarePlatformSprite extends AbstractTerrainSprite
{
  /**
   * Default Constructor for a Spike Sprite that: 1. Moves a spike obstacle across the screen at a
   * constant rate. (Left <-- Right) 2. Sets spike's vertical position to the given y-value. This
   * should rarely be used, if ever. Use the SmallSquarePlatformSprite(double y) version instead.
   */
  public SmallSquarePlatformSprite()
  {
    super(50, 0);
    SmallSquarePlatform ssp = new SmallSquarePlatform();

    addKeyTime(50, 1000.0, 600.0, 0.00, 1.0, ssp);
    addKeyTime(450, 750.0, 600.0, 0.00, 1.0, null);
    addKeyTime(850, 500.0, 600.0, 0.00, 1.0, null);
    addKeyTime(1250, 250.0, 600.0, 0.00, 1.0, null);
    addKeyTime(1650, 0.0, 600.0, 0.00, 1.0, null);

    /** Removing this will remove the Spike the instant it touches x = 0 **/
    addKeyTime(2050, -250.0, 600.0, 0.00, 1.0, null);

    this.setEndState(REMOVE);
  }

  /**
   * Explicit Constructor for a Spike Sprite that: 1. Moves a spike obstacle across the screen at a
   * constant rate. (Left <-- Right) 2. Sets spike's vertical position to the given y-value.
   * 
   * @param y
   *          vertical position of the sprite.
   */
  public SmallSquarePlatformSprite(double y)
  {
    super(50, y);
    SmallSquarePlatform ssp = new SmallSquarePlatform();

    addKeyTime(50, 1000.0, y, 0.00, 1.0, ssp);
    addKeyTime(450, 750.0, y, 0.00, 1.0, null);
    addKeyTime(850, 500.0, y, 0.00, 1.0, null);
    addKeyTime(1250, 250.0, y, 0.00, 1.0, null);
    addKeyTime(1650, 0.0, y, 0.00, 1.0, null);

    /** Removing this will remove the Spike the instant it touches x = 0 **/
    addKeyTime(2050, -250.0, y, 0.00, 1.0, null);

    this.setEndState(REMOVE);
  }

  /**
   * Explicit Constructor for a Spike Sprite that: 1. Moves a spike obstacle across the screen at a
   * constant rate. (Left <-- Right) 2. Sets spike's vertical position to the given y-value. 3. Sets
   * spike's time to begin movement.
   * 
   * @param y
   *          vertical position of the sprite.
   * @param startTime
   *          starting time of sprite movement.
   */
  public SmallSquarePlatformSprite(double y, int startTime)
  {
    super(startTime, y);
    SmallSquarePlatform ssp = new SmallSquarePlatform();

    addKeyTime(startTime, 1000.0, y, 0.00, 1.0, ssp);
    addKeyTime(startTime + 400, 750.0, y, 0.00, 1.0, null);
    addKeyTime(startTime + 800, 500.0, y, 0.00, 1.0, null);
    addKeyTime(startTime + 1200, 250.0, y, 0.00, 1.0, null);
    addKeyTime(startTime + 1600, 0.0, y, 0.00, 1.0, null);

    /** Removing this will remove the Spike the instant it touches x = 0 **/
    addKeyTime(startTime + 2000, -250.0, y, 0.00, 1.0, null);

    this.setEndState(REMOVE);
  }

  /**
   * Add a key time.
   *
   * @param time
   *          The key time
   * @param x
   *          The x position
   * @param y
   *          The y position
   * @param r
   *          The rotation angle
   * @param s
   *          The scaling
   * @param c
   *          The Content
   */
  private void addKeyTime(int time, double x, double y, double r, double s, AggregateContent c)
  {
    addKeyTime(time, new Point2D.Double(x, y), new Double(r), new Double(s), c);
  }

  @Override
  public AbstractTerrainSprite duplicate()
  {
    AbstractTerrainSprite clone = new SmallSquarePlatformSprite(getInitialY(), getStartTime());
    return clone;
  }

}
