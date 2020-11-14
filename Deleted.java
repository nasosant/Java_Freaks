public class Deleted extends AllPeople {

	protected static Deleted delTable[] = new Deleted[100];
	private static int counter = 0;

	public Deleted(String name, String surname) {
		super(name, surname);
		// oti allh plhroforia zhtao na dinetai kata thn epikoinonia
		delTable[counter] = this;
		counter++ ;
	}

	public static void cure(int id) {
		int size = Confirmed.confTable.length;
		int pos = -1;
		for (int i = 0; i < size; i++) {
			if (Confirmed.confTable[i].getId() == id) {
				pos = i;
			}
		}
		
	}

}

