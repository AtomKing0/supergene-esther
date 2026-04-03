package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class m {

    public static final class a extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ j.b f21158g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Modifier f21159h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f21160i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f21161j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j.b bVar, Modifier modifier, int i10, int i11) {
            super(2);
            this.f21158g = bVar;
            this.f21159h = modifier;
            this.f21160i = i10;
            this.f21161j = i11;
        }

        public final void a(@Nullable Composer composer, int i10) {
            m.a(this.f21158g, this.f21159h, composer, this.f21160i | 1, this.f21161j);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(@org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j.b r19, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r20, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r0 = r19
            r1 = r22
            r2 = r23
            java.lang.String r3 = "imageResource"
            kotlin.jvm.internal.t.i(r0, r3)
            r3 = 1666152349(0x634f779d, float:3.827095E21)
            r4 = r21
            androidx.compose.runtime.Composer r15 = r4.startRestartGroup(r3)
            r4 = r2 & 1
            if (r4 == 0) goto L1b
            r4 = r1 | 6
            goto L2b
        L1b:
            r4 = r1 & 14
            if (r4 != 0) goto L2a
            boolean r4 = r15.changed(r0)
            if (r4 == 0) goto L27
            r4 = 4
            goto L28
        L27:
            r4 = 2
        L28:
            r4 = r4 | r1
            goto L2b
        L2a:
            r4 = r1
        L2b:
            r5 = r2 & 2
            if (r5 == 0) goto L32
            r4 = r4 | 48
            goto L45
        L32:
            r6 = r1 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L45
            r6 = r20
            boolean r7 = r15.changed(r6)
            if (r7 == 0) goto L41
            r7 = 32
            goto L43
        L41:
            r7 = 16
        L43:
            r4 = r4 | r7
            goto L47
        L45:
            r6 = r20
        L47:
            r4 = r4 & 91
            r7 = 18
            if (r4 != r7) goto L5a
            boolean r4 = r15.getSkipping()
            if (r4 != 0) goto L54
            goto L5a
        L54:
            r15.skipToGroupEnd()
            r18 = r15
            goto La7
        L5a:
            if (r5 == 0) goto L60
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            r14 = r4
            goto L61
        L60:
            r14 = r6
        L61:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L6d
            r4 = -1
            java.lang.String r5 = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastResourceImage (VastResourceImage.kt:10)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r4, r5)
        L6d:
            int r3 = r19.c()
            float r3 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m3673constructorimpl(r3)
            int r4 = r19.a()
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m3673constructorimpl(r4)
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.m442sizeVpY3zN4(r14, r3, r4)
            java.lang.String r4 = r19.b()
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r3 = 48
            r16 = 1016(0x3f8, float:1.424E-42)
            r17 = r14
            r14 = r15
            r18 = r15
            r15 = r3
            l.i.a(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto La5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        La5:
            r6 = r17
        La7:
            androidx.compose.runtime.ScopeUpdateScope r3 = r18.endRestartGroup()
            if (r3 != 0) goto Lae
            goto Lb6
        Lae:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.m$a r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.m$a
            r4.<init>(r0, r6, r1, r2)
            r3.updateScope(r4)
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.m.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j$b, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }
}
