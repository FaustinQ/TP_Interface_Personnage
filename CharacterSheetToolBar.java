import javax.swing.*;
import java.awt.GridLayout;


public class CharacterSheetToolBar extends JToolBar{

    // Les boutons que l'on veut utiliser :
    // nouveau, charger, enregistrer, enregistrer sous
    private JButton nouveauButton;
    private JButton chargerButton;
    private JButton enregistrerButton;
    private JButton enregistrerSousButton;

    public CharacterSheetToolBar(CharacterSheetListener characterSheetListener){
        this.initComponents();

        
        this.nouveauButton.addActionListener(characterSheetListener);
        this.chargerButton.addActionListener(characterSheetListener);
        this.enregistrerButton.addActionListener(characterSheetListener);
        this.enregistrerSousButton.addActionListener(characterSheetListener);

    }

    private void initComponents() {
        
        this.nouveauButton = new JButton("Nouveau");
        this.nouveauButton.setActionCommand("Nouveau");
        this.chargerButton = new JButton("Charger");
        this.chargerButton.setActionCommand("Charger");
        this.enregistrerButton = new JButton("Enregistrer");
        this.enregistrerButton.setActionCommand("Enregistrer");
        this.enregistrerSousButton = new JButton("Enregistrer sous");
        this.enregistrerSousButton.setActionCommand("Enregistrer sous");

        this.setLayout(new GridLayout(4, 1)); // 4 lignes pour 4 boutons, 1 colonne
        this.add(enregistrerButton);
        this.add(enregistrerSousButton);
        this.add(nouveauButton);
        this.add(chargerButton);
    }
}
