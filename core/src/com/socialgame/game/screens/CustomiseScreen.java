package com.socialgame.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.socialgame.game.SocialGame;

public class CustomiseScreen implements Screen {

    protected final SocialGame game;
    private Stage stage;


    public CustomiseScreen(final SocialGame game) {
        this.game = game;
        this.stage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        Gdx.input.setInputProcessor(stage);
        Skin mySkin;
        mySkin = new Skin(Gdx.files.internal("skin/comic-ui.json"));
        Texture texture = new Texture("playerCustomisePlaceholder.png");

        Image playerDisplayImg = new Image(texture);

        addBackground();

        //TEMP BUTTON
        //TODO: Fix buttons and image not showing up.
        Button backButton = new TextButton("Back",mySkin,"default");
        backButton.addListener(new InputListener(){

            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) { /* touchDown = hovering over button */
                game.setScreen(new MainMenuScreen(game));
                return true;
            }
        });

        //TEMP: Labels for the colours

        /*

        Texture colour1ImageTextureUp = new Texture("exampleItem.png");
        Drawable colour1DrawableUp = new TextureRegionDrawable(new TextureRegion(colour1ImageTextureUp));
        Texture colour1ImageTextureDown = new Texture("exampleItem.png");
        Drawable colour1DrawableDown = new TextureRegionDrawable(new TextureRegion(colour1ImageTextureDown));
        ImageButton colour1 = new ImageButton(colour1DrawableUp,colour1DrawableDown);



        Texture colour1ImageTexture = new Texture("exampleItem.png");
        Drawable colour1Drawable = new TextureRegionDrawable(new TextureRegion(colour1ImageTexture));
        ImageButton colour1 = new ImageButton(colour1Drawable);
          */


        Label colour1 = new Label("colour",mySkin, "default");
        Label colour2 = new Label("colour",mySkin, "default");
        Label colour3 = new Label("colour",mySkin, "default");
        Label colour4 = new Label("colour",mySkin, "default");
        Label colour5 = new Label("colour",mySkin, "default");
        Label colour6 = new Label("colour",mySkin, "default");
        Label colour7 = new Label("colour",mySkin, "default");
        Label colour8 = new Label("colour",mySkin, "default");
        Label colour9 = new Label("colour",mySkin, "default");
        Label colour10 = new Label("colour",mySkin, "default");
        Label colour11 = new Label("colour",mySkin, "default");
        Label colour12 = new Label("colour",mySkin, "default");


        //TEMP: Labels for the playerInfo
        Label playerName = new Label("NAMEEEEEEEEEEE",mySkin, "big");
        Label playerLvl = new Label("Lv.8",mySkin,"big");
        Label playerLvlCurrentBar = new Label("8",mySkin,"big");
        Label playerLvlBar = new Label("##############----",mySkin,"big");
        Label playerLvlNextBar = new Label("9",mySkin,"big");

        //Buttons for the itemMenu table, currently they do not do anything.
        Button hatButton = new TextButton("HAT",mySkin,"default");
        Button topButton = new TextButton("TOP",mySkin,"default");



        Texture itemImageTexture = new Texture("exampleItem.png");
        Drawable drawable = new TextureRegionDrawable(new TextureRegion(itemImageTexture));
        ImageButton itemButton = new ImageButton(drawable);


