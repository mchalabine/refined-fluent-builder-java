import org.junit.Test;

public class CustomersByIdentificationNumberTest {

  @Test
  public void testCustomersByIdentificationNumberTest() throws Exception {

    CustomersByIdentificationNumber
        .aCustomersByIdentificationNumber()
        .withIdentificationNumber(new IdentificationNumber())
        .withCustomer(new Customer())
        .withCustomer(new Customer())
        .withCustomer(new Customer())
        .withIdentificationNumber(new IdentificationNumber())
        .withCustomer(new Customer())
        .withCustomer(new Customer())
        .build();


  }
}