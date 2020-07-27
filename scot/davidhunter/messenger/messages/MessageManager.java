package scot.davidhunter.messenger.messages;

import java.util.ArrayList;

public class MessageManager {

	private ArrayList<MessageBox> messageBoxes;
	
	/**
	 * Manages messages and message boxes.
	 */
	public MessageManager() {
		messageBoxes = new ArrayList<MessageBox>();
	}
	
	/**
	 * Create new Message Box and return its ID as an Integer.
	 * @param name (String) The name to call the Message Box. (e.g. The User's Name)
	 * @return Integer
	 */
	public int createMessageBox(String name) {
		messageBoxes.add(new MessageBox(this, name));
		int ID = messageBoxes.size() - 1;
		
		return ID;
	}
	
	/**
	 * Retrieve's the Message Box for the given ID.
	 * @param ID (Integer) The ID of the Message Box to retrieve.
	 * @return MessageBox
	 */
	public MessageBox retrieveMessageBox(int ID) {
		if(ID < messageBoxes.size())
			return messageBoxes.get(ID);
		return null;
	}
	
	/**
	 * Returns all Message Boxes that have been created.
	 * @return MessageBox[]
	 */
	public MessageBox[] getMessageBoxes() {
		MessageBox[] messageBoxes = new MessageBox[this.messageBoxes.size()];
		
		for(int mb = 0; mb < this.messageBoxes.size(); mb++) {
			messageBoxes[mb] = this.messageBoxes.get(mb);
		}
		
		return messageBoxes;
	}
	
}
