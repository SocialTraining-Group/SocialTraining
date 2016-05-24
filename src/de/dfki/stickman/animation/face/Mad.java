package de.dfki.stickman.animation.face;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;
import java.util.ArrayList;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class Mad extends Animation {

	public Mad(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// mad
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "DEFAULT"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "Eye_O"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "Eye_O"));
                mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "MADBROW"));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "MADBROW"));
                
		playAnimationPart(20);
		
		pauseAnimation(1200);
		
		// no mad
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "DEFAULT"));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "DEFAULT"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "DEFAULT"));
                mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "DEFAULT"));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "DEFAULT"));
		
		playAnimationPart(20);
	}
}
