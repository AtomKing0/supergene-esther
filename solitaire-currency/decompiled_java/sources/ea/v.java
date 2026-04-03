package ea;

import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StreamingJsonDecoder.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class v extends ca.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final a f25500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final fa.c f25501b;

    public v(@NotNull a lexer, @NotNull kotlinx.serialization.json.a json) {
        kotlin.jvm.internal.t.i(lexer, "lexer");
        kotlin.jvm.internal.t.i(json, "json");
        this.f25500a = lexer;
        this.f25501b = json.a();
    }

    @Override // ca.a, kotlinx.serialization.encoding.Decoder
    public byte H() {
        a aVar = this.f25500a;
        String strS = aVar.s();
        try {
            return p9.x.a(strS);
        } catch (IllegalArgumentException unused) {
            a.y(aVar, "Failed to parse type 'UByte' for input '" + strS + '\'', 0, null, 6, null);
            throw new v8.h();
        }
    }

    @Override // kotlinx.serialization.encoding.Decoder, ca.c
    @NotNull
    public fa.c a() {
        return this.f25501b;
    }

    @Override // ca.a, kotlinx.serialization.encoding.Decoder
    public int h() {
        a aVar = this.f25500a;
        String strS = aVar.s();
        try {
            return p9.x.d(strS);
        } catch (IllegalArgumentException unused) {
            a.y(aVar, "Failed to parse type 'UInt' for input '" + strS + '\'', 0, null, 6, null);
            throw new v8.h();
        }
    }

    @Override // ca.a, kotlinx.serialization.encoding.Decoder
    public long m() {
        a aVar = this.f25500a;
        String strS = aVar.s();
        try {
            return p9.x.g(strS);
        } catch (IllegalArgumentException unused) {
            a.y(aVar, "Failed to parse type 'ULong' for input '" + strS + '\'', 0, null, 6, null);
            throw new v8.h();
        }
    }

    @Override // ca.c
    public int o(@NotNull SerialDescriptor descriptor) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        throw new IllegalStateException("unsupported".toString());
    }

    @Override // ca.a, kotlinx.serialization.encoding.Decoder
    public short s() {
        a aVar = this.f25500a;
        String strS = aVar.s();
        try {
            return p9.x.j(strS);
        } catch (IllegalArgumentException unused) {
            a.y(aVar, "Failed to parse type 'UShort' for input '" + strS + '\'', 0, null, 6, null);
            throw new v8.h();
        }
    }
}
