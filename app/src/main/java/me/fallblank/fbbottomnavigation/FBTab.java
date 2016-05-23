package me.fallblank.fbbottomnavigation;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

/**
 * Created by fallb on 2016/5/22.
 */
public class FBTab extends FBBaseItem {
    public FBTab(@DrawableRes int iconRes, @StringRes int titleRes) {
        mIconResource = iconRes;
        mTitleResource = titleRes;
    }

    public FBTab(@DrawableRes int iconRes, String title) {
        mIconResource = iconRes;
        mTitle = title;
    }

}
