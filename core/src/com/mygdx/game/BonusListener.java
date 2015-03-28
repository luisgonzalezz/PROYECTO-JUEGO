package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;


public class BonusListener extends InputListener {
    Bonus bonus;

    BonusListener(Bonus bonus) {
        super();
        this.bonus = bonus;
    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        Sound sound = Gdx.audio.newSound(Gdx.files.internal("bonus.wav"));
        sound.play(.7f);

        MyGdxGame.asteroides_presionados += 5;

        if (MyGdxGame.asteroides_presionados >= 40) {
            for (int i = 0; i < MyGdxGame.mis_bonus.size(); i++) {
                MyGdxGame.mis_bonus.get(i).remove();
            }
        }

            if (MyGdxGame.asteroides_presionados >= 40) {
                for (int i = 0; i < MyGdxGame.mis_asteroides.size(); i++) {
                    MyGdxGame.mis_asteroides.get(i).remove();
                }
                MyGdxGame.ganaste.setVisible(true);
                MyGdxGame.ganaste.toFront();
                MyGdxGame.velocidad++;
            }
            bonus.remove();


            return true;

        }

    }


