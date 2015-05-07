package pathfinder.executables.combatSimulator;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;
import pathfinder.characters.classes.CharacterClassEnum;
import pathfinder.metaObjects.EnumUtil;
import pathfinder.realWorldObject.SizeCategory;
import pathfinder.realWorldObject.creature.coreRaces.CoreRace;
import pathfinder.realWorldObject.item.equipment.armor.Armor;
import pathfinder.realWorldObject.item.equipment.armor.ArmorName;
import pathfinder.realWorldObject.item.equipment.weapon.ManufacturedWeaponName;

public class SpawnMenu extends JPanel
{
    private static final long serialVersionUID = -6110025212444318093L;

    protected enum SpawnType
    {
        Creature,
        Weapon,
        Armor,
        Shield;
    }

    private SpawnType spawnType = SpawnType.Creature; // what should be spawned
    private SizeCategory itemSize = SizeCategory.Medium;

    /*
     * Specifications to spawn a creature.
     */
    private CoreRace selectedRace = CoreRace.Dwarf;
    private CharacterClassEnum selectedClass = CharacterClassEnum.Adept;
    private int classLevel = 1;
    private boolean hasWeapon = false;
    private ManufacturedWeaponName creatureWeapon = ManufacturedWeaponName.Aklys;
    private boolean hasArmor = false;
    private ArmorName creatureArmor = ArmorName.ArmoredCoat;
    private boolean hasShield = false;
    private ArmorName creatureShield = ArmorName.Buckler;

    /*
     * Specifications to spawn a weapon.
     */
    private ManufacturedWeaponName selectedWeapon = ManufacturedWeaponName.Aklys;

    /*
     * Specifications to spawn an armor.
     */
    private ArmorName selectedArmor = ArmorName.ArmoredCoat;

    /*
     * Specifications to spawn a shield.
     */
    private ArmorName selectedShield = ArmorName.Buckler;

    /*
     * Getters
     */
    public SpawnType getSpawnType()
    {
        return spawnType;
    }

    public SizeCategory getSizeCategory()
    {
        return itemSize;
    }

    public CoreRace getSelectedRace()
    {
        return selectedRace;
    }

    public CharacterClassEnum getSelectedClass()
    {
        return selectedClass;
    }

    public int getClassLevel()
    {
        return classLevel;
    }

    public boolean creatureHasWeapon()
    {
        return hasWeapon;
    }

    public ManufacturedWeaponName getCreatureWeapon()
    {
        return creatureWeapon;
    }

    public boolean creatureHasArmor()
    {
        return hasArmor;
    }

    public ArmorName getCreatureArmor()
    {
        return creatureArmor;
    }

    public boolean creatureHasShield()
    {
        return hasShield;
    }

    public ArmorName getCreatureShield()
    {
        return creatureShield;
    }

    public ManufacturedWeaponName getSelectedWeapon()
    {
        return selectedWeapon;
    }

    public ArmorName getSelectedArmor()
    {
        return selectedArmor;
    }

    public ArmorName getSelectedShield()
    {
        return selectedShield;
    }

    /**
     * Create the panel.
     */
    @SuppressWarnings("unchecked")
    public SpawnMenu()
    {
        setLayout(new MigLayout("", "[132px,grow][-7.00px]", "[25px][164px][grow][27px][27px][27px][]"));

        final JLabel lblSpawnObjects = new JLabel("Spawn Objects");
        lblSpawnObjects.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblSpawnObjects, "flowx,cell 0 0,alignx left,aligny center");

        final JLabel lblrightClickTo = new JLabel("*right click to spawn");
        add(lblrightClickTo, "cell 0 0,alignx right,aligny center");

        final ButtonGroup group = new ButtonGroup();

