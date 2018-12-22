package sprite;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import visual.statik.described.AggregateContent;
import visual.statik.described.Content;

/**
 * Boxy's Content class.
 * 
 * @author Brandon Domonoski
 * 
 *         This work complies with the JMU Honor Code.
 */
public class Boxy extends AggregateContent
{
  /**
   * Default constructor for Boxy. Creates a new Boxy AggregateContent.
   */
  public Boxy()
  {
    Rectangle2D head, mouth;
    Ellipse2D left, right;
    Content boxyHead, leftEye, rightEye, boxyMouth;

    BasicStroke stroke = new BasicStroke(1);
    Color headFill = new Color(0x99, 0x99, 0x99);
    Color faceFill = new Color(0xcc, 0xcc, 0xcc);

    // Create the shapes.
    head = new Rectangle2D.Double(0.0, 0.0, 80.0, 80.0);
    mouth = new Rectangle2D.Double(10.0, 65.0, 60.0, 10.0);
    left = new Ellipse2D.Double(20 - 10, 30 - 10, 20.0, 20.0);
    right = new Ellipse2D.Double(60 - 10, 30 - 10, 20.0, 20.0);

    // Create each piece of individual content.
    boxyHead = new Content(head, Color.BLACK, headFill, stroke);
    boxyMouth = new Content(mouth, Color.BLACK, faceFill, stroke);
    leftEye = new Content(left, Color.BLACK, faceFill, stroke);
    rightEye = new Content(right, Color.BLACK, faceFill, stroke);

    // Add content to Boxy.
    add(boxyHead);
    add(boxyMouth);
    add(leftEye);
    add(rightEye);
  }

}
