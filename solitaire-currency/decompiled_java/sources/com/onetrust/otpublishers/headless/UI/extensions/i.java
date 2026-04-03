package com.onetrust.otpublishers.headless.UI.extensions;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class i extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f23207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ URLSpan f23208b;

    public i(Context context, URLSpan uRLSpan) {
        this.f23207a = context;
        this.f23208b = uRLSpan;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(@NotNull View view) {
        t.i(view, "view");
        com.onetrust.otpublishers.headless.Internal.c.e(this.f23207a, this.f23208b.getURL());
    }
}
