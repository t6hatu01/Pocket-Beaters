package fighting.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;

import fighting.game.FightingGame;
import fighting.game.Scenes.Hud;
import fighting.game.Sprites.Avatar;

public class PlayScreen implements Screen {
    private FightingGame game;
    private Hud hud;
    private OrthographicCamera gamecam;
    private FitViewport gamePort;

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    private World world;
    private Box2DDebugRenderer b2dr;

    private Avatar avatar;

    public PlayScreen(FightingGame game){
        this.game = game;
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(FightingGame.V_WIDTH,FightingGame.V_HEIGHT,gamecam);
        hud = new Hud(game.batch);

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("peliareena.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        //gamecam.position.set(gamePort.getScreenWidth() / 2, gamePort.getScreenHeight() / 2, 0);
        gamecam.position.set( 1920 / 2, 1080 / 2, 0);

        world = new World(new Vector2(0,-10),true);
        b2dr = new Box2DDebugRenderer();

        avatar = new Avatar(world,"hpone.png", FightingGame.V_WIDTH / 2 ,
                FightingGame.V_HEIGHT );

        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        for (MapObject object : map.getLayers().get(1).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set(rect.getX(), rect.getY());

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth(), rect.getHeight());
            fdef.shape = shape;
            body.createFixture(fdef);
        }


    }

    @Override
    public void show() {

    }

    public void handleInput(float dt){

    }

    public void update(float dt){
        handleInput(dt);
        renderer.setView(gamecam);
        gamecam.update();
        world.step(1/60f,6,2);
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        b2dr.render(world, gamecam.combined);

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();

        avatar.setPosition(avatar.getX(),avatar.getY() - 1);

        game.batch.begin();
        game.batch.draw(avatar, (FightingGame.V_WIDTH / 2) - avatar.getWidth() / 2,
                (FightingGame.V_HEIGHT / 2) - avatar.getHeight() / 2);
        game.batch.end();

        world.step(Gdx.graphics.getDeltaTime(),6,2);
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width,height);
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
    }
}
