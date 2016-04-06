package filekoller;

import java.io.*;
import java.util.*;

public class FileEntry
{
    public FileEntry( File file )
    {
        _file = file;
    }

    public ArrayList<FileEntry> getSubEntries() // Maybe not needed...
    {
        return null; // TEMP
    }

    File getFile()
    {
        return _file;
    }

    void setFile( File file )
    {
        _file = file;
    }

    private File _file;
}
