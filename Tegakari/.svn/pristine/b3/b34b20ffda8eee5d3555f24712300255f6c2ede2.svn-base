package tegakari;

import java.io.Serializable;

/**
 * The ThemeType represents the kind of game theme to be used. This includes
 * graphics and text descriptions.
 *
 * @author Lohit
 */
public enum ThemeType implements Serializable 
{

    /**
     * The theme of Greek cards.
     */
    GREEK("/InputFiles/GREEK.txt"),
    /**
     * The theme of Pirate cards.
     */
    PIRATE("/InputFiles/PIRATE.txt"),
    /**
     * The theme of White House cards.
     */
    WHITEHOUSE("/InputFiles/WHITEHOUSE.txt"),
    /**
     * A test theme for this unit test.
     */
    WESTERN("/InputFiles/WESTERN.txt"),
    /**
     * The theme to test if this class works.
     */
    FAKE("/InputFiles/FAIL.txt");

    /**
     * the relative file path to the folder containing the theme.
     */
    private String path;

    /**
     * Constructor for the class.
     *
     * @param filepath the relative file path where the necessary files are
     * located
     */
    private ThemeType(String filepath) 
    {
        // CREATE ThemeType with the given filepath
        this.path = filepath;
    }

    /**
     * Retrieves the relative file path.
     *
     * @return the <code>String</code> for the file path
     */
    public String getFilePath() 
    {
        // RETURN the filepath of this ThemeType
        return this.path;
    }
}
