package com.lxj.xpopup.core;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.lxj.xpopup.R;
import com.lxj.xpopup.util.XPopupUtils;

/**
 * Description: 在中间显示的Popup
 * Create by dance, at 2018/12/8
 */
public class CenterPopupView extends BasePopupView {
    protected FrameLayout centerPopupContainer;

    public CenterPopupView(@NonNull Context context) {
        super(context);

        centerPopupContainer = findViewById(R.id.centerPopupContainer);
        View contentView = LayoutInflater.from(getContext()).inflate(getImplLayoutId(), centerPopupContainer, false);
        centerPopupContainer.addView(contentView);
    }

    public CenterPopupView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CenterPopupView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int getPopupLayoutId() {
        return R.layout._xpopup_center_popup_view;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        measureChild(getPopupContentView(), MeasureSpec.makeMeasureSpec(Math.min(getMaxWidth(), width), MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(Math.min(getMaxHeight(), height), MeasureSpec.AT_MOST));
        setMeasuredDimension(width, height);
    }

    /**
     * 具体实现的类的布局
     *
     * @return
     */
    protected int getImplLayoutId() {
        return 0;
    }

    protected int getMaxWidth() {
        return popupInfo.maxWidth==0 ? (int) (XPopupUtils.getWindowWidth(getContext()) * 0.86f)
                : popupInfo.maxWidth;
    }

    protected int getMaxHeight() {
        return popupInfo.maxHeight==0 ? (int) (XPopupUtils.getWindowHeight(getContext()) * 0.85f)
                : popupInfo.maxHeight;
    }

}
