package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

public class Main
{

    public static void main(String[] args)
    {
//        Terminal terminal = TerminalFacade.createTerminal();
//        Screen screen = new Screen(terminal);
//        screen.startScreen();
//
//        screen.clear();
//        Menu menu = new Menu(screen, new TerminalPosition(0,0), 30, 10);
//        menu.draw();
//        mainMenu(screen);

        Connection conn = null;
        try
        {
            conn = createDatabaseConnection();
        } catch (ClassNotFoundException | SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Statement command=null;
        try
        {
            command = conn.createStatement();
        } catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try
        {
            command.executeQuery("create table testTable(num int);");
        } catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /*
     * The method creates a Connection object. Loads the embedded driver,
     * starts and connects to the database using the connection URL.
     */
    public static Connection createDatabaseConnection()
            throws SQLException, ClassNotFoundException {
        String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        Class.forName(driver);
        String url = "jdbc:derby:testDB";
        Connection c = DriverManager.getConnection(url);
        return c;
    }
/*
    private static void mainMenu(Screen screen)
    {
        ScreenWriter writer = new ScreenWriter(screen);
        TerminalSize size = screen.getTerminalSize();

        // draw borders
        for (int i = 0; i < size.getColumns(); i++)
        {
            writer.drawChar(i, 0, '+');
            writer.drawChar(i, size.getRows() - 1, '+');
        }
        for (int i = 0; i < size.getRows(); i++)
        {
            writer.drawChar(0, i, '+');
            writer.drawChar(size.getColumns() - 1, i, '+');
        }

        // draw title art
        ArrayList<String> title = new ArrayList<String>();
        title.add(" ____       _   _      __ _           _           _ ");
        title.add("|  _ \\ __ _| |_| |__  / _(_)_ __   __| | ___ _ __| |");
        title.add("| |_) / _` | __| '_ \\| |_| | '_ \\ / _` |/ _ \\ '__| |");
        title.add("|  __/ (_| | |_| | | |  _| | | | | (_| |  __/ |  |_|");
        title.add("|_|   \\__,_|\\__|_| |_|_| |_|_| |_|\\__,_|\\___|_|  (_)");
        for (int i = 0; i < title.size(); i++)
        {
            // puts the title in the middle of the screen and in the top portion
            writer.drawString(size.getColumns() / 2 - title.get(i).length() / 2, size.getRows() / 4 + i, title.get(i));
        }

        ArrayList<String> menuOptions = new ArrayList<String>();
        menuOptions.add("New Game");
        menuOptions.add("Load Game");
        menuOptions.add("About");
        menuOptions.add("Exit Game");

        for (int i = 0; i < menuOptions.size(); i++)
        {
            writer.drawString(size.getColumns() / 2 + 1, size.getRows() * 2 / 3 + i, menuOptions.get(i));
        }
        writer.drawChar(size.getColumns() / 2 - 2, size.getRows() * 2 / 3, '-');
        screen.refresh();

        int curPos = 0;
        int prePos = 0;
        while (true)
        {
            Key input = getInput(screen);

            if (input.getCharacter() == 'e' || input.getCharacter() == 'E' || input.getKind() == Kind.Enter)
            {
                if(curPos==3)
                {
                    System.exit(0);
                } else if (curPos==0)
                {
                    //creates second terminal window
                    Terminal game = TerminalFacade.createTerminal();
                    Screen gameScreen = new Screen(game);
                    gameScreen.startScreen();
                }
            } else if (input.getCharacter() == 'w' || input.getCharacter() == 'W' || input.getKind() == Kind.ArrowUp)
            {
                prePos = curPos;
                curPos--;
                if (curPos < 0)
                {
                    curPos = 3;
                }
            } else if (input.getCharacter() == 's' || input.getCharacter() == 'S' || input.getKind() == Kind.ArrowDown)
            {
                prePos = curPos;
                curPos++;
                if (curPos > 3)
                {
                    curPos = 0;
                }
            }
            writer.drawChar(size.getColumns() / 2 - 2, size.getRows() * 2 / 3 + prePos, ' ');
            writer.drawChar(size.getColumns() / 2 - 2, size.getRows() * 2 / 3 + curPos, '-');
            screen.refresh();
        }
    }

    private static Key getInput(Screen screen)
    {
        Key input = null;
        while (input == null)
        {
            input = screen.readInput();
        }
        return input;
    }
    */
}