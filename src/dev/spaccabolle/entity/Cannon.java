package dev.spaccabolle.entity;

import java.awt.Graphics;
import java.util.Random;
import dev.spaccabolle.gfx.Assets;
import dev.spaccabolle.input.KeyManager;
import dev.spaccabolle.stati.StatoGioco;

public class Cannon extends DynamicObject{
    
    private static final int SCARTO_X_BOLLA=30;
    private static final int SCARTO_Y_BOLLA=15;

    
    private boolean ballPos,bounce;
    private Random rand = new Random();
    
    private Ball ball;
    private static CollectBall collectBall;
    
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
        return rand.nextInt(4);
    }
    
    private void getInput() {
        if(KeyManager.right && this.angle<60)
            angle += (int) speed;
        if(KeyManager.left && this.angle>-60)
            angle += (int)-speed;
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
        if(ballPos && KeyManager.enter && StatoGioco.pause == false) {
            System.out.println("COOORD SHOT: " + ball.y);
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
    		System.out.println(Ball.RIGHT_BOUNCE);
    		this.bounce=false;
    	}else if(this.x< (-Ball.LEFT_BOUNCE+190)) {
    		this.bounce=true;
    	}
    }
    
    public void difficults() {
    	if(StatoGioco.pause == false) {
	    	switch(difficult) {
	    	
	    	case 1: 
		    	if(this.bounce) {
		    		this.setX(this.x+(float)3.5);
		    		if(!ball.isMove) {
		    			ball.setX(this.x+(float)92);	    		
		    		}
		    	}else {
		    		this.setX(this.x-(float)3.5);
		    		if(!ball.isMove) {
		    			ball.setX(this.x+(float)92);
		    		}
		    	}
		    	break;
	    	case 2: 
		    	if(this.bounce) {
		    		this.setX(this.x+(float)4.5);
		    		if(!ball.isMove) {
		    			ball.setX(this.x+(float)92);	    		
		    		}
		    	}else {
		    		this.setX(this.x-(float)4.5);
		    		if(!ball.isMove) {
		    			ball.setX(this.x+(float)92);
		    		}
		    	}
		    	break;
	    	case 3: 
		    	if(this.bounce) {
		    		this.setX(this.x+(float)5.5);
		    		if(!ball.isMove) {
		    			ball.setX(this.x+(float)92);	    		
		    		}
		    	}else {
		    		this.setX(this.x-(float)5.5);
		    		if(!ball.isMove) {
		    			ball.setX(this.x+(float)92);
		    		}
		    	}
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
        getInput();
        shot();
        newBall();
    }

    public void render(Graphics g) {
        g.drawImage(Assets.cannon,(int)this.getX()-50,(int)this.getY()-280, this.getWidth(), this.getHeight(), null);
        
    }

}
