import java.awt.BorderLayout;

import javax.swing.*;

public class CharacterSheetStateBar extends JPanel{

    // Les deux labels de notre barre d'état
    // le label de message et le label de version
    private JLabel statusLabel;
    private JLabel versionLabel;

    public CharacterSheetStateBar(String version){
        // On initialise la barre d'état
        this.initComponents(version);
    }

    private void initComponents(String version) {
        // On initialise le label de message
        this.statusLabel = new JLabel("<statut>");

        // On initialise le label de version
        this.versionLabel = new JLabel(version);

        this.setLayout(new BorderLayout());
        this.add(this.statusLabel, BorderLayout.WEST);
        this.add(this.versionLabel, BorderLayout.EAST);
    }

    public void setStatusLabel(String status) {
        this.statusLabel.setText(status);
    }

}