        //Save button, to be used to confirm a users choice of customisation
        Button saveButton = new TextButton("Save",mySkin,"default");
        saveButton.addListener(new InputListener(){

            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) { /* touchDown = hovering over button */

                return true;
            }
        });

        //Places the user back to the main menu.
        Button exitButton = new TextButton("Exit",mySkin,"default");
        exitButton.addListener(new InputListener(){

            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) { /* touchDown = hovering over button */
                game.setScreen(new MainMenuScreen(game));
                return true;
            }
        });


        //Creates a table that covers the entire screen, and allows nested tables
        Table container = new Table();
        container.defaults().padTop(10F).padBottom(10F);
        container.setFillParent(true);

        // Creates the table for the player to choose colours, TODO: replace labels with buttons
        Table clrPicker = new Table();
            clrPicker.setDebug(true);
            clrPicker.add(colour1).height(Gdx.graphics.getHeight()/14).pad(2f);
            clrPicker.row();
            clrPicker.add(colour2).height(Gdx.graphics.getHeight()/14).pad(2f);
            clrPicker.row();
            clrPicker.add(colour3).height(Gdx.graphics.getHeight()/14).pad(2f);
            clrPicker.row();
            clrPicker.add(colour4).height(Gdx.graphics.getHeight()/14).pad(2f);
            clrPicker.row();
            clrPicker.add(colour5).height(Gdx.graphics.getHeight()/14).pad(2f);
            clrPicker.row();
            clrPicker.add(colour6).height(Gdx.graphics.getHeight()/14).pad(2f);
            clrPicker.row();
            clrPicker.add(colour7).height(Gdx.graphics.getHeight()/14).pad(2f);
            clrPicker.row();
            clrPicker.add(colour8).height(Gdx.graphics.getHeight()/14).pad(2f);
            clrPicker.row();
            clrPicker.add(colour9).height(Gdx.graphics.getHeight()/14).pad(2f);
            clrPicker.row();
            clrPicker.add(colour10).height(Gdx.graphics.getHeight()/14).pad(2f);
            clrPicker.row();
            clrPicker.add(colour11).height(Gdx.graphics.getHeight()/14).pad(2f);
            clrPicker.row();
            clrPicker.add(colour12).height(Gdx.graphics.getHeight()/14).pad(2f);
            clrPicker.row();

        // Creates the table for the players info
        // TODO: Replace labels with player data when added to the game.
        // TODO: Replace level bar with actual bar that represents the progress to next level

        Table playerInfoContainer = new Table();

            Table playerInfo = new Table();
            playerInfo.defaults().pad(5F);
            playerInfo.add(playerName).colspan(2).left();
            playerInfo.add(playerLvl);
            playerInfo.row();
            playerInfo.add(playerLvlCurrentBar);
            playerInfo.add(playerLvlBar);
            playerInfo.add(playerLvlNextBar);

        // TODO: Once items are implemented add preview of picked items for players
            Table playerDisplay = new Table();
            playerDisplay.add(playerDisplayImg);

        // Combines the player display and info a single table
        playerInfoContainer.add(playerInfo).height(Gdx.graphics.getHeight()/14*3);;
        playerInfoContainer.row();
        playerInfoContainer.add(playerDisplay).height(Gdx.graphics.getHeight()/14*11);


        // Creates the table to house the item menu side
        Table playerItemMenuContainer = new Table();

            // Creates the table that houses the items for players to pick.
            // TODO: Make buttons intractable
            // TODO: Combine with player preview to see items picked.
            Table playerItems = new Table();
            playerItems.defaults().pad(5F);
            playerItems.add(itemButton);
            playerItems.add(itemButton);
            playerItems.add(itemButton);
            playerItems.row();
            playerItems.add(itemButton);
            playerItems.add(itemButton);
            playerItems.add(itemButton);

            // Table that houses the buttons for nav and items for selection.
            // TODO: Once items added make it so the two buttons swap items from Hats to Tops
            Table playerItemMenu = new Table();
            playerItemMenu.defaults();
            playerItemMenu.add(hatButton).padRight(Gdx.graphics.getWidth()/12);
            playerItemMenu.add(topButton);
            playerItemMenu.row();
            playerItemMenu.add(playerItems).colspan(2);

            Table navButtons = new Table();
            navButtons.defaults();
            navButtons.add(saveButton).padRight(Gdx.graphics.getWidth()/12);
            navButtons.add(exitButton);


        // Combines the tables with the nav buttons for the game.
        playerItemMenuContainer.defaults();
        playerItemMenuContainer.add(playerItemMenu).height(Gdx.graphics.getHeight()/10*8);
        playerItemMenuContainer.row();
        playerItemMenuContainer.add(navButtons).height(Gdx.graphics.getHeight()/10*4);

        //Puts all the tables together in one table.
        container.add(clrPicker).width(Gdx.graphics.getWidth()/18).expandY();
        container.add(playerInfoContainer).width(Gdx.graphics.getWidth()/18*8).expandY();
        container.add(playerItemMenuContainer).width(Gdx.graphics.getWidth()/18*9).expandY();

        stage.addActor(container);
        stage.setDebugAll(true);

    }

    // Container

    // Colour picker

    // Player info and level

    // Item selections
        // Hat
        // Top

    // Save and Exit buttons


    public void addBackground() {
        Texture texture = new Texture(Gdx.files.internal("background.png"));
        TextureRegion textureRegion = new TextureRegion(texture);

        textureRegion.setRegion(0, 0, texture.getWidth(), texture.getHeight());
        Image background = new Image(textureRegion);
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getWidth());
        background.setPosition(0, Gdx.graphics.getHeight() - background.getHeight());
        stage.addActor(background);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
