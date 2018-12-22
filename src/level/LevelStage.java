package arcade.level;

import java.security.InvalidParameterException;

import arcade.elements.AbstractProtagonistSprite;
import visual.dynamic.described.Sprite;
import visual.dynamic.described.Stage;

/**
 * Container class that contains and manages a ShapeRun Stage, its Level terrain, and a protagonist.
 * 
 * @author John Latino
 *
 */
public class LevelStage
{

  private AbstractProtagonistSprite protagonist;
  private Level level;
  private Stage stage;

  /**
   * Constructs a LevelStage with the specified Level terrain, visualized at the given width and
   * height.
   * 
   * @param inLevel
   *          Level to manage
   * @param protagonist
   *          protagonist of the level
   * @param width
   *          visualization width
   * @param height
   *          visualization height
   * @param timeStep
   *          metronome time step
   * @throws InvalidParameterException
   *           if the protagonist parameter is null, if the height or width are too low, or if the
   *           timeStep is negative.
   */
  public LevelStage(Level inLevel, AbstractProtagonistSprite protagonist, int width, int height,
      int timeStep) throws InvalidParameterException
  {
    // Sanity checks
    if (protagonist == null)
    {
      throw new InvalidParameterException("Protagonist parameter cannot be null");
    }

    if (width < 0 || height < 0)
    {
      throw new InvalidParameterException("Width and height cannot be negative");
    }

    if (timeStep < 0)
    {
      throw new InvalidParameterException("Time step must be a positive value");
    }

    level = inLevel;
    stage = new Stage(timeStep);
    stage.getView().setBounds(0, 0, width, height);

    this.protagonist = protagonist;

    // add the background image as the first element on the stage (back)
    stage.add(protagonist);
    stage.addKeyListener(protagonist);

    // Add all antagonists to the protagonist and the Stage
    for (Sprite s : inLevel)
    {
      stage.add(s);
      protagonist.addAntagonist(s);
    }
  }

  /**
   * Returns the active protagonist of the level stage.
   * 
   * @return the protagonist.
   */
  public AbstractProtagonistSprite getProtagonist()
  {
    return protagonist;
  }

  /**
   * Returns the height of the decorated stage's visualization view.
   * 
   * @return height
   */
  public int getHeight()
  {
    return stage.getView().getHeight();
  }

  /**
   * Returns the Level being managed by this LevelStage.
   * 
   * @return the decorated level
   */
  public Level getLevel()
  {
    return level;
  }

  /**
   * Returns the stage being managed by this LevelStage.
   * 
   * @return the decorated stage
   */
  public Stage getStage()
  {
    return stage;
  }

  /**
   * Returns the width if the decorated stage's visualization view.
   * 
   * @return width
   */
  public int getWidth()
  {
    return stage.getView().getWidth();
  }

  /**
   * Effectively removes the protagonist's and the Stage's visibility from the view. Stops the
   * current stage, and sets the stage's and the protagonist's visibility to false.
   */
  public void killProtagonist()
  {
    stage.stop();
    stage.getView().setVisible(false);
    protagonist.setVisible(false);
  }

  /**
   * Pauses the stage and sets the visibility of the stage to false.
   */
  public void pause()
  {
    stage.getMetronome().stop();
    stage.getView().setVisible(false);
    stage.getView().setFocusable(false);
  }

  /**
   * Resets the stage (all level terrain) and protagonist to their initial states.
   */
  public void restart()
  {
    stage.stop();
    stage.getMetronome().setTime(0);

    // Remove all terrain sprites from the stage
    for (Sprite s : level)
    {
      s.setLocation(-100, -100); // sets terrain's location to be unreachable
      stage.remove(s);
      protagonist.removeAntagonist(s);
    }

    // Remove the protagonist from the stage
    stage.removeKeyListener(protagonist);
    stage.remove(protagonist);

    // create new protagonist
    int winTime = protagonist.getVictoryTime();

    AbstractProtagonistSprite newProtagonist = protagonist.regenerate();
    protagonist = null;
    protagonist = newProtagonist;
    protagonist.setVictoryTime(winTime);

    // Re-add the new protagonist to the stage
    stage.add(protagonist);
    stage.addKeyListener(protagonist);

    // Add the original (deep copy) terrain sprites to the protagonist and the stage
    Sprite tmp;
    for (Sprite s : level.getInitialSprites())
    {
      tmp = s;
      protagonist.addAntagonist(tmp);
      stage.add(tmp);
    }

    // reset the stage for viewing
    stage.getView().setVisible(true);
    stage.getView().setFocusable(true);

    stage.repaint();
    stage.start();
  }

  /**
   * Resumes execution of the stage.
   */
  public void resume()
  {
    stage.getView().setVisible(true);
    stage.getView().setFocusable(true);
    stage.getMetronome().start();
  }

  /**
   * Sets the LevelStage's protagonist.
   * 
   * @param newProtagonist
   *          the new protagonist
   * @throws InvalidParameterException
   *           if the newProtagonist is null.
   */
  public void setProtagonist(AbstractProtagonistSprite newProtagonist)
      throws InvalidParameterException
  {
    if (newProtagonist == null)
    {
      throw new InvalidParameterException("Protagonist cannot be null");
    }
    protagonist = newProtagonist;
  }

}
