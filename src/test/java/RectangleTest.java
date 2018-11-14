import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.*;

public class RectangleTest {

  @Test
  public void testRectangleTest() throws Exception {
    Rectangle rectangle = new Rectangle();
    assertNotNull(rectangle);
  }

  @Test
  public void testRectangleBuilderReturnsShape() {
//    Shape actual = Rectangle.aRectangle().withColor(10).withOpacity(10).build();
//    assertThat(actual, isA(Shape.class));
  }

  @Test
  public void testRectangleBuilderReturnsRectangle() {
    Rectangle actual= Rectangle.aRectangle()
        .withColor(10)
        .withOpacity(10).withWidth(10).withHeight(10).build();
    assertThat(actual, isA(Rectangle.class));

    Rectangle.aRectangle().withColor(10).withOpacity(10).withWidth(10).withHeight(10).build();


  }
}