        // break up all armors and shields into two lists for ease of selection
        // using array lists for quick conversion into arrays for the combo box models
        final ArrayList<ArmorName> armorlist = new ArrayList<ArmorName>();
        final ArrayList<ArmorName> shieldlist = new ArrayList<ArmorName>();
        for (final ArmorName armor : ArmorName.values())
        {
            if (Armor.isArmor(armor.getArmorProficiency()))
            {
                armorlist.add(armor);
            }
            else if (Armor.isShield(armor.getArmorProficiency()))
            {
                shieldlist.add(armor);
            }
        }
        final CoreRace[] raceArray = (CoreRace[]) EnumUtil.sortAlphabetically(CoreRace.values());
        final CharacterClassEnum[] classArray = (CharacterClassEnum[]) EnumUtil.sortAlphabetically(CharacterClassEnum.values());
        final ManufacturedWeaponName[] weaponArray = (ManufacturedWeaponName[]) EnumUtil.sortAlphabetically(ManufacturedWeaponName.values());
        final ArmorName[] armorArray = (ArmorName[]) EnumUtil.sortAlphabetically(armorlist.toArray(new ArmorName[armorlist.size()]));
        final ArmorName[] shieldArray = (ArmorName[]) EnumUtil.sortAlphabetically(shieldlist.toArray(new ArmorName[shieldlist.size()]));

        final JPanel creaturePanel = new JPanel();
        add(creaturePanel, "cell 0 1,grow");
        creaturePanel.setLayout(new MigLayout("", "[][][][215px,grow]", "[][30px][30px][30px][30px][]"));

        /*
         * Spawn creature section.
         */
        final JRadioButton creatureRadioButton = new JRadioButton("Creature");
        creaturePanel.add(creatureRadioButton, "cell 1 0,alignx left");
        creatureRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        creatureRadioButton.addActionListener((event) ->
        {
            final JRadioButton button = (JRadioButton) event.getSource();
            if (button.isSelected())
            {
                spawnType = SpawnType.Creature;
            }
        });
        creatureRadioButton.setSelected(true);
        group.add(creatureRadioButton);

        final JLabel lblabilityScoresWill = new JLabel("*ability scores will be random");
        creaturePanel.add(lblabilityScoresWill, "cell 3 0");

        final JLabel lblRace = new JLabel("Race");
        creaturePanel.add(lblRace, "cell 1 1,alignx right");
        lblRace.setHorizontalAlignment(SwingConstants.LEFT);

        final JComboBox<CoreRace> raceComboBox = new JComboBox<CoreRace>();
        creaturePanel.add(raceComboBox, "cell 3 1,growx");
        raceComboBox.setModel(new DefaultComboBoxModel<CoreRace>(raceArray));
        raceComboBox.setSelectedIndex(0);
        raceComboBox.setEditable(false);
        raceComboBox.addActionListener((event) ->
        {
            selectedRace = (CoreRace) ((JComboBox<CoreRace>) event.getSource()).getSelectedItem();
        });

        final JLabel lblClasses = new JLabel("Class\r\n");
        creaturePanel.add(lblClasses, "cell 1 2,alignx right");

        final JComboBox<CharacterClassEnum> classComboBox = new JComboBox<CharacterClassEnum>();
        creaturePanel.add(classComboBox, "flowx,cell 3 2,growx");
        classComboBox.setModel(new DefaultComboBoxModel<CharacterClassEnum>(classArray));
        classComboBox.setSelectedIndex(0);
        classComboBox.addActionListener((event) ->
        {
            selectedClass = (CharacterClassEnum) ((JComboBox<CharacterClassEnum>) event.getSource()).getSelectedItem();
        });

        final JLabel lblLevel = new JLabel("Level");
        creaturePanel.add(lblLevel, "cell 3 2");

        final JSpinner lvlSpinner = new JSpinner();
        creaturePanel.add(lvlSpinner, "cell 3 2");
        lvlSpinner.setModel(new SpinnerNumberModel(1, 1, 20, 1));
        lvlSpinner.addChangeListener((event) ->
        {
            classLevel = (int) ((JSpinner) event.getSource()).getValue();
        });

