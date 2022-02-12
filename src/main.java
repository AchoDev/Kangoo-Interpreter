import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.*;
import java.lang.Integer;


public class main
{

    static Int var = new Int("name", 10);
    static Map<String, Integer> ints = new HashMap<String, Integer>();

    private static Scanner s;
    public static void main(String[] args)
    {
        s = new Scanner(System.in);
        print(var.getValue());

        ints.put("name", 10);

        print(ints.get("name"));

        // s.nextInt();
        checkAns();
    }

    public static String turnOneLine(String code)
    {
        return code;
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

    private static void compile(File file) throws FileNotFoundException
    {
        String[] lines;
        ArrayList<String>[] commands;
        String code = "";
        int rep;

        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            code = code + scanner.nextLine() + "/";
        }

        lines = code.split("/");

        commands = new ArrayList[lines.length];

        for(int i = 0; i < lines.length; i++)
        {
            commands[i] = new ArrayList<String>();
            for(int j = 0; j < lines[i].split(" ").length; j++)
            {
                commands[i].add(lines[i].split(" ")[j]);
            }
        }

        for(ArrayList<String> s : commands)
        {
            for(int i = 0; i < s.size(); i++)
            {
                print(s.get(i));
            }
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
                print("something");
                compile(file);
            }
             catch(FileNotFoundException e)
            {
                print("file not found");
            }
        }
    }

    // var:string = "HEY" var num = 10
    // loop ( 10 )
    //

    // two functions to easily print, instead of always writing System.out....
    public static void print(String str)
    {
        System.out.println(str);
    }

    public static void print(int i)
    {
        System.out.println(String.valueOf(i));
    }

    public static void print(boolean cond)
    {
        if(cond)
        {
            print("true");
        }
         else
        {
            print("false");
        }
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
