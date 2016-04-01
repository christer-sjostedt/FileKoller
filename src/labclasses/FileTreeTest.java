package labclasses;

import static java.lang.System.out;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileTreeTest
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try
        {
            // finding current directory
            String currentDir1 = new java.io.File( "." ).getCanonicalPath();
            out.println("Current dir by evaluating .: " + currentDir1);
            String currentDir2 = System.getProperty("user.dir");
            out.println("Current dir by using System: " + currentDir2);

            // listing directory content
            File f = new File(currentDir1);
            //File f = new File("C:\\");
            //ArrayList<String> names = new ArrayList<>(Arrays.asList(f.list()));
            ArrayList<File> files = new ArrayList<>(Arrays.asList(f.listFiles()));
            ArrayList<File> plainFiles = new ArrayList<>();
            ArrayList<File> directories = new ArrayList<>();

            out.println("\nDirectory listing:");

            int maxNameLength = 0;
            long maxFileSize = 0;
            for (File file : files)
            {
                if (file.isDirectory())
                {
                    directories.add(file);

                    if (file.list().length > maxFileSize)
                    {
                        maxFileSize = file.list().length;
                    }
                }
                else if (file.isFile())
                {
                    plainFiles.add(file);

                    if (file.length() > maxFileSize)
                    {
                        maxFileSize = file.length();
                    }
                }

                if (file.getName().length() > maxNameLength)
                {
                    maxNameLength = file.getName().length();
                }
            }

            int maxFileSizeLength = (int)Math.log10( maxFileSize ) + 1;

            for (File file : directories)
            {
                out.printf( "%s %s %s %-" + maxNameLength + "s %" + maxFileSizeLength + "d %s\n",
                        formatFileType(file),
                        formatFileAccesses(file),
                        formatFileAttributes(file),
                        file.getName(),
                        file.list().length,
                        formatDate(file) );
            }

            for (File file : plainFiles)
            {
                out.printf( "%s %s %s %-" + maxNameLength + "s %" + maxFileSizeLength + "d %s\n",
                        formatFileType(file),
                        formatFileAccesses(file),
                        formatFileAttributes(file),
                        file.getName(),
                        file.length(),
                        formatDate(file) );
            }
        }
        catch (IOException ex)
        {
            out.println(ex);
            ex.printStackTrace();
            Logger.getLogger(FileTreeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String formatFileType( File file )
    {
        String retval;

        if (file.isDirectory())
        {
            retval = "d";
        }
        else if (file.isFile())
        {
            retval = " ";
        }
        else
        {
            retval = "?";
        }

        return retval;
    }

    public static String formatFileAccesses( File file )
    {
        String retval;

        if (file.canRead())
        {
            retval = "r";
        }
        else
        {
            retval = "-";
        }

        if (file.canWrite())
        {
            retval += "w";
        }
        else
        {
            retval += "-";
        }

        if (file.canExecute())
        {
            retval += "x";
        }
        else
        {
            retval += "-";
        }

        return retval;
    }

    public static String formatFileAttributes( File file )
    {
        String retval;

        if (file.isHidden())
        {
            retval = "h";
        }
        else
        {
            retval = " ";
        }

        return retval;
    }

    public static String formatDate( File file )
    {
        String retval = "";

        long millis = file.lastModified();
        if (millis != 0) // if we are allowed to read date
        {
            // Date format must be SHORT, not DEFAULT, to get 2016-03-30 format in sv-SE:
            DateFormat df = DateFormat.getDateTimeInstance( DateFormat.SHORT, DateFormat.DEFAULT );
            Date date = new Date(millis);
            retval += df.format(date) + " ";
        }
        else
        {
            retval += "(undisclosed)";
        }

        return retval;
    }

    public static void testMisc( File file )
    {
        String res = "";
        long millis = file.lastModified();

        //DateFormat df = DateFormat.getDateTimeInstance(); // "2016-mar-30 09:21:41" on {sv OS (Win7), en-US lang, ISO/sv datetime format}
        Locale locale = new Locale("sv","SE");
        out.println( "### " + locale.getDisplayLanguage() + " - " + locale.getDisplayCountry());

        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.DEFAULT); // Date format must be SHORT, not DEFAULT, to get 2016-03-30 format.
        SimpleDateFormat sf = (SimpleDateFormat)df;
        //SimpleDateFormat sf = new SimpleDateFormat();
        Date date = new Date(millis);
        res += df.format(date) + " ";
        res += sf.toPattern() + " "; // TEST

        out.println( res );
    }

    public void findResource() // find resources (files) from CLASSPATH
    {
        // From ClassLoader, all paths are "absolute" already - there's no context
        // from which they could be relative. Therefore you don't need a leading slash.
        InputStream in1 = this.getClass().getClassLoader()
                                        .getResourceAsStream("SomeTextFile.txt");

        // From Class, the path is relative to the package of the class unless
        // you include a leading slash, so if you don't want to use the current
        // package, include a slash like this:
        InputStream in2 = this.getClass().getResourceAsStream("/SomeTextFile.txt");
    }
}

