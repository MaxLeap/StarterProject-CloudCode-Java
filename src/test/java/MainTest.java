import com.maxleap.code.Response;
import com.maxleap.code.test.framework.TestCloudCode;
import org.junit.Assert;
import org.junit.Test;

/**
 * User：poplar
 * Date：15/10/14
 */
public class MainTest extends TestCloudCode {
  public MainTest() throws Exception {
    super("http://api.leap.as/2.0");
  }

  @Test
  public void hello(){
    String json = "{\"name\":\"jack\",\"ids\":[\"aa\",\"bb\"]}";
    Response response = runFunction("hello", json);
    if (response.succeeded()){
      System.out.println(response.getResult());
    } else {
      Assert.fail(response.getError());
    }
  }

  @Test
  public void helloJob(){
    runJob("helloJob",null);
  }
}
