package com.ironsource;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface gk extends NativeAdDataInterface {

    public static final class a extends NativeAdDataInterface.Image {
        public a(@Nullable Drawable drawable, @Nullable Uri uri) {
            super(drawable, uri);
        }
    }
}
