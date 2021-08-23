package dev.spaccabolle.entity;

import java.awt.Graphics;
import dev.spaccabolle.gfx.Assets;
import dev.spaccabolle.input.KeyManager;
import dev.spaccabolle.stati.StatoGioco;

public class Cannon extends DynamicObject{
    
    private static final int SCARTO_X_BOLLA=30;
    private static final int SCARTO_Y_BOLLA=15;
    private static final float EASY = (float)3.5;
    private static final float NORMAL = (float)6.5;
    private static final float HARD = (float)11;
    
    private boolean ballPos,bounce;
    
    private Ball ball;
    private static CollectBall collectBall;
    public static Ball[][] mapColor = CollectBall.getMapCollect();
    
    private int angle=0;
    public int difficult = 1,index;
    
    @SuppressWarnings("static-access")
	public Cannon(float x, float y, int width, int height, CollectBall collectBall) {
        super(x, y, width, height);
        this.collectBall=collectBall;
        this.setSpeed(50);
        this.ballPos=true;
        this.bounce=true;
        ball=new Ball(this.x+width/2-SCARTO_X_BOLLA,this.y+SCARTO_Y_BOLLA-250,Ball.BOBBLE_SIZE,Ball.BOBBLE_SIZE,getColor(),index);
        while(ball.color==0) {
        
        	ball=new Ball(this.x+width/2-SCARTO_X_BOLLA,this.y+SCARTO_Y_BOLLA-250,Ball.BOBBLE_SIZE,Ball.BOBBLE_SIZE,getColor(),index);
        	
        }
        collectBall.addBall(ball);
    }
    
  

    public static CollectBall getCollectBall() {
        return collectBall;
    }

    private int getColor() {
    	  return CollectBall.randomColorCannon;
    }
       
    private void newBall() {
        if(!ball.isMove && !ballPos ) {
            ball=new Ball(this.x+width/2-SCARTO_X_BOLLA,this.y+SCARTO_Y_BOLLA-250,Ball.BOBBLE_SIZE,Ball.BOBBLE_SIZE,getColor(),index);
            while(ball.color==0) {
                
            	ball=new Ball(this.x+width/2-SCARTO_X_BOLLA,this.y+SCARTO_Y_BOLLA-250,Ball.BOBBLE_SIZE,Ball.BOBBLE_SIZE,getColor(),index);
            	
            }
            collectBall.addBall(ball);
            ballPos=true;
        }
     }
    
    private void shot() {
        if(ballPos && KeyManager.space && !StatoGioco.pause && !CollectBall.gameOver && !CollectBall.victory) {
            boolean iter = true;
            int i=0;
            while(iter) {
            	if(ball.x >= Map.posX[i] && ball.x < Map.posX[i+1]) {
            		ball.x = Map.posX[i];
            		iter=false;
            	}
            	i++;
            }
            
            ball.directMove=(float) Math.toDegrees(Math.toRadians(angle-90));
            ball.direct();
            ball.isMove=true;
            ballPos=false;
            
            }
    }
    
    public void checkBounce() {
    	if(this.x>Ball.RIGHT_BOUNCE) {
    		
    		this.bounce=false;
    	}else if(this.x< (-Ball.LEFT_BOUNCE+190)) {
    		this.bounce=true;
    	}
    }
    
    private void ballSetX() {
    	if(!ball.isMove) {
			ball.setX(this.x+(float)92);	    		
		}
    }
    
    private void speedCannon(float x) {
    	if(this.bounce) {
    		this.setX(this.x+(float)x);
    		ballSetX();
    	}else {
    		this.setX(this.x-(float)x);
    		ballSetX();
    	}
    }
    
    private void difficults() {
    	if(!StatoGioco.pause && !CollectBall.gameOver && !CollectBall.victory) {
	    	switch(difficult) {
	    	
	    	case 1: 
	    		speedCannon(EASY);
		    	break;
		    	
	    	case 2:
	    		speedCannon(NORMAL);
		    	break;
		    	
	    	case 3: 
	    		speedCannon(HARD);
		    	break;
		    	
	    	default:
	            break;
	    	}
    	}
    }
    
    public void cannonMove() {
    	checkBounce();
    	difficults();
    }
    
    public void tick() {
    	cannonMove();
        shot();
        newBall();
    }

    public void render(Graphics g) {
        g.drawImage(Assets.cannon,(int)this.getX()-50,(int)this.getY()-280, this.getWidth(), this.getHeight(), null);
    }

}
