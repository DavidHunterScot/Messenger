package scot.davidhunter.messenger.messages;

public class Message {

	private String author, text;
	
	/**
	 * Message from Unknown Author.
	 * @param text (String) The message text.
	 */
	public Message(String text) {
		this.author = "Unknown";
		this.text = text;
	}
	
	/**
	 * Message from Known Author.
	 * @param author (String) The author of the message.
	 * @param text (String) The message text.
	 */
	public Message(String author, String text) {
		this.author = author;
		this.text = text;
	}
	
	/**
	 * Returns the message author.
	 * @return (String)
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * Returns the message text.
	 * @return (String)
	 */
	public String getText() {
		return text;
	}
	
}
