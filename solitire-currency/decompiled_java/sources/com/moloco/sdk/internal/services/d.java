package com.moloco.sdk.internal.services;

import android.content.Context;
import android.provider.Settings;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f18622b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f18623a;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public d(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        this.f18623a = context;
    }

    @Override // com.moloco.sdk.internal.services.c
    public boolean a() {
        return Settings.Secure.getInt(this.f18623a.getContentResolver(), "reduce_bright_colors_activated") == 1;
    }

    @Override // com.moloco.sdk.internal.services.c
    public boolean b() {
        Object systemService = this.f18623a.getSystemService("accessibility");
        kotlin.jvm.internal.t.g(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        return ((AccessibilityManager) systemService).isEnabled() && Settings.Secure.getInt(this.f18623a.getContentResolver(), "accessibility_large_pointer_icon", 0) == 1;
    }

    @Override // com.moloco.sdk.internal.services.c
    public boolean c() {
        try {
            Object systemService = this.f18623a.getSystemService("captioning");
            kotlin.jvm.internal.t.g(systemService, "null cannot be cast to non-null type android.view.accessibility.CaptioningManager");
            return ((CaptioningManager) systemService).isEnabled();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.moloco.sdk.internal.services.c
    public float getFontScale() {
        Object systemService = this.f18623a.getSystemService("accessibility");
        kotlin.jvm.internal.t.g(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        if (((AccessibilityManager) systemService).isEnabled()) {
            return this.f18623a.getResources().getConfiguration().fontScale;
        }
        return 1.0f;
    }
}
