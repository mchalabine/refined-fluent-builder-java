public class Rectangle extends Shape {

  public Rectangle(Builder builder) {
    super(builder);
  }

  public Rectangle() {
    super();
  }

  public static Shape.BuilderColor<BuilderWidth<BuilderBuild<Rectangle>>> aRectangle() {
    return new Builder();
  }

  protected static abstract class BuilderBase<B extends BuilderBase<B, H, R>, H, R> extends
      Shape.BuilderBase<B, BuilderWidth<H>, R> implements BuilderWidth<H>, BuilderHeight<H>,
      BuilderBuild<R> {

    long width;
    long height;

    public abstract H rectangleHook();

    @Override
    public B withWidth(long width) {
      this.width = width;
      return self();
    }

    @Override
    public H withHeight(long height) {
      this.height = height;
      return rectangleHook();
    }

    @Override
    public BuilderWidth<H> hook() {
      return this;
    }
  }

  protected static class Builder extends BuilderBase<Builder, BuilderBuild<Rectangle>, Rectangle> {

    @Override
    public Rectangle build() {
      return new Rectangle(this);
    }

    @Override
    public Builder self() {
      return this;
    }

    @Override
    public BuilderBuild<Rectangle> rectangleHook() {
      return this;
    }
  }


  interface BuilderWidth<H> {

    BuilderHeight<H> withWidth(long width);
  }

  interface BuilderHeight<H> {

    H withHeight(long height);
  }


}
