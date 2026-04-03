package com.moloco.sdk.internal.publisher;

import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.MediationInfo;
import com.moloco.sdk.publisher.Moloco;
import java.io.ByteArrayInputStream;
import java.util.zip.GZIPInputStream;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
@VisibleForTesting(otherwise = 2)
public final class w implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f18329a = "Base64GzippedBidPreprocessor";

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.Base64GzippedBidProcessor$process$2", f = "BidProcessor.kt", l = {}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super String>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18330j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f18332l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f18332l = str;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super String> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return w.this.new a(this.f18332l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f18330j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            String str = w.this.f18329a;
            StringBuilder sb = new StringBuilder();
            sb.append("Base64 Gzipped supported ");
            MediationInfo mediationInfo$moloco_sdk_release = Moloco.INSTANCE.getMediationInfo$moloco_sdk_release();
            sb.append(mediationInfo$moloco_sdk_release != null ? mediationInfo$moloco_sdk_release.getName() : null);
            sb.append(" mediation is detected. Starting bid response pre-process.");
            MolocoLogger.debug$default(molocoLogger, str, sb.toString(), false, 4, null);
            String strD = w.this.d(this.f18332l);
            MolocoLogger.debug$default(molocoLogger, w.this.f18329a, "Processed bidresponse: " + strD, false, 4, null);
            return strD;
        }
    }

    @Override // com.moloco.sdk.internal.publisher.y
    @Nullable
    public Object b(@NotNull String str, @NotNull z8.d<? super String> dVar) {
        return kotlinx.coroutines.i.g(com.moloco.sdk.internal.scheduling.c.a().getDefault(), new a(str, null), dVar);
    }

    public final String d(String str) {
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            kotlin.jvm.internal.t.h(bArrDecode, "decode(response, Base64.DEFAULT)");
            MolocoLogger.debug$default(MolocoLogger.INSTANCE, this.f18329a, "Base64 decoded bidresponse: " + bArrDecode, false, 4, null);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrDecode);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream, 2048);
            StringBuilder sb = new StringBuilder();
            byte[] bArr = new byte[2048];
            while (true) {
                try {
                    try {
                        int i10 = gZIPInputStream.read(bArr);
                        if (i10 == -1) {
                            byteArrayInputStream.close();
                            gZIPInputStream.close();
                            return sb.toString();
                        }
                        sb.append(new String(bArr, 0, i10, p9.d.f32952b));
                    } catch (Exception unused) {
                        MolocoLogger.warn$default(MolocoLogger.INSTANCE, this.f18329a, "Failed to unzip bidresponse, perhaps a non-gzipped response: " + str, null, false, 12, null);
                        byteArrayInputStream.close();
                        gZIPInputStream.close();
                        return null;
                    }
                } catch (Throwable th) {
                    byteArrayInputStream.close();
                    gZIPInputStream.close();
                    throw th;
                }
            }
        } catch (Exception unused2) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, this.f18329a, "Failed to base64 decode bidresponse, perhpas a non-base64 encoded response: " + str, null, false, 12, null);
            return null;
        }
    }
}
