package tetrispieces;


public class RightSPiece extends TetrisPiece {
  //Skins
	private final boolean [][] THISSKIN0= {{false,true,true},
                                           {true,true,false},
                                           {false,false,false},};
	private final boolean [][] THISSKIN1= {{true,false,false},
                                           {true,true,false},
                                           {false,true,false},};
  //Dimension of the differents Skins	
	private final int SKIN0DIMX = 3;
	private final int SKIN0DIMY = 2;
	private final int SKIN1DIMX = 2;
	private final int SKIN1DIMY = 3;
    private final int MAXSKIN = 1;
	
   public RightSPiece(){
                  type =5;
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
		  pieceGraph = skin0;
		  currentSkin = 0;
		  cantMoveMore = false;
		  this.updateDimension(SKIN0DIMX, SKIN0DIMY);
	   }
}

