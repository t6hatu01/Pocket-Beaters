package fighting.game.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Avatar extends Sprite {
    public World world;
    public Body b2body;

    public Avatar(World world, String name, float x, float y){
        super(new Texture(name));
        this.world = world;
        setPosition(x - getWidth() / 2, y - getHeight() / 2);
        defineAvatar();
    }

    public void defineAvatar(){
        BodyDef bdef = new BodyDef();

        bdef.position.set(getX(),getY());
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(getWidth() / 2, getHeight() / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1;

        Fixture fixture = b2body.createFixture(fixtureDef);

        shape.dispose();


    }
}
