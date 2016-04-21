package de.mc.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.I18NBundle;

import java.util.Locale;

import de.mc.game.views.GameScreen;
import de.mc.game.views.MainMenuScreen;

public class McGame extends Game implements InputProcessor {

    public SpriteBatch batch;
    public GlyphLayout glyphLayout;
    public BitmapFont droidSansSmall;
    public BitmapFont droidSansMedium;
    public BitmapFont droidSansLarge;
    public FreeTypeFontGenerator generator;
    public FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    public Screen mainMenuScreen;
    public Screen gameScreen;
    public AssetManager assetManager;
    public I18NBundle languageStrings;
    public InputMultiplexer inputMultiplexer;

    public void create() {
        batch = new SpriteBatch();

        inputMultiplexer = new InputMultiplexer(this);
        Gdx.input.setInputProcessor(inputMultiplexer);
        Gdx.input.setCatchBackKey(true);

        // init fonts
        glyphLayout = new GlyphLayout();

        generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/DroidSans.ttf"));

        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 50;
        droidSansSmall = generator.generateFont(parameter);

        parameter.size = 100;
        droidSansMedium = generator.generateFont(parameter);

        parameter.size = 150;
        droidSansLarge = generator.generateFont(parameter);

        Locale locale = new Locale("de", "en");
        languageStrings = I18NBundle.createBundle(Gdx.files.internal("strings/strings"), locale);

        assetManager = new AssetManager();

        mainMenuScreen = new MainMenuScreen(this);
        gameScreen = new GameScreen(this);
        setScreen(mainMenuScreen);
    }

    public void render() {
        super.render();
    }

    public void dispose() {
        batch.dispose();
        droidSansSmall.dispose();
        droidSansMedium.dispose();
        droidSansLarge.dispose();
        generator.dispose();
        assetManager.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.BACK){
            if(screen == gameScreen ) {
                setScreen(mainMenuScreen);
            }
            else {
                Gdx.app.exit();
            }
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
