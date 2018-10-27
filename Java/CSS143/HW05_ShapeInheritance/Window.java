import javax.swing.JFrame;
public class Window extends JFrame {

  public Window() {
      setSize(500,500);
      setVisible(true);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

   public static void main (String[] args) {
       Window a = new Window();
    }
}

