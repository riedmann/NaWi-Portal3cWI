package at.htldornbirn.cwi.nawi.gamestates.parabola;

import at.htldornbirn.cwi.nawi.gamestates.Constants;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Parabola extends BasicGameState {

    private float platform_x, platform_y, newX, newY, gravitation, startVelocity, startAngle, height, time;
    private float test;








    @Override
    public int getID() {
        return Constants.PARABOLA;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.platform_x = 162f;
        this.platform_y = 620f;
        this.newX = 165f;
        this.newY = this.platform_y - 25;
        this.gravitation = 9.81f;
        this.startVelocity = 20f;
        this.startAngle = 0f;
        this.height = 100f;
        this.time = 0f;

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


        if(this.newY <= 615) {
            formula(this.time);
            this.newY = -this.newY;
        }
        else
            //System.out.println("finished " + this.time);

        System.out.println(this.time);
        //System.out.println(this.newY);
        this.time += (float)i/1000;

    }

    public void formula(float posX) {
        this.newY = (float) ((-1)*(640-this.height) + (-0.5)*this.gravitation*posX*posX + this.startVelocity*Math.sin(Math.toRadians(this.startAngle)*posX + this.height));
        this.newX = (float) (this.startVelocity*Math.cos(Math.toRadians(this.startAngle))*this.time);

    }
}
