package me.fallblank.bottombar;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by fallb on 2016/5/22.
 */
public class FBBottomBar extends FrameLayout {

    /**
     * 标签数据
     */
    private ArrayList<FBTab> mTabs;


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
        mTabs = new ArrayList<>();
        init(context);
    }

    public FBBottomBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTabs = new ArrayList<>();
        init(context);
    }

    public FBBottomBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTabs = new ArrayList<>();
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
        View bottomBar = View.inflate(getContext(), R.layout.fb_bottom_bar_tab_container, null);
        mTabContainer = (ViewGroup) bottomBar.findViewById(R.id.fa_tab_container);
        mBackgroundView = bottomBar.findViewById(R.id.fb_background_view);
        mBackgroundOverlay = bottomBar.findViewById(R.id.fb_background_overlay);
        addView(bottomBar);
    }


    /**
     * 添加标签
     *
     * @param tabs
     */
    public void addTabs(@NonNull FBTab... tabs) {
        for (FBTab tab : tabs) {
            mTabs.add(tab);
        }
        updateTabs();
    }

    /**
     * 添加新标签时去除原理的数据
     */
    public void clearTabs() {
        mTabContainer.removeAllViews();
        mTabs.clear();
    }

    /**
     * 更新标签
     */
    private void updateTabs() {
        int length = mTabs.size();
        int currentWidth = FBUtils.dpToPixel(getContext(), mScreenWidth / length);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(currentWidth, ViewGroup.LayoutParams.WRAP_CONTENT);
        for (FBTab item : mTabs) {
            View view = View.inflate(getContext(), R.layout.fb_bottom_bar_tab, null);
            final ImageView ivIcon = (ImageView) view.findViewById(R.id.fb_tab_icon);
            ivIcon.setImageDrawable(item.getIcon(getContext()));
            TextView tvTitle = (TextView) view.findViewById(R.id.fb_tab_title);
            tvTitle.setText(item.getTitle(getContext()));
            if (!item.isShowTitle()) tvTitle.setVisibility(GONE);
            view.setOnClickListener(item.getListener());
            view.setLayoutParams(params);
            mTabContainer.addView(view);
        }
    }
}
