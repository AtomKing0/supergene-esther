package com.vungle.ads.internal.downloader;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Downloader.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface e {

    /* JADX INFO: compiled from: Downloader.kt */
    public static final class a extends Exception {
        public a(@Nullable String str) {
            super(str);
        }
    }

    void cancel(@Nullable d dVar);

    void cancelAll();

    void download(@Nullable d dVar, @Nullable com.vungle.ads.internal.downloader.a aVar);
}
