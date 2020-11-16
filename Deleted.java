public class Deleted extends AllPeople {

	protected static Deleted delTable[] = new Deleted[1];
	protected static int counter = 0;

	public Deleted(String name, String surname, String address, String email, int phonenumber, int AMKA) {
		super(name, surname, address, email, phonenumber, AMKA);
		// oti allh plhroforia zhtao na dinetai kata thn epikoinonia
		if (counter == delTable.length) {
			delTable = (Deleted[]) duplicateTable(delTable.length, delTable);
		}
		delTable[counter] = this;
		counter++;
	}

	public static void cure(int id) {
		int pos = -1;
		for (int i = 0; i < Confirmed.confTable.length; i++) {
			if (Confirmed.confTable[i].getId() == id) {
				pos = i;
				break;
			}
		}
		int temp = AllPeople.counter_for_id;
		AllPeople.counter_for_id = id - 1;

		new Deleted(Confirmed.confTable[pos].name, Confirmed.confTable[pos].surname, Confirmed.confTable[pos].address,
				Confirmed.confTable[pos].email, Confirmed.confTable[pos].phonenumber, Confirmed.confTable[pos].AMKA);

		AllPeople.counter_for_id = temp;
		AllPeople.destructor(Confirmed.confTable[pos]);
		Confirmed.counter = Confirmed.counter - 1;
		Confirmed.confTable[pos] = Confirmed.confTable[Confirmed.counter];
	}

}

