package io.sentry.rrweb;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.protocol.TransactionInfo;
import io.sentry.util.w;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RRWebIncrementalSnapshotEvent.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class d extends io.sentry.rrweb.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f28170c;

    /* JADX INFO: compiled from: RRWebIncrementalSnapshotEvent.java */
    public static final class a {
        public boolean a(@NotNull d dVar, @NotNull String str, @NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            if (!str.equals(TransactionInfo.JsonKeys.SOURCE)) {
                return false;
            }
            dVar.f28170c = (b) w.c((b) l3Var.M(w0Var, new b.a()), "");
            return true;
        }
    }

    /* JADX INFO: compiled from: RRWebIncrementalSnapshotEvent.java */
    public enum b implements h2 {
        Mutation,
        MouseMove,
        MouseInteraction,
        Scroll,
        ViewportResize,
        Input,
        TouchMove,
        MediaInteraction,
        StyleSheetRule,
        CanvasMutation,
        Font,
        Log,
        Drag,
        StyleDeclaration,
        Selection,
        AdoptedStyleSheet,
        CustomElement;

        /* JADX INFO: compiled from: RRWebIncrementalSnapshotEvent.java */
        public static final class a implements x1<b> {
            @Override // io.sentry.x1
            @NotNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
                return b.values()[l3Var.nextInt()];
            }
        }

        @Override // io.sentry.h2
        public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
            m3Var.a(ordinal());
        }
    }

    /* JADX INFO: compiled from: RRWebIncrementalSnapshotEvent.java */
    public static final class c {
        public void a(@NotNull d dVar, @NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
            m3Var.e(TransactionInfo.JsonKeys.SOURCE).o(w0Var, dVar.f28170c);
        }
    }

    public d(@NotNull b bVar) {
        super(io.sentry.rrweb.c.IncrementalSnapshot);
        this.f28170c = bVar;
    }
}
