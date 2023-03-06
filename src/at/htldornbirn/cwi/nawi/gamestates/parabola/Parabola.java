package at.htldornbirn.cwi.nawi.gamestates.parabola;

import at.htldornbirn.cwi.nawi.gamestates.Constants;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Parabola extends BasicGameState {

    private float platform_x, platform_y, newX, newY, gravitation, startVelocity, startAngle, height;
    private float test;






    @Override
    public int getID() {
        return Constants.PARABOLA;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.platform_x = 162f;
        this.platform_y = 500f;
        this.newX = 162f;
        this.newY = 500f;
        this.gravitation = 9.81f;
        this.startVelocity = 1f;
        this.startAngle = 30f;
        this.height = 620-this.platform_y;
        this.test = 0;
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        //Canvas
        graphics.drawRect(50,50,1180,620);
        //Platform
        graphics.fillRect(50, this.platform_y, 125, 670-this.platform_y);
        //Ball
        graphics.fillOval(162,this.platform_y-25,25,25);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        this.test++;
        formula(this.test);
        if(this.newY >= 0) {
            System.out.println(this.newY);
        }
    }

    public void formula(float posX) {
        this.newY = (float) ((-1/2 * this.gravitation / Math.sqrt(this.startVelocity*Math.cos(this.startAngle)) * posX) + Math.tan(this.startAngle)*posX + this.height);
    }
}
