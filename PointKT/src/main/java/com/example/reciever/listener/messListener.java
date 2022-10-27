package com.example.reciever.listener;

import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import com.example.model.patient;

public class messListener implements MessageListener {

	public void onMessage(Message message) {
		
		// TODO Auto-generated method stub
		ObjectMessage ojm=(ObjectMessage) message;
		try {
			ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
			JMSContext jmsContext = cf.createContext();
		InitialContext initialContext = new InitialContext();
		Queue replyQueue = (Queue) initialContext.lookup("queue/replyQueue");
		MapMessage replyMessage = jmsContext.createMapMessage();
		patient patient = (patient) ojm.getObject();
			patient p=(patient) ojm.getObject();
			double due=p.getPayDue();
			if(due>0)
			replyMessage.setBoolean("debt", true);
			else
				replyMessage.setBoolean("debt", false);
			JMSProducer producer = jmsContext.createProducer();
			producer.send(replyQueue, replyMessage);
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}

	}


