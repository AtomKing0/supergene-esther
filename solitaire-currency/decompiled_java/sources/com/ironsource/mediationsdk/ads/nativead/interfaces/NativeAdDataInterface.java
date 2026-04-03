package com.ironsource.mediationsdk.ads.nativead.interfaces;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface NativeAdDataInterface {

    public static class Image {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final Drawable f13294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final Uri f13295b;

        public Image(@Nullable Drawable drawable, @Nullable Uri uri) {
            this.f13294a = drawable;
            this.f13295b = uri;
        }

        @Nullable
        public final Drawable getDrawable() {
            return this.f13294a;
        }

        @Nullable
        public final Uri getUri() {
            return this.f13295b;
        }
    }

    @Nullable
    String getAdvertiser();

    @Nullable
    String getBody();

    @Nullable
    String getCallToAction();

    @Nullable
    Image getIcon();

    @Nullable
    String getTitle();
}
