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
        this.platform_y = 420f;
        this.newX = 162f;
        this.newY = 500f;
        this.gravitation = 9.81f;
        this.startVelocity = 300f;
        this.startAngle = 35;
        this.height = 620-this.platform_y;
        this.test = 0;
        System.out.println(Math.toRadians(180));
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        //Canvas
        graphics.drawRect(50,50,1180,620);
        //Platform
        graphics.fillRect(50, this.platform_y, 125, 670-this.platform_y);
        //Ball
        graphics.fillOval(this.newX,this.newY,25,25);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        formula(this.test);
        if(this.newY >= 0) {
            System.out.println("y(x) = " + this.newY + " x = " + this.test);
        }
        this.test += 0.1;
        this.newY = 620 - this.newY;
        this.newX = 162 + this.test;
    }

    public void formula(float posX) {
        //Funktioniert doch nicht
        System.out.println("With x = " + posX + " " + (-1/2 * this.gravitation / Math.pow(this.startVelocity*Math.cos(Math.toRadians(this.startAngle)), 2) * Math.pow(posX,2)));

        this.newY = (float) ((-1/2 * this.gravitation / Math.sqrt(this.startVelocity*Math.cos(Math.toRadians(this.startAngle))) * posX) + Math.tan(Math.toRadians(this.startAngle))*posX + this.height);
    }
}
