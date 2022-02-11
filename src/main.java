import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main
{
    private static Scanner s;
    public static void main(String[] args)
    {
        s = new Scanner(System.in);
        checkAns();
    }

    private static void checkAns()
    {
        print(
                "Kangoo Interpreter\n\n" +
                        "[1] Select Directory\n" +
                        "[2] Compile Code inside 'source' folder\n" +
                        "[3] Enter Code Editor"
        );

        int ans = s.nextInt();

        switch(ans)
        {
            case 1:
                selectDirectory();
                break;

            case 2:
                print("compile code inside ...");
                break;

            case 3:
                print("code editor");
                break;

            default:
                print("wrong syntax");
                clear();
                checkAns();
                break;
        }
    }

    private static void selectDirectory()
    {
        clear();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose file");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        File file;

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            print("test");

            file = fileChooser.getSelectedFile();

            try
            {
                Scanner scanner = new Scanner(file);
                print(scanner.nextLine());
            }
            catch (FileNotFoundException fnfe)
            {
                print("file not found");
            }
        }
    }

    // var name = "huanson"
    // loop(10) -> var i
    //{ print("hey")}

    // var name = "huanson"
    // l

    // two functions to easily print, instead of always writing System.out....
    public static void print(String str)
    {
        System.out.println(str);
    }

    public static void print(int i)
    {
        System.out.println(Integer.toString(i));
    }

    public static void clear()
    {
        // looking for os name to clear the terminal or command prompt. Windows uses CMD while
        // Mac and Linux use the terminal
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            // nothing
        }
    }
}
