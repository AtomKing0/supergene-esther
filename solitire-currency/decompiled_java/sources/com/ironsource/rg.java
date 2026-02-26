package com.ironsource;

import android.graphics.drawable.Drawable;
import android.webkit.URLUtil;
import java.io.File;
import java.io.InputStream;
import org.jetbrains.annotations.NotNull;
import v8.t;

/* JADX INFO: loaded from: classes4.dex */
public final class rg implements sg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final o8 f14683a;

    /* JADX WARN: Multi-variable type inference failed */
    public rg() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final Object b(String str) {
        Exception exc;
        File file = new File(str);
        if (file.exists()) {
            Drawable drawableCreateFromPath = Drawable.createFromPath(file.getPath());
            if (drawableCreateFromPath != null) {
                return v8.t.b(drawableCreateFromPath);
            }
            t.a aVar = v8.t.f35208b;
            exc = new Exception("failed to create a drawable");
        } else {
            t.a aVar2 = v8.t.f35208b;
            exc = new Exception("file does not exists");
        }
        return v8.t.b(v8.u.a(exc));
    }

    private final Object c(String str) {
        InputStream inputStreamA = this.f14683a.a(str);
        try {
            Object objCreateFromStream = Drawable.createFromStream(inputStreamA, new File(str).getName());
            f9.c.a(inputStreamA, null);
            if (objCreateFromStream == null) {
                t.a aVar = v8.t.f35208b;
                objCreateFromStream = v8.u.a(new Exception("failed to create a drawable"));
            }
            return v8.t.b(objCreateFromStream);
        } finally {
        }
    }

    private final boolean d(String str) {
        return URLUtil.isHttpsUrl(str);
    }

    @Override // com.ironsource.sg
    @NotNull
    public Object a(@NotNull String url) {
        kotlin.jvm.internal.t.i(url, "url");
        try {
            return d(url) ? c(url) : b(url);
        } catch (Exception e10) {
            i9.d().a(e10);
            t.a aVar = v8.t.f35208b;
            return v8.t.b(v8.u.a(e10));
        }
    }

    public rg(@NotNull o8 connectionFactory) {
        kotlin.jvm.internal.t.i(connectionFactory, "connectionFactory");
        this.f14683a = connectionFactory;
    }

    public /* synthetic */ rg(o8 o8Var, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? v9.f15876a : o8Var);
    }
}
