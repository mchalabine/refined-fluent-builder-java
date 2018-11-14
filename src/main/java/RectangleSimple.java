public class RectangleSimple extends ShapeSimple {

  final int width;

  public RectangleSimple(Builder builder) {
    super(builder);
    this.width = builder.width;
  }

  public static Builder aRectangle() {
    return new Builder();
  }

  static class Builder extends ShapeSimple.BuilderBase<Builder, Builder, RectangleSimple> {

    int width;

    Builder withWidth(int i) {
      this.width = i;
      return self();
    }

    @Override
    Builder self() {
      return this;
    }

    @Override
    Builder shapeHook() {
      return this;
    }

    @Override
    RectangleSimple build() {
      return new RectangleSimple(this);
    }
  }
}
