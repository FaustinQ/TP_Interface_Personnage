import javax.swing.*;
import java.awt.BorderLayout;

public class CharacterSheet extends JFrame {

    private JPanel panel;

    private CharacterSheetStats characterSheetStats;
    private CharacterSheetToolBar characterSheetToolBar;
    private CharacterSheetStateBar characterSheetStateBar;

    private CharacterSheetListener characterSheetListener;

    public CharacterSheet() {
        this.initComponents();
    }

    private void initComponents() {
        this.setTitle("Feuille de personnage");

        this.characterSheetListener = new CharacterSheetListener(this);
        
        this.characterSheetStats = new CharacterSheetStats(this.characterSheetListener);
        this.characterSheetToolBar = new CharacterSheetToolBar(this.characterSheetListener);
        this.characterSheetStateBar = new CharacterSheetStateBar("v0.1");

        this.panel = new JPanel(new BorderLayout());
        this.panel.add(this.characterSheetToolBar, BorderLayout.WEST);
        this.panel.add(this.characterSheetStats, BorderLayout.CENTER);
        this.panel.add(this.characterSheetStateBar, BorderLayout.SOUTH);


        
        this.setContentPane(this.panel);
        
    }


    public CharacterSheetStats getCharacterSheetStats() {
        return this.characterSheetStats;
    }

    public CharacterSheetToolBar getCharacterSheetToolBar() {
        return this.characterSheetToolBar;
    }

    public CharacterSheetStateBar getCharacterSheetStateBar() {
        return this.characterSheetStateBar;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CharacterSheet characterSheet = new CharacterSheet();
                characterSheet.setVisible(true);
                characterSheet.setDefaultCloseOperation(EXIT_ON_CLOSE);
                characterSheet.setLocationRelativeTo(null);
                characterSheet.pack();
            }
        });
    }

}
