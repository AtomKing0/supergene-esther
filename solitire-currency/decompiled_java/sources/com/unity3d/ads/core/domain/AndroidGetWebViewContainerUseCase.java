package com.unity3d.ads.core.domain;

import android.content.Context;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidGetWebViewContainerUseCase.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidGetWebViewContainerUseCase implements GetWebViewContainerUseCase {

    @NotNull
    private final AndroidWebViewClient androidWebViewClient;

    @NotNull
    private final Context context;

    @NotNull
    private final k0 defaultDispatcher;

    @NotNull
    private final k0 mainDispatcher;

    @NotNull
    private final SendWebViewClientErrorDiagnostics sendWebViewClientErrorDiagnostics;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidGetWebViewContainerUseCase.kt */
    @f(c = "com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase", f = "AndroidGetWebViewContainerUseCase.kt", l = {24}, m = "invoke")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(z8.d<? super AnonymousClass1> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidGetWebViewContainerUseCase.this.invoke(null, this);
        }
    }

    public AndroidGetWebViewContainerUseCase(@NotNull Context context, @NotNull AndroidWebViewClient androidWebViewClient, @NotNull SendWebViewClientErrorDiagnostics sendWebViewClientErrorDiagnostics, @NotNull k0 mainDispatcher, @NotNull k0 defaultDispatcher) {
        t.i(context, "context");
        t.i(androidWebViewClient, "androidWebViewClient");
        t.i(sendWebViewClientErrorDiagnostics, "sendWebViewClientErrorDiagnostics");
        t.i(mainDispatcher, "mainDispatcher");
        t.i(defaultDispatcher, "defaultDispatcher");
        this.context = context;
        this.androidWebViewClient = androidWebViewClient;
        this.sendWebViewClientErrorDiagnostics = sendWebViewClientErrorDiagnostics;
        this.mainDispatcher = mainDispatcher;
        this.defaultDispatcher = defaultDispatcher;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.core.domain.GetWebViewContainerUseCase
    @android.annotation.SuppressLint({"SetJavaScriptEnabled"})
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.o0 r10, @org.jetbrains.annotations.NotNull z8.d<? super com.unity3d.ads.adplayer.AndroidWebViewContainer> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase$invoke$1 r0 = (com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase$invoke$1 r0 = new com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase$invoke$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r10 = r0.L$1
            kotlinx.coroutines.o0 r10 = (kotlinx.coroutines.o0) r10
            java.lang.Object r0 = r0.L$0
            com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase r0 = (com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase) r0
            v8.u.b(r11)
            goto L52
        L31:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L39:
            v8.u.b(r11)
            kotlinx.coroutines.k0 r11 = r9.mainDispatcher
            com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase$invoke$webview$1 r2 = new com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase$invoke$webview$1
            r4 = 0
            r2.<init>(r9, r4)
            r0.L$0 = r9
            r0.L$1 = r10
            r0.label = r3
            java.lang.Object r11 = kotlinx.coroutines.i.g(r11, r2, r0)
            if (r11 != r1) goto L51
            return r1
        L51:
            r0 = r9
        L52:
            r8 = r10
            r3 = r11
            android.webkit.WebView r3 = (android.webkit.WebView) r3
            com.unity3d.ads.adplayer.AndroidWebViewContainer r10 = new com.unity3d.ads.adplayer.AndroidWebViewContainer
            com.unity3d.ads.adplayer.AndroidWebViewClient r4 = r0.androidWebViewClient
            com.unity3d.ads.core.domain.SendWebViewClientErrorDiagnostics r5 = r0.sendWebViewClientErrorDiagnostics
            kotlinx.coroutines.k0 r6 = r0.mainDispatcher
            kotlinx.coroutines.k0 r7 = r0.defaultDispatcher
            r2 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase.invoke(kotlinx.coroutines.o0, z8.d):java.lang.Object");
    }
}
