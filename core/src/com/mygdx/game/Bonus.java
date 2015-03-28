package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class Bonus extends Image {
   Bonus()
   {
       super(new Texture("bonus.png"));
       addListener(new BonusListener(this));
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

