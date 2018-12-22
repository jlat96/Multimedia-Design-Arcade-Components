package arcade.level;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import arcade.elements.AbstractTerrainSprite;
import visual.dynamic.described.Sprite;

/**
 * Collection class that represents a group of TerrainSprite objects that make up the obsticles of a
 * ShapeRun level.
 * 
 * @author John Latino
 *
 */
public class Level extends AbstractCollection<AbstractTerrainSprite>
    implements Collection<AbstractTerrainSprite>, Iterable<AbstractTerrainSprite>
{

  public static final int DEFAULT_LEVEL_END_OFFSET = 3000;

  private LinkedList<AbstractTerrainSprite> terrain;
  private List<Integer> checkpoints;

  /**
   * Default constructor creates a new Level obejct with an empty terrain list.
   */
  public Level()
  {
    this(new ArrayList<AbstractTerrainSprite>());
  }

  /**
   * Constructs a new Level object that contains a list of TerrainSprite objects specified by the
   * inTerrain parameter.
   * 
   * @param inTerrain
   *          initial TerrainSprites to add
   */
  public Level(List<AbstractTerrainSprite> inTerrain)
  {
    this(inTerrain, new ArrayList<Integer>());
  }

  /**
   * Constructs a new Level object that contains a list of TerrainSprite objects specified by the
   * inTerrain parameter, and a list of checkpoint Integers specified by the inCheckpoints
   * parameter.
   * 
   * @param inTerrain
   *          initial TerrainSprites to add
   * @param inCheckpoints
   *          initial Checkpoints to add
   */
  public Level(List<AbstractTerrainSprite> inTerrain, List<Integer> inCheckpoints)
  {
    terrain = new LinkedList<AbstractTerrainSprite>();
    checkpoints = new ArrayList<Integer>(inCheckpoints);
    addAll(inTerrain);
  }

  /**
   * Adds a new TerrainSprite to the collection.
   */
  @Override
  public boolean add(AbstractTerrainSprite spriteToAdd)
  {
    return terrain.add(spriteToAdd);
  }

  /**
   * Adds a new checkpoint time to the checkpoint list.
   * 
   * @param checkpointTime
   *          checkpoint to add
   * 
   * @return true
   */
  public boolean addCheckpoint(Integer checkpointTime)
  {
    return checkpoints.add(checkpointTime);
  }

  /**
   * Returns the Iterator for the checkpoints list.
   * 
   * @return checkpoints' iterator
   */
  public Iterator<Integer> checkpointIterator()
  {
    return checkpoints.iterator();
  }

  /**
   * Returns the integer value of the highest startTime owned by a TerrainSprite object. (e.g. the
   * last sprite)
   * 
   * @return Level End Time
   */
  public int getLevelEndTime()
  {
    return getLevelEndTime(DEFAULT_LEVEL_END_OFFSET);
  }

  /**
   * Returns the integer value of the highest startTime owned by a TerrainSprite (e.g. the last
   * sprite to spawn) plus the number of milliseconds specified by the offset parameter.
   * 
   * @param offset
   *          milliseconds to add
   * @return Level end time
   */
  public int getLevelEndTime(int offset)
  {
    int end = 0;
    for (AbstractTerrainSprite s : terrain)
    {
      if (s.getStartTime() > end)
      {
        end = s.getStartTime();
      }
    }
    return end + offset;
  }

  /**
   * Returns a List of cloned Sprites. Cloned sprites are equal to the original inTerrain sprites
   * before any positional manipulation has occurred.
   * 
   * @return List of cloned sprites.
   */
  public List<Sprite> getInitialSprites()
  {
    LinkedList<Sprite> origSprites = new LinkedList<Sprite>();
    for (AbstractTerrainSprite s : terrain)
    {
      origSprites.add(s.duplicate());
    }

    return origSprites;
  }

  /**
   * Returns a List of the sprites in the terrain list. This list is copied to a new LinkedList and
   * returned as raw Sprites.
   * 
   * @return list of Sprite objects
   */
  public List<Sprite> getSprites()
  {
    LinkedList<Sprite> sprites = new LinkedList<Sprite>(terrain);
    return sprites;
  }

  /**
   * Returns the default iterator for the Terrain list.
   */
  @Override
  public Iterator<AbstractTerrainSprite> iterator()
  {
    return terrain.iterator();
  }

  /**
   * Returns the number of TerrainSprite objects in the collection.
   */
  @Override
  public int size()
  {
    return terrain.size();
  }
}
