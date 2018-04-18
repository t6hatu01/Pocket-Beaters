package fighting.game.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


import fighting.game.FightingGame;

public class Hud {
    public Stage stage;
    private Viewport viewport;

    private Integer worldTimer;
    private float timeCount;
    private Integer health;

    Label countdownLabel;
    Label healthLabel;
    Label timeLabel;
    Label levelLabel;
    Label worldLabel;
    Label playerLabel;

    public Hud(SpriteBatch sb){
        worldTimer = 300;
        timeCount = 0;
        health = 0;

        viewport = new FitViewport(FightingGame.V_WIDTH,FightingGame.V_HEIGHT,new OrthographicCamera());
        stage = new Stage(viewport, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        countdownLabel = new Label(String.format("%03d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        healthLabel = new Label(String.format("%06d",health), new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        timeLabel = new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        levelLabel = new Label("AREENA",new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        worldLabel = new Label("WORLD", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        playerLabel = new Label("PLAYER", new Label.LabelStyle(new BitmapFont(), Color.BLACK));

        table.add(playerLabel).expandX().padTop(10);
        table.add(worldLabel).expandX().padTop(10);
        table.add(timeLabel).expandX().padTop(10);
        table.row();
        table.add(healthLabel).expandX();
        table.add(levelLabel).expandX();
        table.add(countdownLabel).expandX();

        stage.addActor(table);

    }

}
