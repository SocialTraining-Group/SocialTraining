package de.dfki.stickman.body;

import de.dfki.stickman.Stickman;
import java.awt.Color;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import static de.dfki.stickman.animationlogic.util.Interpolator.linear;
import java.awt.BasicStroke;

/**
 *
 * @author Patrick Gebhard
 *
 */

/*
TOOOOOOOODDDOOOOOOOOOO
*/
public class LeftCheek extends BodyPart {

	public static enum SHAPE {

		DEFAULT, REDCHEEK
	};

	Head mHead;
	public LeftCheek.SHAPE mShape = LeftCheek.SHAPE.DEFAULT;

	public LeftCheek(Head head) {
		mHead = head;
		mLength = 5;
		mDefaultRotationPoint = mHead.mDefaultRotationPoint;
		mColor = new Color(255,153,153);
		mStroke = new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

		init();
	}

	@Override
	public void setShape(String s) {
		SHAPE shape = SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = LeftCheek.SHAPE.DEFAULT;
	}

	@Override
	public void createShape() {
		mStart = mHead.getLeftEyePostion();
		mEnd = new Point(mStart.x - mLength, mStart.y);

		clearDrawObjects();
		GeneralPath gp = new GeneralPath();

		switch (mShape) {
			case DEFAULT:
				gp = new GeneralPath();
				gp.moveTo(mStart.x, mStart.y);
				gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y);
				break;

			
			
			
                        
		}

		addToDrawObjects(gp);
	}
}
