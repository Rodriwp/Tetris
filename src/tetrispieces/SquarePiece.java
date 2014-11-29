package tetrispieces;

public class SquarePiece extends TetrisPiece {
  //Skins
	private final boolean [][] THISSKIN0= {{true,true,false},
                                           {true,true,false},
                                           {false,false,false},};
  //Dimension of the differents Skins		
	private final int SKIN0DIMX = 2;
	private final int SKIN0DIMY = 2;
    private final int MAXSKIN = 0;
	
   public SquarePiece(){
                  type =7;
		  positionx = 0;
		  positiony = 0;
		  //Set variables in TetrisPiece to the values of this type of Piece
		  skin0 = THISSKIN0;
		  skin0DimX= SKIN0DIMX;
		  skin0DimY= SKIN0DIMY;
		  maxSkin = MAXSKIN;
		  //Initializate the object
		  pieceGraph = skin0;
		  currentSkin = 0;
		  cantMoveMore = false;
		  this.updateDimension(SKIN0DIMX, SKIN0DIMY);
	   }
}