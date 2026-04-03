package com.unity3d.ads.core.data.datasource;

import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import java.io.File;
import java.io.IOException;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidRemoteCacheDataSource.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidRemoteCacheDataSource implements CacheDataSource {

    @NotNull
    private final HttpClient httpClient;

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource$getFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidRemoteCacheDataSource.kt */
    @f(c = "com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource", f = "AndroidRemoteCacheDataSource.kt", l = {26}, m = "getFile")
    static final class AnonymousClass1 extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
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
            return AndroidRemoteCacheDataSource.this.getFile(null, null, null, null, this);
        }
    }

    public AndroidRemoteCacheDataSource(@NotNull HttpClient httpClient) {
        t.i(httpClient, "httpClient");
        this.httpClient = httpClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object downloadFile(String str, File file, Integer num, z8.d<? super HttpResponse> dVar) {
        return this.httpClient.execute(new HttpRequest(str, null, null, null, null, null, null, null, null, 0, 0, 0, 0, false, null, file, num != null ? num.intValue() : Integer.MAX_VALUE, 32766, null), dVar);
    }

    private final File setupFile(File file, String str) throws IOException {
        File file2 = new File(file, str);
        if (file2.exists()) {
            file2.delete();
            file2.createNewFile();
        } else {
            file2.createNewFile();
        }
        return file2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @Override // com.unity3d.ads.core.data.datasource.CacheDataSource
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getFile(@org.jetbrains.annotations.NotNull java.io.File r17, @org.jetbrains.annotations.NotNull java.lang.String r18, @org.jetbrains.annotations.Nullable java.lang.String r19, @org.jetbrains.annotations.Nullable java.lang.Integer r20, @org.jetbrains.annotations.NotNull z8.d<? super com.unity3d.ads.core.data.model.CacheResult> r21) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r19
            r2 = r20
            r3 = r21
            boolean r4 = r3 instanceof com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource.AnonymousClass1
            if (r4 == 0) goto L1b
            r4 = r3
            com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource$getFile$1 r4 = (com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource.AnonymousClass1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L1b
            int r5 = r5 - r6
            r4.label = r5
            goto L20
        L1b:
            com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource$getFile$1 r4 = new com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource$getFile$1
            r4.<init>(r3)
        L20:
            java.lang.Object r3 = r4.result
            java.lang.Object r5 = a9.b.e()
            int r6 = r4.label
            r7 = 1
            if (r6 == 0) goto L4c
            if (r6 != r7) goto L44
            java.lang.Object r1 = r4.L$3
            java.io.File r1 = (java.io.File) r1
            java.lang.Object r2 = r4.L$2
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r5 = r4.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r4 = r4.L$0
            java.lang.String r4 = (java.lang.String) r4
            v8.u.b(r3)
            r10 = r1
            r9 = r4
            r8 = r5
            goto L76
        L44:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L4c:
            v8.u.b(r3)
            if (r1 != 0) goto L5b
            com.unity3d.ads.core.data.model.CacheResult$Failure r1 = new com.unity3d.ads.core.data.model.CacheResult$Failure
            com.unity3d.ads.core.data.model.CacheError r2 = com.unity3d.ads.core.data.model.CacheError.MALFORMED_URL
            com.unity3d.ads.core.data.model.CacheSource r3 = com.unity3d.ads.core.data.model.CacheSource.REMOTE
            r1.<init>(r2, r3)
            return r1
        L5b:
            java.io.File r3 = r16.setupFile(r17, r18)
            r6 = r18
            r4.L$0 = r6
            r4.L$1 = r1
            r4.L$2 = r2
            r4.L$3 = r3
            r4.label = r7
            java.lang.Object r4 = r0.downloadFile(r1, r3, r2, r4)
            if (r4 != r5) goto L72
            return r5
        L72:
            r8 = r1
            r10 = r3
            r3 = r4
            r9 = r6
        L76:
            com.unity3d.services.core.network.model.HttpResponse r3 = (com.unity3d.services.core.network.model.HttpResponse) r3
            java.lang.String r1 = "?"
            r4 = 0
            r5 = 2
            java.lang.String r1 = p9.h.V0(r8, r1, r4, r5, r4)
            java.lang.String r6 = "."
            java.lang.String r11 = p9.h.R0(r1, r6, r4, r5, r4)
            com.unity3d.ads.core.data.model.CachedFile r1 = new com.unity3d.ads.core.data.model.CachedFile
            java.lang.String r7 = ""
            long r12 = r3.getContentSize()
            java.lang.String r14 = r3.getProtocol()
            if (r2 == 0) goto L99
            int r2 = r2.intValue()
            goto L9c
        L99:
            r2 = 2147483647(0x7fffffff, float:NaN)
        L9c:
            r15 = r2
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11, r12, r14, r15)
            boolean r2 = com.unity3d.services.core.network.model.HttpResponseKt.isSuccessful(r3)
            if (r2 == 0) goto Laf
            com.unity3d.ads.core.data.model.CacheResult$Success r2 = new com.unity3d.ads.core.data.model.CacheResult$Success
            com.unity3d.ads.core.data.model.CacheSource r3 = com.unity3d.ads.core.data.model.CacheSource.REMOTE
            r2.<init>(r1, r3)
            goto Lb8
        Laf:
            com.unity3d.ads.core.data.model.CacheResult$Failure r2 = new com.unity3d.ads.core.data.model.CacheResult$Failure
            com.unity3d.ads.core.data.model.CacheError r1 = com.unity3d.ads.core.data.model.CacheError.NETWORK_ERROR
            com.unity3d.ads.core.data.model.CacheSource r3 = com.unity3d.ads.core.data.model.CacheSource.REMOTE
            r2.<init>(r1, r3)
        Lb8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource.getFile(java.io.File, java.lang.String, java.lang.String, java.lang.Integer, z8.d):java.lang.Object");
    }
}
