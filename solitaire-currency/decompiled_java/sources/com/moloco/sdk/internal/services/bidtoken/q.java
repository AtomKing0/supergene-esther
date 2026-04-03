package com.moloco.sdk.internal.services.bidtoken;

import androidx.media3.common.PlaybackException;
import com.google.protobuf.ByteString;
import com.moloco.sdk.d;
import com.moloco.sdk.e;
import com.moloco.sdk.internal.services.b;
import com.moloco.sdk.internal.services.f;
import com.moloco.sdk.internal.services.g0;
import com.moloco.sdk.internal.services.h0;
import com.moloco.sdk.internal.services.i0;
import java.util.Date;
import java.util.TimeZone;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class q implements p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final h0 f18548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.l f18549c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f18551b;

        static {
            int[] iArr = new int[com.moloco.sdk.internal.services.p.values().length];
            try {
                iArr[com.moloco.sdk.internal.services.p.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[com.moloco.sdk.internal.services.p.PORTRAIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[com.moloco.sdk.internal.services.p.LANDSCAPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f18550a = iArr;
            int[] iArr2 = new int[i0.values().length];
            try {
                iArr2[i0.SILENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[i0.VIBRATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[i0.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            f18551b = iArr2;
        }
    }

    public q(@NotNull h0 deviceInfoService, @NotNull com.moloco.sdk.internal.services.l screenInfoService) {
        kotlin.jvm.internal.t.i(deviceInfoService, "deviceInfoService");
        kotlin.jvm.internal.t.i(screenInfoService, "screenInfoService");
        this.f18548b = deviceInfoService;
        this.f18549c = screenInfoService;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.p
    @NotNull
    public com.moloco.sdk.e a(@NotNull com.moloco.sdk.internal.services.bidtoken.providers.k clientSignals, @NotNull g bidTokenConfig) {
        e.j.b bVar;
        kotlin.jvm.internal.t.i(clientSignals, "clientSignals");
        kotlin.jvm.internal.t.i(bidTokenConfig, "bidTokenConfig");
        g0 g0VarB = this.f18548b.b();
        com.moloco.sdk.internal.services.j jVarA = this.f18549c.a();
        e.C0296e c0296eL = com.moloco.sdk.e.l();
        e.l.a aVarC = e.l.c();
        aVarC.b(clientSignals.j());
        c0296eL.h(aVarC.build());
        e.i.a aVarE = e.i.e();
        Boolean boolA = clientSignals.g().a();
        if (boolA != null) {
            aVarE.b(boolA.booleanValue());
        }
        Long lB = clientSignals.g().b();
        if (lB != null) {
            aVarE.c(lB.longValue());
        }
        Long lC = clientSignals.g().c();
        if (lC != null) {
            aVarE.d(lC.longValue());
        }
        c0296eL.i(aVarE.build());
        e.g.a aVarC2 = e.g.c();
        Long lA = clientSignals.c().a();
        if (lA != null) {
            aVarC2.b(lA.longValue());
        }
        c0296eL.g(aVarC2.build());
        e.j.a aVarF = e.j.f();
        Integer numA = clientSignals.h().a();
        if (numA != null) {
            numA.intValue();
            aVarF.b(clientSignals.h().a().intValue());
        }
        Integer numB = clientSignals.h().b();
        if (numB != null) {
            aVarF.c(numB.intValue());
        }
        Boolean boolC = clientSignals.h().c();
        if (boolC != null) {
            aVarF.d(boolC.booleanValue());
        }
        com.moloco.sdk.internal.services.b bVarD = clientSignals.h().d();
        if (bVarD != null) {
            if (bVarD instanceof b.a) {
                bVar = e.j.b.CELLULAR;
            } else if (kotlin.jvm.internal.t.d(bVarD, b.C0326b.f18413a)) {
                bVar = e.j.b.NO_NETWORK;
            } else {
                if (!kotlin.jvm.internal.t.d(bVarD, b.c.f18414a)) {
                    throw new v8.q();
                }
                bVar = e.j.b.WIFI;
            }
            aVarF.e(bVar);
        }
        c0296eL.j(aVarF.build());
        e.d.b bVarE = e.d.e();
        Integer numB2 = clientSignals.e().b();
        if (numB2 != null) {
            bVarE.d(numB2.intValue());
        }
        Integer numA2 = clientSignals.e().a();
        if (numA2 != null) {
            int iIntValue = numA2.intValue();
            bVarE.b(iIntValue != 2 ? iIntValue != 3 ? iIntValue != 4 ? iIntValue != 5 ? e.d.a.UNKNOWN : e.d.a.FULL : e.d.a.NOT_CHARGING : e.d.a.DISCHARGING : e.d.a.CHARGING);
        }
        Boolean boolC2 = clientSignals.e().c();
        if (boolC2 != null) {
            bVarE.c(boolC2.booleanValue());
        }
        c0296eL.e(bVarE.build());
        e.b.a aVarD = e.b.d();
        com.moloco.sdk.internal.services.f fVarB = clientSignals.b();
        if (fVarB instanceof f.a) {
            aVarD.b(false);
            aVarD.c(((f.a) fVarB).a());
        } else if (kotlin.jvm.internal.t.d(fVarB, f.b.f18674a)) {
            aVarD.b(true);
        }
        c0296eL.c(aVarD.build());
        e.k.a aVarG = e.k.g();
        Boolean boolIsAgeRestrictedUser = clientSignals.i().isAgeRestrictedUser();
        if (boolIsAgeRestrictedUser != null) {
            aVarG.c(boolIsAgeRestrictedUser.booleanValue());
        }
        Boolean boolIsUserConsent = clientSignals.i().isUserConsent();
        if (boolIsUserConsent != null) {
            aVarG.d(boolIsUserConsent.booleanValue());
        }
        Boolean boolIsDoNotSell = clientSignals.i().isDoNotSell();
        if (boolIsDoNotSell != null) {
            aVarG.b(boolIsDoNotSell.booleanValue());
        }
        String tCFConsent = clientSignals.i().getTCFConsent();
        if (tCFConsent != null) {
            aVarG.e(tCFConsent);
        }
        aVarG.f(clientSignals.i().getUsPrivacy());
        c0296eL.k(aVarG.build());
        e.f.a aVarY = e.f.y();
        aVarY.m(g0VarB.e());
        aVarY.t(g0VarB.j());
        aVarY.p(g0VarB.f());
        aVarY.q(g0VarB.h());
        aVarY.j(g0VarB.d());
        aVarY.c(g0VarB.g());
        aVarY.e(g0VarB.l() ? 5 : 1);
        aVarY.k(1);
        e.h.a aVarC3 = e.h.c();
        aVarC3.b(TimeZone.getDefault().getOffset(new Date().getTime()) / 60000);
        aVarY.f(aVarC3.build());
        aVarY.w(jVarA.f());
        aVarY.g(jVarA.d());
        aVarY.v(jVarA.a());
        aVarY.u(jVarA.b());
        aVarY.s(g0VarB.i());
        if (bidTokenConfig.a()) {
            aVarY.d(c(g0VarB.b()));
        }
        com.moloco.sdk.internal.services.p pVarC = clientSignals.f().c();
        if (pVarC != null) {
            aVarY.r(e(pVarC));
        }
        Boolean boolA2 = this.f18548b.a();
        if (boolA2 != null) {
            aVarY.i(boolA2.booleanValue());
        }
        String strA = clientSignals.f().a();
        if (strA != null) {
            aVarY.l(strA);
        }
        String strB = clientSignals.f().b();
        if (strB != null) {
            aVarY.o(strB);
        }
        aVarY.x(jVarA.g());
        aVarY.y(jVarA.h());
        aVarY.h(g0VarB.c());
        aVarY.b(g0VarB.a());
        c0296eL.f(aVarY.build());
        e.c.a aVarD2 = e.c.d();
        i0 i0VarB = clientSignals.d().b();
        if (i0VarB != null) {
            aVarD2.b(d(i0VarB));
        }
        Integer numA3 = clientSignals.d().a();
        if (numA3 != null) {
            aVarD2.c(numA3.intValue());
        }
        c0296eL.d(aVarD2.build());
        e.a.C0294a c0294aF = e.a.f();
        Float fC = clientSignals.a().c();
        if (fC != null) {
            c0294aF.d(fC.floatValue());
        }
        Boolean boolB = clientSignals.a().b();
        if (boolB != null) {
            c0294aF.c(boolB.booleanValue());
        }
        Boolean boolA3 = clientSignals.a().a();
        if (boolA3 != null) {
            c0294aF.b(boolA3.booleanValue());
        }
        Boolean boolD = clientSignals.a().d();
        if (boolD != null) {
            c0294aF.e(boolD.booleanValue());
        }
        c0296eL.b(c0294aF.build());
        com.moloco.sdk.e eVarBuild = c0296eL.build();
        kotlin.jvm.internal.t.h(eVarBuild, "newBuilder().apply {\n   …build()\n        }.build()");
        return eVarBuild;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.p
    @NotNull
    public byte[] b(@NotNull byte[] bidTokenComponents, @NotNull byte[] secret) {
        kotlin.jvm.internal.t.i(bidTokenComponents, "bidTokenComponents");
        kotlin.jvm.internal.t.i(secret, "secret");
        d.a aVarD = com.moloco.sdk.d.d();
        aVarD.b(ByteString.copyFrom(secret));
        aVarD.c(ByteString.copyFrom(bidTokenComponents));
        byte[] byteArray = aVarD.build().toByteArray();
        kotlin.jvm.internal.t.h(byteArray, "newBuilder().apply {\n   …  }.build().toByteArray()");
        return byteArray;
    }

    public final long c(long j10) {
        return j10 * ((long) PlaybackException.CUSTOM_ERROR_CODE_BASE);
    }

    public final e.c.b d(i0 i0Var) {
        int i10 = a.f18551b[i0Var.ordinal()];
        if (i10 == 1) {
            return e.c.b.SILENT;
        }
        if (i10 == 2) {
            return e.c.b.VIBRATE;
        }
        if (i10 == 3) {
            return e.c.b.NORMAL;
        }
        throw new v8.q();
    }

    public final e.f.b e(com.moloco.sdk.internal.services.p pVar) {
        int i10 = a.f18550a[pVar.ordinal()];
        if (i10 == 1) {
            return e.f.b.UNKNOWN;
        }
        if (i10 == 2) {
            return e.f.b.PORTRAIT;
        }
        if (i10 == 3) {
            return e.f.b.LANDSCAPE;
        }
        throw new v8.q();
    }
}
