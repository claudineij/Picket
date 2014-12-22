package br.com.waio.erp.web;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class TransactionFilterFilter implements Filter {

    @Inject
    private UserTransaction userTransaction;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            this.userTransaction.begin();
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            try {
                this.userTransaction.rollback();
            } catch (SystemException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                if (Status.STATUS_ACTIVE == this.userTransaction.getStatus()) {
                    this.userTransaction.commit();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {

    }
}
