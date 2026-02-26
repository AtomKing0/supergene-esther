package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface f1 {

    public static final class a implements f1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final C0255a f12013c = new C0255a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f12014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final String f12015b;

        /* JADX INFO: renamed from: com.ironsource.f1$a$a, reason: collision with other inner class name */
        public static final class C0255a {
            private C0255a() {
            }

            public /* synthetic */ C0255a(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final a a() {
                return new a(false, "ad is invalid due to loading time", 1, null);
            }

            @NotNull
            public final a a(@Nullable String str) {
                return new a(false, str, 1, null);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(false, null, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ a a(a aVar, boolean z10, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = aVar.a();
            }
            if ((i10 & 2) != 0) {
                str = aVar.f12015b;
            }
            return aVar.a(z10, str);
        }

        public final boolean b() {
            return a();
        }

        @Nullable
        public final String c() {
            return this.f12015b;
        }

        @Nullable
        public final String d() {
            return this.f12015b;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a() == aVar.a() && kotlin.jvm.internal.t.d(this.f12015b, aVar.f12015b);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean zA = a();
            ?? r02 = zA;
            if (zA) {
                r02 = 1;
            }
            int i10 = r02 * 31;
            String str = this.f12015b;
            return i10 + (str == null ? 0 : str.hashCode());
        }

        @NotNull
        public String toString() {
            return "NotReady(isReady=" + a() + ", reason=" + this.f12015b + ')';
        }

        public a(boolean z10, @Nullable String str) {
            this.f12014a = z10;
            this.f12015b = str;
        }

        @NotNull
        public final a a(boolean z10, @Nullable String str) {
            return new a(z10, str);
        }

        public /* synthetic */ a(boolean z10, String str, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? null : str);
        }

        @Override // com.ironsource.f1
        public boolean a() {
            return this.f12014a;
        }
    }

    public static final class b implements f1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f12016a;

        public b() {
            this(false, 1, null);
        }

        public static /* synthetic */ b a(b bVar, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = bVar.a();
            }
            return bVar.a(z10);
        }

        public final boolean b() {
            return a();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && a() == ((b) obj).a();
        }

        public int hashCode() {
            boolean zA = a();
            if (zA) {
                return 1;
            }
            return zA ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "Ready(isReady=" + a() + ')';
        }

        public b(boolean z10) {
            this.f12016a = z10;
        }

        @NotNull
        public final b a(boolean z10) {
            return new b(z10);
        }

        public /* synthetic */ b(boolean z10, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? true : z10);
        }

        @Override // com.ironsource.f1
        public boolean a() {
            return this.f12016a;
        }
    }

    boolean a();
}
