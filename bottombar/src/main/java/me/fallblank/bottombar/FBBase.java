package me.fallblank.bottombar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by fallb on 2016/5/22.
 * 基本数据，包括tab的图片，主标题，气泡文字
 */
public abstract class FBBase {
    protected int mIconResource;
    protected Drawable mIcon;
    protected int mTitleResource;
    protected String mTitle;

    protected Drawable getIcon(Context context) {
        if (mIconResource != 0) {
            return ContextCompat.getDrawable(context, mIconResource);
        } else {
            return this.mIcon;
        }
    }

    protected String getTitle(Context context) {
        if (mTitleResource != 0) {
            return context.getString(mTitleResource);
        } else {
            return mTitle;
        }
    }
}
