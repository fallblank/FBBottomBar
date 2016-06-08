package me.fallblank.bottombar;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fallb on 2016/5/22.
 */
public class FBTab extends FBBase {
    boolean mShowTitle;
    View.OnClickListener mListener;

    public FBTab(@DrawableRes int iconRes, @StringRes int titleRes, View.OnClickListener listener) {
        mIconResource = iconRes;
        mTitleResource = titleRes;
        mShowTitle = true;
        mListener = listener;
    }

    public FBTab(Context context, @DrawableRes int iconRes, String title, View.OnClickListener listener) {
        mIconResource = iconRes;
        mTitle = title;
        mShowTitle = true;
        mListener = listener;
    }

    public void setShowTitle(boolean showTitle) {
        mShowTitle = showTitle;
    }

    public boolean isShowTitle() {
        return mShowTitle;
    }

    public void setListener(View.OnClickListener listener) {
        mListener = listener;
    }

    View.OnClickListener getListener() {
        return mListener;
    }
}
