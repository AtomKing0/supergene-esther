package com.facebook.ads.internal.api;

import androidx.annotation.Keep;
import androidx.annotation.UiThread;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@UiThread
public interface AdOptionsViewApi extends AdComponentViewApiProvider {
    void setIconColor(int i10);

    void setIconSizeDp(int i10);

    void setSingleIcon(boolean z10);
}
