package com.web.jsp.web.service;

import com.web.jsp.domain.dto.MemberDto;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface MemberService {

    List<MemberDto> getMemberList(MemberDto memberDto) throws SQLException;

    Optional<MemberDto> getMemberById(MemberDto memberDto) throws SQLException;

    void insertMember(MemberDto memberDto) throws Exception;

    void deleteMember(MemberDto memberDto) throws SQLException;

    void login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, MemberDto memberDto) throws Exception;

    void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws SQLException;

    void setLoginMember(Model model, HttpServletRequest httpServletRequest);

    String getLoginMemberIdx(HttpServletRequest httpServletRequest);
}
