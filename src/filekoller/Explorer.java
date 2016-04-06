package filekoller;

import static java.lang.System.*;

import java.io.*;
import java.util.*;

public class Explorer
{
    ExplorerGui _explorerGui;

    public Explorer( ExplorerGui explorerGui )
    {
        _explorerGui = explorerGui;
    }

    public ArrayList<FileEntry> buildTree( String path )
    {
        //System.out.println( "Building tree from " + path +  "..." );

        File f = new File(path);

        ArrayList<File> files = new ArrayList<>(Arrays.asList(f.listFiles()));
        ArrayList<FileEntry> plainFiles = new ArrayList<>();
        ArrayList<FileEntry> directories = new ArrayList<>();

        for (File file : files)
        {
            if (file.isDirectory())
            {
                directories.add(new FileEntry(file));
            }
            else if (file.isFile())
            {
                plainFiles.add(new FileEntry(file));
            }
        }

        return directories;
    }

    public void viewDirectory( String path )
    {
        System.out.println( "Viewing files in " + path +  "..." );
    }

    public void openPath( String path )
    {
        System.out.println( "Opening file " + path +  "..." );
    }
}
