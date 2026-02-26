package q9;

import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DurationUnitJvm.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f33184b = new e("NANOSECONDS", 0, TimeUnit.NANOSECONDS);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f33185c = new e("MICROSECONDS", 1, TimeUnit.MICROSECONDS);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f33186d = new e("MILLISECONDS", 2, TimeUnit.MILLISECONDS);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f33187e = new e("SECONDS", 3, TimeUnit.SECONDS);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f33188f = new e("MINUTES", 4, TimeUnit.MINUTES);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f33189g = new e("HOURS", 5, TimeUnit.HOURS);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f33190h = new e("DAYS", 6, TimeUnit.DAYS);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ e[] f33191i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ b9.a f33192j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final TimeUnit f33193a;

    static {
        e[] eVarArrA = a();
        f33191i = eVarArrA;
        f33192j = b9.b.a(eVarArrA);
    }

    private e(String str, int i10, TimeUnit timeUnit) {
        this.f33193a = timeUnit;
    }

    private static final /* synthetic */ e[] a() {
        return new e[]{f33184b, f33185c, f33186d, f33187e, f33188f, f33189g, f33190h};
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) f33191i.clone();
    }

    @NotNull
    public final TimeUnit c() {
        return this.f33193a;
    }
}
