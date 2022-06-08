package com.web.jsp.web.service;

import com.web.jsp.domain.dto.BoardDto;

import java.util.List;
import java.util.Optional;

public interface BoardService {

    List<BoardDto> getBoardList(BoardDto boardDto) throws Exception;

    Optional<BoardDto> getBoard(BoardDto boardDto)throws Exception;

    void insertBoard(BoardDto boardDto)throws Exception;

    void updateBoard(BoardDto boardDto)throws Exception;

    void deleteBoard(BoardDto boardDto)throws Exception;
}
