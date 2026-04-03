package com.onetrust.otpublishers.headless.UI.Helper;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public final class j extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f22162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ URLSpan f22163b;

    public j(Context context, URLSpan uRLSpan) {
        this.f22162a = context;
        this.f22163b = uRLSpan;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(@NonNull View view) {
        com.onetrust.otpublishers.headless.Internal.c.e(this.f22162a, this.f22163b.getURL());
    }
}
