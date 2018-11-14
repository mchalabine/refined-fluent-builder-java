
public class ShapeSimple {

  private final int color;
  private final int opacity;

  public ShapeSimple(BuilderBase<?, ?, ?> builder) {
    this.color = builder.color;
    this.opacity = builder.opacity;
  }

  public static Builder aShape() {
    return new Builder();
  }

  static abstract class BuilderBase<B extends BuilderBase<B, H, R>, H, R> {

    int color;
    int opacity;

    abstract B self();

    abstract H shapeHook();

    abstract R build();

    public B withColor(int i) {
      this.color = i;
      return self();
    }

    public H withOpacity(int i) {
      this.opacity = i;
      return shapeHook();
    }

  }

  static class Builder extends BuilderBase<Builder, Builder, ShapeSimple> {

    public ShapeSimple build() {
      return new ShapeSimple(this);
    }

    @Override
    Builder self() {
      return this;
    }

    @Override
    Builder shapeHook() {
      return this;
    }
  }

}
