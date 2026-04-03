package oa;

import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PushObserver.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f32299a = a.f32301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final l f32300b = new a.C0645a();

    /* JADX INFO: compiled from: PushObserver.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f32301a = new a();

        /* JADX INFO: renamed from: oa.l$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: PushObserver.kt */
        private static final class C0645a implements l {
            @Override // oa.l
            public boolean a(int i10, @NotNull ua.e source, int i11, boolean z10) throws IOException {
                t.i(source, "source");
                source.skip(i11);
                return true;
            }

            @Override // oa.l
            public void b(int i10, @NotNull b errorCode) {
                t.i(errorCode, "errorCode");
            }

            @Override // oa.l
            public boolean c(int i10, @NotNull List<c> requestHeaders) {
                t.i(requestHeaders, "requestHeaders");
                return true;
            }

            @Override // oa.l
            public boolean d(int i10, @NotNull List<c> responseHeaders, boolean z10) {
                t.i(responseHeaders, "responseHeaders");
                return true;
            }
        }

        private a() {
        }
    }

    boolean a(int i10, @NotNull ua.e eVar, int i11, boolean z10) throws IOException;

    void b(int i10, @NotNull b bVar);

    boolean c(int i10, @NotNull List<c> list);

    boolean d(int i10, @NotNull List<c> list, boolean z10);
}
