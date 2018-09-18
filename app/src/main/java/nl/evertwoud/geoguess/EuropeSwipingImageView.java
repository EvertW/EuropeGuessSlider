package nl.evertwoud.geoguess;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class EuropeSwipingImageView extends android.support.v7.widget.AppCompatImageView {
    private static final int THRESHOLD = 300;

    boolean isEurope = false;
    boolean lock = false;
    float dX;

    public EuropeSwipingImageView(Context context) {
        super(context);
    }

    public EuropeSwipingImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EuropeSwipingImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //Sets the image view correct answer
    public void setEurope(boolean pEurope) {
        isEurope = pEurope;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!lock) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    dX = getX() - event.getRawX();
                    break;

                case MotionEvent.ACTION_MOVE:
                    animate()
                            .x(event.getRawX() + dX)
                            .setDuration(0)
                            .start();

                    if (getX() > getWidth() - THRESHOLD) {   //If swiped right
                        lock = true;
                        //Set color based on swipe
                        if(!isEurope){
                            setColorFilter(Color.GREEN, PorterDuff.Mode.OVERLAY);
                        }else {
                            setColorFilter(Color.RED, PorterDuff.Mode.OVERLAY);
                        }
                    }
                    else if (getX() + getWidth() < THRESHOLD) { //If swiped left
                        lock = true;
                        //Set color based on swipe
                        if(isEurope){
                            setColorFilter(Color.GREEN, PorterDuff.Mode.OVERLAY);
                        }else {
                            setColorFilter(Color.RED, PorterDuff.Mode.OVERLAY);
                        }
                    }
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
