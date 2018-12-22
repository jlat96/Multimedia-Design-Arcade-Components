package arcade.elements;

import visual.dynamic.described.DescribedSprite;

/**
 * Abstract class parent to terrain based sprites to be contained in a Level collection.
 * 
 * @author John Latino
 *
 *         This work complies with the JMU Honor code.
 */
public abstract class AbstractTerrainSprite extends DescribedSprite
    implements Comparable<AbstractTerrainSprite>
{

  protected int startTime;
  protected double initialY;

  /**
   * Explicit value constructor. Creates a new TerrainSprite child with a startTime parameter.
   * 
   * @param startTime
   *          spawn time
   * @param initialY
   *          initial y position
   */
  public AbstractTerrainSprite(int startTime, double initialY)
  {
    super();
    this.startTime = startTime;
    this.initialY = initialY;
  }

  /**
   * Compares this TerrainSprite to another using the startTime value. If the startTimes are equal,
   * they are compare by their Y position values. Override if other comparison behavior is desired.
   * 
   * @return 1 if the other start time is greater than this start time, and -1 if the other start
   *         time is less than this start time. If the two start times are equal, they are compared
   *         by the Y value of their bounding boxes.
   */
  @Override
  public int compareTo(AbstractTerrainSprite other)
  {

    int cmp;

    if (other.getStartTime() > startTime)
    {
      cmp = 1;
    }
    else if (other.getStartTime() == startTime)
    {
      cmp = (other.getBounds2D().getY() <= this.getBounds2D().getY()) ? 1 : -1;
    }
    else
    {
      return -1;
    }

    return cmp;
  }

  /**
   * Returns a deep copy of the current TerrainSprite with the initial position values.
   * 
   * @return duplicated AbstractTerrainSprite
   */
  public abstract AbstractTerrainSprite duplicate();

  /**
   * Returns the initial y value.
   * 
   * @return initial y position
   */
  public double getInitialY()
  {
    return initialY;
  }

  /**
   * Returns the start time for this TerrainSprite.
   * 
   * @return the start time.
   */
  public int getStartTime()
  {
    return startTime;
  }
}
