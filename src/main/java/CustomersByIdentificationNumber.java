import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Chalabine
 */
public final class CustomersByIdentificationNumber {

  private Map<IdentificationNumber, Collection<Customer>> customersByIdentificationNumber;

  private CustomersByIdentificationNumber(Builder builder) {
    customersByIdentificationNumber = builder.customersByIdentificationNumber;
  }

  public static BuilderInitial<BuilderBuild<CustomersByIdentificationNumber>,
      CustomersByIdentificationNumber> aCustomersByIdentificationNumber() {
//    return new Builder(new HashMap<>());
    throw new UnsupportedOperationException();
  }

  public static final class Builder extends
      BuilderBase<Builder,
          BuilderCustomerChain<BuilderCustomer<BuilderBuild<CustomersByIdentificationNumber>>>,
          CustomersByIdentificationNumber> {

    private Map<IdentificationNumber, Collection<Customer>> customersByIdentificationNumber;

    private Builder(
        Map<IdentificationNumber, Collection<Customer>> customersByIdentificationNumber) {
      super(customersByIdentificationNumber);
      this.customersByIdentificationNumber = customersByIdentificationNumber;
    }

    public CustomersByIdentificationNumber build() {
      return new CustomersByIdentificationNumber(this);
    }

    protected Builder self() {
      return this;
    }

    protected BuilderCustomerChain<BuilderCustomer<BuilderBuild<CustomersByIdentificationNumber>>> hook() {
      return new BuilderCustomerChained(this);
    }
  }

  public static class BuilderCustomerChained implements
      BuilderCustomerChain<BuilderCustomer<BuilderBuild<CustomersByIdentificationNumber>>> {

    private final Builder parentBuilder;

    public BuilderCustomerChained(Builder builder) {
      this.parentBuilder = builder;
    }

    public BuilderCustomerChain<BuilderCustomer<BuilderBuild<CustomersByIdentificationNumber>>> withCustomer(
        Customer customer) {
      parentBuilder.withCustomer(customer);
      return this;
    }

    public BuilderCustomer<BuilderBuild<CustomersByIdentificationNumber>> withIdentificationNumber(
        IdentificationNumber identificationNumber) {
      return parentBuilder.withIdentificationNumber(identificationNumber);
    }
  }

  protected abstract static class BuilderBase<B extends BuilderBase<B, H, R>, H, R> implements
      BuilderInitial<H, R>, BuilderIdentificationNumber<H>, BuilderCustomer<H>,
      BuilderBuild<R> {

    private final Map<IdentificationNumber, Collection<Customer>> customersByIdentificationNumber;

    private Collection<Customer> customers;

    private IdentificationNumber identificationNumber;

    private BuilderBase(
        Map<IdentificationNumber, Collection<Customer>> customersByIdentificationNumber) {
      this.customersByIdentificationNumber = customersByIdentificationNumber;
    }

    protected abstract B self();

    protected abstract H hook();

    public abstract R build();

    public BuilderCustomer<H> withIdentificationNumber(IdentificationNumber identificationNumber) {
      customersByIdentificationNumber.putIfAbsent(identificationNumber, new ArrayList<>());
      this.identificationNumber = identificationNumber;
      return self();
    }

    public H withCustomer(Customer customer) {
      this.customers.add(customer);
      return hook();
    }
  }

  public interface BuilderInitial<H, R> extends BuilderIdentificationNumber<H>, BuilderBuild<R> {

  }

  @FunctionalInterface
  public interface BuilderIdentificationNumber<H> {

    BuilderCustomer<H> withIdentificationNumber(IdentificationNumber identificationNumber);
  }

  @FunctionalInterface
  public interface BuilderCustomer<H> {

    H withCustomer(Customer customer);
  }

  public interface BuilderCustomerChain<R> {

    BuilderCustomerChain<R> withCustomer(Customer customer);

    R withIdentificationNumber(IdentificationNumber identificationNumber);
  }

  @FunctionalInterface
  public interface BuilderBuild<R> {

    R build();
  }
}