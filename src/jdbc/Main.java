package jdbc;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DBConnection db = new DBConnection();
		//db.getData();
        db.setloginData("tesfealem","gebrie", "tesfi", "tesfi");
		db.getData();
		

	}
	

}
