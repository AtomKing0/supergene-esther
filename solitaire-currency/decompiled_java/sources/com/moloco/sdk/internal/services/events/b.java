package com.moloco.sdk.internal.services.events;

import com.moloco.sdk.internal.services.j;
import com.moloco.sdk.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import org.jetbrains.annotations.NotNull;
import v8.q;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18666a;

        static {
            int[] iArr = new int[a.AbstractC0481a.c.EnumC0483a.values().length];
            try {
                iArr[a.AbstractC0481a.c.EnumC0483a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.AbstractC0481a.c.EnumC0483a.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a.AbstractC0481a.c.EnumC0483a.SKIP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[a.AbstractC0481a.c.EnumC0483a.SKIP_DEC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[a.AbstractC0481a.c.EnumC0483a.MUTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[a.AbstractC0481a.c.EnumC0483a.UNMUTE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[a.AbstractC0481a.c.EnumC0483a.CTA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[a.AbstractC0481a.c.EnumC0483a.REPLAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[a.AbstractC0481a.c.EnumC0483a.AD_BADGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f18666a = iArr;
        }
    }

    @NotNull
    public static final t.e.b a(@NotNull a.AbstractC0481a.c.EnumC0483a enumC0483a) {
        kotlin.jvm.internal.t.i(enumC0483a, "<this>");
        switch (a.f18666a[enumC0483a.ordinal()]) {
            case 1:
                return t.e.b.NONE;
            case 2:
                return t.e.b.CLOSE;
            case 3:
                return t.e.b.SKIP;
            case 4:
                return t.e.b.DEC_SKIP;
            case 5:
                return t.e.b.MUTE;
            case 6:
                return t.e.b.UNMUTE;
            case 7:
                return t.e.b.CTA;
            case 8:
                return t.e.b.REPLAY;
            case 9:
                return t.e.b.AD_BADGE;
            default:
                throw new q();
        }
    }

    @NotNull
    public static final t.k b(@NotNull a.AbstractC0481a.f fVar) {
        kotlin.jvm.internal.t.i(fVar, "<this>");
        t.k.a aVarD = t.k.d();
        aVarD.b(fVar.a());
        aVarD.c(fVar.b());
        t.k kVarBuild = aVarD.build();
        kotlin.jvm.internal.t.h(kVarBuild, "newBuilder().apply {\n   … topLeftYDp\n    }.build()");
        return kVarBuild;
    }

    @NotNull
    public static final t.l c(@NotNull j jVar) {
        kotlin.jvm.internal.t.i(jVar, "<this>");
        t.l.a aVarD = t.l.d();
        aVarD.c(jVar.e());
        aVarD.b(jVar.c());
        t.l lVarBuild = aVarD.build();
        kotlin.jvm.internal.t.h(lVarBuild, "newBuilder().apply {\n   …eenHeightDp\n    }.build()");
        return lVarBuild;
    }

    @NotNull
    public static final t.l d(@NotNull a.AbstractC0481a.g gVar) {
        kotlin.jvm.internal.t.i(gVar, "<this>");
        t.l.a aVarD = t.l.d();
        aVarD.c(gVar.b());
        aVarD.b(gVar.a());
        t.l lVarBuild = aVarD.build();
        kotlin.jvm.internal.t.h(lVarBuild, "newBuilder().apply {\n   … = heightDp\n    }.build()");
        return lVarBuild;
    }
}
