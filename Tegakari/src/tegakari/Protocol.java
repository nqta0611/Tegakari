package tegakari;

import java.io.Serializable;

/**
 * The Protocol class represents the communication system the
 * <code>GameServer</code> and
 * <code>GameClient</code> would recognize and will act appropriately according
 * to the received Protocol.
 *
 * @author Jonathan Molina
 * @author Anh Nguyen
 * 
 * @version 12/5/2015 Version 1.0
 */
public enum Protocol implements Serializable
{
    /**
     * Indicate when when is ready to be started.
     */
    GAME_READY, 
    /**
     * Start the game.
     */
    GAME_START,
    /**
     * Indicate game is over, someone won the game.
     */
    GAME_OVER,
    /**
     * Signal server the file name for the ordered clue deck will be sent next.
     */
    ORDERED_CLUE_DECK,
    /**
     * Signal server the file name for the ordered action deck will be sent next.
     */
    ORDERED_ACTION_DECK,
    /**
     * Indicate player made wrong accusation, lose the game.
     */
    PLAYER_OUT, 
    /**
     * Indicate one's turn is end.
     */
    END_TURN, 
    /**
     * Indicate one's turn is begin.
     */
    BEGIN_TURN,
    /**
     * Indicate the start of doing suggestion period.
     */
    SUGGESTION_START, 
    /**
     * Indicate when the suggestion is valid.
     */
    SUGGESTION_VALID,
    /**
     * Indicate when the suggestion is invalid.
     */
    SUGGESTION_INVALID, 
    /**
     * Indicate when the suggestion period ends.
     */
    SUGGESTION_END,
    /**
     * Flag the server this game is in testing mode.
     */
    TESTING_MODE,
    /**
     * Indicate when a player has disconnected from the lobby.
     */
    PLAYER_DISCONNECTED_FROM_LOBBY,
    /**
     * Indicate to server to send list of players.
     */
    SEND_PLAYERS;
}
