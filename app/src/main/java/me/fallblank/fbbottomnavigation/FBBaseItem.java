package me.fallblank.fbbottomnavigation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

/**
 * Created by fallb on 2016/5/22.
 * 基本数据，包括tab的图片，主标题，气泡文字
 */
public class FBBaseItem {
    protected int mIconResource;
    protected Drawable mIcon;
    protected int mTitleResource;
    protected String mTitle;
    protected int mBadgeResource;
    protected String mBadge;

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

    protected String getBadge(Context context) {
        if (mBadgeResource != 0) {
            return context.getString(mBadgeResource);
        } else {
            return mBadge;
        }
    }
}
