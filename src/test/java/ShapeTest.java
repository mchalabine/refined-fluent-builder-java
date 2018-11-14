import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeTest {

  @Test
  public void testShapeTestConstructor() throws Exception {
    Shape shape = new Shape();
    assertNotNull(shape);
  }

  @Test
  public void testBuilder() {
//    Shape shape = Shape.aShape().build();
//    assertNotNull(shape);
  }

  @Test
  public void testBuilderWithProperties() {
//    Shape.aShape().build();
//    assertNotNull(shape);
  }

  @Test
  public void testBuilderWithGuidence() {
//    Shape.aShape().withColor(10).build();
  }
}