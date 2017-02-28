package lining.bawei.com.custimageviewdamo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by JasonMiao on 2017/2/28.
 */

public class CustomImageView extends ImageView {

    private Paint paint;
    private int progress;
    private boolean isVisiable = true;
    private Rect rect;

    public CustomImageView(Context context) {
        super(context);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inintPaint();
    }

    private void inintPaint() {
        paint = new Paint();

        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(2,2);

        paint.setColor(Color.parseColor("#70000000"));
        canvas.drawRect(0, 0, getWidth(), getHeight() - getHeight() * progress / 100, paint);
        paint.setColor(Color.RED);

        paint.setTextSize(20);
        if (progress < 100) {
            rect = new Rect();
            paint.getTextBounds("00%", 0, "00%".length(), rect);
            canvas.drawText(progress + "%", getWidth() / 2- (rect.width()/2), getHeight() / 2, paint);
        } else {
            canvas.drawText("", getWidth() / 2, getHeight() / 2, paint);
        }
        canvas.restore();
    }

    public void setProgress(int progress) {
        this.progress = progress;
        postInvalidate();

    }
}
