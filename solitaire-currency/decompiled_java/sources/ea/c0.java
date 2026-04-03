package ea;

import ba.j;
import com.ironsource.v8;
import java.util.Arrays;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JsonPath.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private Object[] f25419a = new Object[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private int[] f25420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f25421c;

    /* JADX INFO: compiled from: JsonPath.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f25422a = new a();

        private a() {
        }
    }

    public c0() {
        int[] iArr = new int[8];
        for (int i10 = 0; i10 < 8; i10++) {
            iArr[i10] = -1;
        }
        this.f25420b = iArr;
        this.f25421c = -1;
    }

    private final void e() {
        int i10 = this.f25421c * 2;
        Object[] objArrCopyOf = Arrays.copyOf(this.f25419a, i10);
        kotlin.jvm.internal.t.h(objArrCopyOf, "copyOf(this, newSize)");
        this.f25419a = objArrCopyOf;
        int[] iArrCopyOf = Arrays.copyOf(this.f25420b, i10);
        kotlin.jvm.internal.t.h(iArrCopyOf, "copyOf(this, newSize)");
        this.f25420b = iArrCopyOf;
    }

    @NotNull
    public final String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("$");
        int i10 = this.f25421c + 1;
        for (int i11 = 0; i11 < i10; i11++) {
            Object obj = this.f25419a[i11];
            if (obj instanceof SerialDescriptor) {
                SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
                if (!kotlin.jvm.internal.t.d(serialDescriptor.getKind(), j.b.f2322a)) {
                    int i12 = this.f25420b[i11];
                    if (i12 >= 0) {
                        sb.append(".");
                        sb.append(serialDescriptor.e(i12));
                    }
                } else if (this.f25420b[i11] != -1) {
                    sb.append(v8.i.f15837d);
                    sb.append(this.f25420b[i11]);
                    sb.append(v8.i.f15839e);
                }
            } else if (obj != a.f25422a) {
                sb.append(v8.i.f15837d);
                sb.append("'");
                sb.append(obj);
                sb.append("'");
                sb.append(v8.i.f15839e);
            }
        }
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final void b() {
        int i10 = this.f25421c;
        int[] iArr = this.f25420b;
        if (iArr[i10] == -2) {
            iArr[i10] = -1;
            this.f25421c = i10 - 1;
        }
        int i11 = this.f25421c;
        if (i11 != -1) {
            this.f25421c = i11 - 1;
        }
    }

    public final void c(@NotNull SerialDescriptor sd) {
        kotlin.jvm.internal.t.i(sd, "sd");
        int i10 = this.f25421c + 1;
        this.f25421c = i10;
        if (i10 == this.f25419a.length) {
            e();
        }
        this.f25419a[i10] = sd;
    }

    public final void d() {
        int[] iArr = this.f25420b;
        int i10 = this.f25421c;
        if (iArr[i10] == -2) {
            this.f25419a[i10] = a.f25422a;
        }
    }

    public final void f(@Nullable Object obj) {
        int[] iArr = this.f25420b;
        int i10 = this.f25421c;
        if (iArr[i10] != -2) {
            int i11 = i10 + 1;
            this.f25421c = i11;
            if (i11 == this.f25419a.length) {
                e();
            }
        }
        Object[] objArr = this.f25419a;
        int i12 = this.f25421c;
        objArr[i12] = obj;
        this.f25420b[i12] = -2;
    }

    public final void g(int i10) {
        this.f25420b[this.f25421c] = i10;
    }

    @NotNull
    public String toString() {
        return a();
    }
}
