package filekoller;

public class Window
{
    WindowGui _starterGui;

    public Window( WindowGui starterGui )
    {
        _starterGui = starterGui;
    }

    public void openPath( String program )
    {
        System.out.println( "Operning " + program +  "..." );

        // TODO: Starta ett annat program här!
    }

    public void printTestMessage()
    {
        System.out.println( "Printing a test message..." );

        // (Den här metoden är bara för test!)
    }
}
