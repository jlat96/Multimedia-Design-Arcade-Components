package sprite;

import java.awt.event.KeyEvent;

import arcade.elements.AbstractProtagonistSprite;

/**
 * Demo class that demonstrates a realization of the AbstractProtagonistSprite.
 * 
 * @author John Latino
 */
public class DemoProtagonist extends AbstractProtagonistSprite
{
  private int bottom;
  private double curAngle, apexY, apexR;
  private boolean isFalling, isRising, apexSet;

  /**
   * Default Constructor.
   * 
   * @param bottom
   *          the bottom bound of the screen (the bigger number)
   */
  public DemoProtagonist(int bottom)
  {
    super(new Boxy());
    this.bottom = bottom;
  }

  @Override
  public void goToInitial()
  {
    isRising = false;
    isFalling = false;
    curAngle = 0;
    this.setRotation(0);
    y = yInitial;
    x = xInitial;
  }

  @Override
  public void handleTick(int e)
  {
    if (isRising)
    {
      y -= 3;
      increaseRotation();

      // if jumps off the top of the screen
      if (y < 0)
      {
        // trigger game over state
      }
    }
    if (isFalling)
    {
      y += 3;
      increaseRotation();
    }

    // Rising -> Falling
    if (isRising && (y <= apexY))
    {
      isRising = false;
      isFalling = true;
      apexSet = false;
    }

    // Falling -> On Ground
    if (isFalling && ((y >= bottom - 80)))
    {
      isFalling = false;
      apexSet = false;
    }

    if (getVictoryTime() > 0 && e >= getVictoryTime())
    {
      // trigger victory state
    }

  }

  /**
   * Increases the rotation angle and sets the rotation.
   */
  private void increaseRotation()
  {
    if (!apexSet)
    {
      apexR += Math.PI / 2;
      apexSet = true;
    }
    if (curAngle < apexR)
    {
      curAngle += .03;
      setRotation(curAngle);
    }
  }

  /**
   * jump method, called when space bar is pressed and jump is a legal movement.
   */
  @Override
  public void jump()
  {
    apexY = y - 200;
    isRising = true;
    apexSet = false;
  }

  @Override
  public void keyPressed(KeyEvent e)
  {
    if (e.getKeyChar() == KeyEvent.VK_SPACE && !isFalling && !isRising)
    {
      jump();
    }
  }

  @Override
  public AbstractProtagonistSprite regenerate()
  {
    DemoProtagonist newSprite = new DemoProtagonist(bottom);

    newSprite.setXInitial(xInitial);
    newSprite.setYInitial(yInitial);

    return newSprite;
  }

}
