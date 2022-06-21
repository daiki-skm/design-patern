import command.*;
import drawer.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements MouseMotionListener, WindowListener {
    private MacroCommand history = new MacroCommand();
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    private JButton clearButton = new JButton("clear");
    private JButton redButton = new JButton("red");
    private JButton blueButton = new JButton("blue");
    private JButton greenButton = new JButton("green");

    public Main(String title) {
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(e -> {
            history.clear();
            canvas.init();
            canvas.repaint();
        });
        redButton.addActionListener(e -> {
            Command command = new ColorCommand(canvas, Color.red);
            history.append(command);
            command.execute();
        });
        blueButton.addActionListener(e -> {
            Command command = new ColorCommand(canvas, Color.blue);
            history.append(command);
            command.execute();
        });
        greenButton.addActionListener(e -> {
            Command command = new ColorCommand(canvas, Color.green);
            history.append(command);
            command.execute();
        });

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(redButton);
        buttonBox.add(blueButton);
        buttonBox.add(greenButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Command command = new DrawCommand(canvas, e.getPoint());
        history.append(command);
        command.execute();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}