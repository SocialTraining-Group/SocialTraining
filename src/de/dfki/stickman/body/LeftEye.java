package de.dfki.stickman.body;

import de.dfki.stickman.Stickman;
import java.awt.Color;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import static de.dfki.stickman.animationlogic.util.Interpolator.linear;
import java.awt.BasicStroke;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class LeftEye extends BodyPart {

	public static enum SHAPE {

		DEFAULT, BLINK, LOOKLEFT, LOOKRIGHT, Eye_O, LOOKLEFTDOWN, LOOKRIGHTDOWN, LOOKDOWN, LOOKUP
	};

	Head mHead;
	public LeftEye.SHAPE mShape = LeftEye.SHAPE.DEFAULT;

	public LeftEye(Head head) {
		mHead = head;
		mLength = 5;
		mDefaultRotationPoint = mHead.mDefaultRotationPoint;
		mColor = new Color(mHead.mStickman.mType == Stickman.TYPE.FEMALE ? 22 : 0,
		  mHead.mStickman.mType == Stickman.TYPE.FEMALE ? 40 : 0,
		  mHead.mStickman.mType == Stickman.TYPE.FEMALE ? 65 : 0, 144);
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
		mShape = LeftEye.SHAPE.DEFAULT;
	}

	@Override
	public void createShape() {
		mStart = mHead.getLeftEyePostion();
		mEnd = new Point(mStart.x - mLength, mStart.y);

		clearDrawObjects();
		GeneralPath gp = new GeneralPath();
                GeneralPath gp1 = new GeneralPath();
                Shape eyeForm;
                Shape pupil;

		switch (mShape) 
                {
			case DEFAULT:
                                eyeForm = new Ellipse2D.Float(mStart.x-8, mStart.y-3, 15, 8); 
                                pupil = new Ellipse2D.Float((float) (mStart.x-1.5), mStart.y, 3, 3);
				gp = new GeneralPath(eyeForm);
                                gp1 = new GeneralPath(pupil);
                                
				//gp.moveTo(mStart.x, mStart.y);
				//gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y);
				break;

			case BLINK:
				gp = new GeneralPath();
				gp.moveTo(mStart.x-8, mStart.y);
				gp.lineTo(mEnd.x+10, mEnd.y);
				break;
			case LOOKLEFT:
                                  eyeForm = new Ellipse2D.Float(mStart.x-8, mStart.y-3, 15, 8);
                                  pupil = new Ellipse2D.Float((float) (mStart.x+0.8), mStart.y, 3, 3);
                                  gp = new GeneralPath(eyeForm);
                                  gp1 = new GeneralPath(pupil);
//				gp = new GeneralPath();
//				gp.moveTo(mStart.x, mStart.y);
//				gp.quadTo(linear((mStart.x + mEnd.x) / 2, mStart.x, mShapeAnimationStep), mStart.y - 3, mEnd.x, mEnd.y);
				break;
			case LOOKRIGHT:
                                eyeForm = new Ellipse2D.Float(mStart.x-8, mStart.y-3, 15, 8); 
                                pupil = new Ellipse2D.Float((float) (mStart.x-3.5), mStart.y, 3, 3);
				gp = new GeneralPath(eyeForm);
                                gp1 = new GeneralPath(pupil);
//				gp = new GeneralPath();
//				gp.moveTo(mStart.x, mStart.y);
//				gp.quadTo(linear((mStart.x + mEnd.x) / 2, mEnd.x, mShapeAnimationStep), mStart.y - 3, mEnd.x, mEnd.y);
				break;
                          case Eye_O:
                              eyeForm = new Ellipse2D.Float(mStart.x-8, mStart.y-4, 15, (float) 10.5); 
                              pupil = new Ellipse2D.Float((float) (mStart.x-1.5), mStart.y, 3, 3);
                              gp = new GeneralPath(eyeForm);
                              gp1 = new GeneralPath(pupil);
//                                mLength = 10;
//                                gp = new GeneralPath();
//                                int posX = mStart.x + 5;
//                               
//                                mEnd = new Point(posX - mLength, mStart.y);
//                               
//                                gp.moveTo(posX, mStart.y);
//                                gp.quadTo(posX-mLength/2, (mStart.y-3) - mLength / 2, mEnd.x, mStart.y);
//                                gp.moveTo(posX, mStart.y);
//                                gp.quadTo(posX-mLength/2, (mStart.y+3) + mLength / 2, mEnd.x, mStart.y);
//                                
//                                mLength = 5;
//                                mEnd = new Point(0,0);
                                break;
                          case LOOKLEFTDOWN:
                                  eyeForm = new Ellipse2D.Float(mStart.x-8, mStart.y-3, 15, 8);
                                  pupil = new Ellipse2D.Float((float) (mStart.x+0.2), (float) (mStart.y+1.1), 3, 3);
                                  gp = new GeneralPath(eyeForm);
                                  gp1 = new GeneralPath(pupil);
                                break;
                          case LOOKRIGHTDOWN:
                                eyeForm = new Ellipse2D.Float(mStart.x-8, mStart.y-3, 15, 8); 
                                pupil = new Ellipse2D.Float((float) (mStart.x-3.5), mStart.y+1, 3, 3);
				gp = new GeneralPath(eyeForm);
                                gp1 = new GeneralPath(pupil);
                                break;
                          case LOOKDOWN:
                                eyeForm = new Ellipse2D.Float(mStart.x-8, mStart.y-3, 15, 8); 
                                pupil = new Ellipse2D.Float((float) (mStart.x-1.5), mStart.y+1, 3, 3);
				gp = new GeneralPath(eyeForm);
                                gp1 = new GeneralPath(pupil);
                              break;
                          case LOOKUP:
                                eyeForm = new Ellipse2D.Float(mStart.x-8, mStart.y-3, 15, 8); 
                                pupil = new Ellipse2D.Float((float) (mStart.x-1.5), (float) (mStart.y-1), 3, 3);
				gp = new GeneralPath(eyeForm);
                                gp1 = new GeneralPath(pupil);
                              break;
                            
		}
                
                addToDrawObjects(gp1);
		addToDrawObjects(gp);
	}
}
