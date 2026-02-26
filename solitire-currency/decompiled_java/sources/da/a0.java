package da;

import java.lang.Enum;
import java.util.Arrays;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Enums.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a0<T extends Enum<T>> implements KSerializer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final T[] f24534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private SerialDescriptor f24535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final v8.l f24536c;

    /* JADX INFO: compiled from: Enums.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.a<SerialDescriptor> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a0<T> f24537g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f24538h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(a0<T> a0Var, String str) {
            super(0);
            this.f24537g = a0Var;
            this.f24538h = str;
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SerialDescriptor invoke() {
            SerialDescriptor serialDescriptor = ((a0) this.f24537g).f24535b;
            return serialDescriptor == null ? this.f24537g.c(this.f24538h) : serialDescriptor;
        }
    }

    public a0(@NotNull String serialName, @NotNull T[] values) {
        kotlin.jvm.internal.t.i(serialName, "serialName");
        kotlin.jvm.internal.t.i(values, "values");
        this.f24534a = values;
        this.f24536c = v8.n.a(new a(this, serialName));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SerialDescriptor c(String str) {
        z zVar = new z(str, this.f24534a.length);
        for (T t10 : this.f24534a) {
            PluginGeneratedSerialDescriptor.l(zVar, t10.name(), false, 2, null);
        }
        return zVar;
    }

    @Override // z9.b
    @NotNull
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public T deserialize(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        int iE = decoder.e(getDescriptor());
        boolean z10 = false;
        if (iE >= 0 && iE < this.f24534a.length) {
            z10 = true;
        }
        if (z10) {
            return this.f24534a[iE];
        }
        throw new z9.i(iE + " is not among valid " + getDescriptor().h() + " enum values, values size is " + this.f24534a.length);
    }

    @Override // z9.j
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void serialize(@NotNull Encoder encoder, @NotNull T value) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        kotlin.jvm.internal.t.i(value, "value");
        int iY = kotlin.collections.p.Y(this.f24534a, value);
        if (iY != -1) {
            encoder.k(getDescriptor(), iY);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        sb.append(" is not a valid enum ");
        sb.append(getDescriptor().h());
        sb.append(", must be one of ");
        String string = Arrays.toString(this.f24534a);
        kotlin.jvm.internal.t.h(string, "toString(this)");
        sb.append(string);
        throw new z9.i(sb.toString());
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.f24536c.getValue();
    }

    @NotNull
    public String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().h() + '>';
    }
}
