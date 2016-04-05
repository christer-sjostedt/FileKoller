package filekoller;

public class Window
{
    WindowGui _windowGui;

    public Window( WindowGui windowGui )
    {
        _windowGui = windowGui;
    }

    public void openPath( String path )
    {
        System.out.println( "Operning " + path +  "..." );

        _windowGui.update();
    }

    public void printTestMessage()
    {
        System.out.println( "Printing a test message..." );

        // (Den här metoden är bara för test!)
    }
}
