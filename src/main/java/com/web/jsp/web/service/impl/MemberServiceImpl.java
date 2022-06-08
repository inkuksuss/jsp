package com.web.jsp.web.service.impl;

import com.web.jsp.domain.dto.MemberDto;
import com.web.jsp.web.repository.MemberRepository;
import com.web.jsp.web.service.MemberService;
import com.web.jsp.web.utills.PasswordEncoder;
import com.web.jsp.web.utills.SessionManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final SessionManager sessionManager;

    @Override
    public List<MemberDto> getMemberList(MemberDto memberDto) throws SQLException {
        return memberRepository.getMemberList(memberDto);
    }

    @Override
    public Optional<MemberDto> getMemberById(MemberDto memberDto) throws SQLException {
        return memberRepository.getMemberById(memberDto);
    }

    @Override
    public void insertMember(MemberDto memberDto) throws Exception {

        MemberDto member = new MemberDto();
        member.setMemberId(memberDto.getMemberId());

        if (getMemberById(memberDto).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        };

        memberDto.setMemberPassword(PasswordEncoder.encrypt(memberDto.getMemberPassword()));
        memberRepository.insertMember(memberDto);
    }

    @Override
    public void deleteMember(MemberDto memberDto) throws SQLException {
        memberRepository.deleteMember(memberDto);
    }

    @Override
    public void login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, MemberDto memberDto) throws Exception {
        MemberDto member = memberRepository.getMemberById(memberDto)
                .orElseThrow(() -> new IllegalArgumentException("계정을 확인해주세요."));

        String memberPassword = member.getMemberPassword();

        if (!memberDto.getMemberPassword().equals(PasswordEncoder.decrypt(memberPassword))) {
            throw new IllegalArgumentException("비밀번호를 확인해주세요");
        }

        member.setMemberPassword(null);
        sessionManager.createSession(member, httpServletRequest, httpServletResponse);
    }

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws SQLException {
        sessionManager.expireSession(httpServletRequest, httpServletResponse);
    }

    @Override
    public void setLoginMember(Model model, HttpServletRequest httpServletRequest) {
        MemberDto memberDto = null;

        if (sessionManager.getSession(httpServletRequest).isPresent()) {
            memberDto = sessionManager.getSession(httpServletRequest).get();
        }

        model.addAttribute("loginMember", memberDto);
    }

    @Override
    public String getLoginMemberIdx(HttpServletRequest httpServletRequest) {
        if(sessionManager.getSession(httpServletRequest).isPresent()) {
            MemberDto memberDto = sessionManager.getSession(httpServletRequest).get();
            return memberDto.getMemberIdx();
        }
        return null;
    }
}
