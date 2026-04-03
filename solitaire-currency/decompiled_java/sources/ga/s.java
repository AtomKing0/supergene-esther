package ga;

import androidx.browser.trusted.sharing.ShareTarget;
import ga.v;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FormBody.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class s extends c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final b f26198c = new b(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final x f26199d = x.f26237e.a(ShareTarget.ENCODING_TYPE_URL_ENCODED);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<String> f26200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<String> f26201b;

    /* JADX INFO: compiled from: FormBody.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final Charset f26202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final List<String> f26203b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final List<String> f26204c;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @NotNull
        public final a a(@NotNull String name, @NotNull String value) {
            kotlin.jvm.internal.t.i(name, "name");
            kotlin.jvm.internal.t.i(value, "value");
            List<String> list = this.f26203b;
            v.b bVar = v.f26216k;
            list.add(v.b.b(bVar, name, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.f26202a, 91, null));
            this.f26204c.add(v.b.b(bVar, value, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.f26202a, 91, null));
            return this;
        }

        @NotNull
        public final a b(@NotNull String name, @NotNull String value) {
            kotlin.jvm.internal.t.i(name, "name");
            kotlin.jvm.internal.t.i(value, "value");
            List<String> list = this.f26203b;
            v.b bVar = v.f26216k;
            list.add(v.b.b(bVar, name, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.f26202a, 83, null));
            this.f26204c.add(v.b.b(bVar, value, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.f26202a, 83, null));
            return this;
        }

        @NotNull
        public final s c() {
            return new s(this.f26203b, this.f26204c);
        }

        public a(@Nullable Charset charset) {
            this.f26202a = charset;
            this.f26203b = new ArrayList();
            this.f26204c = new ArrayList();
        }

        public /* synthetic */ a(Charset charset, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? null : charset);
        }
    }

    /* JADX INFO: compiled from: FormBody.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public s(@NotNull List<String> encodedNames, @NotNull List<String> encodedValues) {
        kotlin.jvm.internal.t.i(encodedNames, "encodedNames");
        kotlin.jvm.internal.t.i(encodedValues, "encodedValues");
        this.f26200a = ha.d.T(encodedNames);
        this.f26201b = ha.d.T(encodedValues);
    }

    private final long a(ua.d dVar, boolean z10) throws EOFException {
        ua.c cVarG;
        if (z10) {
            cVarG = new ua.c();
        } else {
            kotlin.jvm.internal.t.f(dVar);
            cVarG = dVar.g();
        }
        int size = this.f26200a.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            if (i10 > 0) {
                cVarG.writeByte(38);
            }
            cVarG.E(this.f26200a.get(i10));
            cVarG.writeByte(61);
            cVarG.E(this.f26201b.get(i10));
            i10 = i11;
        }
        if (!z10) {
            return 0L;
        }
        long size2 = cVarG.size();
        cVarG.c();
        return size2;
    }

    @Override // ga.c0
    public long contentLength() {
        return a(null, true);
    }

    @Override // ga.c0
    @NotNull
    public x contentType() {
        return f26199d;
    }

    @Override // ga.c0
    public void writeTo(@NotNull ua.d sink) throws IOException {
        kotlin.jvm.internal.t.i(sink, "sink");
        a(sink, false);
    }
}
