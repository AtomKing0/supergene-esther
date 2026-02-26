package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer;

import android.net.Uri;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import h9.p;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.j;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z3.k;
import z3.m0;
import z3.o;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f21460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f f21461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final String f21462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public RandomAccessFile f21463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f21464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f21465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f21466g;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.ProgressiveMediaFileDataSource$open$1", f = "ProgressiveMediaFileDataSource.kt", l = {}, m = "invokeSuspend")
    public static final class a extends l implements p<o0, z8.d<? super Long>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21467j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ o f21469l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o oVar, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f21469l = oVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super Long> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return c.this.new a(this.f21469l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws IOException {
            File fileA;
            a9.d.e();
            if (this.f21467j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            try {
                c cVar = c.this;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVarE = cVar.e(cVar.f21460a);
                if (cVarE instanceof c.a) {
                    fileA = ((c.a) cVarE).a();
                } else {
                    if (!(cVarE instanceof c.C0384c)) {
                        c.this.f21466g = true;
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, c.this.f21462c, "Failed to download file: " + c.this.f21460a, null, false, 12, null);
                        throw new IOException("Cannot read file: " + c.this.f21460a);
                    }
                    fileA = ((c.C0384c) cVarE).a();
                }
                if (!fileA.exists()) {
                    throw new IOException("Cannot read file, does not exist yet: " + c.this.f21460a);
                }
                c cVar2 = c.this;
                RandomAccessFile randomAccessFile = new RandomAccessFile(fileA, AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
                randomAccessFile.seek(this.f21469l.f37469g);
                cVar2.h(randomAccessFile);
                c cVar3 = c.this;
                long length = this.f21469l.f37470h;
                if (length == -1) {
                    length = fileA.length() - this.f21469l.f37469g;
                }
                cVar3.f21464e = length;
                if (c.this.f21464e == 0 && c.this.j(cVarE)) {
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, c.this.f21462c, "Streaming error likely detected", null, false, 12, null);
                    c.this.f21466g = true;
                }
                return kotlin.coroutines.jvm.internal.b.e(c.this.f21464e);
            } catch (IOException e10) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, c.this.f21462c, "Failed to open file: " + c.this.f21460a, e10, false, 8, null);
                throw e10;
            }
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.ProgressiveMediaFileDataSource$streamingStatus$1", f = "ProgressiveMediaFileDataSource.kt", l = {}, m = "invokeSuspend")
    public static final class b extends l implements p<o0, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21470j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f21472l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f21472l = str;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> dVar) {
            return ((b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return c.this.new b(this.f21472l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f21470j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            return c.this.f21461b.a(this.f21472l);
        }
    }

    public c(@NotNull String url, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f mediaCacheRepository) {
        t.i(url, "url");
        t.i(mediaCacheRepository, "mediaCacheRepository");
        this.f21460a = url;
        this.f21461b = mediaCacheRepository;
        this.f21462c = "ProgressiveMediaFileDataSource";
    }

    @Override // z3.k
    public long a(@NotNull o dataSpec) {
        t.i(dataSpec, "dataSpec");
        return ((Number) j.b(null, new a(dataSpec, null), 1, null)).longValue();
    }

    @Override // z3.k
    public void b(@NotNull m0 transferListener) {
        t.i(transferListener, "transferListener");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f21462c, "addTransferListener", null, false, 12, null);
    }

    @Override // z3.k
    public void close() {
        try {
            RandomAccessFile randomAccessFile = this.f21463d;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } finally {
            this.f21463d = null;
        }
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c e(String str) {
        return (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c) j.b(null, new b(str, null), 1, null);
    }

    @Override // z3.k
    public /* synthetic */ Map getResponseHeaders() {
        return z3.j.a(this);
    }

    @Override // z3.k
    @Nullable
    public Uri getUri() {
        return Uri.parse(this.f21460a);
    }

    public final void h(@Nullable RandomAccessFile randomAccessFile) {
        this.f21463d = randomAccessFile;
    }

    public final boolean i() {
        return this.f21466g;
    }

    public final boolean j(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVar) {
        return this.f21465f && (cVar instanceof c.C0384c) && t.d(((c.C0384c) cVar).b(), com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.d.a());
    }

    @Override // z3.h
    public int read(@NotNull byte[] buffer, int i10, int i11) {
        IOException iOException;
        int i12;
        t.i(buffer, "buffer");
        try {
            if (i11 == 0) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f21462c, "Read length is 0", null, false, 12, null);
                return 0;
            }
            if (this.f21464e == 0 && (e(this.f21460a) instanceof c.a)) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f21462c, "Media stream is complete", null, false, 12, null);
                return -1;
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVarE = e(this.f21460a);
            if (cVarE instanceof c.b) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, this.f21462c, "Streaming failed: " + this.f21460a, null, false, 12, null);
                this.f21466g = true;
                return 0;
            }
            if (cVarE instanceof c.a) {
                RandomAccessFile randomAccessFile = this.f21463d;
                i = randomAccessFile != null ? randomAccessFile.read(buffer, i10, i11) : 0;
                if (i <= 0) {
                    return i;
                }
                this.f21465f = true;
                this.f21464e -= (long) i;
                return i;
            }
            loop0: while (true) {
                i12 = 0;
                while (i12 <= 0) {
                    try {
                        if (!(e(this.f21460a) instanceof c.C0384c)) {
                            break loop0;
                        }
                        RandomAccessFile randomAccessFile2 = this.f21463d;
                        if (randomAccessFile2 != null) {
                            i12 = randomAccessFile2.read(buffer, i10, i11);
                        }
                    } catch (IOException e10) {
                        iOException = e10;
                        i = i12;
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, this.f21462c, "Waiting for more data", iOException, false, 8, null);
                        return i;
                    }
                }
            }
            if (i12 <= 0) {
                return i12;
            }
            this.f21465f = true;
            this.f21464e -= (long) i12;
            return i12;
        } catch (IOException e11) {
            iOException = e11;
        }
    }
}
