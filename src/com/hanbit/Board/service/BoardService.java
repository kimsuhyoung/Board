package com.hanbit.Board.service;

import com.hanbit.Board.domain.BoardBean;

public interface BoardService {
	public void writeBoard(BoardBean board); //작성자(addmember)
	public int countWriter();
	public BoardBean[] list(); //조건없는 배열 선언
	public BoardBean findBySeq(int Seq);
	public BoardBean[] findByWriter(String writer);
	public int count();
	public void updateContent(BoardBean board);
	public void delete(int Seq);
}
