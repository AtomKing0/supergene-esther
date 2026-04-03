package com.moloco.sdk.internal.services.init;

import android.net.Uri;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.init.h;
import com.moloco.sdk.l;
import com.moloco.sdk.n;
import e8.c;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.q;

/* JADX INFO: loaded from: classes4.dex */
public final class m implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f18785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d f18786b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18787a;

        static {
            int[] iArr = new int[b.values().length];
            try {
                iArr[b.Unknown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[b.RequestTimeout.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[b.UnknownHostHttpError.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[b.HttpSocketError.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[b.HttpSslError.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[b.PersistentHttpUnavailableError.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f18787a = iArr;
        }
    }

    public m(@NotNull String endpoint, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d httpRequestClient) {
        t.i(endpoint, "endpoint");
        t.i(httpRequestClient, "httpRequestClient");
        this.f18785a = endpoint;
        this.f18786b = httpRequestClient;
    }

    @Override // com.moloco.sdk.internal.services.init.l
    @Nullable
    public Object a(long j10, @NotNull z8.d<? super k0> dVar) {
        MolocoLogger molocoLogger;
        try {
            molocoLogger = MolocoLogger.INSTANCE;
            MolocoLogger.debug$default(molocoLogger, "InitTrackingApi", "Reporting InitTracking success", false, 4, null);
        } catch (Exception e10) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "InitTrackingApi", "Failed to send notifySuccess post request", e10, false, 8, null);
        }
        if (this.f18785a.length() == 0) {
            MolocoLogger.debug$default(molocoLogger, "InitTrackingApi", "SDK InitTracking disabled", false, 4, null);
            return k0.f35197a;
        }
        Uri uriBuild = Uri.parse(this.f18785a).buildUpon().build();
        com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d dVar2 = this.f18786b;
        String string = uriBuild.toString();
        t.h(string, "preparedUrl.toString()");
        dVar2.a(string, d(j10), c.a.f25201a.b());
        return k0.f35197a;
    }

    @Override // com.moloco.sdk.internal.services.init.l
    @Nullable
    public Object b(@NotNull h hVar, long j10, @NotNull z8.d<? super k0> dVar) {
        try {
            if (hVar instanceof h.a) {
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, "InitTrackingApi", "Reporting InitTracking client failure: " + ((h.a) hVar).a(), false, 4, null);
            } else if (hVar instanceof h.b) {
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, "InitTrackingApi", "Reporting InitTracking server failure: " + ((h.b) hVar).a(), false, 4, null);
            }
        } catch (Exception e10) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "InitTrackingApi", "Failed to send notifyFailure post request", e10, false, 8, null);
        }
        if (this.f18785a.length() == 0) {
            MolocoLogger.debug$default(MolocoLogger.INSTANCE, "InitTrackingApi", "SDK InitTracking disabled", false, 4, null);
            return k0.f35197a;
        }
        Uri uriBuild = Uri.parse(this.f18785a).buildUpon().build();
        byte[] bArrE = e(hVar, j10);
        com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d dVar2 = this.f18786b;
        String string = uriBuild.toString();
        t.h(string, "preparedUrl.toString()");
        dVar2.a(string, bArrE, c.a.f25201a.b());
        return k0.f35197a;
    }

    public final l.b.EnumC0333b c(b bVar) {
        switch (a.f18787a[bVar.ordinal()]) {
            case 1:
                return l.b.EnumC0333b.UNKNOWN;
            case 2:
                return l.b.EnumC0333b.HTTP_REQUEST_TIMEOUT;
            case 3:
                return l.b.EnumC0333b.HTTP_UKNOWN_HOST;
            case 4:
                return l.b.EnumC0333b.HTTP_SOCKET;
            case 5:
                return l.b.EnumC0333b.HTTP_SSL_ERROR;
            case 6:
                return l.b.EnumC0333b.ANDROID_WORK_MANAGER_ISSUE;
            default:
                throw new q();
        }
    }

    public final byte[] d(long j10) {
        n.a aVarE = n.e();
        aVarE.c(j10);
        aVarE.d(com.moloco.sdk.m.b().build());
        byte[] byteArray = aVarE.build().toByteArray();
        t.h(byteArray, "newBuilder().apply {\n   …  }.build().toByteArray()");
        return byteArray;
    }

    public final byte[] e(h hVar, long j10) {
        n.a aVarE = n.e();
        l.a aVarD = com.moloco.sdk.l.d();
        if (hVar instanceof h.a) {
            l.b.a aVarC = l.b.c();
            aVarC.b(c(((h.a) hVar).a()));
            aVarD.b(aVarC.build());
        } else if (hVar instanceof h.b) {
            l.c.a aVarC2 = l.c.c();
            aVarC2.b(((h.b) hVar).a());
            aVarD.c(aVarC2.build());
        }
        aVarE.b(aVarD.build());
        aVarE.c(j10);
        byte[] byteArray = aVarE.build().toByteArray();
        t.h(byteArray, "newBuilder().apply {\n   …  }.build().toByteArray()");
        return byteArray;
    }
}
