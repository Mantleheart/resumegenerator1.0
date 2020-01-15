//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.LayoutManager;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main {
    public Main() {
    }

    public static void main(String[] var0) throws IOException {
        JFrame var2 = new JFrame("The Resume Generating tool");
        JTextField var1 = new JTextField("Please type in the name of the University:", 1);
        var2.setDefaultCloseOperation(3);
        var2.add(var1);
        var2.setSize(200, 200);
        var2.setLayout((LayoutManager)null);
        var2.setVisible(true);
        var2.pack();

        for(int var3 = 0; var3 < 100; ++var3) {
            Fabricator var4 = new Fabricator("the University of Texas at Austin");
            System.out.print(var4.printResult());
        }

    }
}
