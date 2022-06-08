package com.web.jsp.web.controller;

import com.web.jsp.domain.dto.BoardDto;
import com.web.jsp.domain.dto.MemberDto;
import com.web.jsp.web.service.BoardService;
import com.web.jsp.web.service.MemberService;
import com.web.jsp.web.utills.SessionManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CommonController {

    private final SessionManager sessionManager;
    private final BoardService boardService;
    private final MemberService memberService;

    @GetMapping("/")
    public String home(Model model, HttpServletRequest httpServletRequest) {
        MemberDto memberDto = null;

        if (sessionManager.getSession(httpServletRequest).isPresent()) {
            memberDto = sessionManager.getSession(httpServletRequest).get();
        }


        try {
            List<BoardDto> boardList = boardService.getBoardList(new BoardDto());
            System.out.println("boardList = " + boardList.toString());

            model.addAttribute("loginMember", memberDto);
            model.addAttribute("boardList", boardList);
            return "/home";
        } catch (Exception e) {
            e.printStackTrace();
            return "/error";
        }
    }

    @GetMapping("/board/{boardIdx}")
    public String home(Model model, HttpServletRequest httpServletRequest, @PathVariable String boardIdx) {
        MemberDto memberDto = null;

        if (sessionManager.getSession(httpServletRequest).isPresent()) {
            memberDto = sessionManager.getSession(httpServletRequest).get();
        }


        try {
            BoardDto boardDto = new BoardDto();
            boardDto.setBoardIdx(boardIdx);
            Optional<BoardDto> board = boardService.getBoard(boardDto);

            if (board.isPresent()) {
                model.addAttribute("board", board.get());
            }

            System.out.println("board = " + board.toString());

            model.addAttribute("loginMember", memberDto);

            return "/board";
        } catch (Exception e) {
            e.printStackTrace();
            return "/error";
        }
    }

    @GetMapping("/insertBoard")
    public String getInsertBoard(Model model, HttpServletRequest httpServletRequest) {
        MemberDto memberDto = null;

        if (sessionManager.getSession(httpServletRequest).isPresent()) {
            memberDto = sessionManager.getSession(httpServletRequest).get();
        }

        try {
            model.addAttribute("loginMember", memberDto);
            return "/insert-board";
        } catch (Exception e) {
            e.printStackTrace();
            return "/error";
        }
    }

    @PostMapping("/insertBoard")
    public String postInsertBoard(
            @RequestParam(required = false) String boardName,
            @RequestParam(required = false) String boardBody,
            @RequestParam(required = false) String productState,
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) int productPrice,
            @RequestParam(required = false) int productAmount,
            @RequestParam(required = false) String productImage,
            Model model, HttpServletRequest httpServletRequest) {
        MemberDto memberDto = null;

        BoardDto boardDto = new BoardDto();
        boardDto.setBoardName(boardName);
        boardDto.setBoardBody(boardBody);
        boardDto.setProductState(productState);
        boardDto.setProductName(productName);
        boardDto.setProductPrice(productPrice);
        boardDto.setProductAmount(productAmount);
        boardDto.setProductImage(productImage);


        if (sessionManager.getSession(httpServletRequest).isPresent()) {
            memberDto = sessionManager.getSession(httpServletRequest).get();
        }

        try {
            boardService.insertBoard(boardDto);
            model.addAttribute("loginMember", memberDto);
            return "/";
        } catch (Exception e) {
            e.printStackTrace();
            return "/error";
        }
    }
}
