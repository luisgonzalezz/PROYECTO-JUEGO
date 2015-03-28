package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;


public class AsteroideListener extends InputListener {
    Asteroide asteroide;
    AsteroideListener(Asteroide asteroide)
    {
        super();
        this.asteroide= asteroide;

    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
    {
        Sound sound = Gdx.audio.newSound(Gdx.files.internal("explosion.wav"));
        sound.play(.4f);
        MyGdxGame.asteroides_presionados++;


        if(MyGdxGame.asteroides_presionados>=40)

        {


            for(int i=0; i<MyGdxGame.mis_asteroides.size(); i++)
            {
                MyGdxGame.mis_asteroides.get(i).remove();
            }

            MyGdxGame.ganaste.setVisible(true);
            MyGdxGame.ganaste.toFront();
            MyGdxGame.velocidad++;
        }
        asteroide.remove();

        return true;

    }

}
