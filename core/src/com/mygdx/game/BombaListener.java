package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;


public class BombaListener extends InputListener {
    Bomba bomba;

    BombaListener(Bomba bomba) {
        super();
        this.bomba = bomba;
    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        Sound sound = Gdx.audio.newSound(Gdx.files.internal("bomba.wav"));
        sound.play(.5f);
        for(int i=0; i<MyGdxGame.mis_asteroides.size(); i++)
        {
            MyGdxGame.mis_asteroides.get(i).remove();
        }

            bomba.remove();


            return true;

        }

    }


