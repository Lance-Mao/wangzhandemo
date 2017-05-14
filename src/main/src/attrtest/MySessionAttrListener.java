package attrtest;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Created by pc on 17-5-13.
 */
public class MySessionAttrListener implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent event) {
        //获取session对象
        HttpSession session = event.getSession();
        Object obj = session.getAttribute("username");
        //测试
        System.out.println("添加的属性：" + obj);
    }

    public void attributeRemoved(HttpSessionBindingEvent event) {

    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
        //获取session对象
        HttpSession session = event.getSession();
        //获取替换前的值
        Object noe = session.getValue("username");
        Object three = session.getAttributeNames();
        System.out.println(noe);
        System.out.println(three);
        //获取新值
        Object two = session.getAttribute("username");
        System.out.println(two);

    }
}
