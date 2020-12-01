public class Deleted extends AllPeople {

	protected static Arraylist<Deleted> deleted = new Arraylist<>();
	//protected static Deleted delTable[] = new Deleted[100];
	private static int counter = 0;

	public Deleted(String name, String surname, String address, String email, int phonenumber, int AMKA) {
		super(name, surname, address, email, phonenumber, AMKA);
		// oti allh plhroforia zhtao na dinetai kata thn epikoinonia
		if (counter == delTable.length) {
			delTable = (Deleted[]) duplicateTable(delTable.length, delTable);
		}
		delTable[counter] = this;
		counter++;
	}

	public static boolean cure(int id) {
// 		for (int i = 0; i <  deleted.size(); i++) {
// 			if (deleted(i).getId() == id) {
// 				System.out.println("The patient :" + deleted.get(i).getName() +" "+deleted.get(i).getsurname() + " has already been deleted");
// 				return false;
// 			}
// 		}
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
		destructor(pos, VictimContact.victimContactTable);
		Confirmed.confTable[pos] = Confirmed.confTable[Confirmed.counter];
		Confirmed.counter = Confirmed.counter - 1;
	}

}
