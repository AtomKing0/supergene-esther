package com.moloco.sdk.internal.services;

import android.content.Context;
import android.content.pm.PackageInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: loaded from: classes4.dex */
public final class v implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f18826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public t f18827b;

    public v(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        this.f18826a = context;
    }

    @Override // com.moloco.sdk.internal.services.u
    @NotNull
    public t invoke() {
        Object objB;
        t tVar = this.f18827b;
        if (tVar != null) {
            return tVar;
        }
        try {
            t.a aVar = v8.t.f35208b;
            Context context = this.f18826a;
            String string = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
            PackageInfo packageInfoA = w.a(this.f18826a);
            String str = packageInfoA.packageName;
            kotlin.jvm.internal.t.h(str, "it.packageName");
            String str2 = packageInfoA.versionName;
            kotlin.jvm.internal.t.h(str2, "it.versionName");
            t tVar2 = new t(string, str, str2);
            this.f18827b = tVar2;
            objB = v8.t.b(tVar2);
        } catch (Throwable th) {
            t.a aVar2 = v8.t.f35208b;
            objB = v8.t.b(v8.u.a(th));
        }
        if (v8.t.g(objB)) {
            objB = null;
        }
        t tVar3 = (t) objB;
        return tVar3 == null ? new t("", "", "") : tVar3;
    }
}
