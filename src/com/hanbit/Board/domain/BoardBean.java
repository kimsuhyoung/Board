package com.hanbit.Board.domain;

public class BoardBean {

	private int Sequence;
	private String Regdate, Writer, Title, Content;
	
	public void setSequence(int Sequence){
		this.Sequence=Sequence;
	}
	public int getSequence(){
		return Sequence;
	}
	public void setRegdate(String Regdate){
		this.Regdate=Regdate;
	}
	public String getRegdate (){
		return Regdate;
	}
	public void setWriter(String Writer){
		this.Writer=Writer;
	}
	public String getWriter (){
		return Writer;
	}
	public void setTitle(String Title){
		this.Title=Title;
	}
	public String getTitle(){
		return Title;
	}
	public void setContent(String Content){
		this.Content=Content;
	}
	public String getContent(){
		return Content;
	}
	public String toString(){
		return String.format("%d / %s / %s/ %s/ %s", Sequence,Title,Content,Writer,Regdate+"\n");
	}
	
}

