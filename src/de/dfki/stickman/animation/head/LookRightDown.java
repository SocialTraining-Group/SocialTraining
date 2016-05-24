package de.dfki.stickman.animation.head;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;
import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class LookRightDown extends Animation {

	public LookRightDown(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		int translationUnit = 3;

		// look left
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "LOOKRIGHTDOWN"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "LOOKRIGHTDOWN"));
		playAnimationPart(20);
                
                pauseAnimation(1200);

		// no look left
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "DEFAULT"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "DEFAULT"));
		playAnimationPart(20);
	}
}
