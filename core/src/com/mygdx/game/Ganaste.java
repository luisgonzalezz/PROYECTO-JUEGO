package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class Ganaste extends Image {
    Ganaste()
    {

    super(new Texture("ganaste.png") );

    addListener(new InputListener()
    {
        @Override
        public boolean touchDown (InputEvent event,float x, float y,int pointer, int button)
        {
            MyGdxGame.AumentarNivel();
            return true;
        }
    }

    );
}
}