        final JLabel lblWeapon = new JLabel("Weapon");
        creaturePanel.add(lblWeapon, "cell 1 3,alignx right");

        final JCheckBox wpnChkBx = new JCheckBox("");
        creaturePanel.add(wpnChkBx, "cell 2 3");
        wpnChkBx.addActionListener((event) ->
        {
            hasWeapon = ((JCheckBox) event.getSource()).isSelected();
        });

        final JComboBox<ManufacturedWeaponName> creatureWeaponComboBox = new JComboBox<ManufacturedWeaponName>();
        creaturePanel.add(creatureWeaponComboBox, "cell 3 3,growx");
        creatureWeaponComboBox.setModel(new DefaultComboBoxModel<ManufacturedWeaponName>(weaponArray));
        creatureWeaponComboBox.setSelectedIndex(0);
        creatureWeaponComboBox.addActionListener((event) ->
        {
            creatureWeapon = (ManufacturedWeaponName) ((JComboBox<ManufacturedWeaponName>) event.getSource()).getSelectedItem();
        });

        final JLabel lblArmor = new JLabel("Armor");
        creaturePanel.add(lblArmor, "cell 1 4,alignx right");

        final JCheckBox amrChkBx = new JCheckBox("");
        creaturePanel.add(amrChkBx, "cell 2 4");
        amrChkBx.addActionListener((event) ->
        {
            hasArmor = ((JCheckBox) event.getSource()).isSelected();
        });

        final JComboBox<ArmorName> creatureArmorComboBox = new JComboBox<ArmorName>();
        creaturePanel.add(creatureArmorComboBox, "cell 3 4,growx");
        creatureArmorComboBox.setModel(new DefaultComboBoxModel<ArmorName>(armorArray));
        creatureArmorComboBox.setSelectedIndex(0);
        creatureArmorComboBox.addActionListener((event) ->
        {
            creatureArmor = (ArmorName) ((JComboBox<ArmorName>) event.getSource()).getSelectedItem();
        });

        final JLabel lblShield = new JLabel("Shield");
        creaturePanel.add(lblShield, "cell 1 5,alignx trailing");

        final JCheckBox shldChkBx = new JCheckBox("");
        creaturePanel.add(shldChkBx, "cell 2 5");
        shldChkBx.addActionListener((event) ->
        {
            hasShield = ((JCheckBox) event.getSource()).isSelected();
        });

        final JComboBox<ArmorName> creatureShieldComboBox = new JComboBox<ArmorName>();
        creaturePanel.add(creatureShieldComboBox, "cell 3 5,growx");
        creatureShieldComboBox.setModel(new DefaultComboBoxModel<ArmorName>(shieldArray));
        creatureShieldComboBox.setSelectedIndex(0);
        creatureShieldComboBox.addActionListener((event) ->
        {
            creatureShield = (ArmorName) ((JComboBox<ArmorName>) event.getSource()).getSelectedItem();
        });

        /*
         * Spawn weapon section.
         */

        final JSeparator separator = new JSeparator();
        separator.setBackground(Color.BLACK);
        add(separator, "cell 0 2,grow");
        final JRadioButton weaponRadioButton = new JRadioButton("Weapon");
        add(weaponRadioButton, "flowx,cell 0 3,alignx left,aligny center");
        weaponRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        weaponRadioButton.addActionListener((event) ->
        {
            final JRadioButton button = (JRadioButton) event.getSource();
            if (button.isSelected())
            {
                spawnType = SpawnType.Weapon;
            }
        });
        group.add(weaponRadioButton);

        final JComboBox<ManufacturedWeaponName> weaponComboBox = new JComboBox<ManufacturedWeaponName>();
        add(weaponComboBox, "cell 0 3,growx,aligny center");
        weaponComboBox.setModel(new DefaultComboBoxModel<ManufacturedWeaponName>(weaponArray));
        weaponComboBox.setSelectedIndex(0);
        weaponComboBox.addActionListener((event) ->
        {
            selectedWeapon = (ManufacturedWeaponName) ((JComboBox<ManufacturedWeaponName>) event.getSource()).getSelectedItem();
        });

