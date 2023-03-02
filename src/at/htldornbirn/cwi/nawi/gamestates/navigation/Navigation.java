package at.htldornbirn.cwi.nawi.gamestates.navigation;

import at.htldornbirn.cwi.nawi.gamestates.Constants;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Navigation extends BasicGameState {
    @Override
    public int getID() {
        return Constants.NAVIGATION;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawOval(10,10,10,10);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if (gameContainer.getInput().isKeyPressed(Input.KEY_SPACE)){
            stateBasedGame.enterState(Constants.PARABOLA );
        }
    }

    @Override
    public void keyPressed(int key, char c) {

    }
}
