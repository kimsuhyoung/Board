package com.hanbit.Board.serviceImpl;

import java.util.Arrays;

import com.hanbit.Board.domain.BoardBean;
import com.hanbit.Board.service.BoardService;

public class BoardServiceImpl implements BoardService{
	int count;
	BoardBean board;
	BoardBean[] list;
	BoardBean[] listByWriter;
	public BoardServiceImpl(){
		count=0;
		board=new BoardBean();
		list=new BoardBean[count+1];
		
	}
	@Override
	public void writeBoard(BoardBean board) {
		list[count]=board;
		count++;
		list=Arrays.copyOf(list, count+1);
		
	}
	
	@Override
	public int countWriter() {
		// TODO Auto-generated method stub
		return count;
	}
	
	@Override
	public BoardBean[] list() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public BoardBean findBySeq(int Seq) {
		board=new BoardBean();
		for(int i=0;i<count;i++){
			if(Seq==list[i].getSequence()){
				board=list[i];
				break;
			}
		}
		return board;
	}

	@Override
	public BoardBean[] findByWriter(String writer) {
		int cnt=0;
		for(int i=0;i<count;i++){
			if(writer.equals(list[i].getWriter())){
				cnt++;
			}
		}
		
		int j=0;
		listByWriter=new BoardBean[cnt];
		for(int i=0;i<count;i++){
			if(writer.equals(list[i].getWriter())){
				listByWriter[j]=list[i];
				j++;
			}
			if(j==cnt){
				break;
			}
		}
		return listByWriter;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public void updateContent(BoardBean board) {
		this.board=findBySeq(board.getSequence());
		this.board.setContent(board.getContent());
		
	}

	@Override
	public void delete(int Seq) {
		for(int i=0;i<count;i++){
			if(Seq==list[i].getSequence()){
				list[i]=list[count-1];
				list[count-1]=null;
				break;
			}			
		}
		 		count--;
		 		list=Arrays.copyOf(list, count);
	}

	
	

}
