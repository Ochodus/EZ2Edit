package ez2edit;

import java.util.ArrayList;
import java.util.List;

public class Config {
	public static int initBarNumber = 38;
	public static int initBeat = 4;
	public static int initModer = 4;
	public static int playMode = 16;
	public static int initBarHeight = 192;
	public static int initColumnWidth = 28;
	public static int grid = 8;
	public static int sub = 4;
	public static double widthMod = 1.5;
	public static double heightMod = 1.5;
	public static int curBarHeight = (int)(initBarHeight*heightMod);
	public static int curColumnWidth = (int)(initColumnWidth*widthMod);
	public static int typeGap = (int)(4*widthMod);
	public static int editMode = 1;
	public static int NoteHeight = 15;
	
	public static List<Note> pinnedNote = new ArrayList<Note>();
	public static List<Note> selectedNote = new ArrayList<Note>();
}
