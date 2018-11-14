import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleSimpleTest {

  @Test
  public void testRectangleSimpleTest() throws Exception {

    RectangleSimple r = RectangleSimple.
        aRectangle()
        .withColor(10)
        .withOpacity(10)
        .withWidth(10)
        .build();

  }
}