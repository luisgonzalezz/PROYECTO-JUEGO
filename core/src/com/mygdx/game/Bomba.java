package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class Bomba extends Image {
   Bomba()
   {
       super(new Texture("bomba.png"));
       addListener(new BombaListener(this));
       setY(480);
       setX((float) (Math.random() * 10000) % (Gdx.graphics.getHeight() + getWidth()));
   }
    @Override
    public void act(float delta) {
        float posicion_vieja = getY();
        float posicion_nueva = posicion_vieja - MyGdxGame.velocidad;
        setY(posicion_nueva);
    }
}

