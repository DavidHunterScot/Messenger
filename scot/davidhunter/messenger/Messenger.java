package scot.davidhunter.messenger;

import scot.davidhunter.messenger.messages.MessageBox;
import scot.davidhunter.messenger.messages.MessageManager;

/**
 * A Simply Messenger Program, made in Java.
 * @author DavidHunterScot
 *
 */
public class Messenger {

	private MessageManager messageManager;
	
	/**
	 * The messenger that delivers all messages to the Message Manager.
	 */
	public Messenger() {
		messageManager = new MessageManager();
	}
	
	/**
	 * Retrieve the Messenger's Message Manager.
	 * @return MessageManager
	 */
	public MessageManager getMessageManager() {
		return messageManager;
	}
	
	public static void main(String[] args) {
		// Create a new Messenger.
		Messenger messenger = new Messenger();
		// Contact the Message Manager.
		MessageManager mm = messenger.getMessageManager();
		
		// Ask the manager to create a Message Box for "David Hunter".
		int dhID = mm.createMessageBox("David Hunter");
		// Ready the box for messages.
		MessageBox dh = mm.retrieveMessageBox(dhID);
		
		// Ask the manager to create another Message Box for "John Doe".
		int jdID = mm.createMessageBox("John Doe");
		// Ready the box for messages.
		MessageBox jd = mm.retrieveMessageBox(jdID);
		
		// David sends a message to John.
		dh.sendMessage(jdID, "Hey, how are you today?");
		// John responds to David's message.
		jd.sendMessage(dhID, "Hey, I'm fine thank you, how are you?");
		
		// John wants to view his Inbox.
		jd.open(MessageBox.INBOX);
		// David wants to view his Inbox.
		dh.open(MessageBox.INBOX);
		
		// David wants to view his Outbox.
		dh.open(MessageBox.OUTBOX);
		// John wants to view his Outbox.
		jd.open(MessageBox.OUTBOX);
	}
	
}