        /*
         * Spawn armor section.
         */
        final JRadioButton armorRadioButton = new JRadioButton("Armor");
        add(armorRadioButton, "flowx,cell 0 4,alignx left,aligny center");
        armorRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        armorRadioButton.addActionListener((event) ->
        {
            final JRadioButton button = (JRadioButton) event.getSource();
            if (button.isSelected())
            {
                spawnType = SpawnType.Armor;
            }
        });
        group.add(armorRadioButton);

        final JComboBox<ArmorName> armorComboBox = new JComboBox<ArmorName>();
        add(armorComboBox, "cell 0 4,growx,aligny center");
        armorComboBox.setModel(new DefaultComboBoxModel<ArmorName>(armorArray));
        armorComboBox.setSelectedIndex(0);
        armorComboBox.addActionListener((event) ->
        {
            selectedArmor = (ArmorName) ((JComboBox<ArmorName>) event.getSource()).getSelectedItem();
        });

        /*
         * Spawn shield section
         */

        final JRadioButton shieldRadioButton = new JRadioButton("Shield");
        shieldRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(shieldRadioButton, "flowx,cell 0 5,alignx left,aligny center");
        shieldRadioButton.addActionListener((event) ->
        {
            final JRadioButton button = (JRadioButton) event.getSource();
            if (button.isSelected())
            {
                spawnType = SpawnType.Shield;
            }
        });
        group.add(shieldRadioButton);

        final JComboBox<ArmorName> shieldComboBox = new JComboBox<ArmorName>();
        add(shieldComboBox, "cell 0 5,growx,aligny center");
        shieldComboBox.setModel(new DefaultComboBoxModel<ArmorName>(shieldArray));
        shieldComboBox.setSelectedIndex(0);
        shieldComboBox.addActionListener((event) ->
        {
            selectedShield = (ArmorName) ((JComboBox<ArmorName>) event.getSource()).getSelectedItem();
        });

        final ButtonGroup sizeGroup = new ButtonGroup();
        final JRadioButton rdbtnTiny = new JRadioButton("Tiny");
        add(rdbtnTiny, "flowx,cell 0 6");
        sizeGroup.add(rdbtnTiny);
        rdbtnTiny.addActionListener((event) ->
        {
            final JRadioButton button = (JRadioButton) event.getSource();
            if (button.isSelected())
            {
                itemSize = SizeCategory.Tiny;
            }
        });

        final JRadioButton rdbtnSmall = new JRadioButton("Small");
        add(rdbtnSmall, "cell 0 6");
        sizeGroup.add(rdbtnSmall);
        rdbtnSmall.addActionListener((event) ->
        {
            final JRadioButton button = (JRadioButton) event.getSource();
            if (button.isSelected())
            {
                itemSize = SizeCategory.Small;
            }
        });

        final JRadioButton rdbtnMedium = new JRadioButton("Medium");
        rdbtnMedium.setSelected(true);
        add(rdbtnMedium, "cell 0 6");
        sizeGroup.add(rdbtnMedium);
        rdbtnMedium.addActionListener((event) ->
        {
            final JRadioButton button = (JRadioButton) event.getSource();
            if (button.isSelected())
            {
                itemSize = SizeCategory.Medium;
            }
        });

        final JRadioButton rdbtnLarge = new JRadioButton("Large");
        add(rdbtnLarge, "cell 0 6");
        sizeGroup.add(rdbtnLarge);
        rdbtnLarge.addActionListener((event) ->
        {
            final JRadioButton button = (JRadioButton) event.getSource();
            if (button.isSelected())
            {
                itemSize = SizeCategory.Large;
            }
        });
    }
}