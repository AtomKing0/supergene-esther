package kotlinx.serialization.json;

import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JsonElement.kt */
/* JADX INFO: loaded from: classes5.dex */
@z9.h(with = q.class)
public final class JsonNull extends JsonPrimitive {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final JsonNull f30027a = new JsonNull();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f30028b = "null";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ v8.l<KSerializer<Object>> f30029c = v8.n.b(v8.p.f35202b, a.f30030g);

    /* JADX INFO: compiled from: JsonElement.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.a<KSerializer<Object>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f30030g = new a();

        a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final KSerializer<Object> invoke() {
            return q.f30080a;
        }
    }

    private JsonNull() {
        super(null);
    }

    private final /* synthetic */ v8.l b() {
        return f30029c;
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    @NotNull
    public String a() {
        return f30028b;
    }

    @NotNull
    public final KSerializer<JsonNull> serializer() {
        return (KSerializer) b().getValue();
    }
}
