import javax.swing.*;
import java.awt.GridLayout;

public class CharacterSheetStats extends JPanel {

    // On a besoin de ce blankLabel pour "passer" des cellules du GridLayout
    private JLabel blankLabel;

    // Les labels
    private JLabel nomLabel;
    private JLabel raceLabel;
    private JLabel classeLabel;
    private JLabel str;
    private JLabel con;
    private JLabel dex;
    private JLabel inte;
    private JLabel wis;
    private JLabel cha;
    private JLabel ptsLabel;
    private JLabel numLabel;
    
    // Les champs de texte
    private JTextField nomTextField;
    
    // Les boutons radios
    private JRadioButton HRadioButton;
    private JRadioButton FRadioButton;

    // Les combobox
    private JComboBox<String> RaceComboBox;
    private JComboBox<String> ClasseComboBox;

    // Liste déroulante 
    private JSpinner strSpinner;
    private JSpinner conSpinner;
    private JSpinner dexSpinner;
    private JSpinner inteSpinner;
    private JSpinner wisSpinner;
    private JSpinner chaSpinner;

    // Model
    private CharacterSheetModel characterSheetModel;

    private int ptsRestants = 27; // Points restants

    public CharacterSheetStats(CharacterSheetListener characterSheetListener) {
        this.initComponents();

    }

    private int getPointCost(int statValue) {
        switch (statValue) {
            case 8: return 0;
            case 9: return 1;
            case 10: return 2;
            case 11: return 3;
            case 12: return 4;
            case 13: return 5;
            case 14: return 7;
            case 15: return 9;
            default: return Integer.MAX_VALUE; // Valeur invalide
        }
    }

    private void updateSpinnerLimits(JSpinner spinner) {
        int current = (int) spinner.getValue();
        int max = 15; // Valeur maximale autorisée
    
        // Si les points restants sont à 0 et que la valeur actuelle est inférieure à 15, on empêche l'augmentation
        if (ptsRestants <= 0 && current < 15) {
            max = current;  // La valeur maximale ne peut pas être plus grande que la valeur actuelle
        }
    
        // On met à jour directement les limites du modèle existant sans recréer tout le modèle
        SpinnerNumberModel model = (SpinnerNumberModel) spinner.getModel();
    
        // Utiliser getMaximum() correctement
        Integer currentMax = (Integer) model.getMaximum();  // Récupérer la valeur maximale actuelle
    
        // On compare la valeur maximale existante avec la nouvelle valeur calculée
        if (!currentMax.equals(max)) {
            model.setMaximum(max);  // On met à jour la valeur maximale du modèle
        }
    }
    
    

    private void updatePtsRestants() {
        int total = getPointCost((int) strSpinner.getValue())
                  + getPointCost((int) conSpinner.getValue())
                  + getPointCost((int) dexSpinner.getValue())
                  + getPointCost((int) inteSpinner.getValue())
                  + getPointCost((int) wisSpinner.getValue())
                  + getPointCost((int) chaSpinner.getValue());
    
        int restants = 27 - total;
        this.ptsRestants = restants;
        this.numLabel.setText(String.valueOf(restants));
    
        // Met à jour dynamiquement les bornes supérieures des spinners
        updateSpinnerLimits(strSpinner);
        updateSpinnerLimits(conSpinner);
        updateSpinnerLimits(dexSpinner);
        updateSpinnerLimits(inteSpinner);
        updateSpinnerLimits(wisSpinner);
        updateSpinnerLimits(chaSpinner);
    }

    private void initComponents() {

        JPanel empty = new JPanel(); // Panel vide sans contenu
        JPanel topPanel = new JPanel(new GridLayout(4, 2));
        JPanel bottomPanel = new JPanel(new GridLayout(4, 4, 2, 2));
        JPanel annexesPanel = new JPanel(new GridLayout(1,2, 2, 2));
        this.blankLabel = new JLabel("");

        // Ici on ajoute le nom du personnage
        // TIPS : JLabel - JTextField
        
        this.nomLabel = new JLabel("Nom");
        this.nomTextField = new JTextField(20);
        this.str = new JLabel("Str");
        this.con = new JLabel("Con");
        this.dex = new JLabel("Dex");
        this.inte = new JLabel("Int");
        this.wis = new JLabel("Wis");
        this.cha = new JLabel("Cha");
        this.ptsLabel = new JLabel("Points restants");
        this.numLabel = new JLabel(String.valueOf(this.ptsRestants));

        // Ici on ajoute la sélection de race, on souhaite utilisé l'énumeration Races
        // TIPS : Enum.values() permet de récupérer les valeurs
        // TIPS : JComboBox<String>
        this.raceLabel = new JLabel("Race");
        this.RaceComboBox = new JComboBox<String>();
        for (Races race : Races.values()) {
            this.RaceComboBox.addItem(race.name());
        }


        this.classeLabel = new JLabel("Classe");
        this.ClasseComboBox = new JComboBox<String>();
        for (Classes classe : Classes.values()) {
            this.ClasseComboBox.addItem(classe.name());
        }

        

        // Ici on ajoute les boutons radio H/F (attention, on ne veux pas qu'ils fassent toute la largeur)
        // TIPS : faire un JPanel qui regroupe les deux boutons, ne pas oublier ButtonGroup
        this.HRadioButton = new JRadioButton("H");
        this.FRadioButton = new JRadioButton("F");

        this.strSpinner = new JSpinner(new SpinnerNumberModel(8,8,15,1));
        this.conSpinner = new JSpinner(new SpinnerNumberModel(8,8,15,1));
        this.dexSpinner = new JSpinner(new SpinnerNumberModel(8,8,15,1));
        this.inteSpinner = new JSpinner(new SpinnerNumberModel(8,8,15,1));
        this.wisSpinner = new JSpinner(new SpinnerNumberModel(8,8,15,1));
        this.chaSpinner = new JSpinner(new SpinnerNumberModel(8,8,15,1));
    
        this.strSpinner.addChangeListener(e -> updatePtsRestants());
        this.conSpinner.addChangeListener(e -> updatePtsRestants());
        this.dexSpinner.addChangeListener(e -> updatePtsRestants());
        this.inteSpinner.addChangeListener(e -> updatePtsRestants());
        this.wisSpinner.addChangeListener(e -> updatePtsRestants());
        this.chaSpinner.addChangeListener(e -> updatePtsRestants());

        
        annexesPanel.add(this.HRadioButton);
        annexesPanel.add(this.FRadioButton);
        
        topPanel.add(this.nomLabel);
        topPanel.add(this.nomTextField);
        topPanel.add(this.raceLabel);
        topPanel.add(this.RaceComboBox);
        topPanel.add(this.classeLabel);
        topPanel.add(this.ClasseComboBox);
        topPanel.add(empty);
        topPanel.add(annexesPanel);

        bottomPanel.add(this.str);
        bottomPanel.add(this.strSpinner);
        bottomPanel.add(this.inte);
        bottomPanel.add(this.inteSpinner);
        bottomPanel.add(this.con);
        bottomPanel.add(this.conSpinner);
        bottomPanel.add(this.wis);
        bottomPanel.add(this.wisSpinner);
        bottomPanel.add(this.dex);
        bottomPanel.add(this.dexSpinner);
        bottomPanel.add(this.cha);
        bottomPanel.add(this.chaSpinner);
        bottomPanel.add(this.ptsLabel);
        bottomPanel.add(this.numLabel);

        this.setLayout(new GridLayout(2, 2, 10, 10));
        this.add(topPanel);
        this.add(bottomPanel);
        
    }
}
