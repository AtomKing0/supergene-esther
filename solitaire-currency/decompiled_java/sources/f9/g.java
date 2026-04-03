package f9;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.q;

/* JADX INFO: compiled from: FileTreeWalk.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g implements o9.g<File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final File f25738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final h f25739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final h9.l<File, Boolean> f25740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final h9.l<File, k0> f25741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final h9.p<File, IOException, k0> f25742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f25743f;

    /* JADX INFO: compiled from: FileTreeWalk.kt */
    private static abstract class a extends c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull File rootDir) {
            super(rootDir);
            t.i(rootDir, "rootDir");
        }
    }

    /* JADX INFO: compiled from: FileTreeWalk.kt */
    private final class b extends kotlin.collections.b<File> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final ArrayDeque<c> f25744c;

        /* JADX INFO: compiled from: FileTreeWalk.kt */
        private final class a extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f25746b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @Nullable
            private File[] f25747c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f25748d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private boolean f25749e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f25750f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull b bVar, File rootDir) {
                super(rootDir);
                t.i(rootDir, "rootDir");
                this.f25750f = bVar;
            }

            @Override // f9.g.c
            @Nullable
            public File b() {
                if (!this.f25749e && this.f25747c == null) {
                    h9.l lVar = g.this.f25740c;
                    boolean z10 = false;
                    if (lVar != null && !((Boolean) lVar.invoke(a())).booleanValue()) {
                        z10 = true;
                    }
                    if (z10) {
                        return null;
                    }
                    File[] fileArrListFiles = a().listFiles();
                    this.f25747c = fileArrListFiles;
                    if (fileArrListFiles == null) {
                        h9.p pVar = g.this.f25742e;
                        if (pVar != null) {
                            pVar.mo4invoke(a(), new f9.a(a(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.f25749e = true;
                    }
                }
                File[] fileArr = this.f25747c;
                if (fileArr != null) {
                    int i10 = this.f25748d;
                    t.f(fileArr);
                    if (i10 < fileArr.length) {
                        File[] fileArr2 = this.f25747c;
                        t.f(fileArr2);
                        int i11 = this.f25748d;
                        this.f25748d = i11 + 1;
                        return fileArr2[i11];
                    }
                }
                if (!this.f25746b) {
                    this.f25746b = true;
                    return a();
                }
                h9.l lVar2 = g.this.f25741d;
                if (lVar2 != null) {
                    lVar2.invoke(a());
                }
                return null;
            }
        }

        /* JADX INFO: renamed from: f9.g$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FileTreeWalk.kt */
        private final class C0557b extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f25751b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ b f25752c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0557b(@NotNull b bVar, File rootFile) {
                super(rootFile);
                t.i(rootFile, "rootFile");
                this.f25752c = bVar;
            }

            @Override // f9.g.c
            @Nullable
            public File b() {
                if (this.f25751b) {
                    return null;
                }
                this.f25751b = true;
                return a();
            }
        }

        /* JADX INFO: compiled from: FileTreeWalk.kt */
        private final class c extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f25753b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @Nullable
            private File[] f25754c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f25755d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ b f25756e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(@NotNull b bVar, File rootDir) {
                super(rootDir);
                t.i(rootDir, "rootDir");
                this.f25756e = bVar;
            }

            /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
            
                if (r0.length == 0) goto L33;
             */
            @Override // f9.g.c
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.io.File b() {
                /*
                    r10 = this;
                    boolean r0 = r10.f25753b
                    r1 = 0
                    if (r0 != 0) goto L2c
                    f9.g$b r0 = r10.f25756e
                    f9.g r0 = f9.g.this
                    h9.l r0 = f9.g.e(r0)
                    r2 = 0
                    r3 = 1
                    if (r0 == 0) goto L22
                    java.io.File r4 = r10.a()
                    java.lang.Object r0 = r0.invoke(r4)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L22
                    r2 = r3
                L22:
                    if (r2 == 0) goto L25
                    return r1
                L25:
                    r10.f25753b = r3
                    java.io.File r0 = r10.a()
                    return r0
                L2c:
                    java.io.File[] r0 = r10.f25754c
                    if (r0 == 0) goto L4b
                    int r2 = r10.f25755d
                    kotlin.jvm.internal.t.f(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L39
                    goto L4b
                L39:
                    f9.g$b r0 = r10.f25756e
                    f9.g r0 = f9.g.this
                    h9.l r0 = f9.g.g(r0)
                    if (r0 == 0) goto L4a
                    java.io.File r2 = r10.a()
                    r0.invoke(r2)
                L4a:
                    return r1
                L4b:
                    java.io.File[] r0 = r10.f25754c
                    if (r0 != 0) goto L97
                    java.io.File r0 = r10.a()
                    java.io.File[] r0 = r0.listFiles()
                    r10.f25754c = r0
                    if (r0 != 0) goto L7b
                    f9.g$b r0 = r10.f25756e
                    f9.g r0 = f9.g.this
                    h9.p r0 = f9.g.f(r0)
                    if (r0 == 0) goto L7b
                    java.io.File r2 = r10.a()
                    f9.a r9 = new f9.a
                    java.io.File r4 = r10.a()
                    r5 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r7 = 2
                    r8 = 0
                    r3 = r9
                    r3.<init>(r4, r5, r6, r7, r8)
                    r0.mo4invoke(r2, r9)
                L7b:
                    java.io.File[] r0 = r10.f25754c
                    if (r0 == 0) goto L85
                    kotlin.jvm.internal.t.f(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L97
                L85:
                    f9.g$b r0 = r10.f25756e
                    f9.g r0 = f9.g.this
                    h9.l r0 = f9.g.g(r0)
                    if (r0 == 0) goto L96
                    java.io.File r2 = r10.a()
                    r0.invoke(r2)
                L96:
                    return r1
                L97:
                    java.io.File[] r0 = r10.f25754c
                    kotlin.jvm.internal.t.f(r0)
                    int r1 = r10.f25755d
                    int r2 = r1 + 1
                    r10.f25755d = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: f9.g.b.c.b():java.io.File");
            }
        }

        /* JADX INFO: compiled from: FileTreeWalk.kt */
        public /* synthetic */ class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f25757a;

            static {
                int[] iArr = new int[h.values().length];
                try {
                    iArr[h.f25759a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[h.f25760b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f25757a = iArr;
            }
        }

        public b() {
            ArrayDeque<c> arrayDeque = new ArrayDeque<>();
            this.f25744c = arrayDeque;
            if (g.this.f25738a.isDirectory()) {
                arrayDeque.push(f(g.this.f25738a));
            } else if (g.this.f25738a.isFile()) {
                arrayDeque.push(new C0557b(this, g.this.f25738a));
            } else {
                b();
            }
        }

        private final a f(File file) {
            int i10 = d.f25757a[g.this.f25739b.ordinal()];
            if (i10 == 1) {
                return new c(this, file);
            }
            if (i10 == 2) {
                return new a(this, file);
            }
            throw new q();
        }

        private final File g() {
            File fileB;
            while (true) {
                c cVarPeek = this.f25744c.peek();
                if (cVarPeek == null) {
                    return null;
                }
                fileB = cVarPeek.b();
                if (fileB == null) {
                    this.f25744c.pop();
                } else {
                    if (t.d(fileB, cVarPeek.a()) || !fileB.isDirectory() || this.f25744c.size() >= g.this.f25743f) {
                        break;
                    }
                    this.f25744c.push(f(fileB));
                }
            }
            return fileB;
        }

        @Override // kotlin.collections.b
        protected void a() {
            File fileG = g();
            if (fileG != null) {
                c(fileG);
            } else {
                b();
            }
        }
    }

    /* JADX INFO: compiled from: FileTreeWalk.kt */
    private static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final File f25758a;

        public c(@NotNull File root) {
            t.i(root, "root");
            this.f25758a = root;
        }

        @NotNull
        public final File a() {
            return this.f25758a;
        }

        @Nullable
        public abstract File b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private g(File file, h hVar, h9.l<? super File, Boolean> lVar, h9.l<? super File, k0> lVar2, h9.p<? super File, ? super IOException, k0> pVar, int i10) {
        this.f25738a = file;
        this.f25739b = hVar;
        this.f25740c = lVar;
        this.f25741d = lVar2;
        this.f25742e = pVar;
        this.f25743f = i10;
    }

    @Override // o9.g
    @NotNull
    public Iterator<File> iterator() {
        return new b();
    }

    /* synthetic */ g(File file, h hVar, h9.l lVar, h9.l lVar2, h9.p pVar, int i10, int i11, kotlin.jvm.internal.k kVar) {
        this(file, (i11 & 2) != 0 ? h.f25759a : hVar, lVar, lVar2, pVar, (i11 & 32) != 0 ? Integer.MAX_VALUE : i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(@NotNull File start, @NotNull h direction) {
        this(start, direction, null, null, null, 0, 32, null);
        t.i(start, "start");
        t.i(direction, "direction");
    }
}
