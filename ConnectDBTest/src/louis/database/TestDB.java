/**
 * 
 */
package louis.database;

/**
 * @author luongnv89
 *
 */
public class TestDB {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MySQLAccess dao = new MySQLAccess();
		dao.readDataBase();
	}

}
