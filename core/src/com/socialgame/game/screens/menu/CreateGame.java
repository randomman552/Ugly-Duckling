package com.socialgame.game.screens.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.socialgame.game.SocialGame;

public class CreateGame extends BaseMenuScreen {
    public CreateGame(final SocialGame game) {
        super(game);
        Image title = new Image(game.menuSpriteSheet.findRegion("title"));

        Label passwordLabel = new Label("Password:", skin,"big");
        final TextField passwordText = new TextField("", skin);

        //TEMP BUTTON
        //TODO: Fix buttons and image not showing up.
        Button backButton = new TextButton("Back",skin,"default");
        backButton.addListener(new InputListener(){

            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) { /* touchDown = hovering over button */
                game.setScreen(new Main(game));
                return true;
            }
        });

        Button createButton = new TextButton("Create",skin,"default");
        createButton.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) { /* touchDown = hovering over button */
                System.out.println(passwordText.getText());//Example of grabbing text
                return true;
            }
        });

        Table table = new Table();
        table.setDebug(false); // turn on all debug lines (table, cell, and widget)
        table.setFillParent(true);
        table.center();
        table.add(title).width(Gdx.graphics.getWidth()/3f).height(Gdx.graphics.getHeight()/3f).colspan(2);
        table.row();
        table.add(passwordLabel);
        table.add(passwordText).width(Gdx.graphics.getWidth()/5f).uniform().pad(5f);
        table.row();
        table.add(backButton).width(Gdx.graphics.getWidth()/6f).height(Gdx.graphics.getHeight()/10f).padBottom(10).padTop(10);
        table.add(createButton).width(Gdx.graphics.getWidth()/6f).height(Gdx.graphics.getHeight()/10f).padBottom(10).padTop(10);
        stage.addActor(table);
    }
}
