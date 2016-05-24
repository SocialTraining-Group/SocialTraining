/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.animation.head;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;
import java.util.ArrayList;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class Eye_O extends Animation {

	public Eye_O(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "Eye_O"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "Eye_O"));
		playAnimationPart(20);
		
		pauseAnimation(1200);

		// blink up
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "DEFAULT"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "DEFAULT"));
		playAnimationPart(20);
	}
}
