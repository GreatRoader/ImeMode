package com.example.wei.inputsoftstatus;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * 通过监测根布局位置变化来判断输入法的显示与隐藏
 * The display and hiding of input method is determined by monitoring the change of root layout position.
 *
 * created by Songwh
 */
public class InputSoftRelativeLayout extends RelativeLayout{
    private OnSoftKeyboardListener mSoftKeyboardListener;
    private boolean flag=true;
    private int maxHeight;
    private Rect rect;

    public InputSoftRelativeLayout(Context context) {
        super(context);
    }
    public InputSoftRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if(mSoftKeyboardListener!=null){
            if(rect==null)rect = new Rect();
            getWindowVisibleDisplayFrame(rect);
            int visibleBottom=rect.bottom;
            if(flag){
                flag = false;
                maxHeight=visibleBottom;
            }
            mSoftKeyboardListener.onSoftKeyboardChange(maxHeight>rect.bottom);
        }
    }

    public void setSoftKeyboardListener(OnSoftKeyboardListener listener){
        mSoftKeyboardListener=listener;
    }

    public interface OnSoftKeyboardListener{
         void onSoftKeyboardChange(boolean show);
    }




}