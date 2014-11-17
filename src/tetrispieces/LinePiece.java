package tetrispieces;

public class LinePiece extends TetrisPiece {
 //Skins
	private final boolean [][] THISSKIN0= {{true,false,false},
                                           {true,false,false},
                                           {true,false,false},};
	private final boolean [][] THISSKIN1= {{true,true,true},
                                           {false,false,false},
                                           {false,false,false},};
 //Dimension of the differents Skins
	private final int SKIN0DIMX = 1;
	private final int SKIN0DIMY = 3;
	private final int SKIN1DIMX = 3;
	private final int SKIN1DIMY = 1;
    private final int MAXSKIN = 1;
	
   public LinePiece(){
	  positionx = 0;
	  positiony = 0;
	  //Set variables in TetrisPiece to the values of this type of Piece
	  skin0 = THISSKIN0;
	  skin0DimX= SKIN0DIMX;
	  skin0DimY= SKIN0DIMY;
	  skin1 = THISSKIN1;
	  skin1DimX= SKIN1DIMX;
	  skin1DimY= SKIN1DIMY;
	  maxSkin = MAXSKIN;
	  //Initializate the object
	  pieceGraph = skin1;
	  currentSkin = 1;
	  cantMoveMore = false;
	  this.updateDimension(SKIN1DIMX, SKIN1DIMY);
   }
}
