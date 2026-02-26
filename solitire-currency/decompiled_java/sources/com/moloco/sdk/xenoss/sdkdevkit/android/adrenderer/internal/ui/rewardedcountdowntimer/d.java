package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.moloco.sdk.internal.ortb.model.i;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.m0;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    public static final class a extends v implements l<SemanticsPropertyReceiver, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f20030g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(1);
            this.f20030g = str;
        }

        public final void a(@NotNull SemanticsPropertyReceiver semantics) {
            t.i(semantics, "$this$semantics");
            String str = this.f20030g;
            SemanticsPropertiesKt.setContentDescription(semantics, str);
            SemanticsPropertiesKt.setTestTag(semantics, str);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            a(semanticsPropertyReceiver);
            return k0.f35197a;
        }
    }

    public static final class c extends v implements l<SemanticsPropertyReceiver, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f20032g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(1);
            this.f20032g = str;
        }

        public final void a(@NotNull SemanticsPropertyReceiver semantics) {
            t.i(semantics, "$this$semantics");
            String str = this.f20032g;
            SemanticsPropertiesKt.setContentDescription(semantics, str);
            SemanticsPropertiesKt.setTestTag(semantics, str);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            a(semanticsPropertyReceiver);
            return k0.f35197a;
        }
    }

    public static final class e extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ i f20034g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f20035h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f20036i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f20037j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(i iVar, int i10, int i11, int i12) {
            super(2);
            this.f20034g = iVar;
            this.f20035h = i10;
            this.f20036i = i11;
            this.f20037j = i12;
        }

        public final void a(@Nullable Composer composer, int i10) {
            d.b(this.f20034g, this.f20035h, this.f20036i, composer, this.f20037j | 1);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final float a(int i10, int i11) {
        return ((float) m0.c(i10)) / ((float) m0.c(i11));
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x021d  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(@org.jetbrains.annotations.NotNull com.moloco.sdk.internal.ortb.model.i r23, int r24, int r25, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r26, int r27) {
        /*
            Method dump skipped, instruction units count: 566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.d.b(com.moloco.sdk.internal.ortb.model.i, int, int, androidx.compose.runtime.Composer, int):void");
    }

    public static final class b extends v implements h9.a<k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f20031g = new b();

        public b() {
            super(0);
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            b();
            return k0.f35197a;
        }

        public final void b() {
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.d$d, reason: collision with other inner class name */
    public static final class C0418d extends v implements h9.a<k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final C0418d f20033g = new C0418d();

        public C0418d() {
            super(0);
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            b();
            return k0.f35197a;
        }

        public final void b() {
        }
    }
}
