package com.unity3d.ads.core.extensions;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ViewExtensionsKt {
    public static final void removeViewFromParent(@Nullable View view) {
        ViewParent parent = view != null ? view.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
    }
}
