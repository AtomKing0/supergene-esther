package j8;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Date.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Comparable<b> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public static final a f28773j = new a(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private static final b f28774k = j8.a.a(0L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f28775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f28776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f28777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final d f28778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f28779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f28780f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final c f28781g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f28782h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f28783i;

    /* JADX INFO: compiled from: Date.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    public b(int i10, int i11, int i12, @NotNull d dayOfWeek, int i13, int i14, @NotNull c month, int i15, long j10) {
        t.i(dayOfWeek, "dayOfWeek");
        t.i(month, "month");
        this.f28775a = i10;
        this.f28776b = i11;
        this.f28777c = i12;
        this.f28778d = dayOfWeek;
        this.f28779e = i13;
        this.f28780f = i14;
        this.f28781g = month;
        this.f28782h = i15;
        this.f28783i = j10;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull b other) {
        t.i(other, "other");
        return t.l(this.f28783i, other.f28783i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f28775a == bVar.f28775a && this.f28776b == bVar.f28776b && this.f28777c == bVar.f28777c && this.f28778d == bVar.f28778d && this.f28779e == bVar.f28779e && this.f28780f == bVar.f28780f && this.f28781g == bVar.f28781g && this.f28782h == bVar.f28782h && this.f28783i == bVar.f28783i;
    }

    public int hashCode() {
        return (((((((((((((((this.f28775a * 31) + this.f28776b) * 31) + this.f28777c) * 31) + this.f28778d.hashCode()) * 31) + this.f28779e) * 31) + this.f28780f) * 31) + this.f28781g.hashCode()) * 31) + this.f28782h) * 31) + androidx.compose.animation.a.a(this.f28783i);
    }

    @NotNull
    public String toString() {
        return "GMTDate(seconds=" + this.f28775a + ", minutes=" + this.f28776b + ", hours=" + this.f28777c + ", dayOfWeek=" + this.f28778d + ", dayOfMonth=" + this.f28779e + ", dayOfYear=" + this.f28780f + ", month=" + this.f28781g + ", year=" + this.f28782h + ", timestamp=" + this.f28783i + ')';
    }
}
