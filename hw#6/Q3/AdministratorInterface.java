/**
 * Interface of Administrator
 * @author mustafa
 *
 */
public interface AdministratorInterface {
	/**
	 * adding book
	 * @param newBook
	 */
	public void addBook(Book newBook);
	/**
	 * deleting book
	 * @param deletingBook
	 */
	public void deleteBook(Book deletingBook);
	/**
	 * show books
	 */
	public void showBooks();
	/**
	 * updates status
	 * @param choice that is book number
	 */
	public void updateStatus(int choice);
	/**
	 * update lociton
	 * @param choice given book nuber
	 * @param locate
	 */
	public void updateLocation(int choice,String locate);
	/**
	 * deleting book with given book number
	 * @param choice
	 * @return
	 */
	public boolean deleteBook(int choice);
	/**
	 * update name
	 * @param choice
	 * @param name
	 */
	public void updateName(int choice,String name);
	/**
	 * update author name
	 * @param oldAuthor
	 * @param newAuthor
	 */
	public void updateAuthor(String oldAuthor ,String newAuthor);
	/**
	 * To show books with author name
	 * @param author_name
	 */
	public void showLocation(String author_name);
}
