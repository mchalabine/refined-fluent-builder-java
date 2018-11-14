
public class Shape {

  final long color;
  final long opacity;

  public Shape() {
    this.color = 0;
    this.opacity = 0;
  }

  protected Shape(BuilderBase<?, ?, ?> builder) {
    this.color = builder.color;
    this.opacity = builder.opacity;
  }

  public static BuilderColor<BuilderBuild<Shape>> aShape() {
    return new Builder();
  }

  protected static abstract class BuilderBase<B extends BuilderBase<B, H, R>, H, R> implements
      BuilderColor<H>, BuilderOpacity<H>, BuilderBuild<R> {

    protected long color;
    protected long opacity;

    public abstract B self();

    public abstract H hook();

    public abstract R build();

    public BuilderOpacity withColor(long color) {
      this.color = color;
      return self();
    }

    public H withOpacity(long opacity) {
      this.opacity = opacity;
      return hook();
    }
  }

  protected static class Builder extends BuilderBase<Builder, BuilderBuild<Shape>, Shape> {

    @Override
    public Builder self() {
      return this;
    }

    @Override
    public Shape build() {
      return new Shape(this);
    }

    @Override
    public BuilderBuild hook() {
      return self();
    }
  }

  interface BuilderColor<H> {

    BuilderOpacity<H> withColor(long color);
  }

  interface BuilderOpacity<H> {

    H withOpacity(long opacity);
  }

  interface BuilderBuild<R> {

    R build();

  }
}
