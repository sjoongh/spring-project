package com.bitacademy.myportal.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BoardVo> selectAll() {
		List<BoardVo> list = sqlSession.selectList("board.selectAll");
		return list;
	}

	@Override
	public int insert(BoardVo boardVo) {
		// TODO: 예외처리
		int insertedCount = sqlSession.insert("board.insert", boardVo);
		return insertedCount;
	}

	@Override
	public BoardVo view(Long no) {
		BoardVo vo = sqlSession.selectOne("board.selectOne", no);
		return vo;
	}

	@Override
	public int update(BoardVo boardVo) {
		return sqlSession.update("board.update", boardVo);
	}
	
	@Override
	public Long updateHit(Long hit) {
		return (long) sqlSession.update("board.updateHit", hit);
	}

	@Override
	public void delete(Long no) {
		sqlSession.delete("board.delete", no);
	}

}
