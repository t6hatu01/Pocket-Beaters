package fighting.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import fighting.game.FightingGame;
import fighting.game.Scenes.Hud;
import fighting.game.Sprites.Avatar;
import fighting.game.Sprites.Enemy;
import fighting.game.Sprites.Ground;

public class PlayScreen implements Screen {
    private FightingGame game;
    private Hud hud;
    private OrthographicCamera gamecam;

    private Box2DDebugRenderer b2dr;

    private Texture bg;

    private Avatar avatar;

    private Enemy enemy;

    private World world;


    public PlayScreen(FightingGame game){
        this.game = game;
        gamecam = new OrthographicCamera();
        gamecam.setToOrtho(false, FightingGame.V_WIDTH / FightingGame.PPM,
                FightingGame.V_HEIGHT / FightingGame.PPM);
        gamecam.position.set(FightingGame.V_WIDTH / 2f, FightingGame.V_HEIGHT / 2f,0);

        b2dr = new Box2DDebugRenderer();

        world = new World(new Vector2(0,-9.8f),true);

        bg = new Texture("peliareenas.png");

        avatar = new Avatar(world,"hpone.png", FightingGame.V_WIDTH / 2 ,
                FightingGame.V_HEIGHT );

        enemy = new Enemy(world, "gidle.png", FightingGame.V_WIDTH / 2,
                FightingGame.V_HEIGHT);

        Ground g = new Ground(world);

    }

    @Override
    public void show() {

    }


    public void update(float dt){

        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            avatar.getBody2().applyLinearImpulse(new Vector2(-1f,0),
                    avatar.getBody2().getWorldCenter(),true);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            avatar.getBody2().applyLinearImpulse(new Vector2(1f,0),
                    avatar.getBody2().getWorldCenter(),true);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            avatar.getBody2().applyLinearImpulse(new Vector2(0,5f),
                    avatar.getBody2().getWorldCenter(),true);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            enemy.getBody4().applyLinearImpulse(new Vector2(-1f,0),
                    enemy.getBody4().getWorldCenter(),true);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            enemy.getBody4().applyLinearImpulse(new Vector2(1f,0),
                    enemy.getBody4().getWorldCenter(),true);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            enemy.getBody4().applyLinearImpulse(new Vector2(0,5f),
                    enemy.getBody4().getWorldCenter(),true);
        }

       /* world.step(1/10f,6,2);

        gamecam.update();*/

    }

    @Override
    public void render(float delta) {

        update(delta);

        avatar.updateAvatar();
        enemy.updateEnemy();

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();
        game.getBatch().draw(bg,0,0);
        game.getBatch().draw(avatar, avatar.getX(), avatar.getY() - avatar.getHeight() / 2f);
        game.getBatch().draw(enemy, enemy.getX(), enemy.getY() - enemy.getHeight() / 2f);
        game.getBatch().end();

        b2dr.render(world,gamecam.combined);

        world.step(Gdx.graphics.getDeltaTime(),6,2);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        avatar.getTexture().dispose();
        enemy.getTexture().dispose();
    }
}




