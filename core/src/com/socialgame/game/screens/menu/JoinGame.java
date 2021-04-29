package com.socialgame.game.screens.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.socialgame.game.SocialGame;
import com.socialgame.game.screens.GameScreen;

import java.io.IOException;

public class JoinGame extends BaseMenuScreen {
    public JoinGame(final SocialGame game) {
        super(game);

        Image title = new Image(game.menuSpriteSheet.findRegion("title"));
        
        Label ipAddressLabel = new Label("IP Address:", skin,"big");
        final TextField ipAddressText = new TextField("", skin);
        Label passwordLabel = new Label("Password:", skin,"big");
        final TextField passwordText = new TextField("", skin);


        Button backButton = new TextButton("Back",skin,"default");
        backButton.addListener(new InputListener(){

            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) { /* touchDown = hovering over button */
                game.setScreen(new Main(game));
                return true;
            }
        });

        Button joinButton = new TextButton("Join",skin,"default");
        joinButton.addListener(new InputListener(){

            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) { /* touchDown = hovering over button */
                String ip = ipAddressText.getText();
                // TODO: Add IP validation
                System.out.println("IP: " + ipAddressText.getText());
                System.out.println("Password: " + passwordText.getText());

                if (ip.length() == 0)
                    ip = "127.0.0.1";

                try {
                    game.setScreen(new GameScreen(game, ipAddressText.getText()));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return true;
            }
        });

        Table table = new Table();
        table.setDebug(false); // turn on all debug lines (table, cell, and widget)
        table.setFillParent(true);
        table.center();
        table.add(title).width(Gdx.graphics.getWidth()/3f).height(Gdx.graphics.getHeight()/3f).colspan(2);
        table.row();
        table.add(ipAddressLabel);
        table.add(ipAddressText).width(Gdx.graphics.getWidth()/5f).uniform().pad(5f);
        table.row();
        table.add(passwordLabel);
        table.add(passwordText).width(Gdx.graphics.getWidth()/5f).uniform().pad(5f);
        table.row();
        table.add(backButton).width(Gdx.graphics.getWidth()/6f).height(Gdx.graphics.getHeight()/10f).padBottom(10).padTop(10);
        table.add(joinButton).width(Gdx.graphics.getWidth()/6f).height(Gdx.graphics.getHeight()/10f).padBottom(10).padTop(10);
        stage.addActor(table);
    }
}
