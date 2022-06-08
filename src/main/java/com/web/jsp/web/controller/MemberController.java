package com.web.jsp.web.controller;


import com.web.jsp.domain.dto.MemberDto;
import com.web.jsp.web.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String getLogin(HttpServletRequest httpServletRequest, Model model) {
        memberService.setLoginMember(model, httpServletRequest);
        return "/login";
    }

    @PostMapping("/login")
    public String postLogin(
            @RequestParam(required = false) String memberId,
            @RequestParam(required = false) String memberPassword,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse
    ) {

        MemberDto memberDto = new MemberDto();
        memberDto.setMemberId(memberId);
        memberDto.setMemberPassword(memberPassword);

        try {
            memberService.login(httpServletRequest, httpServletResponse, memberDto);
            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
            return "/error";
        }
    }

    @GetMapping("/join")
    public String getJoin(HttpServletRequest httpServletRequest, Model model) {
        memberService.setLoginMember(model, httpServletRequest);
        return "/join";
    }

    @PostMapping("/join")
    public String postJoin(
            @RequestParam(required = false) String memberId,
            @RequestParam(required = false) String memberPassword,
            @RequestParam(required = false) String memberNick,
            @RequestParam(required = false) String memberAuth) {

        MemberDto memberDto = new MemberDto();
        memberDto.setMemberId(memberId);
        memberDto.setMemberPassword(memberPassword);
        memberDto.setMemberNick(memberNick);
        memberDto.setMemberAuth(memberAuth);

        try {
            memberService.insertMember(memberDto);
            return "/login";
        } catch (Exception e) {
            e.printStackTrace();
            return "/error";
        }
    }

    @GetMapping("/logout")
    public String getLogout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            memberService.logout(httpServletRequest, httpServletResponse);
            return "redirect:/login";
        } catch (Exception e) {
            e.printStackTrace();
            return "/error";
        }
    }

    @GetMapping("/deleteMember")
    public String deleteMember(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String loginMemberIdx = memberService.getLoginMemberIdx(httpServletRequest);

        MemberDto memberDto = new MemberDto();
        memberDto.setMemberIdx(loginMemberIdx);

        try {
            memberService.logout(httpServletRequest, httpServletResponse);

            memberService.deleteMember(memberDto);
            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
            return "/error";
        }
    }

    @GetMapping("/my-page")
    public String getMyPage(HttpServletRequest httpServletRequest, Model model) {

        try {
            memberService.setLoginMember(model, httpServletRequest);
            return "my-page";
        } catch (Exception e) {
            e.printStackTrace();
            return "/error";
        }
    }
}
