package org.t246osslab.easybuggy.core.servlets;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Minimal base servlet providing the message helpers and response writer used
 * by the easybuggy "troubles" servlets. Trimmed to what the CWE-209 dataflow needs.
 */
@SuppressWarnings("serial")
public abstract class AbstractServlet extends HttpServlet {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    protected String getMsg(String key, Locale locale) {
        return key;
    }

    protected String getInfoMsg(String key, Locale locale) {
        return key;
    }

    protected String getErrMsg(String key, String[] args, Locale locale) {
        StringBuilder sb = new StringBuilder(key);
        for (String arg : args) {
            sb.append(": ").append(arg);
        }
        return sb.toString();
    }

    protected void responseToClient(HttpServletRequest req, HttpServletResponse res, String title, String body)
            throws IOException {
        res.setContentType("text/html; charset=UTF-8");
        res.getWriter().write("<html><head><title>" + title + "</title></head><body>" + body + "</body></html>");
    }
}
