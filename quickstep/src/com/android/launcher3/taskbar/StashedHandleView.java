/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.launcher3.taskbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;

import com.android.launcher3.R;

public class StashedHandleView extends View {

    private final @ColorInt int mStashedHandleLightColor;
    private final @ColorInt int mStashedHandleDarkColor;
    private final Rect mSampledRegion = new Rect();
    private final int[] mTmpArr = new int[2];

    public StashedHandleView(Context context) {
        this(context, null);
    }

    public StashedHandleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StashedHandleView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public StashedHandleView(Context context, AttributeSet attrs, int defStyleAttr,
            int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        mStashedHandleLightColor = ContextCompat.getColor(context,
                R.color.taskbar_stashed_handle_light_color);
        mStashedHandleDarkColor = ContextCompat.getColor(context,
                R.color.taskbar_stashed_handle_dark_color);
    }

    public void updateSampledRegion() {
        getLocationOnScreen(mTmpArr);
        mSampledRegion.set(mTmpArr[0], mTmpArr[1], mTmpArr[0] + getWidth(),
                mTmpArr[1] + getHeight());
    }

    public Rect getSampledRegion() {
        return mSampledRegion;
    }

    public void updateHandleColor(boolean isRegionDark) {
        setBackgroundColor(isRegionDark ? mStashedHandleLightColor : mStashedHandleDarkColor);
    }
}