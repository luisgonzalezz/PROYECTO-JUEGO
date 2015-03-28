package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;


public class AntiBonusListener extends InputListener {
    AntiBonus antibonus;

    AntiBonusListener(AntiBonus antibonus) {
        super();
        this.antibonus = antibonus;
    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

        Sound sound = Gdx.audio.newSound(Gdx.files.internal("antibonus.wav"));
        sound.play(.7f);

        MyGdxGame.asteroides_presionados -= 5;

            antibonus.remove();


            return true;

        }

    }


