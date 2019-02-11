package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Comparator;
import java.util.List;

/**
 * Sorts list according to their names in alphabetical order
 */
public class SortedListCommand extends Command {

    /**
     * Comparator class to sort Person by name in ascending order
     * If name is the same, order remains unchanged
     */
    private class SortByName implements Comparator<Person> {
        public int compare(Person personA, Person personB) {
            return personA.getName().toString().compareTo(personB.getName().toString());
        }
    }

    public static final String COMMAND_WORD = "sortedlist";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list with index numbers sorted by their names.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<Person> allPersons = addressBook.getAllPersons().mutableListView();
        allPersons.sort(new SortByName());
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
