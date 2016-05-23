package me.fallblank.fbbottomnavigation;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by fallb on 2016/5/22.
 */
public class FBBottomBar extends FrameLayout {

    /**
     * 标签数据
     */
    private FBBaseItem[] mTabs;


    /**
     * 标签的容器,背景及覆盖
     */
    private ViewGroup mTabContainer;
    private View mBackgroundView;
    private View mBackgroundOverlay;

    /**
     * 用于计算标签宽带的屏幕值
     */
    private int mScreenWidth;

    public FBBottomBar(Context context) {
        super(context);
        init(context);
    }

    public FBBottomBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FBBottomBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FBBottomBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mScreenWidth = FBUtils.getScreenWidth(getContext());
        initViews();
    }

    private void initViews() {
        View bottonBar = View.inflate(getContext(), R.layout.fb_bottom_bar_tab_container, null);
        mTabContainer = (ViewGroup) bottonBar.findViewById(R.id.fa_tab_container);
        mBackgroundView = bottonBar.findViewById(R.id.fb_background_view);
        mBackgroundOverlay = bottonBar.findViewById(R.id.fb_background_overlay);
        addView(bottonBar);
    }


    /**
     * @param tabs
     */
    public void addTabs(@NonNull FBTab... tabs) {
        if (tabs.length > 0) {
            clearTabs();
            this.mTabs = tabs;
        }
        updateTabs();
    }

    /**
     * 添加新标签时去除原理的数据
     */
    private void clearTabs() {
        mTabContainer.removeAllViews();
        mTabs = null;
    }

    /**
     * 更新标签
     */
    private void updateTabs() {
        int length = mTabs.length;
        int currentWidth = FBUtils.dpToPixel(getContext(), mScreenWidth / length);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(currentWidth, ViewGroup.LayoutParams.WRAP_CONTENT);
        for (FBBaseItem item : mTabs) {
            View view = View.inflate(getContext(), R.layout.fb_bottom_bar_tab, null);
            ImageView ivIcon = (ImageView) view.findViewById(R.id.fb_tab_icon);
            ivIcon.setImageDrawable(item.getIcon(getContext()));
            TextView tvTitle = (TextView) view.findViewById(R.id.fb_tab_title);
            tvTitle.setText(item.getTitle(getContext()));
            view.setLayoutParams(params);
            mTabContainer.addView(view);
        }
    }
}
