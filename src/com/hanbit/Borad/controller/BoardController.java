package com.hanbit.Borad.controller;

import javax.swing.JOptionPane;
import com.hanbit.Board.domain.BoardBean;
import com.hanbit.Board.service.BoardService;
import com.hanbit.Board.serviceImpl.BoardServiceImpl;

public class BoardController {
	public static void main(String[] args){
		BoardService service = new BoardServiceImpl();
		BoardBean board=null;
		int Sequence=0;
		while(true){
			switch(JOptionPane.showInputDialog("0.종료 1.글작성 2.글갯수 3.글목록 4.글찾기(번호) 5.글찾기(작성자) 6.수정 7.삭제")){
			case "0" :
				return;
			case "1" :
				board=new BoardBean();
				String[] foo=JOptionPane.showInputDialog("작성자/제목/입력하고 싶은 글/날짜").split("/"); 	
				Sequence++;
				board.setSequence(Sequence);
				board.setWriter(foo[0]);
				board.setTitle(foo[1]);
				board.setContent(foo[2]);
				board.setRegdate(foo[3]);
				service.writeBoard(board);
				JOptionPane.showMessageDialog(null, "글작성 완료");
				
				break;
				
			case "2" :
				JOptionPane.showMessageDialog(null, service.countWriter()+"개");
				break;
			case "3" :
				String allList="";
				for(int i=0;i<service.count();i++){
					allList+=service.list()[i].toString(); 
				}
				
				JOptionPane.showMessageDialog(null, allList);
				break;
			
			case "4" :
				board=new BoardBean();
				board=service.findBySeq(Integer.parseInt(JOptionPane.showInputDialog("찾을번호를 입력하세요")));
				JOptionPane.showMessageDialog(null, board.toString());
				break;
			
			case "5" :
				BoardBean[] listByWriter=service.findByWriter(JOptionPane.showInputDialog("찾을 작성자를 입력하세요"));
				String findWriter="";
				for(int i=0;i<listByWriter.length;i++){
					findWriter+=listByWriter[i].toString();
				}
				JOptionPane.showMessageDialog(null, findWriter);
				break;
			
			case "6" :
				board=new BoardBean();
				board.setSequence(Integer.parseInt(JOptionPane.showInputDialog("수정할 글 번호를 알려주세요")));
				board.setContent(JOptionPane.showInputDialog("수정할 글을 입력하여 주세요"));
				service.updateContent(board);
				JOptionPane.showMessageDialog(null, "수정완료");
				break;
				
			case "7" :
				service.delete(Integer.parseInt(JOptionPane.showInputDialog("삭제할 글의 번호를 알려주세요")));
				JOptionPane.showMessageDialog(null, "삭제완료");
				break;
			}
		} 
	}
}
