package controller;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class MenuPanel extends JPanel {

    private Color defaultBackgroundColor = Color.BLACK;
    private Color hoverBackgroundColor = new Color(172, 44, 0);
    private Color clickBackgroundColor = new Color(0, 0, 0);

    public MenuPanel(int a, int b) {
        setBackground(a == b ? hoverBackgroundColor : clickBackgroundColor);
        setOpaque(true);
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 20));
        setPreferredSize(new Dimension(250, 55));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (a!=b) SwingUtilities.invokeLater(() -> setBackground(hoverBackgroundColor));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (a!=b) SwingUtilities.invokeLater(() -> setBackground(defaultBackgroundColor));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (a!=b) SwingUtilities.invokeLater(() -> setBackground(clickBackgroundColor));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (a!=b) SwingUtilities.invokeLater(() -> setBackground(hoverBackgroundColor));
            }
        });
    }

    public void setHoverBackgroundColor(Color hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
    }

    public void setClickBackgroundColor(Color clickBackgroundColor) {
        this.clickBackgroundColor = clickBackgroundColor;
    }
}
