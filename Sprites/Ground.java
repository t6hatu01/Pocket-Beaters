package fighting.game.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import fighting.game.FightingGame;

public class Ground extends Sprite {

    private World world;
    private Body body3;

    public Ground(World world){
        super(new Texture("peliareenas.png"));
        this.world = world;
        setPosition(FightingGame.V_WIDTH / 2f, FightingGame.V_HEIGHT / 2f - 900);
        createBody();
    }

    void createBody(){
        BodyDef bdef = new BodyDef();

        bdef.type = BodyDef.BodyType.StaticBody;

        bdef.position.set (getX() / FightingGame.PPM, getY() / FightingGame.PPM);


        body3 = world.createBody(bdef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(getWidth() / 2 / FightingGame.PPM, getHeight() / 2 / FightingGame.PPM);

        FixtureDef fiDef = new FixtureDef();
        fiDef.shape = shape;
        fiDef.density = 1f;

        Fixture fixture = body3.createFixture(fiDef);

        shape.dispose();
    }
}
