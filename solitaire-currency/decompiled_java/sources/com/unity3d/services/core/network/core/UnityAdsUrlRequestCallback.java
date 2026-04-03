package com.unity3d.services.core.network.core;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.d;
import ua.k0;

/* JADX INFO: compiled from: UnityAdsUrlRequestCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class UnityAdsUrlRequestCallback extends UrlRequest.Callback {
    private static final int BYTE_BUFFER_CAPACITY_BYTES = 65536;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final ByteArrayOutputStream bytesReceived;

    @Nullable
    private final File file;
    private final WritableByteChannel receiveChannel;
    private d sink;

    /* JADX INFO: compiled from: UnityAdsUrlRequestCallback.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    public UnityAdsUrlRequestCallback(@Nullable File file) {
        this.file = file;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.bytesReceived = byteArrayOutputStream;
        this.receiveChannel = Channels.newChannel(byteArrayOutputStream);
    }

    @Nullable
    public final File getFile() {
        return this.file;
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onReadCompleted(@NotNull UrlRequest request, @NotNull UrlResponseInfo info, @NotNull ByteBuffer byteBuffer) throws IOException {
        t.i(request, "request");
        t.i(info, "info");
        t.i(byteBuffer, "byteBuffer");
        byteBuffer.flip();
        File file = this.file;
        boolean z10 = false;
        if (file != null && file.exists()) {
            z10 = true;
        }
        if (z10) {
            d dVar = this.sink;
            if (dVar == null) {
                t.A("sink");
                dVar = null;
            }
            dVar.write(byteBuffer);
        } else {
            this.receiveChannel.write(byteBuffer);
        }
        byteBuffer.clear();
        request.read(byteBuffer);
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onRedirectReceived(@NotNull UrlRequest request, @Nullable UrlResponseInfo urlResponseInfo, @Nullable String str) {
        t.i(request, "request");
        request.followRedirect();
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onResponseStarted(@NotNull UrlRequest request, @NotNull UrlResponseInfo info) {
        t.i(request, "request");
        t.i(info, "info");
        File file = this.file;
        boolean z10 = false;
        if (file != null && file.exists()) {
            z10 = true;
        }
        if (z10) {
            d dVarC = k0.c(k0.f(this.file));
            t.h(dVarC, "buffer(Okio.sink(file))");
            this.sink = dVarC;
        }
        request.read(ByteBuffer.allocateDirect(65536));
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onSucceeded(@NotNull UrlRequest request, @NotNull UrlResponseInfo info) throws IOException {
        t.i(request, "request");
        t.i(info, "info");
        byte[] bodyBytes = this.bytesReceived.toByteArray();
        File file = this.file;
        if (file != null && file.exists()) {
            d dVar = this.sink;
            if (dVar == null) {
                t.A("sink");
                dVar = null;
            }
            dVar.close();
        }
        t.h(bodyBytes, "bodyBytes");
        onSucceeded(request, info, bodyBytes);
    }

    public abstract void onSucceeded(@NotNull UrlRequest urlRequest, @NotNull UrlResponseInfo urlResponseInfo, @NotNull byte[] bArr);
}
