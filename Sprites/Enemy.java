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

public class Enemy extends Sprite {
    public World world;
    private Body body4;

    public Enemy(World world, String name, float x, float y){
        super(new Texture(name));
        this.world = world;
        setPosition(x - getWidth() / 2, y - getHeight() / 2);
        createEnemy();
    }

    public void createEnemy(){
        BodyDef bdef = new BodyDef();

        bdef.type = BodyDef.BodyType.DynamicBody;

        bdef.position.set (1650 / FightingGame.PPM, getY() / FightingGame.PPM);

        body4 = world.createBody(bdef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(getWidth() / 2 / FightingGame.PPM, getHeight() / 2 / FightingGame.PPM);

        FixtureDef fiDef = new FixtureDef();
        fiDef.shape = shape;
        fiDef.density = 1f;

        Fixture fixture = body4.createFixture(fiDef);

        shape.dispose();

    }

    public  void updateEnemy() {
        this.setPosition(body4.getPosition().x * FightingGame.PPM,
                body4.getPosition().y * FightingGame.PPM);
    }

    public Body getBody4() {
        return this.body4;
    }
}
