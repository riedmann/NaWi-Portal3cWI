package at.htldornbirn.cwi.nawi;

import at.htldornbirn.cwi.nawi.gamestates.Constants;
import at.htldornbirn.cwi.nawi.gamestates.navigation.Navigation;
import at.htldornbirn.cwi.nawi.gamestates.parabola.Parabola;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class NaWIPortalMainGame extends StateBasedGame {

    public NaWIPortalMainGame(String name) {
        super(name);
    }

        public static void main(String[] args) throws SlickException {
            AppGameContainer container = new AppGameContainer(new NaWIPortalMainGame("NaWI Portal 3cwi"));
            container.setDisplayMode(1920,1080,false);
            container.setTargetFrameRate(59);
            container.start();


    }
    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new Navigation());

        addState(new Parabola());


    }
}
