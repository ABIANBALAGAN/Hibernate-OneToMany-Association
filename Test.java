package com.model;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sun.tools.javac.util.List;

public class Test {
public static void main(String[] args) {
	Transaction tr=null;
	try(Session ses=HBUtil.getSf().openSession()){
			tr=ses.beginTransaction();
			Question q1=new Question();
			q1.setQuestion("What is Hibernate?");
			Question q2=new Question();
			q2.setQuestion("What is Entity Class?");
			Answer a1=new Answer(101,"Hb is an ORM.","Sunil");
			Answer a2=new Answer(102,"Hb implements JPA.","Kumar");
			Answer b1=new Answer(201,"Entity Class is a simple java class","Abi");
			Answer b2=new Answer(202,"POJO Classes are called  Entity class","Dhanya");
			ArrayList<Answer> l1=new ArrayList<Answer>();
			l1.add(a1);
			l1.add(a2);
			ArrayList<Answer> l2=new ArrayList<Answer>();
			l2.add(b1);
			l2.add(b2);
			q1.setAnswers(l1);
			q1.setAnswers(l2);
			ses.merge(q1);
			ses.merge(q2);
			tr.commit();
			ses.close();
}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
