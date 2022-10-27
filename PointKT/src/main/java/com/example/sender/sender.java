package com.example.sender;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.MapMessage;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import com.example.model.patient;

public class sender {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		
		InitialContext ctx = new InitialContext();
		Queue requestQueue=(Queue) ctx.lookup("queue/requestQueue");
		Queue replyQueue=(Queue) ctx.lookup("queue/replyQueue");
		
		try {
			ActiveMQConnectionFactory conn=new ActiveMQConnectionFactory();
			JMSContext jctx=conn.createContext();
			JMSProducer prod=jctx.createProducer();
			patient p=new patient();
			p.setId(1);
			p.setName("Abc");
			p.setPayDue(1000);
			p.setPaymentString(2000);
			ObjectMessage om=jctx.createObjectMessage();
			om.setObject(p);
			prod.send(requestQueue, om);
			JMSConsumer jCons=jctx.createConsumer(replyQueue);
			MapMessage reply= (MapMessage) jCons.receive(1000000);
			System.out.println("Reply ---- patient in debt true/false"+reply.getBoolean("debt"));
			
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
		}

	}

}
