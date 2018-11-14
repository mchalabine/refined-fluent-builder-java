import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeSimpleTest {

  @Test
  public void testShapeSimpleTest() throws Exception {
    ShapeSimple.aShape()
        .withColor(10)
        .withOpacity(10)
        .build();

  }
}