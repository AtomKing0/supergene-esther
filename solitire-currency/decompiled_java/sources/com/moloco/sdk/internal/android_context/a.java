package com.moloco.sdk.internal.android_context;

import android.annotation.SuppressLint;
import android.content.Context;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"StaticFieldLeak"})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f17528a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Context f17529b;

    @NotNull
    public final Context a() {
        Context context = f17529b;
        if (context != null) {
            return context;
        }
        t.A("value");
        return null;
    }

    public final void b(@NotNull Context context) {
        t.i(context, "context");
        Context applicationContext = context.getApplicationContext();
        t.h(applicationContext, "context.applicationContext");
        f17529b = applicationContext;
    }
}
