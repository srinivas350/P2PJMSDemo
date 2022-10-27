package com.example.reciever;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import com.example.reciever.listener.messListener;

public class reciever {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		
		InitialContext ctx = new InitialContext();
		Queue requestQueue=(Queue) ctx.lookup("queue/requestQueue");
		try {
			ActiveMQConnectionFactory conn=new ActiveMQConnectionFactory();
			JMSContext jctx=conn.createContext();
			JMSConsumer cons=jctx.createConsumer(requestQueue);
			cons.setMessageListener(new messListener());
			Thread.sleep(1000000);
			

	}
		catch(Exception e)
		{
			
		}

}
}
