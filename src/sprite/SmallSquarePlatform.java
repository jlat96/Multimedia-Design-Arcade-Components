package sprite;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;

import visual.statik.described.AggregateContent;
import visual.statik.described.Content;

/**
 * Content for a Small Square Platform terrain sprite.
 * 
 * @author John Latino
 *
 */
public class SmallSquarePlatform extends AggregateContent
{
  private static Double SMALL_BOX_HEIGHT = 100.0;
  private static Double SMALL_BOX_WIDTH = 100.0;

  /**
   * Default Constructor. Creates default sized ShapeRun spike with the default colors.
   */
  public SmallSquarePlatform()
  {
    this(Color.BLACK, Color.WHITE);
  }

  /**
   * Creates a default sized ShapeRun platform with the specified colors.
   * 
   * @param color
   *          - outline color
   * @param paint
   *          - fill color
   */
  public SmallSquarePlatform(Color color, Paint paint)
  {
    Rectangle2D rect = new Rectangle2D.Double(0, 0, SMALL_BOX_WIDTH, SMALL_BOX_HEIGHT);

    Content platform = new Content(rect, color, paint, new BasicStroke(1));

    this.add(platform);
  }
}
