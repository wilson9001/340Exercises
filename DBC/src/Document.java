/**
 * The Document class is used to store and modify the contents of a 
 * text document.
 * 
 * Operations are provided for reading, inserting, and deleting characters
 * in the document.
 * For convenience, cursor-relative operations are provided to make it easier
 * to edit a document in the style supported by a typical text editor.
 *
 * Domain:
 *      Content: Sequence<char>, Document content
 *      Length: Integer, Number of characters in the document (initially zero)
 *      Cursor: Integer, Position in the character sequence where some
 *              operations on the document occur (initially zero)
 *
 * @invariant length() >= 0
 * @invariant 0 <= cursor() <= length()
 */
class Document {

	/**
	 * Initializes empty document
	 * 
	 * @pre None
	 * 
	 * @post new length() = 0
	 * @post new cursor() = 0
	 */
	Document(){}

    
	/**
	 * Returns the number of characters in the document
	 * 
	 * @pre None
	 * 
	 * @post Return value contains the number of characters in the document
	 */
	int length() { return 0; }

    
	/**
	 * Returns the specified number of characters, starting at the specified
	 * position
	 * 
	 * @param pos Position of the characters to be returned
	 * @param count Number of characters to be returned
	 * 
	 * @pre int >= 0
	 * @pre count >= 0
	 * @pre pos + count <= length()
	 * 
	 * @post return is non-null
	 * @post return's length = count
	 * @post return's value = characters in content() beginning at position pos and ending at position pos+count-1
	 * @post content() is unchanged
	 * @post length() is unchanged
	 * @post cursor() is unchanged
	 */
	String read(int pos, int count) { return null; }
	
    
	/**
	 * Inserts a character sequence into the document
	 * 
	 * @param pos Position at which the character sequence should be inserted
	 * @param s Character sequence to be inserted
	 * 
	 * @pre pos >= 0
	 * @pre pos <= length()
	 * @pre s != null
	 * 
	 * @post new length() = old length() + s.size()
	 * @post new content() will contain all of the characters of old Content(), with the characters from s inserted at index pos
	 * @post new cursor() <= length()
	 */
	void insert(int pos, String s) {}

	
	/**
	 * Deletes a character sequence from the document.
	 * 
	 * @param pos Starting position of the sequence that is being deleted 
	 * @param count Number of characters to be deleted
	 * 
	 * @pre pos >= 0
	 * @pre count >= 0
	 * @pre pos < length()
	 * @pre (pos + count) <= length()
	 * 
	 * @post new length() = old length() - count
	 * @post new cursor() <= new length()
	 * @post new cursor() >= 0
	 * @post new Content() will contain characters of old Content() that were not in old Content() from index pos to index pos+count-1
	 */
	void delete(int pos, int count) {}

    
	/**
	 * Returns the current cursor position
	 * 
	 * @pre None
	 * 
	 * @post Return value contains the current cursor position
	 */
	int cursor() { return 0; }
	
    
	/**
	 * Sets the current cursor position
	 * 
	 * @param pos New cursor position
	 * 
	 * @pre 0 <= pos <= length()
	 * 
	 * @post new cursor() = pos
	 */
	void setCursor(int pos) {}

    
	/**
	 * Inserts a single character into the document at the current cursor
     * position, and advances the cursor forward one position
	 * 
	 * @param c Character to be inserted
	 * 
	 * @pre None
	 *
	 * @post new cursor() = old cursor() + 1
	 * @post new content() = old content() except with character c inserted at the position of new cursor() - 1
	 * @post new length() = old length() + 1
	 */
	void insert(char c) {}
	
    
	/**
	 * Deletes the character at the current cursor position
	 * 
	 * @pre length() >= 1
	 * 
	 * @post new cursor() = old cursor()
	 * @post new length() = old length() - 1
	 * @post new content() = old content() except for removal of the character at position cursor() in old content()
	 */
	void delete() {}
	
    
	/**
	 * Moves the cursor backward one position, and deletes the character at the new cursor position
	 *
	 * @pre length() >= 1
	 * 
	 * @post new cursor() = old cursor()-1
	 * @post new length() = old length()-1
	 * @post new content() = old content() except for character in old content() at index new cursor()
	 */
	void deletePrevious() {}

    
	/**
	 * Deletes the entire contents of the document and resets it to an empty state
	 *
	 * @pre length() >= 1
	 * 
	 * @post new length() = 0
	 * @post new content().size() = 0
	 * @post new cursor() = 0
	 */
	void clear() {}
}
