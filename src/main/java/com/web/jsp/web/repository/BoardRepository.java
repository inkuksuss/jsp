package com.web.jsp.web.repository;


import com.web.jsp.domain.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface BoardRepository {
    List<BoardDto> getBoardList(BoardDto boardDto);

    Optional<BoardDto> getBoard(BoardDto boardDto);

    void insertBoard(BoardDto boardDto);

    void insertProduct(BoardDto boardDto);

    void insertProductDetail(BoardDto boardDto);

    void updateBoard(BoardDto boardDto);

    void deleteBoard(BoardDto boardDto);
}
