package com.vungle.ads.internal.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.vungle.ads.internal.util.p;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ImageLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class m {

    @NotNull
    private static final String FILE_SCHEME = "file://";

    @Nullable
    private Executor ioExecutor;

    @NotNull
    public static final a Companion = new a(null);
    private static final String TAG = m.class.getSimpleName();

    @NotNull
    private static final m instance = new m();

    /* JADX INFO: compiled from: ImageLoader.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final m getInstance() {
            return m.instance;
        }
    }

    private m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: displayImage$lambda-0, reason: not valid java name */
    public static final void m4117displayImage$lambda0(String str, h9.l onImageLoaded) {
        kotlin.jvm.internal.t.i(onImageLoaded, "$onImageLoaded");
        if (p9.q.K(str, "file://", false, 2, null)) {
            String strSubstring = str.substring(7);
            kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(strSubstring);
            if (bitmapDecodeFile != null) {
                onImageLoaded.invoke(bitmapDecodeFile);
                return;
            }
            p.a aVar = p.Companion;
            String TAG2 = TAG;
            kotlin.jvm.internal.t.h(TAG2, "TAG");
            aVar.w(TAG2, "decode bitmap failed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getImageSize$lambda-1, reason: not valid java name */
    public static final void m4118getImageSize$lambda1(String str, h9.p onImageSizeLoaded) {
        kotlin.jvm.internal.t.i(onImageSizeLoaded, "$onImageSizeLoaded");
        if (p9.q.K(str, "file://", false, 2, null)) {
            String strSubstring = str.substring(7);
            kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(strSubstring, options);
            onImageSizeLoaded.mo4invoke(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
        }
    }

    public final void displayImage(@Nullable final String str, @NotNull final h9.l<? super Bitmap, k0> onImageLoaded) {
        kotlin.jvm.internal.t.i(onImageLoaded, "onImageLoaded");
        if (this.ioExecutor == null) {
            p.a aVar = p.Companion;
            String TAG2 = TAG;
            kotlin.jvm.internal.t.h(TAG2, "TAG");
            aVar.w(TAG2, "ImageLoader not initialized.");
            return;
        }
        if (str == null || str.length() == 0) {
            p.a aVar2 = p.Companion;
            String TAG3 = TAG;
            kotlin.jvm.internal.t.h(TAG3, "TAG");
            aVar2.w(TAG3, "the uri is required.");
            return;
        }
        Executor executor = this.ioExecutor;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.vungle.ads.internal.util.k
                @Override // java.lang.Runnable
                public final void run() {
                    m.m4117displayImage$lambda0(str, onImageLoaded);
                }
            });
        }
    }

    public final void getImageSize(@Nullable final String str, @NotNull final h9.p<? super Integer, ? super Integer, k0> onImageSizeLoaded) {
        kotlin.jvm.internal.t.i(onImageSizeLoaded, "onImageSizeLoaded");
        if (this.ioExecutor == null) {
            p.a aVar = p.Companion;
            String TAG2 = TAG;
            kotlin.jvm.internal.t.h(TAG2, "TAG");
            aVar.w(TAG2, "ImageLoader not initialized.");
            return;
        }
        if (str == null || str.length() == 0) {
            p.a aVar2 = p.Companion;
            String TAG3 = TAG;
            kotlin.jvm.internal.t.h(TAG3, "TAG");
            aVar2.w(TAG3, "the uri is required.");
            return;
        }
        Executor executor = this.ioExecutor;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.vungle.ads.internal.util.l
                @Override // java.lang.Runnable
                public final void run() {
                    m.m4118getImageSize$lambda1(str, onImageSizeLoaded);
                }
            });
        }
    }

    public final void init(@NotNull Executor ioExecutor) {
        kotlin.jvm.internal.t.i(ioExecutor, "ioExecutor");
        this.ioExecutor = ioExecutor;
    }
}
