package Model;

public abstract class PlayingPiece {

    public String name;

    public PieceType pieceType;

    public PlayingPiece(String name, PieceType pieceType){
        this.name=name;
        this.pieceType=pieceType;
    }

}
