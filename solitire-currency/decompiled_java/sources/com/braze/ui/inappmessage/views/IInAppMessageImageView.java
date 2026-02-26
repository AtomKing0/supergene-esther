package com.braze.ui.inappmessage.views;

import com.braze.enums.inappmessage.CropType;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IInAppMessageImageView.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IInAppMessageImageView {
    void setCornersRadiiPx(float f10, float f11, float f12, float f13);

    void setCornersRadiusPx(float f10);

    void setInAppMessageImageCropType(@Nullable CropType cropType);
}
