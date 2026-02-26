package j8;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Date.kt */
/* JADX INFO: loaded from: classes.dex */
public enum d {
    MONDAY("Mon"),
    TUESDAY("Tue"),
    WEDNESDAY("Wed"),
    THURSDAY("Thu"),
    FRIDAY("Fri"),
    SATURDAY("Sat"),
    SUNDAY("Sun");


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f28799b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f28808a;

    /* JADX INFO: compiled from: Date.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        @NotNull
        public final d a(int i10) {
            return d.values()[i10];
        }
    }

    d(String str) {
        this.f28808a = str;
    }
}
