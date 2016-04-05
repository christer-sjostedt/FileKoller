package filekoller;

public class Explorer
{
    ExplorerGui _explorerGui;

    public Explorer( ExplorerGui explorerGui )
    {
        _explorerGui = explorerGui;
    }

    public void openPath( String path )
    {
        System.out.println( "Operning " + path +  "..." );

        _explorerGui.update();
    }

    public void printTestMessage()
    {
        System.out.println( "Printing a test message..." );

        // (Den här metoden är bara för test!)
    }
}
