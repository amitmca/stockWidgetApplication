package com.stockwidget.web.stockdetailservice;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequence")
public class CustomSequences {
    @Id
    private String id;
    private int seq;
    
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}

}