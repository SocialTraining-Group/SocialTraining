package de.dfki.stickman.animationlogic;

import de.dfki.stickman.Stickman;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class EventAnimationScheduler extends Thread {

	Stickman mStickman;
	boolean mRunning = true;
	public LinkedBlockingQueue<Animation> mAnimationQueue = new LinkedBlockingQueue<>();
	public Semaphore mTheBlockOfHell = new Semaphore(1);

	public EventAnimationScheduler(Stickman s) {
		setName(s.mName + "'s Event AnimationScheduler");
		mStickman = s;
	}

	public void introduce(Animation a) {
		try {
			mStickman.mLogger.info("Animation " + a + " added to event animation scheduler");

			mAnimationQueue.put(a);
		} catch (InterruptedException ex) {
			mStickman.mLogger.severe(ex.getMessage());
		}
	}

	public void proceed(Animation a) {
		removeAnimation(a);
		mTheBlockOfHell.release();
	}

	public void removeAnimation(Animation a) {
		mAnimationQueue.remove(a);
	}

	public synchronized void end() {
		mRunning = false;

		// throw in a last animation that unblocks the scheduler letting him end
		try {
			mAnimationQueue.put(new Animation(mStickman, 1, false) {
			});
		} catch (InterruptedException ex) {
			Logger.getLogger(EventAnimationScheduler.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void run() {
		while (mRunning) {
			try {
				// serialize all animations here ...
				mTheBlockOfHell.acquire(1);

				// get the next animation in the animation queue
				Animation animation = mAnimationQueue.take();

				// tell the animation to render itself
				animation.mAnimationStart.release();

				// unblock the scheduler if animation is not blocking
				if (!animation.mBlocking) {
					mTheBlockOfHell.release();
					removeAnimation(animation);
				}
			} catch (InterruptedException ex) {
				mStickman.mLogger.severe(ex.getMessage());
			}
		}
	}
}
