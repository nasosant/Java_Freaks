public class Deleted extends AllPeople {

	protected static Deleted delTable[] = new Deleted[100];
	private static int counter = 0;

	public Deleted(String name, String surname, String address, String email, int phonenumber, int AMKA) {
		super(name, surname, address, email, phonenumber, AMKA);
		// oti allh plhroforia zhtao na dinetai kata thn epikoinonia
		if (counter == delTable.length) {
			delTable = duplicateTable(delTable.length, delTable);
		}
		delTable[counter] = this;
		counter++;
	}

	public static Deleted[] duplicateTable(int length, Deleted[] delTable) {
		Deleted newdelTable[] = new Deleted[2 * length];
		for (int i = 0; i < length; i++) {
			newdelTable[i] = delTable[i];
		}
		return newdelTable;
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

		Deleted lucky = new Deleted(Confirmed.confTable[pos].name, Confirmed.confTable[pos].surname,
				Confirmed.confTable[pos].address, Confirmed.confTable[pos].email, Confirmed.confTable[pos].phonenumber,
				Confirmed.confTable[pos].AMKA);

		AllPeople.counter_for_id = temp;
		destructor(Confirmed.confTable[pos]);
		Confirmed.confTable[pos] = Confirmed.confTable[Confirmed.counter];
		Confirmed.counter = Confirmed.counter - 1;
	}

	public static void destructor(AllPeople person) {
		person.finalize(person);
		person = null;
		System.gc();
	}

}

