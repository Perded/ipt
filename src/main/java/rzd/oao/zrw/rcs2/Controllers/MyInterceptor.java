package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;

import java.util.HashMap;
import java.util.Map;

public class MyInterceptor extends AbstractInterceptor {

    public String intercept(ActionInvocation invocation)throws Exception{
      /* let us do some pre-processing */
//        Map<String,Object> stack = ActionContext.getContext().getParameters();
//        for(Map.Entry pare: stack.entrySet()){
//            /*if("request".equals(pare.getKey()))*/ System.out.println(pare.getKey() + " !_! "+pare.getValue());
//        }
 //       System.out.println("!!!!!!!!!фывафывафывафываф!!!!!!!!!!!!");
      /* let us call action or next interceptor */
        String result = invocation.invoke();
      /* let us do some post-processing */
//        output = "Post-Processing";
 //       System.out.println(output);
        return result;
    }
}