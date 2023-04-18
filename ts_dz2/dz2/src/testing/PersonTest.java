package testing;

import FileExceptions.BadFileException;
import Structure.Gridline;

public interface PersonTest {
	public abstract boolean createGridMine() throws BadFileException;
	public abstract Gridline gridlineMine();
}
