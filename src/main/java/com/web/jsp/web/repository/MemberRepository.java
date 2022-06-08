package com.web.jsp.web.repository;

import com.web.jsp.domain.dto.BoardDto;
import com.web.jsp.domain.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface MemberRepository {

    List<MemberDto> getMemberList(MemberDto memberDto) throws SQLException;

    Optional<MemberDto> getMemberById(MemberDto memberDto) throws SQLException;

    void insertMember(MemberDto memberDto) throws SQLException;

    void deleteMember(MemberDto memberDto) throws SQLException;
}

