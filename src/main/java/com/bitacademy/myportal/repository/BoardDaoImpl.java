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
//		int hit = sqlSession.update("board.updateHit", no);
		return vo;
	}

	@Override
	public int update(BoardVo boardVo) {
		// int형으로 하는게 맞나?
		int updatedCount = sqlSession.update("board.update", boardVo);
		return updatedCount;
	}

	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

}
