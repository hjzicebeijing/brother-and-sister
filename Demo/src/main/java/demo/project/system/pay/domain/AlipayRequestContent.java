package demo.project.system.pay.domain;

import org.springframework.stereotype.Component;

@Component
public class AlipayRequestContent {
    private String out_trade_no;
    private String total_amount;
    private String subject;
    private String timeout_express;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public String getSubject() {
        return subject;
    }

    public String getTimeout_express() {
        return timeout_express;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTimeout_express(String timeout_express) {
        this.timeout_express = timeout_express;
    }
}
