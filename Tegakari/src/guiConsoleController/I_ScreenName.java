/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiConsoleController;

/**
 * The interface for ScreenName
 * @author jchoi30
 */
public interface I_ScreenName 
{
    /**
     * Sets the title of the screen to the given string
     * @param s what to set the title to
     */
    public void setParentTitle(String s);
    /**
     * sets error text
     * @param s what to set the error text to
     */
    public void setErrorText(String s);
    /**
     * gets the username
     * @return the username
     */
    public String getUsername();
}
