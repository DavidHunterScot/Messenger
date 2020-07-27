package scot.davidhunter.messenger.messages;

import java.util.ArrayList;

public class MessageBox {

	private MessageManager messageManager;
	private String name;
	private ArrayList<Message> inMessages, outMessages;
	
	public static final String INBOX = "Inbox", OUTBOX = "Outbox";
	
	/**
	 * A Message Box to store Messages.
	 * @param messageManager (MessageManager) The manager of the messages and boxes.
	 * @param name (String) A name to give the box.
	 */
	public MessageBox(MessageManager messageManager, String name) {
		this.messageManager = messageManager;
		this.name = name;
		inMessages = new ArrayList<Message>();
		outMessages = new ArrayList<Message>();
	}
	
	/**
	 * Returns the name of the Message Box.
	 * @return (String)
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Add a message to the Inbox folder of the Message Box.
	 * @param message (Message) The message to store in the Message Box.
	 */
	public void addMessage(Message message) {
		addMessage(message, MessageBox.INBOX);
	}
	
	/**
	 * Add a message to a folder in the Message Box.
	 * @param message (Message) The message to store in the Message Box.
	 * @param folder (String) The folder to store the Message in. (Static Strings are Available)
	 */
	public void addMessage(Message message, String folder) {
		if(folder == INBOX || folder == "") inMessages.add(message);
		if(folder == OUTBOX) outMessages.add(message);
	}
	
	/**
	 * Open the Inbox Folder and Output All Messages
	 */
	public void open() {
		open(INBOX);
	}
	
	/**
	 * Open a Folder and Output All Messages
	 * @param folder (String) The folder to open. (Static Strings are Available)
	 */
	public void open(String folder) {
		Message[] messages = getMessages(folder);
		
		if(messages == null) return;
		
		System.out.println("---" + name + "'s Message Box " + folder + " ---");
		
		for(Message message : messages) {
			String author = message.getAuthor();
			
			if(author == name || author == "Unknown")
				author = "Note to Self";
			
			System.out.println(author + ": " + message.getText());
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	/**
	 * Send a message to another Message Box.
	 * @param ID (Integer) The ID of the recipient's Message Box.
	 * @param text (String) The message text to send.
	 */
	public void sendMessage(int ID, String text) {
		MessageBox recipient = messageManager.retrieveMessageBox(ID);
		
		if(recipient != null) {
			Message inMessage = new Message(name + " -> " + recipient.name, text);
			Message outMessage = new Message(name + " -> " + recipient.name, text);
			recipient.addMessage(inMessage, INBOX);
			addMessage(outMessage, OUTBOX);
		}
	}
	
	/**
	 * Get all Messages stored in the Inbox folder.
	 * @return (Message[])
	 */
	public Message[] getMessages() {
		return getMessages(INBOX);
	}
	
	/**
	 * Get all Messages stored in a folder.
	 * @param folder (String) The folder to retrieve from. (Static Strings are Available)
	 * @return (Message[])
	 */
	public Message[] getMessages(String folder) {
		ArrayList<Message> allMessages = null;
		Message[] boxMessages = null;
		
		if(folder == INBOX || folder == "") allMessages = this.inMessages;
		if(folder == OUTBOX) allMessages = this.outMessages;
		
		boxMessages = new Message[allMessages.size()];
		
		if( allMessages == null || boxMessages == null ) return null;
		
		for(int m = 0; m < allMessages.size(); m++) {
			boxMessages[m] = allMessages.get(m);
		}
		
		return boxMessages;
	}
	
}
