import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CharacterSheetListener implements ActionListener, ChangeListener {

    private CharacterSheet characterSheet;

    public CharacterSheetListener(CharacterSheet characterSheet) {
        this.characterSheet = characterSheet;
    }

    public void actionPerformed(ActionEvent paramActionEvent) {
        String command = paramActionEvent.getActionCommand();
        if (command.equals("Nouveau")) {
            // Change le statut de la barre d'état
            this.characterSheet.getCharacterSheetStateBar().setStatusLabel("Nouveau personnage créé.");
        } else if (command.equals("Charger")) {
            this.characterSheet.getCharacterSheetStateBar().setStatusLabel("Personnage chargé.");
        } else if (command.equals("Enregistrer")) {
            this.characterSheet.getCharacterSheetStateBar().setStatusLabel("Personnage enregistré.");
        } else if (command.equals("Enregistrer sous")) {
            this.characterSheet.getCharacterSheetStateBar().setStatusLabel("Personnage enregistré sous.");
        }
        
    }

    public void stateChanged(ChangeEvent paramChangeEvent) {
        
        
    }

}
