import com.maxleap.code.*;
import com.maxleap.code.impl.GlobalConfig;
import com.maxleap.code.impl.MLResponse;
import com.maxleap.code.impl.LoaderBase;

/**
 * User：poplar
 * Date：15/10/14
 */
public class Main extends LoaderBase implements Loader{

  @Override
  public void main(GlobalConfig globalConfig) {
    //定义一个简单的function:返回输入数据
    defineFunction("hello", new MLHandler<Request, Response>() {
      @Override
      public Response handle(Request request) {
        Response<String> response = new MLResponse<>(String.class);
        response.setResult(request.parameter(String.class));
        return response;
      }
    });

    //定义一个简单的job
    defineJob("helloJob", new MLHandler<Request, Response>() {
      @Override
      public Response handle(Request request) {
        Response response = new MLResponse(String.class);
        response.setResult("hello job");
        return response;
      }
    });
  }
}
