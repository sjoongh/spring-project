package com.bitacademy.myportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal.repository.BoardDao;
import com.bitacademy.myportal.repository.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDaoImpl;
	@Override
	public List<BoardVo> getList() {
		List<BoardVo> list = boardDaoImpl.selectAll();
		return list;
	}

	@Override
	public BoardVo view(Long no) {
		BoardVo vo = boardDaoImpl.view(no);
		return vo;
	}
	

	@Override
	public boolean write(BoardVo vo) {
		int insertedCount = boardDaoImpl.insert(vo);
		return 1 == insertedCount;
	}

	@Override
	public boolean update(BoardVo vo) {
		int updatedCount = boardDaoImpl.update(vo);
		return 1 == updatedCount;
	}
	
	@Override
	public void updateHit(Long hit) {
		boardDaoImpl.updateHit(hit);
	}
	
	@Override
	public void delete(Long no) {
		boardDaoImpl.delete(no);
	}

}
