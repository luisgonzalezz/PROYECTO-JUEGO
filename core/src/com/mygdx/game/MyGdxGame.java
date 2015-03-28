package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
	Stage stage;
    static Ganaste ganaste;
    static Perdiste perdiste;
    static int frame;
    static int velocidad;
    static int nivel=1;


    static ArrayList<Asteroide>mis_asteroides;
    static ArrayList<Bonus>mis_bonus;
    static ArrayList<AntiBonus>mis_antibonus;
    static ArrayList<Bomba>mis_bombas;
    static int asteroides_presionados;

    SpriteBatch sprite_batch;
	BitmapFont bitmap_font;


	@Override
	public void create () {
        frame=0;
        velocidad=2;

        asteroides_presionados=0;

        mis_asteroides = new ArrayList<Asteroide>();
        mis_bonus = new ArrayList<Bonus>();
        mis_antibonus = new ArrayList<AntiBonus>();
        mis_bombas = new ArrayList<Bomba>();

        stage = new Stage();
        stage.addActor(new Fondo());

        ganaste = new Ganaste();
        ganaste.setVisible(false);
        stage.addActor(ganaste);

        perdiste = new Perdiste();
        perdiste.setVisible(false);
        stage.addActor(perdiste);

		sprite_batch = new SpriteBatch();
		bitmap_font = new BitmapFont();

        Gdx.input.setInputProcessor(stage);

        Music mp3Music = Gdx.audio.newMusic(Gdx.files.internal("musica.mp3"));
        mp3Music.setVolume(0.3f);
        mp3Music.setLooping(true);
        mp3Music.play();
	}

	@Override
	public void render () {

        if(!ganaste.isVisible())
        {
            if (frame % 30 == 0) {
                Asteroide a = new Asteroide();
                stage.addActor(a);
                mis_asteroides.add(a);
            }
            frame++;
        }

        if(!ganaste.isVisible()) {
            if (frame % 300 == 0) {
                Bonus b = new Bonus();
                stage.addActor(b);
                mis_bonus.add(b);
            }
        }
         if(!ganaste.isVisible()) {
             if (frame % 100 == 0) {
                 AntiBonus c = new AntiBonus();
                 stage.addActor(c);
                 mis_antibonus.add(c);
             }
         }
             if (!ganaste.isVisible()) {
                 if (frame % 500 == 0) {
                     Bomba x = new Bomba();
                     stage.addActor(x);
                     mis_bombas.add(x);
                 }
        }

        stage.draw();
        stage.act();

        sprite_batch.begin();
        bitmap_font.draw(sprite_batch, "ASTEROIDES: 40/" + asteroides_presionados, 120, 17);
        bitmap_font.draw(sprite_batch,"TIEMPO: "+(frame/60),300,17);
        bitmap_font.draw(sprite_batch,"NIVEL: "+nivel,450,17);
        sprite_batch.end();

	}

    static void AumentarNivel()
    {
        Sound sound = Gdx.audio.newSound(Gdx.files.internal("laser.wav"));
        sound.play(.8f);
        ganaste.setVisible(false);

        asteroides_presionados = 0;
        frame=0;
        nivel++;

    }



    static void reiniciar()
    {
        perdiste.setVisible(false);
        Sound sound = Gdx.audio.newSound(Gdx.files.internal("antibonus.wav"));
        sound.play(.7f);

        for(int i=0; i<mis_asteroides.size(); i++)
        {
            mis_asteroides.get(i).remove();
        }
        for(int i=0; i<mis_bonus.size(); i++)
        {
            mis_bonus.get(i).remove();
        }
        for(int i=0; i<mis_antibonus.size(); i++)
        {
            mis_antibonus.get(i).remove();
        }

        asteroides_presionados = 0;
        frame=0;
        velocidad=2;
        nivel=1;

    }





}
