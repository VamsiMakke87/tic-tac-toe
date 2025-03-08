package Model;

public class PlayingPieceFactory {

    public static PlayingPiece getPlayingPiece(String playingPiece, String playerName){

        switch (playingPiece){
            case "X": return new PlayingPieceX(playerName);
            case "O": return new PlayingPieceO(playerName);
            default: return null;
        }

    }

}
