package tegakari;

import java.io.Serializable;

/**
 * HistoryLog is the history box displayed the last 5 action of the game. All
 * player will have the same history box during the game The history log will be
 * update instantly after each action of the game
 *
 * @author Anh Nguyen
 *
 * @version 11/4/2015 - Write java doc
 * @version 11/11/2015 - Implement code
 */
public class HistoryLog implements Serializable 
{
    /**
     * this will contain the history of the last 5 action of the game.
     */
    private final int kLogSize = 5;
    private String[] eventLog = new String[kLogSize];

    /**
     * Building the log a the game goes on.
     *
     * @param text is a line of the most recent action of the game, which will
     * be concatenated to the end of the history log
     */
    public void addToLog(String text) 
    {
        //FOR each string in the log, except last one
        for (int iLoop = kLogSize-1; iLoop > 0 ; iLoop--) 
        {
            //BUMP it to the next space in the log
            eventLog[iLoop] = eventLog[iLoop-1];
        //ENDFOR
        }
        //ADD text to the first space in the log
        eventLog[0] = text;
    }

    /**
     * Access to the log
     *
     * @return the whole log as a string
     */
    @Override
    public String toString() 
    {
        //INIT a string to return
        String toReturn = "";
        //FOR each string in the log
        for (String line : eventLog) 
        {
            //ADD the string to the return string
            if (line != null)
            {
                toReturn = toReturn + line + "\n";
            }
        //ENDFOR
        }
        //RETURN the string
        return toReturn;
    }

    /**
     * Clear all data in the the log
     */
    public void clearLog() 
    {
        //REINIT the log
        eventLog = new String[kLogSize];
    }

    /**
     * Checking method to check if the log is empty
     *
     * @return a boolean indicate if the log is empty or not
     */
    public boolean isEmptyLog() 
    {
        //FOR each space in the log
        for (String line : eventLog) 
        {
            //IF that space is not null
            if (line != null)
            {
                //RETURN false
                return false;
            }
            //ENDIF
        //ENDFOR
        }
        //RETURN true
        return true;
    }
}
