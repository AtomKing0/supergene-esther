package ea;

import ba.i;
import java.lang.annotation.Annotation;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Polymorphic.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class p0 {
    public static final void b(@NotNull ba.i kind) {
        kotlin.jvm.internal.t.i(kind, "kind");
        if (kind instanceof i.b) {
            throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
        }
        if (kind instanceof ba.e) {
            throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
        }
        if (kind instanceof ba.d) {
            throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself".toString());
        }
    }

    @NotNull
    public static final String c(@NotNull SerialDescriptor serialDescriptor, @NotNull kotlinx.serialization.json.a json) {
        kotlin.jvm.internal.t.i(serialDescriptor, "<this>");
        kotlin.jvm.internal.t.i(json, "json");
        for (Annotation annotation : serialDescriptor.getAnnotations()) {
            if (annotation instanceof kotlinx.serialization.json.d) {
                return ((kotlinx.serialization.json.d) annotation).discriminator();
            }
        }
        return json.e().c();
    }

    public static final <T> T d(@NotNull kotlinx.serialization.json.f fVar, @NotNull z9.b<T> deserializer) {
        JsonPrimitive jsonPrimitiveL;
        kotlin.jvm.internal.t.i(fVar, "<this>");
        kotlin.jvm.internal.t.i(deserializer, "deserializer");
        if (!(deserializer instanceof da.b) || fVar.d().e().k()) {
            return deserializer.deserialize(fVar);
        }
        String strC = c(deserializer.getDescriptor(), fVar.d());
        JsonElement jsonElementG = fVar.g();
        SerialDescriptor descriptor = deserializer.getDescriptor();
        if (jsonElementG instanceof JsonObject) {
            JsonObject jsonObject = (JsonObject) jsonElementG;
            JsonElement jsonElement = (JsonElement) jsonObject.get(strC);
            String strA = (jsonElement == null || (jsonPrimitiveL = kotlinx.serialization.json.h.l(jsonElement)) == null) ? null : jsonPrimitiveL.a();
            z9.b<? extends T> bVarC = ((da.b) deserializer).c(fVar, strA);
            if (bVarC != null) {
                return (T) w0.b(fVar.d(), strC, jsonObject, bVarC);
            }
            e(strA, jsonObject);
            throw new v8.h();
        }
        throw a0.e(-1, "Expected " + kotlin.jvm.internal.o0.b(JsonObject.class) + " as the serialized body of " + descriptor.h() + ", but had " + kotlin.jvm.internal.o0.b(jsonElementG.getClass()));
    }

    @NotNull
    public static final Void e(@Nullable String str, @NotNull JsonObject jsonTree) {
        String str2;
        kotlin.jvm.internal.t.i(jsonTree, "jsonTree");
        if (str == null) {
            str2 = "missing class discriminator ('null')";
        } else {
            str2 = "class discriminator '" + str + '\'';
        }
        throw a0.f(-1, "Polymorphic serializer was not found for " + str2, jsonTree.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(z9.j<?> jVar, z9.j<Object> jVar2, String str) {
    }
}
