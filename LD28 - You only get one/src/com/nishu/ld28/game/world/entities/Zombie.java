package com.nishu.ld28.game.world.entities;

import java.util.List;

import com.nishu.ld28.game.level.Level;
import com.nishu.ld28.game.world.entities.animation.Sprite;
import com.nishu.ld28.utilities.Constants;
import com.nishu.ld28.utilities.GameSound;

public class Zombie extends Entity {

	public Zombie(Level level, float x, float y) {
		super(level, x, y, Sprite.zombie_forward, 50);
	}

	public void update(List<Zombie> zombies, Player player) {
		if (getRectangle().intersects(player.getRectangle())
				&& player.getHealth() > 0) {
			player.setHealth(player.getHealth() - 1);
			if (Constants.rand.nextInt(10) == 0) {
				//getLevel().bloodSplatter.add(new Blood(getX(), getY(), false));
			}
			if (Constants.rand.nextInt(50) == 0) {
				GameSound.Bite.play(0.5f);
			}
		}
		if (player.getX() > getX()) {
			setSprite(Sprite.zombie_left);
			move(Constants.ZOMBIE_SPEED, 0);
		}
		if (player.getX() < getX()) {
			setSprite(Sprite.zombie_right);
			move(-Constants.ZOMBIE_SPEED, 0);
		}
		if (player.getY() > getY()) {
			setSprite(Sprite.zombie_forward);
			move(0, Constants.ZOMBIE_SPEED);
		}
		if (player.getY() < getY()) {
			setSprite(Sprite.zombie_backward);
			move(0, -Constants.ZOMBIE_SPEED);
		}
		if (player.getY() > getY() && player.getX() > getX()) {
			setSprite(Sprite.zombie_left);
		}
		if (player.getY() < getY() && player.getX() < getX()) {
			setSprite(Sprite.zombie_right);
		}
	}
}
