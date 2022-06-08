package com.web.jsp.web.service.impl;

import com.web.jsp.domain.dto.BoardDto;
import com.web.jsp.web.repository.BoardRepository;
import com.web.jsp.web.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public List<BoardDto> getBoardList(BoardDto boardDto) throws Exception{
        return boardRepository.getBoardList(boardDto);
    }

    @Override
    public Optional<BoardDto> getBoard(BoardDto boardDto) throws Exception{
        return boardRepository.getBoard(boardDto);
    }

    @Override
    public void insertBoard(BoardDto boardDto) throws Exception {
        boardRepository.insertBoard(boardDto);
        boardRepository.insertProduct(boardDto);
        boardRepository.insertProductDetail(boardDto);
    }

    @Override
    public void updateBoard(BoardDto boardDto) throws Exception{
        boardRepository.updateBoard(boardDto);

    }

    @Override
    public void deleteBoard(BoardDto boardDto) {
        boardRepository.deleteBoard(boardDto);
    }
}
