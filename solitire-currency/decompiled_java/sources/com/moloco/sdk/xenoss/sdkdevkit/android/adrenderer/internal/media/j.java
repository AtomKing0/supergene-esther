package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class j {
    @NotNull
    public static final f.a.AbstractC0379a a(@NotNull Exception e10) {
        t.i(e10, "e");
        return e10 instanceof UnknownHostException ? f.a.AbstractC0379a.q.f19421a : e10 instanceof SocketException ? f.a.AbstractC0379a.i.f19413a : e10 instanceof SSLHandshakeException ? f.a.AbstractC0379a.j.f19414a : e10 instanceof IOException ? f.a.AbstractC0379a.C0381f.f19410a : e10 instanceof SecurityException ? f.a.AbstractC0379a.g.f19411a : e10 instanceof k ? f.a.AbstractC0379a.m.f19417a : e10 instanceof NumberFormatException ? f.a.AbstractC0379a.l.f19416a : f.a.AbstractC0379a.r.f19422a;
    }
}
