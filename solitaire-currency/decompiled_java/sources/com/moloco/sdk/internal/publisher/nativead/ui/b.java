package com.moloco.sdk.internal.publisher.nativead.ui;

import android.content.Context;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.MaterialThemeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.ComposeView;
import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    public static final class a extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ q<Modifier, Composer, Integer, k0> f18244g;

        /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.ui.b$a$a, reason: collision with other inner class name */
        public static final class C0322a extends v implements p<Composer, Integer, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ q<Modifier, Composer, Integer, k0> f18245g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0322a(q<? super Modifier, ? super Composer, ? super Integer, k0> qVar) {
                super(2);
                this.f18245g = qVar;
            }

            @Composable
            public final void a(@Nullable Composer composer, int i10) {
                if ((i10 & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1363979682, i10, -1, "com.moloco.sdk.internal.publisher.nativead.ui.NativeAdComposeViewWrapper.<anonymous>.<anonymous>.<anonymous> (NativeAdComposeViewWrapper.kt:14)");
                }
                this.f18245g.invoke(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), composer, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
                a(composer, num.intValue());
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(q<? super Modifier, ? super Composer, ? super Integer, k0> qVar) {
            super(2);
            this.f18244g = qVar;
        }

        @Composable
        public final void a(@Nullable Composer composer, int i10) {
            if ((i10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(624754934, i10, -1, "com.moloco.sdk.internal.publisher.nativead.ui.NativeAdComposeViewWrapper.<anonymous>.<anonymous> (NativeAdComposeViewWrapper.kt:13)");
            }
            MaterialThemeKt.MaterialTheme(null, null, null, ComposableLambdaKt.composableLambda(composer, 1363979682, true, new C0322a(this.f18244g)), composer, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    @NotNull
    public static final ComposeView a(@NotNull Context context, @NotNull q<? super Modifier, ? super Composer, ? super Integer, k0> content) {
        t.i(context, "context");
        t.i(content, "content");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(624754934, true, new a(content)));
        return composeView;
    }
}
