package com.web.jsp.web.utills;


import com.web.jsp.domain.dto.MemberDto;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@Component
public class SessionManager {

    public static final String SESSION_ID = "JSP_SESSION";

    public void createSession(MemberDto memberDto, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String uuid = UUID.randomUUID().toString();

        HttpSession session = httpServletRequest.getSession();
        session.setAttribute(uuid, memberDto);

        Cookie cookie = new Cookie(SESSION_ID, uuid);
        httpServletResponse.addCookie(cookie);
    }

    public Optional<MemberDto> getSession(HttpServletRequest httpServletRequest) {
        Cookie cookie = findCookie(httpServletRequest);
        if (cookie == null) return Optional.empty();

        return Optional.of((MemberDto) httpServletRequest.getSession().getAttribute(cookie.getValue()));
    }

    public void expireSession(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Cookie cookie = findCookie(httpServletRequest);

        if (cookie != null) {
            HttpSession session = httpServletRequest.getSession();
            session.removeAttribute(cookie.getValue());

            cookie.setMaxAge(0);
            httpServletResponse.addCookie(cookie);
        }
    }

    private Cookie findCookie(HttpServletRequest httpServletRequest) {
        if (httpServletRequest.getCookies() == null) return null;
        return Arrays.stream(httpServletRequest.getCookies())
                .filter(cookie -> cookie.getName().equals(SESSION_ID))
                .findFirst()
                .orElse(null);
    }
}
