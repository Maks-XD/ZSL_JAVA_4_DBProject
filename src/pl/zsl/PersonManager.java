package pl.zsl;
import java.util.ArrayList;
import java.util.List;

public class PersonManager {
	private List<Person> persons;
	private PersonDBLayer personsDB;
	
	public PersonManager () {
		personsDB = new PersonDBLayer();
		persons = new ArrayList<Person>();
	}
	
	public void addPerson (Person p) throws Exception {
		personsDB.addPerson(p);
		persons.add(p);
	}
	
	public Boolean removePerson (String name) throws Exception {
		Person tempPerson = null;
		for (Person p : persons)
			if (p.getName().equals(name)) {
				tempPerson = p;
				break;
			}
		if (tempPerson != null) {
			removePerson(tempPerson);
			return true;
		}
		else
			return false;
	}
	
	public void removePerson (Person p) throws Exception {
		personsDB.removePerson(p);
		persons.remove(p);
	}
	
	public List<Person> readPersons() throws Exception {
		this.persons = personsDB.getPersons();
		return this.persons;
	}
	
	public List<Person> getPersons() throws Exception {
		if (this.persons == null || this.persons.size() == 0)
			this.persons = personsDB.getPersons();
		return this.persons;
	}
	
	public Person getPerson (String name) {
		for (Person p : persons)
			if (p.getName().equals(name)) {
				return p;
			}
		return null;
	}
}
