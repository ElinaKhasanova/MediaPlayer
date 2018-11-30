package someServ;

import dateTime.Time;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
public class EventTag extends SimpleTagSupport {
    public String dt;

    public void setDt(String dt) {
        this.dt = dt;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        Time time = new Time(dt);
        time.calculatePastTime();
        out.write(time.pastTimeToString());
//        out.write("hi");
    }
}
    //    @Override
//    public int doStartTag() throws JspException {
//
//            JspWriter out = pageContext.getOut();
//
//            dateTime.Time time = new dateTime.Time("6/11/2018 12:00");
//            time.calculatePastTime();
//            out.write(time.pastTimeToString());
//
//        }catch (IOException e) {
//            throw new JspException(e.getMessage());
//        }
//        return SKIP_BODY;
//    }
//
//    @Override
//    public int doEndTag() throws JspException {
//        return SKIP_PAGE;
//    }
