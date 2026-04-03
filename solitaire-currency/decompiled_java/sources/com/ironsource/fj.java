package com.ironsource;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.ironsource.qj;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class fj extends WebView implements rj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private qj f12143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private kn f12144b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fj(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.t.i(context, "context");
    }

    public final void a(@Nullable kn knVar) {
        this.f12144b = knVar;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, @NotNull KeyEvent event) {
        kotlin.jvm.internal.t.i(event, "event");
        if (i10 == 4) {
            kn knVar = this.f12144b;
            if (knVar != null && knVar.onBackButtonPressed()) {
                return true;
            }
        }
        return super.onKeyDown(i10, event);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fj(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(attrs, "attrs");
    }

    @Override // com.ironsource.rj
    public void a(@NotNull String script) {
        kotlin.jvm.internal.t.i(script, "script");
        qj qjVar = this.f12143a;
        qj qjVar2 = null;
        if (qjVar == null) {
            kotlin.jvm.internal.t.A("javascriptEngine");
            qjVar = null;
        }
        if (!qjVar.a()) {
            qj qjVar3 = this.f12143a;
            if (qjVar3 == null) {
                kotlin.jvm.internal.t.A("javascriptEngine");
                qjVar3 = null;
            }
            qjVar3.a(this);
        }
        qj qjVar4 = this.f12143a;
        if (qjVar4 == null) {
            kotlin.jvm.internal.t.A("javascriptEngine");
        } else {
            qjVar2 = qjVar4;
        }
        qjVar2.a(script);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fj(@NotNull Context context, @NotNull AttributeSet attrs, int i10) {
        super(context, attrs, i10);
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(attrs, "attrs");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public fj(@NotNull Context context, @NotNull qj javascriptEngine) {
        this(context);
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(javascriptEngine, "javascriptEngine");
        this.f12143a = javascriptEngine;
    }

    public /* synthetic */ fj(Context context, qj qjVar, int i10, kotlin.jvm.internal.k kVar) {
        this(context, (i10 & 2) != 0 ? new qj.a(0, 1, null) : qjVar);
    }
}
